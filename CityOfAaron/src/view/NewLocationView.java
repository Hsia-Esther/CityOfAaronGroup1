/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.MapControl;
import model.Point;
import exceptions.MapControlException;

/**
 *
 * @author estherhsia
 */
public class NewLocationView extends ViewBase {

    /**
     * Constructor
     */
    public NewLocationView() {
        // empty constructor
    }

    @Override
    protected String getMessage() {
        return "\nMoving to a new location";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend
        // to get from user
        String[] inputs = new String[2];

        inputs[0] = getUserInput("Enter the column coordinate you wish to move to:");
        inputs[1] = getUserInput("Enter the row coordinate you wish to move to:");

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

        // call setCurrentLocation() to set current location in the map
        int column = 0;
        int row = 0;
        boolean inputValid = false;

        try {
            column = Integer.parseInt(inputs[0]);
            row = Integer.parseInt(inputs[1]);
            MapControl.checkNewLocation(column, row);

            inputValid = true;
            moveToNewLocation(column, row);
        } catch (NumberFormatException ex) {
            ErrorView.display(this.getClass().getName(), "Please enter a number.");
        } catch (MapControlException mce) {
            ErrorView.display(this.getClass().getName(), mce.getMessage());
        }

        return !inputValid;
    }

    private void moveToNewLocation(int column, int row) {

        Point point = new Point();
        point.setColumn(column);
        point.setRow(row);

        //TODO call setCurrentLocation() to set coordinates then the location at new coordinates
        this.console.println("\nsetCurrentLocation() called.\n");
    }

}
