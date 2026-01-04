package Trees.BinaryTree;

import Trees.TreeNode;

import java.util.*;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/">ZigzagLevelOrderTraversal</a>
 */
public class ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean flag = true;

        while (!q.isEmpty()) {

            int size = q.size();

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                list.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }

            }
            if (!flag) {
                Collections.reverse(list);

            }
            res.add(list);
            flag = !flag;
        }
    }

}
