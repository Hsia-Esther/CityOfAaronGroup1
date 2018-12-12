/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exceptions.GameControlException;
import exceptions.WheatControlException;

/**
 *
 * @author Brenda
 */
public class WheatControl {

    public static int calculateLossToRats(int tithesPercent, int wheatInStorage) throws WheatControlException, GameControlException {
        //Calculate the amount of wheat in storage lost to rats, based on
        //the percentage of tithing paid. Assume that GameControl.getRandomNumber(low,high)
        //is available to be called.

        //if wheatInStorage < 0 then return -1
        if (wheatInStorage < 0) {
            throw new WheatControlException("There is no wheat in storage.");
        }

        //if tithingPercent < 0 OR tithingPercent > 100 then return -2
        if (tithesPercent < 0 || tithesPercent > 100) {
            throw new WheatControlException("Tithing amount should be between 0-100.");
        }

        //chanceOfRats = GameControl.getRandomNumber(1,100)
        int chanceOfRats = GameControl.getRandomNumber(1, 100);
        //if chanceOfRats >= 30 then return 0
        if (chanceOfRats >= 30) {
            return 0;
        }

        int high = 2;
        int low = 1;

        //if tithingPercent < 8 then low = 6, high = 10        
        if (tithesPercent < 8) {
            low = 6;
            high = 10;
        }

        //if tithingPercent >= 8 AND tithingPercent <= 12 then low = 3, high = 7
        if (tithesPercent >= 8 && tithesPercent <= 12) {
            low = 3;
            high = 7;
        }

        //if tithingPercent > 12 then low = 3, high = 5        
        if (tithesPercent > 12) {
            low = 3;
            high = 5;
        }

        int bushelsLost = 0;
        //percentLost = getRandomNumber(low, high)*0.01 //turn into a fraction        
        int lossToRats = GameControl.getRandomNumber(low, high);
        double percentLost = lossToRats * 0.01;

        //return wheatInStorage * percentLost //will need to be cast back to int        
        bushelsLost = (int) (wheatInStorage * percentLost);

        return bushelsLost;
    }

    public static int calculateHarvest(int tithesPercent, int acresPlanted) throws WheatControlException, GameControlException {

        // Calculate the amount of wheat harvested, based on the percentage 
        // of tithing paid. Assume that GameControl.getRandomNumber(low,high) 
        // is available to be called.
        if (acresPlanted < 0) {
            throw new WheatControlException("There is no wheat in storage.");
        }

        if (tithesPercent < 0 || tithesPercent > 100) {
            throw new WheatControlException("Tithing amount should be between 0-100.");
        }

        //create variables for low and hight, and set values in the if statements
        int high = 2;
        int low = 1;

        //if tithingPercent < 8 then low = 1, high = 3       
        if (tithesPercent < 8) {
            low = 1;
            high = 3;
        }

        //if tithingPercent >= 8 AND tithingPercent <= 12 then low = 2, high = 4
        if (tithesPercent >= 8 && tithesPercent <= 12) {
            low = 2;
            high = 4;
        }

        //if tithingPercent > 12 then low = 2, high = 5        
        if (tithesPercent > 12) {
            low = 2;
            high = 5;
        }

        int yield = 0;

        yield = GameControl.getRandomNumber(low, high);

        return yield * acresPlanted;
    }

    public static void checkNumber(int stringToNum) throws WheatControlException {
        if (stringToNum < 0) {
            throw new WheatControlException("Please enter a positive number.");
        }
    }

    public static boolean checkTithing(int tithes) {
        return tithes >= 0 && tithes <= 100;
    }
}
