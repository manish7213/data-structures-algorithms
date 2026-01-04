package Trees.BinaryTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/symmetric-tree/">SymmetricTree</a>
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symetryHelper(root.left, root.right);
    }

    private boolean symetryHelper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return symetryHelper(node1.left, node2.right) && symetryHelper(node1.right, node2.left);
    }
}
