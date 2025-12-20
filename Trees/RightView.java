package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author manishkumar
 *
 * <a href="https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1">LeftView</a>
 */
public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        bfs(root, res);
        ArrayList<Integer> list = new ArrayList<>();
        for (ArrayList<Integer> l : res) {
            list.add(l.get(l.size() - 1));
        }
        return list;
    }

    private void bfs(TreeNode node, ArrayList<ArrayList<Integer>> res) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(node);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
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
