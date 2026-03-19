package Trees.BinaryTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/symmetric-tree/">SymmetricTree</a>
 */
public class Q12_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        if(root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode leftRoot, TreeNode rightRoot) {

        if(leftRoot == null && rightRoot == null) {
            return true;
        }

        if(leftRoot == null || rightRoot == null) {
            return false;
        }

        if(leftRoot.val != rightRoot.val) {
            return false;
        }

        return isMirror(leftRoot.left,rightRoot.right) && isMirror(leftRoot.right, rightRoot.left);
    }

}
