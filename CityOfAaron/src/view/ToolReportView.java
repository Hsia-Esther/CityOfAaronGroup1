package view;

import cityofaaron.CityOfAaron;
import control.StorehouseControl;
import exceptions.StorehouseControlException;
import java.io.*;
import model.InventoryItem;
import model.Condition;

/**
 *
 * @author brenda
 */
public class ToolReportView extends ViewBase {
    
    public ToolReportView() {
        //empty constructor
    }
    
    @Override
    protected String getMessage() {
        return "Send Tool Report to file:\n";
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

        inputs[0] = getUserInput("Please enter the name you would like the report to be saved as\n"
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
            this.console.println("Tool Report saved as " + fileName);

        } catch (StorehouseControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;
        }
        // to end the loop
        return false;
    }
    
    private void writeReport(String fileName) {
        
        InventoryItem[] tools = CityOfAaron.getCurrentGame().getTheStorehouse().getTools();
//        String toolName;
//        int toolCount;
//        Condition condition;
        
        try (PrintWriter report = new PrintWriter(new FileWriter(fileName))) {
            report.println("TOOL REPORT");
            report.println();
            
            String formatString = "%-10s %-20s %10s";
            report.println(String.format(formatString, "QUANTITY", "TOOL NAME", "CONDITION"));
            report.println("---------- -------------------- ----------");
            
            for (InventoryItem tool : tools) {
                report.println(String.format(formatString, tool.getQuantity(), tool.getName(),
                        tool.getCondition()));
//                toolName = tool.getName();
//                toolCount = tool.getQuantity();
//                condition = tool.getCondition();
            }
            report.println();
            report.println("End of Tool Report");
            
            report.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
