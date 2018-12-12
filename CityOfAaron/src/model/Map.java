/*
 * Map class
 */
package model;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Shay
 */
public class Map implements Serializable {
    
    private Location[][] locations = new Location[5][5];
    private Point currentLocation;
    
    public Map(){
        //empty for default constructor
    }
    
    public Location[][] getLocations() {
        return locations;
    }
    
    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }
    
    public Point getCurrentLocation() {
        return currentLocation;
    }
    
    public void setCurrentLocation (Point currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    @Override
    public String toString() {
        return "Map { "
                + ", locations = " + Arrays.toString(locations)
                + ", currentLocation = " + currentLocation
                + " }";
    }
}
