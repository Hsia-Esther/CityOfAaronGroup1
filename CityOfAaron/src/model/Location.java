/*
 * Location class
 */
package model;
import java.util.Arrays;
import java.io.Serializable;

/**
 *
 * @author Shay
 */
public class Location implements Serializable {
    private String name;
    private String description;
    private String mapSymbol;
    private String[] gameTips;
    
    public Location() {
    //empty constructor for JavaBeans
    }
    
    public Location(String mapSymbol, String name, String description, String[] tips) {
        setMapSymbol(mapSymbol);
        setName(name);
        setDescription(description);
        setGameTips(tips);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getMapSymbol() {
        return mapSymbol;
    }
    
    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }
    
    public String[] getGameTips() {
        return gameTips;
    }
    
    public void setGameTips(String[] gameTips) {
        this.gameTips = gameTips;
    }
    
    @Override
    public String toString() {
        return "Location { "
                + ", name = " + name
                + ", decription = " + description
                + ", mapSymbol = " + mapSymbol
                + ", gameTips = " + Arrays.toString(gameTips)
                + " }";
    }
    
}