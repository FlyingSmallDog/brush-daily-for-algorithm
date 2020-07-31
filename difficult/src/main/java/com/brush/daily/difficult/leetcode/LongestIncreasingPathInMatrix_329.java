package com.brush.daily.difficult.leetcode;

/**
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 */

/**
 * 解题：DFS + 备忘录
 */
public class LongestIncreasingPathInMatrix_329 {


    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        //防止特例输入空数组，导致初始化备忘录数组出错
        if(matrix.length==0 || matrix[0].length == 0) {
            return 0;
        }
        //备忘录数组
        int[][] maxPaths = new int[matrix.length][matrix[0].length];
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int j = 0; j <= matrix[i].length - 1; j++) {
                if (maxPaths[i][j] != 0) continue;
                int left = maxPath(matrix, maxPaths, i - 1, j, matrix[i][j]);
                int right = maxPath(matrix, maxPaths, i + 1, j, matrix[i][j]);
                int bottom = maxPath(matrix, maxPaths, i, j + 1, matrix[i][j]);
                int top = maxPath(matrix, maxPaths, i, j - 1, matrix[i][j]);
                maxPaths[i][j] = Math.max(Math.max(left, right), Math.max(bottom, top)) + 1;
            }
        }
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int j = 0; j <= matrix[i].length - 1; j++) {
                result = Math.max(maxPaths[i][j], result);
            }
        }
        return result;
    }


    public int maxPath(int[][] matrix, int[][] maxPaths, int x, int y, int val) {
        int max = 0;
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || val >= matrix[x][y]) {
            return max;
        }
        if (maxPaths[x][y] != 0) {
            return maxPaths[x][y];
        }
        int left = maxPath(matrix, maxPaths, x - 1, y, matrix[x][y]);
        int right = maxPath(matrix, maxPaths, x + 1, y, matrix[x][y]);
        int bottom = maxPath(matrix, maxPaths, x, y + 1, matrix[x][y]);
        int top = maxPath(matrix, maxPaths, x, y - 1, matrix[x][y]);

        maxPaths[x][y] = Math.max(Math.max(left, right), Math.max(bottom, top)) + 1;
        return maxPaths[x][y];
    }
}
