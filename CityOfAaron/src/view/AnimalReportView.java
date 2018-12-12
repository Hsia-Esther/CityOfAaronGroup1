/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cityofaaron.CityOfAaron;
import control.StorehouseControl;
import exceptions.StorehouseControlException;
import model.Animal;
import java.io.*;

/**
 *
 * @author shay
 */
public class AnimalReportView extends ViewBase {

    public AnimalReportView() {
        //empty constuctor
    }

    @Override
    protected String getMessage() {
        return "\nWant to save Animal Report to a file?";
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

        inputs[0] = getUserInput("Please enter the name you would like the report saved as\n"
                + "\t\t-OR-\n"
                + "Press Enter to return to the Reports Menu", true);
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
            StorehouseControl.testInput(inputs);
            String fileName = inputs[0];
            writeReport(fileName);
            this.console.println("---------------------------------------------\n"
                    + "This Animal Report is saved as: " + fileName + "\n"
                    + "---------------------------------------------\n"
                    + "Returning to Reports Menu\n\n");

        } catch (StorehouseControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;
        }
        // to end the loop
        return false;
    }

    private void writeReport(String fileName) {
        Animal[] animals = CityOfAaron.getCurrentGame().getTheStorehouse().getAnimals();

        try (PrintWriter animalReport = new PrintWriter(new FileWriter(fileName))) {
            animalReport.println("Animal Report");
            animalReport.println();

            String format = "%-20s %-10s %10s";
            animalReport.println(String.format(format, "Quntity", "Type", "Age"));
            animalReport.println("-----------------------------------");

           
            for (int i = 0; i < animals.length; i++) {
                animalReport.println(String.format(format, animals[i].getQuantity(), animals[i].getName(), animals[i].getAge()));
            }
            animalReport.println();
            animalReport.println("End of Animla Report");

            animalReport.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
