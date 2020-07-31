package com.brush.daily.medium.leetcode;

/**
 * 题目：
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 示例：
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinimumPathSum_64 {

    public int minPathSum(int[][] grid) {
        //return sum(grid, 0, 0);
        return  sum2(grid);
    }

    /**
     * 递归，遍历
     * 时间复杂度较高
     *
     * @param grid
     * @param row
     * @param len
     * @return
     */
    public int sum(int[][] grid, int row, int len) {
        if (grid.length - 1 == row && grid[0].length - 1 == len) {
            return grid[row][len];
        } else if (grid.length - 1 == row) {
            return grid[row][len] + sum(grid, row, len + 1);
        } else if (grid[0].length - 1 == len) {
            return grid[row][len] + sum(grid, row + 1, len);
        }
        return Math.min(grid[row][len] + sum(grid, row + 1, len), grid[row][len] + sum(grid, row, len + 1));
    }

    /**
     * 动态规划
     *
     * 时间复杂度为O(MN)
     *
     * @param grid
     * @return
     */
    public int sum2(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int len = 0; len < grid[row].length; len++) {
                if (row == 0 && len == 0) {
                    continue;
                } else if (row == 0) {
                    grid[row][len] += grid[row][len - 1];
                } else if (len == 0) {
                    grid[row][len] += grid[row - 1][len];
                } else {
                    grid[row][len] += Math.min(grid[row - 1][len], grid[row][len - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
