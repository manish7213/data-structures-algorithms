package Trees;

import java.util.HashMap;
import java.util.Map;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">ConstructBTFromPreAndInorderTraversal</a>
 */
public class ConstructBTFromPreAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, inorderMap, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, Map<Integer, Integer> inorderMap, int root, int left, int right) {

        if (left > right) {
            return null;
        }

        TreeNode rootNode = new TreeNode(preorder[root]);

        int mid = inorderMap.get(preorder[root]);

        if (left < mid) {
            rootNode.left = buildTreeHelper(preorder, inorderMap, root + 1, left, mid - 1); // root + 1 because left starts immediately after root in preorder.
        }

        if (mid < right) {
            rootNode.right = buildTreeHelper(preorder, inorderMap, root + mid - left + 1, mid + 1, right); // root + 1 + leftSubTreeSize
        }

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
