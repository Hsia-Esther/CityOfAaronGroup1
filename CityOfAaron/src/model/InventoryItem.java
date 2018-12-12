/*
 * InventoryItem class
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Brenda
 */
public class InventoryItem implements Serializable{
    private ItemType itemType;
    private int quantity;
    private Condition condition;
    private String name;
    
    public InventoryItem() {
     //empty default constructor for JavaBeans  
    }
    
    public InventoryItem(ItemType itemType, int quantity, Condition condition, String name) {
        setItemType(itemType);
        setQuantity(quantity);
        setCondition(condition);
        setName(name);
    }
    
    public ItemType getItemType() {
        return itemType;
    }
    
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public Condition getCondition() {
        return condition;
    }
    
    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "InventoryItem {"
            + " itemType = " + itemType
            + ", quantity = " + quantity 
            + ", condition = " + condition
            + " }";        
    }
    
}

