/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
/**
 *
 * @author Brenda
 */
public class Provision extends InventoryItem implements Serializable{
    private Boolean perishable;
    
    public Provision() {
        //empty default constructor for JavaBeans
    }
    
    public Provision(ItemType itemType, int quantity, Condition condition, String name, boolean perishable) {
        setItemType(itemType);
        setQuantity(quantity);
        setCondition(condition);
        setName(name);
        setPerishable(perishable);
    }
    
    public Boolean getPerishable() {
        return perishable;
    }
    
    public void setPerishable(Boolean perishable) {
        this.perishable = perishable;
    }

    @Override
    public String toString() {
        return String.format("Provision {%s, perishable=%s}", 
                super.toString(), perishable);
    }
    
}
