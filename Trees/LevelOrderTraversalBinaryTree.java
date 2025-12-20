package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/description/">LevelOrderTraversalBinaryTree</a>
 */
public class LevelOrderTraversalBinaryTree {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        bfs(root, list);
        return list;
    }

    private void bfs(TreeNode node, List<List<Integer>> res) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(node);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                level.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            res.add(level);
        }
    }

}
