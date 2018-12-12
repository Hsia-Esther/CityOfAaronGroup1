
package view;


/**
 *
 * @author Shay
 */
public class ManageCropMenuView extends ViewBase {
    
    
    /**
     * Constructor
     */
    public ManageCropMenuView(){
       //Empty Constructor    
    }
    
    @Override
    protected String getMessage() {
      return    "Crop Management Menu\n"
                + "----------------------\n"
                + "B - Buy Land\n"
                + "S - Sell Land\n"
                + "F - Feed the People\n"
                + "P - Plant Crops\n"
                + "T - Pay Tithes and Offereings\n"
                + "M - Return to the Game Menu\n";  
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
        
        inputs[0] = getUserInput("What would you like to do?");
        
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
        // Act on the user's input.
        // This is a "dispatch" function that decides what
        // other functions to call. You can use an if-, if-else,
        // or switch statement.
        
        // return false if you want this view to exit and return
        // to the view that called it.
        switch(inputs[0].trim().toUpperCase()){
            case "B":
                View buyLand = new BuyLandView();
                buyLand.displayView();
                break;   
            case "S":
                View sellLand = new SellLandView();
                sellLand.displayView();
                break;
            case "F":
                View feedPeople = new FeedPeopleView();
                feedPeople.displayView();
                break;
            case "P":
                View plantCrops = new PlantCropsView();
                plantCrops.displayView();
                break;
            case "T":
                TithesPercentView tithesPercent = new TithesPercentView();
                tithesPercent.displayView();
                break;
            case "M":    
                return false;
                    
        } 
        
        return true;
    }
    
}
