package Trees.BinarySearchTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/search-in-a-binary-search-tree/description/">SearchInBST</a>
 */
public class SearchInBST {

    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBSTRecursive(root.left, val);
        } else {
            return searchBSTRecursive(root.right, val);
        }
    }

    public TreeNode searchBSTIterative(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val > val) {
                curr = curr.left;
            } else if (curr.val < val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }

}
