package Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">InorderTraversalRecursive</a>
 *
 * left -> root -> right
 */
public class InorderTraversalRecursive {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;

    }

    private void dfs(TreeNode node, List<Integer> res) {

        if(node == null) {
            return;
        }

        dfs(node.left,res);
        res.add(node.val);
        dfs(node.right,res);
    }
}
