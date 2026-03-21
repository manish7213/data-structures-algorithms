package Trees.BinaryTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">MaxPathSumBinaryTree</a>
 */
public class Q15_MaxPathSumBinaryTree {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = helper(root.left);
        int rightMax = helper(root.right);

        int currentSum = root.val + leftMax + rightMax;

        max = Math.max(root.val, Math.max(max, Math.max(currentSum, Math.max(leftMax, rightMax) + root.val)));

        return Math.max(Math.max(leftMax, rightMax) + root.val, root.val);
    }
}
