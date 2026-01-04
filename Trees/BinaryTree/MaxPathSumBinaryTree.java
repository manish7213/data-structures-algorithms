package Trees.BinaryTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">MaxPathSumBinaryTree</a>
 */
public class MaxPathSumBinaryTree {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, dfs(node.left, res));
        int right = Math.max(0, dfs(node.right, res));

        int tempNode = Math.max(Math.max(left, right) + node.val, node.val);

        int ans = left + right + node.val;

        res[0] = Math.max(res[0], ans);

        return tempNode;
    }
}
