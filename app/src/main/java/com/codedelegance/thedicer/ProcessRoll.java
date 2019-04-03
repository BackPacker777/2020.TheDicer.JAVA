package com.codedelegance.thedicer;

import java.util.Random;

/**
 * Created by bates.he.z on 4/3/2019.
 */
class ProcessRoll {
    private int result;
    private int[] rolls;

    ProcessRoll(int dieQty, int dieType) {
        result = 0;
        Random roll = new Random();
        rolls = new int[dieQty];
        if (dieType == 0 || dieQty == 0) {
            result = 0;
        } else {
            for (int i = 0; i < dieQty; i++) {
                rolls[i] = roll.nextInt(dieType) + 1;
                result = result + roll.nextInt(dieType) + 1;
            }
        }
    }

    int getResult() {
        return result;
    }

    int[] getRolls() {
        return rolls;
    }
}