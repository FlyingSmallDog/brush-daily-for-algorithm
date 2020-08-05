package com.brush.daily.easy.leetcode;

/**
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * <p>
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 * <p>
 * 示例：
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 */
public class CheckIfStraightLine_1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 1; i < coordinates.length - 1; i++) {
            int mut1 = (coordinates[i][1] - coordinates[i - 1][1]) * (coordinates[i + 1][0] - coordinates[i][0]);
            int mut2 = (coordinates[i + 1][1] - coordinates[i][1]) * (coordinates[i][0] - coordinates[i - 1][0]);
            if (mut1 != mut2) {
                return false;
            }
        }
        return true;
    }
}
