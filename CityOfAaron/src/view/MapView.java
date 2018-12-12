
package view;

import control.MapControl;
import model.Map;
import model.Location;

/**
 *
 * @author estherhsia
 */
public class MapView extends ViewBase {
    
    public MapView() {
        // empty constructor
    }
    
    @Override
    protected String getMessage() {
           
          return null;      
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
     * should exit and return to previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {
       
        // return false if you want this view to exit and return
        // to the view that called it.

        displayMap();
        return false;
    }
    
    public void displayMap() {
        this.console.println("As the ruler of the City of Aaron,");
        this.console.println("you have access to the city map and its secrets.");
        this.console.println("------------------------------");
        
        Map map = MapControl.createMap();    
        Location[][] locations = map.getLocations();

        for (int i = 0; i < locations.length; i++) {

            for (int j = 0; j < locations[i].length; j++) {
                this.console.printf("%3s", map.getLocations()[i][j].getMapSymbol());
            }
            this.console.println();
        }
        this.console.println("------------------------------");
        this.console.println("C - Ruler's Court");
        this.console.println("S - City Granary and Storehouse");
        this.console.println("F - Wheat field");
        this.console.println("U - Undeveloped land");
        this.console.println("V - Village");
        this.console.println("R - River"); 
        this.console.println("B - Border of the Lamanite lands");
        this.console.println("T - Temple");
        this.console.println("W - Watchtower\n"); 
        pause(1500);
    }

}
