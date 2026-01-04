package Trees.BinaryTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/balanced-binary-tree/description/">BalanceBinaryTree</a>
 */
public class BalanceBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);

        if (!isLeftBalanced || !isRightBalanced) {
            return false;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.abs(lh - rh) <= 1;

    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

}
