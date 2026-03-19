package Trees.BinaryTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">DiameterOfBinaryTree</a>
 */
public class Q10_DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxHeight = height(root.left);
        int rightMaxHeight = height(root.right);

        int currentDia = leftMaxHeight + rightMaxHeight;

        max = Math.max(max, currentDia);

        return 1 + Math.max(leftMaxHeight, rightMaxHeight);
    }


}
