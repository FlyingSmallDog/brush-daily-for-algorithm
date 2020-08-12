package com.brush.daily.medium.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q130Test {

    Q130 q = new Q130();

    @Test
    void solve() {
        char[][] test = new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}};
       // char[][] test = new char[][]{{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        q.solve(test);
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++){
                System.out.print(test[i][j] + " ");
            }
            System.out.println();
        }
    }
}