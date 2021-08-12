package com.johnny.althorithm.balloon;

import java.util.Vector;

public class BalloonSolution {

    public int result = 0;

    public int maxCoins(int[] balls) {
        if (balls.length == 0) {
            return result;
        }
        Vector<Integer> ballVector = new Vector<>();
        for (int i = 0; i < balls.length; i++) {
            ballVector.add(balls[i]);
        }
        backTrack(ballVector, 0);
        return result;
    }

    public void backTrack(Vector<Integer> balls, int coins) {
        if (balls.isEmpty()) {
            result = Math.max(coins, result);
            return;
        }
        for (int i = 0; i < balls.size(); i++) {
            int left = i == 0 ? 1 : balls.get(i - 1);
            int right = i == balls.size() - 1 ? 1 : balls.get(i + 1);
            int coin = left * balls.get(i) * right;

            Vector<Integer> others = new Vector<>();
            for (int j = 0; j < balls.size(); j++) {
                if (j != i) {
                    others.add(balls.get(j));
                }
            }
            backTrack(others, coin + coins);
        }
    }

}
