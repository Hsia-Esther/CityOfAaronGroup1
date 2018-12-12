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
public class Animal extends InventoryItem implements Serializable {
    private int age;
        
    public Animal() {
     //empty default constructor for JavaBeans  
    }  
    
    public Animal(ItemType itemType, int quantity, Condition condition, String name, int age){
        setItemType(itemType);
        setQuantity(quantity);
        setCondition(condition);
        setName(name);
        setAge(age);
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Animal {%s, age=%s}", 
                super.toString(), age);
    }
}
    
