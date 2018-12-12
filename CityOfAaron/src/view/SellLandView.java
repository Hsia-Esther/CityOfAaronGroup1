/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 *  @author shay
 */
public class SellLandView extends ViewBase {
    
    /**
     * Constructor
     */
    public SellLandView(){     
        //empty contructor     
    }
    
    @Override
    protected String getMessage() {
        return "\nSell Land";   
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
        
        inputs[0] = getUserInput("How many acres of new land do you want sell?");
        
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
        
        int num = stringToInt(inputs);
        saveAcersSold(num);
           
        return false;
   }
          
    
    private void saveAcersSold(int num) {
        //stub function, to be completed after AnnualReport is implemented 
        this.console.println("\n" + num + " acres of land sold is being saved\n"
                           + "Implentations coming soon\n"
                           + "*Returning To Manage Crop Menu\n");//TODO call function to save and update land owned.
    } 
    

}    
    
