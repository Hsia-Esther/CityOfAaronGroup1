package control;

import java.util.Random;
import java.util.ArrayList;

/**
 * Provides a class that can be used anywhere a Random is used, but
 * it overrides nextInt(int bound) to return predetermined values.
 */
public class FakeRandom extends Random {
    
    //Required because Random is Serializable
    private static final long serialVersionUID = 1L;
        
    //Store the predetermined integer value that have been added to the object.
    private ArrayList<Integer> integersToReturn = new ArrayList<>();
  
    /** 
    *Add the specified integer value to the list of values that will be
    *returned by the nextInt() method.
    */
    public void add(int number) {
        integersToReturn.add(number);
    }
    
    /**
     * Returns the next predetermined value from the list, or -1 if there
     * are no more predetermined values to be returned
     */
    @Override
    public int nextInt(int bound) {
        //Make sure we have something to return
        if (integersToReturn.size() == 0) {
            return -1;
        }
        
        int returnInteger = integersToReturn.get(0);
        
        //revove the value so we don't reuse it.
        integersToReturn.remove(0);
        
        return returnInteger;
    }
    
}
