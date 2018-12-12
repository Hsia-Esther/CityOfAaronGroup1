package control;

import exceptions.PeopleControlException;

/**
 *
 * @author estherhsia
 */
public class PeopleControl {

    public static int calculateMortality(int bushelsForFood, int currentPopulation) throws PeopleControlException {

        // Calculate the number of people who are not fed the amount required to
        // sustain life (20 bushels per person).  They die.  It is very sad.
        // if bushelsForFood < 0 then return -1
        if (bushelsForFood < 0) {
            throw new PeopleControlException("The number must be greater than zero.");
        }

        // if currentPopulation < 0 then return -1
        if (currentPopulation < 0) {
            throw new PeopleControlException("The current population must be greater than zero.");
        }

        // numberOfPeopleFed = bushelsForFood / 20
        int numberOfPeopleFed = bushelsForFood / 20;

        //if numberOfPeopleFed > currentPopulation then return 0 // everyone got fed
        // otherwise return currentPopulation - numberOfPeopleFed
        if (numberOfPeopleFed > currentPopulation) {
            return 0;
        } else {
            return currentPopulation - numberOfPeopleFed;
        }

    }
}
