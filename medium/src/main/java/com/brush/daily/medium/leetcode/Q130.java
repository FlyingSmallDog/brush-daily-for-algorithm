package com.brush.daily.medium.leetcode;

/**
 * 130. 被围绕的区域
 * <p>
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Q130 {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;

        //上
        for (int i = 0; i < board.length; i++) {
            doInit(board, i, 0);
            doInit(board, i, board[0].length - 1);
        }

        for (int i = 1; i < board[0].length - 1; i++) {
            doInit(board, 0, i);
            doInit(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void doInit(char[][] board, int i, int j) {
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        doInit(board, i, j - 1);
        doInit(board, i, j + 1);
        doInit(board, i - 1, j);
        doInit(board, i + 1, j);

    }
}
