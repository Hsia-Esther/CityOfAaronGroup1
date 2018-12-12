package view;

import control.WheatControl;
import exceptions.WheatControlException;

/**
 *
 * @author bwicker
 */
public class TithesPercentView extends ViewBase {

    /**
     * Constructor
     */
    public TithesPercentView() {
        //empty constructor       
    }

    @Override
    protected String getMessage() {
        return "It is time to decide your tithing payment for the year.\n";
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
        inputs[0] = getUserInput("Enter a number that will be the percent of your harvest that you pay in tithing.");

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
        int tithes = 0;
        boolean inputValid = false;

        try {
            tithes = Integer.parseInt(inputs[0]);
            if (WheatControl.checkTithing(tithes) == false) {
                ErrorView.display(this.getClass().getName(), "Tithing value of "
                        + tithes
                        + " is invalid. It should be between 0 and 100.");
                return true;
            }
            inputValid = true;
            saveTithing(tithes);
        } catch (NumberFormatException ex) {
            ErrorView.display(this.getClass().getName(), "Please enter a number.");
        }

        return !inputValid;
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void saveTithing(int tithingPercent) {
        //TODO stub function, to be completed after AnnualReport is implemented 
        this.console.println("Saving tithing percent");
    }

}
