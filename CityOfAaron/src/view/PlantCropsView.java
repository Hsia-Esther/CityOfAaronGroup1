
package view;

/**
 *
 *  @author shay
 */
public class PlantCropsView extends ViewBase {
    
    /**
     * Constructor
     */
    public PlantCropsView(){     
        //empty contructor     
    }
    
    @Override
    protected String getMessage() {
        return "\nPlant Crops";   
    }
    
    /**
     * Get the set of inputs from the user.
     * @return 
     */
    @Override
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];
        
        inputs[0] = getUserInput("How many acres of land do you want to plant?");
        
        // Repeat for each input you need, putting it into its proper slot in the array.
        
        return inputs;
    }
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs){
        
        int cropNum = stringToInt(inputs);
        saveCropsPlanted(cropNum);
        
        return false;
    }
           
    private void saveCropsPlanted(int cropNum) {
        //stub function, to be completed after AnnualReport is implemented 
        this.console.println("\n" + cropNum + " acres will be planted\n"
                           + "Implentations coming soon\n"
                           + "*Returning To Manage Crop Menu\n");//TODO: call function to make sure the amount being planted is possible, update, and save.
    }       

}
