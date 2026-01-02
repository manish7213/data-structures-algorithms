package Trees;

import java.util.HashMap;
import java.util.Map;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">ConstructBTFromPreAndInorderTraversal</a>
 */
public class ConstructBTFromPreAndInorderTraversal {
    private int preOrderRootIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderRootIndex = 0;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, inorderMap, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, Map<Integer,Integer> inorderMap, int left, int right) {

        if(left > right) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[preOrderRootIndex]);
        int rootIndex = inorderMap.get(preorder[preOrderRootIndex]);

        preOrderRootIndex++;

        rootNode.left = buildTreeHelper(preorder, inorderMap,  left, rootIndex - 1);

        rootNode.right = buildTreeHelper(preorder, inorderMap, rootIndex + 1, right);

        return rootNode;

    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

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
