package view;

import model.Player;
import model.Game;
import cityofaaron.CityOfAaron;
import control.GameControl;
import exceptions.GameControlException;

/**
 *
 *
 */
public class NewGameView extends ViewBase {

    /**
     * Constructor
     */
    public NewGameView() {
        // empty constructor       
    }

    @Override
    protected String getMessage() {
        return "Creating a new game:\n";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("Please enter your Name to start the game\n"
                + "\t\t-OR-\n"
                + "Press Enter to return to the Main Menu", true);

        // Repeat for each input you need, putting it into its proper slot in the array.
        return inputs;
    }

    /**
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {

        try {
            GameControl.testInput(inputs);
            String playerName = inputs[0];
            createAndStartGame(playerName);
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;
        }
        // to end the loop
        return false;
    }

    //Created a new Game with a named player and call the GameMenuView
    private void createAndStartGame(String playerName) {

        //Eventually, we will do this:
        Game game = GameControl.createNewGame(playerName);

        CityOfAaron.setCurrentGame(game);

        this.console.println();
        this.console.println("Welcome to the game, " + CityOfAaron.getCurrentGame().getThePlayer().getName() + "!\n");

        //Create and call the GameMenuView.
        View gameMenu = new GameMenuView();
        gameMenu.displayView();
    }
}
