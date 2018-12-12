/*
 * Player class
 */
package model;

import java.io.Serializable;

/**
 *
 * @author estherhsia
 */
public class Player implements Serializable {
    
    private String name;
    
    public Player() {
        //empty for default constructor
    } 
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
       return "Player {"
               + " name = " + name
               + " }";
    } 
    
}
