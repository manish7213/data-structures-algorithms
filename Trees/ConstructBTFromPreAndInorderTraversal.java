package Trees;

import java.util.HashMap;
import java.util.Map;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">ConstructBTFromPreAndInorderTraversal</a>
 */
public class ConstructBTFromPreAndInorderTraversal {
    public TreeNode buildTree(int[] preorderTraversal, int[] inorderTraversal) {

        // Maps node value → its index in inorder traversal
        Map<Integer, Integer> inorderIndexByValue = new HashMap<>();

        for (int index = 0; index < inorderTraversal.length; index++) {
            inorderIndexByValue.put(inorderTraversal[index], index);
        }

        // Build the entire tree using full traversal ranges
        return buildSubtree(preorderTraversal, 0, preorderTraversal.length - 1, 0, inorderTraversal.length - 1, inorderIndexByValue);
    }

    private TreeNode buildSubtree(int[] preorderTraversal, int preorderStartIndex, int preorderEndIndex, int inorderStartIndex, int inorderEndIndex, Map<Integer, Integer> inorderIndexByValue) {

        // No elements left to construct this subtree
        if (preorderStartIndex > preorderEndIndex || inorderStartIndex > inorderEndIndex) {
            return null;
        }

        // First element in preorder range is always the root
        int rootValue = preorderTraversal[preorderStartIndex];
        TreeNode rootNode = new TreeNode(rootValue);

        // Locate root in inorder traversal
        int rootIndexInInorder = inorderIndexByValue.get(rootValue);

        // Count of nodes in the left subtree
        int leftSubtreeSize = rootIndexInInorder - inorderStartIndex;

        // Recursively build left subtree
        rootNode.left = buildSubtree(preorderTraversal, preorderStartIndex + 1, preorderStartIndex + leftSubtreeSize, inorderStartIndex,
                rootIndexInInorder - 1, inorderIndexByValue);

        // Recursively build right subtree
        rootNode.right = buildSubtree(preorderTraversal, preorderStartIndex + leftSubtreeSize + 1, preorderEndIndex, rootIndexInInorder + 1,
                inorderEndIndex, inorderIndexByValue);

        return rootNode;
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};

        ConstructBTFromPreAndInorderTraversal solution = new ConstructBTFromPreAndInorderTraversal();
        TreeNode root = solution.buildTree(preorder, inorder);

        System.out.println("\nPreorder traversal of constructed tree:");
        printPreorder(root);

        System.out.println("\nInorder traversal of constructed tree:");
        printInorder(root);
    }

    private static void printPreorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    private static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
