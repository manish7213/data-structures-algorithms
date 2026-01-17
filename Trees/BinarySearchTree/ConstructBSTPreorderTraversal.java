package Trees.BinarySearchTree;

import Trees.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/">ConstructBSTPreorderTraversal</a>
 */
public class ConstructBSTPreorderTraversal {

    int preIndex = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        preIndex = 0;
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, map, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, Map<Integer, Integer> map, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);

        root.left = dfs(preorder, map, left, map.get(root.val) - 1);

        root.right = dfs(preorder, map, map.get(root.val) + 1, right);

        return root;
    }
}
