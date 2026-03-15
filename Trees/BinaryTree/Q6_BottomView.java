package Trees.BinaryTree;

import Trees.TreeNode;

import java.util.*;

/**
 * @author manishkumar
 *
 * <a href="https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1">BottomView</a>
 */
public class Q6_BottomView {

    public ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();

//                if (!map.containsKey(p.pos)) { Condition for top view
                    map.put(p.pos, p.node.val);
//                }
                if (p.node.left != null) {
                    Pair p1 = new Pair(p.node.left, p.pos - 1);
                    q.add(p1);
                }

                if (p.node.right != null) {
                    Pair p1 = new Pair(p.node.right, p.pos + 1);
                    q.add(p1);
                }
            }

        }

        map.forEach((k, v) -> {
            res.add(v);
        });


        return res;

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

