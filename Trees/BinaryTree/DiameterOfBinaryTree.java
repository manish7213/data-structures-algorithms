package Trees.BinaryTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">DiameterOfBinaryTree</a>
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        int res = diameter(root, max);
        return max[0];
    }

    private int diameter(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int leftDia = diameter(root.left, max);
        int rightDia = diameter(root.right, max);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int currentDia = leftHeight + rightHeight; // when passes through root

        max[0] = Math.max(Math.max(Math.max(leftDia, rightDia), currentDia), max[0]);

        return 1 + Math.max(leftHeight, rightHeight);

    }

    private int height(TreeNode node) {
        return node == null ? 0 : (1 + Math.max(height(node.left), height(node.right)));
    }

}
