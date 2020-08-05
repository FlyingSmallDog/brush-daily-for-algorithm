package com.brush.daily.medium.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberIII_337Test {

    private HouseRobberIII_337 test = new HouseRobberIII_337();

    @Test
    void rob() {
        // test 1
        /*HouseRobberIII_337.TreeNode tree = new HouseRobberIII_337.TreeNode(3);
        HouseRobberIII_337.TreeNode leftSon = new HouseRobberIII_337.TreeNode(2);
        HouseRobberIII_337.TreeNode rightSon = new HouseRobberIII_337.TreeNode(3);
        tree.left = leftSon;
        tree.right = rightSon;
        leftSon.right = new HouseRobberIII_337.TreeNode(3);
        rightSon.right = new HouseRobberIII_337.TreeNode(1);*/

        //test2
        HouseRobberIII_337.TreeNode tree = new HouseRobberIII_337.TreeNode(3);
        HouseRobberIII_337.TreeNode leftSon = new HouseRobberIII_337.TreeNode(4);
        HouseRobberIII_337.TreeNode rightSon = new HouseRobberIII_337.TreeNode(5);
        tree.left = leftSon;
        tree.right = rightSon;
        leftSon.left = new HouseRobberIII_337.TreeNode(1);
        leftSon.right = new HouseRobberIII_337.TreeNode(3);
        rightSon.right = new HouseRobberIII_337.TreeNode(1);
        System.out.println(test.rob(tree));
    }
}