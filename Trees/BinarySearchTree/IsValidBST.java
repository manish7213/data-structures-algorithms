package Trees.BinarySearchTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">IsValidBST</a>
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return bstHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean bstHelper(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }

        if (root.val <= left || root.val >= right) {
            return false;
        }

        return bstHelper(root.left, left, root.val) && bstHelper(root.right, root.val, right);
    }
}
