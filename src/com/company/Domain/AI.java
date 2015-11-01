package com.company.Domain;

import java.util.Random;

public class AI extends Player {
    public AI() {
        name = "Computer";
        isHuman = false;
    }
    @Override
    public int[] generateMove() {
        Random rand = new Random();
        int x = rand.nextInt(3 - 0);
        int y = rand.nextInt(3 - 0);
        int[] arr = {x, y};
        return arr;
    }
}
