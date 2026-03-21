package Trees.BinaryTree;

import Trees.TreeNode;

import java.util.*;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/">ZigzagLevelOrderTraversal</a>
 */
public class Q14_ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        bfs(root, list);
        return transformToZigZag(list);
    }

    private void bfs(TreeNode root, List<List<Integer>> list) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            List<Integer> level = new ArrayList<>();
            int size = q.size();
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

            list.add(level);
        }
    }

    private List<List<Integer>> transformToZigZag(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0) {
                Collections.reverse(list.get(i));
            }
        }

        return list;
    }

}
