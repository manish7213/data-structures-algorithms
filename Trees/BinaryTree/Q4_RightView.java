package Trees.BinaryTree;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">Right View</a>
 */
public class Q4_RightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (i == size - 1) {
                    res.add(temp.val);
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }

        return res;

    }
}
