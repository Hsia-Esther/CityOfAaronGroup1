
package view;

/**
 *
 * 
 */
public class StartProgramView extends ViewBase {
    
    /**
     * Constructor
     */
    public StartProgramView(){     
        super();      
    }
    
    @Override
    protected String getMessage() {
        return "Welcome to the city of Aaron.\n"
                + "You have just been installed as the new ruler of this city.\n"  
                + "Your responsiblities include:\n" 
                + "- Buying and selling land\n"
                + "- Determining how much wheat to plant\n"
                + "- Determining how much wheat to feed your people\n"
                + "- Deciding how much annual tithing to pay on the wheat harvest\n"
                + "Choose wisely! Based on your choices, some of your workforce may starve to death.\n"
                + "Be aware that you may lose some of your harvest to rats.\n";   
    }
    
    /**
     * Get the set of inputs from the user.
     * @return 
     */
    @Override
    public String[] getInputs() {
        
        // this view is not interactive, all it does is show the game description
        return null;
    }
    
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs){
        
        startMainMenuView();
        
        return false;
    }
   
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
   
    private void startMainMenuView(){
        
        pause(2000);
        View mainMenu = new MainMenuView();
        mainMenu.displayView();
      
    }
}
