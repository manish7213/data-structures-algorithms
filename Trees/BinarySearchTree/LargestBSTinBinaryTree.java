package Trees.BinarySearchTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://www.geeksforgeeks.org/problems/largest-bst/1">LargestBSTinBinaryTree</a>
 */
public class LargestBSTinBinaryTree {

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(TreeNode root) {
        return largestBSTHelper(root).maxSize;
    }

    static NodeValue largestBSTHelper(TreeNode root) {
        if(root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = largestBSTHelper(root.left);
        NodeValue right = largestBSTHelper(root.right);

        if(left.maxNode < root.val && root.val < right.minNode ) {
            return new NodeValue(Math.min(left.minNode, root.val),
                    Math.max(root.val, right.maxNode),left.maxSize + right.maxSize + 1);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    static class NodeValue {

        int minNode;
        int maxNode;
        int maxSize;

        NodeValue(int minNode,int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }

    }



}
