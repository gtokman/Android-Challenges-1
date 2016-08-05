package com.garytokman.tokmangary_ce02.model;

import java.util.Random;

/**
 * Created by gtokman1 on 8/4/16.
 */
public class GuessNumber {

    // Fields
    private Random mRandomNumber = new Random();


    // Get / Set
    public int getRandomNumber() {
        return mRandomNumber.nextInt(10); // Does not include upper bound 0 - 9
    }


}
