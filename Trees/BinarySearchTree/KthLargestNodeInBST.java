package Trees.BinarySearchTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 * <a href="https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1">Kth Largest in BST</a>
 */
public class KthLargestNodeInBST {
    int res = -1;
    int count = 0;

    public int kthLargest(TreeNode root, int k) {
        inorder(root, k);
        return res;

    }

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.right, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }

        inorder(root.left, k);
    }

}
