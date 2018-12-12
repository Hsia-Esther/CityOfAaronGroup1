/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Random;
import model.Game;
import model.Player;
import model.Map;
import model.Storehouse;
import model.Author;
import model.Provision;
import model.InventoryItem;
import model.Animal;
import exceptions.GameControlException;
import java.io.*;
import cityofaaron.CityOfAaron;
import view.ErrorView;
import view.ViewBase;

/**
 *
 * @author Brenda
 */
public class GameControl {

    private static Random randomGenerator = new Random();

    /**
     * Protected setter for tests to inject a mock random object.
     *
     * @param random
     */
    protected static void setRandomGenerator(Random random) {
        randomGenerator = random;
    }

    /**
     * Generates a random integer between min and max, inclusive
     * <ul>Requirements:
     * <li>min and max must be positive integers (return -1)</li>
     * <li>max must be greater than min (return -2)</li>
     * <li>max cannot be equal to the maximum value for integers (return
     * -3)</li>
     * </ul>
     *
     * @param min
     * @param max
     * @return The random number
     */
    public static int getRandomNumber(int min, int max) throws GameControlException {
        //if min < 0 or max < 0 then return message
        if (min < 0 || max < 0) {
            throw new GameControlException("The number must be greater than zero.");
        }

        //if max <= min then return -2
        if (max <= min) {
            throw new GameControlException("The max number must be greater than the min number.");
        }

        //if max is the maximum value for integers, then return -3
        if (max == Integer.MAX_VALUE) {
            throw new GameControlException("The max number cannot be the maximum value for integers.");
        }

        //calculate the size of the range; add one so Random() includes high value
        int range = (max - min) + 1;

        //return low + random(range size)
        return min + randomGenerator.nextInt(range);

    }

    public static Game loadGameFromFile(String filePath) throws GameControlException, IOException {

        if (filePath == null) {
            throw new GameControlException("Please enter a valid file path.");
        }

        Game game = null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            game = (Game)in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ErrorView.display(ViewBase.class.getName(), "Error reading input: " + ex.getMessage());
        }

        CityOfAaron.setCurrentGame(game);
        Player player = new Player();
        game.getThePlayer();
        game.setThePlayer(player);

        return game;
    }

    public static boolean gameShouldEnd(int mortalityRate) {
        //TODO stub function, to fully implement change mortality rate to > 50%, not zero
        if (mortalityRate > 0) {
            // throw new GameControlException("More than 50% of your population died, therefore this game is over. Repent and try again."); 
            return true;
        }
        return false;
    }

    public static boolean gameMatures(int yearNumber) {
        if (yearNumber > 10) {
            return true;
        }
        return false;
    }

    public static void saveGameToFile(Game game, String filePath) throws GameControlException, IOException {

        if (filePath == null) {
            throw new GameControlException("Please enter a valid file path.");
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(game);
        } catch (IOException ex) {
            throw new IOException("I/O Error: " + ex.getMessage());
        }
    }

    public static void saveReportToFile(String[] filename) {
        //TODO stub funtion
    }

    public static Game createNewGame(String playerName) {

        Player player = new Player();
        player.setName(playerName);

        Game game = new Game();
        game.setThePlayer(player);

        game.setCurrentPopulation(100);
        game.setAcresOwned(1000);
        game.setWheatInStorage(2700);

        Map theMap = MapControl.createMap();
        game.setTheMap(theMap);

        Storehouse storehouse = new Storehouse();
        Author[] author = {
            new Author("Brenda", "Programmer"),
            new Author("Shay", "Programmer"),
            new Author("Esther", "Programmer")
        };
        storehouse.setAuthors(author);

        //call createTools() to create a tools array and set it in the storehouse
        InventoryItem[] tools = StorehouseControl.createTools();
        storehouse.setTools(tools);

        Animal[] animals = StorehouseControl.createAnimals();
        storehouse.setAnimals(animals);

        Provision[] provision = StorehouseControl.createProvisions();
        storehouse.setProvisions(provision);

        game.setTheStorehouse(storehouse);

        return game;

    }

    public static void testInput(String[] inputs) throws GameControlException {

        if (inputs[0] == null || inputs[0].equals("")) {
            throw new GameControlException("No name entered; returning to the Main Menu.");
        }
    }
}
