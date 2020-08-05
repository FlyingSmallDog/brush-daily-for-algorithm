package com.brush.daily.medium.leetcode;

import java.util.Map;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * <p>
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 *      3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HouseRobberIII_337 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        return method1(root);
        /**方法2
            HashMap<TreeNode, Integer> memo = new HashMap<>();
            return method2(root, memo);
         */
        /**方法3
         * int[] result = method3(root);
         * return Math.max(result[0],result[1]);
         */
    }

    /**
     * 方法1
     * 暴力递归 - 最优子结构
     * 在解法一和解法二中，我们使用爷爷、两个孩子、4 个孙子来说明问题
     * 首先来定义这个问题的状态
     * 爷爷节点获取到最大的偷取的钱数呢
     * <p>
     * 首先要明确相邻的节点不能偷，也就是爷爷选择偷，儿子就不能偷了，但是孙子可以偷
     * 二叉树只有左右两个孩子，一个爷爷最多 2 个儿子，4 个孙子
     * 根据以上条件，我们可以得出单个节点的钱该怎么算
     * 4 个孙子偷的钱 + 爷爷的钱 VS 两个儿子偷的钱 哪个组合钱多，就当做当前节点能偷的最大钱数。这就是动态规划里面的最优子结构
     * <p>
     * 由于是二叉树，这里可以选择计算所有子节点
     * <p>
     * 4 个孙子投的钱加上爷爷的钱如下
     * int method1 = root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right)
     * 两个儿子偷的钱如下
     * int method2 = rob(root.left) + rob(root.right);
     * 挑选一个钱数多的方案则
     * int result = Math.max(method1, method2);
     *
     * @param root 根节点
     * @return
     */
    public int method1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        } else if (root.left == null && root.right != null) {
            return Math.max(root.val + rob(root.right.left) + rob(root.right.right), rob(root.right));
        } else if (root.left != null && root.right == null) {
            return Math.max(root.val + rob(root.left.left) + rob(root.left.right), rob(root.left));
        } else {
            return Math.max(root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right), rob(root.right) + rob(root.left));
        }
    }

    /**
     * 方法2
     * 记忆化 - 解决重复子问题
     * 针对解法一种速度太慢的问题，经过分析其实现，我们发现爷爷在计算自己能偷多少钱的时候，同时计算了 4 个孙子能偷多少钱，也计算了 2 个儿子能偷多少钱。这样在儿子当爷爷时，就会产生重复计算一遍孙子节点。
     * <p>
     * 于是乎我们发现了一个动态规划的关键优化点
     * <p>
     * 重复子问题
     * <p>
     * 我们这一步针对重复子问题进行优化，我们在做斐波那契数列时，使用的优化方案是记忆化，但是之前的问题都是使用数组解决的，把每次计算的结果都存起来，下次如果再来计算，就从缓存中取，不再计算了，这样就保证每个数字只计算一次。
     * 由于二叉树不适合拿数组当缓存，我们这次使用哈希表来存储结果，TreeNode 当做 key，能偷的钱当做 value
     *
     * @param root 根节点
     * @param memo 缓存map
     * @return
     */
    public int method2(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int money = root.val;

        if (root.left != null) {
            money += (method2(root.left.left, memo) + method2(root.left.right, memo));
        }
        if (root.right != null) {
            money += (method2(root.right.left, memo) + method2(root.right.right, memo));
        }
        int result = Math.max(money, method2(root.left, memo) + method2(root.right, memo));
        memo.put(root, result);
        return result;
    }

    /**
     * 方法3
     *
     * 上面两种解法用到了孙子节点，计算爷爷节点能偷的钱还要同时去计算孙子节点投的钱，虽然有了记忆化，但是还是有性能损耗。
     *
     * 我们换一种办法来定义此问题
     *
     * 每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
     *
     * 当前节点选择偷时，那么两个孩子节点就不能选择偷了
     * 当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
     * 我们使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
     * 任何一个节点能偷到的最大钱的状态可以定义为
     *
     * 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     * 当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     * 表示为公式如下
     *
     *
     * root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
     * root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
     */
    public int[] method3(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = method3(root.left);
        int[] right = method3(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
