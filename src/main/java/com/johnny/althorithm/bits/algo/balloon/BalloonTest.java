package com.johnny.althorithm.bits.algo.balloon;

public class BalloonTest {

    public static void main(String[] args) {
        BalloonSolution solution = new BalloonSolution();
        int[] balls = new int[]{3, 1, 5, 8};
        int result = solution.maxCoins(balls);
        System.out.println(result);
    }

}
