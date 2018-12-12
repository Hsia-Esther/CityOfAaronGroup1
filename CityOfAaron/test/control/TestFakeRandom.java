package control;

import org.junit.Test;
import static org.junit.Assert.*;
 
public class TestFakeRandom {
 
    /**
     * Demonstrate the basic use of FakeRandom class.
     */
    @Test
    public void demonstrateHowToUseFakeRandom() {
        
        //Create an instance of the FakeRandom class. We
        //can use this anywhere a real Random is needed because
        //FakeRandom extends Random.
        FakeRandom fakeRandom = new FakeRandom();
        
        //Stuff the fake random wiht a few test values.
        //fakeRandom.add(1);
        fakeRandom.add(5);
        
        //Yes, because this is a simple class used for testing, you can 
        //abuse it and violate the normal semantics of Random.
        fakeRandom.add(-23);
        
        //Now test the values.
        assertEquals(1, fakeRandom.nextInt(10));
        assertEquals(5, fakeRandom.nextInt(10));
        assertEquals(-23, fakeRandom.nextInt(10));
        
        //Test the "empty" behavior.
        assertEquals(-1, fakeRandom.nextInt(10));
    }
    
    /**
     * Demonstrate how to use the FakeRandom class as a substitute for the
     * Random class in our GameControl.
     */
    @Test
    public void demonstrateInjectingFakeRandom() {
        
//        FakeRandom fakeRandom = new FakeRandom();
//        
//        //Here's the trick... remember that protected static setRandomGenerator() method
//        //in our GameControl class? This is what that's for. We're going to inject
//        //a different Random object, our fakeRandom, and it's going to provide the
//        //predetermined value to the getRandomNumber() function.
//        GameControl.setRandomGenerator(fakeRandom);
//        
//        //Voila!
//        fakeRandom.add(5); //17 + 5 = 22
//        assertEquals(22, GameControl.getRandomNumber(17, 27));
//        
//        //We can add new numbers to the list any time we need to.
//        fakeRandom.add(35); //0 + 35 = 35
//        assertEquals(35, GameControl.getRandomNumber(0, 100));
//        
    }
}
