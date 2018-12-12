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
public class FeedPeopleView extends ViewBase {
    
    /**
     * Constructor
     */
    public FeedPeopleView(){     
        //empty contructor     
    }
    
    @Override
    protected String getMessage() {
        return "\nFeed Your People";   
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
        
        inputs[0] = getUserInput("How many bushels of grain do you want to give to the people?");
        
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
        
        int bushelsNum = stringToInt(inputs);
        saveBushelsFed(bushelsNum);
        
        return false;
    }
           
    private void saveBushelsFed(int bushelsNum) {
        //stub function, to be completed after AnnualReport is implemented 
        this.console.println("\nYour People have been fed " + bushelsNum + " bushels\n"
                           + "Implentations coming soon\n"
                           + "*Returning To Manage Crop Menu\n");//TODO call function to check and make sure the amount doesn't exceed the wheat in storage and then update and save.
    }       

}