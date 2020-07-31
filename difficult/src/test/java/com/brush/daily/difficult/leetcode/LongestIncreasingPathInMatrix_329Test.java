package com.brush.daily.difficult.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingPathInMatrix_329Test {

    LongestIncreasingPathInMatrix_329 objects = new LongestIncreasingPathInMatrix_329();

    @Test
    void longestIncreasingPath() {
        int[][] test = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(objects.longestIncreasingPath(test));
    }
}