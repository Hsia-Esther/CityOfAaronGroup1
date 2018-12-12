
package control;

import org.junit.Test;
import static org.junit.Assert.*;

public class GetRandomNumberTests {
    
    public GetRandomNumberTests() {
    }

    /**
     * Test of getRandomNumber method, of class GameControl.
     */
    @Test
    public void InputsNotNegativeTest() {
//        int random = GameControl.getRandomNumber(-1, 10);
//        assertEquals(-1, random);
//
//        random = GameControl.getRandomNumber(8, -1);
//        assertEquals(-1, random);
//      
    }
    
    @Test
    public void InputOrderTest() {
//        int random = GameControl.getRandomNumber(90, 8);
//        assertEquals(-2, random);
//        
//        random = GameControl.getRandomNumber(6, 6);
//        assertEquals(-2, random);
    }

    @Test
    public void MaxIntegerTest() {
//        int random = GameControl.getRandomNumber(0, Integer.MAX_VALUE);
//        assertEquals(-3, random);
    }  
    
    @Test
    public void ValidRangeTest() {
//        int[][] testRanges = new int[][]{
//            {1, 10},
//            {25, 100},
//            {7, 8},
//            {0, Integer.MAX_VALUE-1}
//        };
//        
//        for (int i=0; i < testRanges.length; i++) {
//            int low = testRanges[i][0];
//            int high = testRanges[i][1];
//            
//            int random = GameControl.getRandomNumber(low, high);
//            this.console.printf("%d <= %d <= %d\n", low, random, high);
//            
//            assertTrue(
//                String.format("%d should be between %d and %d", random, low, high),
//                random >= low && random <= high);
//        }
    }
    
}
