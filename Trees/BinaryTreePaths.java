package Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/binary-tree-paths/">BinaryTreePaths</a>
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<String> list = new ArrayList<>();
        String str = "";
        dfs(root, list, str);
        return list;
    }

    private void dfs(TreeNode root, List<String> list, String str) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) { // isLeaf
            list.add(str + root.val);
            return;
        }
        dfs(root.left, list, str + root.val + "->");
        dfs(root.right, list, str + root.val + "->");

    }
}
