package Trees.BinarySearchTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 * <a href="https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1">Kth Largest in BST</a>
 */
public class Q9_KthLargestNodeInBST {
    int ans = -1;
    int count = 0;
    public int kthLargest(TreeNode root, int k) {
        helper(root,k);
        return ans;
    }

    private void helper(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        helper(root.right, k);
        count++;
        if(count == k) {
            ans = root.val;
        }
        helper(root.left,k);

    }

}
