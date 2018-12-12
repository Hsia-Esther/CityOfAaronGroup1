package view;

import control.GameControl;
import exceptions.GameControlException;
import java.io.IOException;

/**
 *
 * @author Shay
 */
public class LoadGameView extends ViewBase {

    /**
     * Constructor
     */
    public LoadGameView() {
        //Empty contructor        
    }

    @Override
    protected String getMessage() {
        return "Load a Saved Game.\n";
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

        inputs[0] = getUserInput("Enter the name of the Saved your game\n"
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

        String filePath = inputs[0];

        try {
            GameControl.testInput(inputs);
            GameControl.loadGameFromFile(filePath);
            View gameMenu = new GameMenuView();
            gameMenu.displayView();
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "I/O Error: " + ex.getMessage());
        }

        return false;
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
//    private void loadSavedGameFromName(String gameName){
//      //not sure if the function is called correctly...
//        //loadGameFromFile(gameName);
//        
//        this.console.println("\nloadGameFromFile() called, implementation coming soon.\n");
//      
//    }
}
