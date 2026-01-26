package Trees.BinarySearchTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/recover-binary-search-tree/description/">RecoverBST</a>
 */
public class RecoverBST {

    private TreeNode first = null;
    private TreeNode prev = null;
    private TreeNode middle = null;
    private TreeNode last = null;

    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (first != null && last != null) { // Not adjacent swaps
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else {
            int temp = first.val; // Adjacent swap
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        //logic
        if (prev != null && root.val < prev.val) {

            if (first == null) {
                first = prev; // assign first with prev
                middle = root; // assign root to middle;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
