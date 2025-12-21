package Trees;

import java.util.*;

/**
 * @author manishkumar
 *
 * <a href="https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1">BottomView</a>
 */
public class BottomView {
    public ArrayList<Integer> bottomView(TreeNode root) {
        // code here

        Map<Integer, Integer> map = new TreeMap<>();
        bfs(root, map);
        // System.out.println(map);
        return new ArrayList<>(map.values());
    }

    private void bfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        Queue<TopView.Pair> q = new LinkedList<>();
        q.add(new TopView.Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TopView.Pair p1 = q.poll();
                map.put(p1.pos, p1.node.val); // Here is the difference between top and bottom view
                if (p1.node.left != null) {
                    q.add(new TopView.Pair(p1.node.left, p1.pos - 1));
                }
                if (p1.node.right != null) {
                    q.add(new TopView.Pair(p1.node.right, p1.pos + 1));
                }
            }
        }
    }

    static class Pair {
        TreeNode node;
        int pos;

        Pair(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
}
