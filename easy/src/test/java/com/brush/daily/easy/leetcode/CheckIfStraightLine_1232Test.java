package com.brush.daily.easy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfStraightLine_1232Test {

    private CheckIfStraightLine_1232 test = new CheckIfStraightLine_1232();

    @Test
    void checkStraightLine() {
        //int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        //int[][] coordinates = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        //int[][] coordinates = {{0, 0}, {0, 1}, {0, -1}};
        int[][] coordinates = {{1, -8}, {2, -3}, {1, 2}};
        System.out.println(test.checkStraightLine(coordinates));
    }
}