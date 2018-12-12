package view;

import model.Storehouse;
import model.Author;
import cityofaaron.CityOfAaron;
import model.Game;
import model.InventoryItem;
import model.Animal;
import model.Provision;
import control.StorehouseControl;
import javafx.util.Pair;

/**
 *
 * @author estherhsia
 */
public class ReportsMenuView extends ViewBase {

    /**
     * Constructor
     */
    public ReportsMenuView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "Reports Menu\n"
                + "-----------------------\n"
                + "A - View the animals in the storehouse\n"
                + "R - Print animal report\n"
                + "T - View the tools in the storehouse\n"
                + "O - Print tool report\n"
                + "P - View the provisions in the storehouse\n"
                + "V - Print provision report\n"
                + "G - View the authors of this game\n"
                + "Q - Return to Game Menu\n";
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

        inputs[0] = getUserInput("Which report would you like to view?");

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
        // Act on the user's input.
        // This is a "dispatch" function that decides what
        // other functions to call. You can use an if-, if-else,
        // or switch statement.

        // return false if you want this view to exit and return
        // to the view that called it.
        switch (inputs[0].trim().toUpperCase()) {
            case "A":
                animalsInStorehouse();
                break;
            case "R":
                View animalReport = new AnimalReportView();
                animalReport.displayView();
                break;
            case "T":
                toolsInStorehouse();
                break;
            case "O":
                View toolReport = new ToolReportView();
                toolReport.displayView();
                break;
            case "P":
                provisionsInStorehouse();
                break;
            case "V":
                View provisionReport = new ProvisionReportView();
                provisionReport.displayView();
                break;
            case "G":
                authorsOfGame();
                break;
            case "Q":
                this.console.println("Returning to Game Menu\n");
                return false;
        }

        return true;
    }

    private void animalsInStorehouse() {
        this.console.println("The Animals in this game are:");

        Game game = CityOfAaron.getCurrentGame();
        Storehouse storehouse = game.getTheStorehouse();
        Animal[] animals = storehouse.getAnimals();

        String animalName;
        int animalCount;
        int animalAge;
        for (Animal animal : animals) {
            animalName = animal.getName();
            animalCount = animal.getQuantity();
            animalAge = animal.getAge();
            this.console.println(animalCount + " " + animalName + ": " + animalAge + "-years-old");
        }

        Pair[] maxAge = StorehouseControl.animalMaxAge();
        this.console.println("\nYour " + maxAge[0].getKey() + " is the oldest animal\n"
                + "you have, at " + maxAge[0].getValue() + "-years old.\n"
                + "Consider acquiring a new one.\n");
        saveReport();
    }

    private void toolsInStorehouse() {
        this.console.println("The tools of this game are:");
        InventoryItem[] tools = CityOfAaron.getCurrentGame().getTheStorehouse().getTools();
        String toolName;
        int toolCount;
        for (int i = 0; i < tools.length; i++) {
            toolName = tools[i].getName();
            toolCount = tools[i].getQuantity();
            this.console.println(toolCount + " " + toolName);
        }

        //get tool quantity and put in total variable to use in println
        long total = StorehouseControl.toolQuantity();
        this.console.println("There is a total of " + total + " tools in the Storehouse.");

        saveReport();
    }

    private void provisionsInStorehouse() {

        this.console.println("The provisions you have are:");

        Provision[] provisions = CityOfAaron.getCurrentGame().getTheStorehouse().getProvisions();

        int provisionCount;
        String provisionName;
        for (Provision provision : provisions) {
            provisionCount = provision.getQuantity();
            provisionName = provision.getName();
            this.console.println(provisionName + ", " + provisionCount);
        }

        Pair[] minValue = StorehouseControl.provisionMinValue();
        this.console.println("You only have " + minValue[0].getValue() + " left of " + minValue[0].getKey() + ". You should search for more.\n");
        saveReport();
    }

    private Author authorsOfGame() {

        this.console.println("The authors of this game are:");

        Game game = CityOfAaron.getCurrentGame();
        Storehouse storehouse = game.getTheStorehouse();
        Author[] authors = storehouse.getAuthors();

        for (int i = 0; i < authors.length; i++) {

            this.console.println(authors[i].getName());

        }
        this.console.println();
        saveReport();
        return null;
    }

    private void saveReport() {

        String[] inputs = new String[1];

        inputs[0] = getUserInput("Do you want to save report to file?\n"
                + "Y - Yes\n"
                + "N - No\n");

        switch (inputs[0].trim().toUpperCase()) {
            case "Y":
                this.console.println("GameControl.saveReportToFile() called, implementation coming soon.\n");
                break;
            case "N":
                displayView();
                break;

        }
    }
}
