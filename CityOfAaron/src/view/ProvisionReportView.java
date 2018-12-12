/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cityofaaron.CityOfAaron;
import control.StorehouseControl;
import exceptions.StorehouseControlException;
import model.Provision;
import java.io.*;

/**
 *
 * @author estherhsia
 */
public class ProvisionReportView extends ViewBase {

    public ProvisionReportView() {
        //empty constructor
    }

    @Override
    protected String getMessage() {
        return "Saving Provision Report to a File.\n";
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

        inputs[0] = getUserInput("What name do you want to save this report under?", true);

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
            StorehouseControl.provisionTestInput(filePath);
            writeToFile(filePath);
            this.console.println("Your provision report was successfully saved as " + filePath + "\n");
                    
        } catch (StorehouseControlException sce) {
            ErrorView.display(this.getClass().getName(), sce.getMessage());
        } 
        return false;
    }

    private void writeToFile(String filePath) {

        Provision[] provisions = CityOfAaron.getCurrentGame().getTheStorehouse().getProvisions();

        try (PrintWriter provisionReport = new PrintWriter(new FileWriter(filePath))) {
            provisionReport.println("MY PROVISION REPORT");
            provisionReport.println();

            String formatString = "%-20s %-15s %10s";
            provisionReport.println(String.format(formatString, "ITEM NAME", "CONDITION", "QUANTITY"));
            provisionReport.println("-------------------- --------------- ----------");

            for (int i = 0; i < provisions.length; i++) {
                provisionReport.println(String.format(formatString, provisions[i].getName(), provisions[i].getCondition(), provisions[i].getQuantity()));
            }
            
            provisionReport.println();
            provisionReport.println("End of List");

        } catch (IOException e) {
            ErrorView.display(this.getClass().getName(), "I/O Error: " + e.getMessage());
        }
    }
}
