package Trees.BinaryTree;

import Trees.TreeNode;

import java.util.*;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/description/">LevelOrderTraversalBinaryTree</a>
 */
public class Q2_LevelOrderTraversalBinaryTree {

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

    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        levelOrderHelperRecursive(root, map, 0);

        map.forEach((k, v) -> {
            res.add(v);
        });

        return res;
    }

    private void levelOrderHelperRecursive(TreeNode root, Map<Integer, List<Integer>> map, int level) {

        if (root == null) {
            return;
        }
        if (map.containsKey(level)) {
            map.get(level).add(root.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(level, list);
        }

        levelOrderHelperRecursive(root.left, map, level + 1);
        levelOrderHelperRecursive(root.right, map, level + 1);

    }

}
