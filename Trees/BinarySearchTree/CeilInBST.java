package Trees.BinarySearchTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1">CeilInBST</a>
 */
public class CeilInBST {
    int findCeil(TreeNode root, int x) {
        int ceil = -1;
        if (root == null) {
            return -1;
        }

        while (root != null) {
            if (root.val == x) {
                ceil = root.val;
                return ceil;
            }

            if (x > root.val) {
                root = root.right;
            } else {
                ceil = root.val;
                root = root.left;
            }
        }

        return ceil;
    }
}
