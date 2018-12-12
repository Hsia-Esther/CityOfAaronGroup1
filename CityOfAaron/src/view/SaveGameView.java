package view;
import cityofaaron.CityOfAaron;
import control.GameControl;
import model.Game;
import exceptions.GameControlException;
import java.io.IOException;

/**
 *
 * @author estherhsia
 */
public class SaveGameView extends ViewBase {
    
    /**
     * Constructor
     */
    public SaveGameView() {
        // empty constructor
    }
    
    @Override
    protected String getMessage() {
        return "Creating file\n";
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
        
        inputs[0] = getUserInput("What is the name of the file you wish to save?");
        
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
        
        // call control method
        
       String filePath = inputs[0];
       Game game = CityOfAaron.getCurrentGame();
       
       try {
           GameControl.saveGameToFile(game, filePath);
       } catch(GameControlException gce) {
           ErrorView.display(this.getClass().getName(), gce.getMessage());
           return false;
       } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "I/O Error: " + ex.getMessage());
        }
       
       this.console.println("Your game has been saved as " + filePath);
        
        return false;
    }
    
}


