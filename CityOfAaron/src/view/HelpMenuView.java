
package view;

/**
 *
 * @author kanderson
 */
public class HelpMenuView extends ViewBase {

    /**
     * Constructor
     */
    public HelpMenuView(){
        // empty constructor      
    }
    
    @Override
    protected String getMessage() {
        return "Help Menu\n"
                + "----------------------\n"
                + "G - What are the goals of the game?\n"
                + "C - Where is the City of Aaron?\n"
                + "V - How do I view the Map?\n"
                + "L - How do I move to another Location?\n"
                + "S - How do I display a list of animals, provisions, and tools in the city Storehouse?\n"
                + "M - Return to the Main Menu\n";
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
        
        inputs[0] = getUserInput("What would you like to know?");
        
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
        switch(inputs[0].trim().toUpperCase()){
            case "G":
                this.console.println("Manage your resources wisely and remain ruler for 10 years.\n");
                break;   
            case "C":
                this.console.println("Messages about where the City of Aaron is\n");
                break;
            case "V":
                this.console.println("Message about how to view the Map\n");
                break;
            case "L":
                this.console.println("Message about how to move to another Location\n");
                break;
            case "S":
                this.console.println("Message about how to display the list of items in the Storehouse\n");
                break;
            case "M":
                return false;
        } 
        
        return true;
    }

}