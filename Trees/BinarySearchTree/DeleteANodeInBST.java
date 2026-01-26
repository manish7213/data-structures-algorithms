package Trees.BinarySearchTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/delete-node-in-a-bst/description/">DeleteANodeInBST</a>
 */
public class DeleteANodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key == root.val) {
            return helper(root, key);
        }

        TreeNode curr = root;

        while (root != null) {

            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left, key);
                    break;
                } else {
                    root = root.left;
                }

            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right, key);
                    break;
                } else {
                    root = root.right;
                }
            }
        }

        return curr;
    }

    private TreeNode helper(TreeNode root, int key) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        TreeNode rightChild = root.right;
        TreeNode lastRightOfLeft = findLastRight(root.left);
        lastRightOfLeft.right = rightChild;
        return root.left;
    }

    private TreeNode findLastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }

        return findLastRight(root.right);
    }
}
