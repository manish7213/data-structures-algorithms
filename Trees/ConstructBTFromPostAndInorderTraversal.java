package Trees;

import java.util.HashMap;
import java.util.Map;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">ConstructBTFromPostAndInorderTraversal</a>
 */
public class ConstructBTFromPostAndInorderTraversal {
    private int rootIndex;


    public TreeNode buildTree(int[] inorderTraversal, int[] postorderTraversal) {

        rootIndex = postorderTraversal.length - 1;

        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorderTraversal.length; i++) {
            inorderMap.put(inorderTraversal[i], i);
        }

        return buildSubtree(postorderTraversal, inorderMap, 0,
                inorderTraversal.length - 1);
    }

    private TreeNode buildSubtree(int[] postorderTraversal, Map<Integer, Integer> inorderMap,
                                  int left, int right) {

        if (left > right) {
            return null;
        }

        int rootValue = postorderTraversal[rootIndex--];
        TreeNode rootNode = new TreeNode(rootValue);

        int inorderRootIndex = inorderMap.get(rootValue);

        rootNode.right = buildSubtree(
                postorderTraversal,
                inorderMap,
                inorderRootIndex + 1,
                right);

        rootNode.left = buildSubtree(
                postorderTraversal,
                inorderMap,
                left,
                inorderRootIndex - 1);

        return rootNode;
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        ConstructBTFromPostAndInorderTraversal solution = new ConstructBTFromPostAndInorderTraversal();
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
