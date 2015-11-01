package com.company.Domain;

import java.util.Random;

/**
 * Created by Gudmundur Bjarni Kristinsson on 01-Nov-15.
 * gudmundurk14@ru.is
 * kt: 110384-3279
 */
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
