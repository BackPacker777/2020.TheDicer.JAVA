package com.codedelegance.thedicer;

import java.util.Random;

/**
 * Created by bates.he.z on 4/3/2019.
 */
class ProcessRoll {

    static int[] performRolls(int dieQty, int dieType) {
        Random roll = new Random();
        int[] rolls;
        rolls = new int[dieQty];
        for (int i = 0; i < dieQty; i++) {
            rolls[i] = roll.nextInt(dieType) + 1;
        }
        return rolls;
    }
}