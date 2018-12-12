
package control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author estherhsia
 */
public class PeopleControlTest {
    
    public PeopleControlTest() {
    }

    /**
     * Test of calculateMortality method, of class PeopleControl.
     */
    @Test
    public void validInputTest() {
//        int bushelsForFood = 1000;
//        int currentPopulation = 55;
//        int expResult = 5;
//        int result = PeopleControl.calculateMortality(bushelsForFood, currentPopulation);
//        assertEquals(expResult, result);

    }
    
    @Test
    public void invalidInputTest1() {
//        int result = PeopleControl.calculateMortality(-1, 90);
//        assertEquals(-1, result);
    }
    
    @Test
    public void invalidInputTest2() {
//        int result = PeopleControl.calculateMortality(250, -1);
//        assertEquals(-1, result);
    }
    
    @Test
    public void invalidInputTest3() {
//        int result = PeopleControl.calculateMortality(-1, -1);
//        assertEquals(-1, result);
    }
    
    @Test
    public void lowBoundaryTest() {
//        int result = PeopleControl.calculateMortality(0, 88);
//        assertEquals(88, result);
    }
    
    @Test
    public void highBoundaryTest() {
//        int result = PeopleControl.calculateMortality(1500, 70);
//        assertEquals(0, result);
    }
    
}
