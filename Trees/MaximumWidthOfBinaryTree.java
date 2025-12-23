package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author manishkumar
 *
 * <a href="https://www.youtube.com/watch?v=ZbybYvcVLks&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=30">MaximumWidthOfBinaryTree</a>
 *
 */
public class MaximumWidthOfBinaryTree {
    static class Pair {
        TreeNode node;
        long idx;

        Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    static class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(root, 0L));

            int maxWidth = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                long base = q.peek().idx;
                long first = 0, last = 0;

                for (int i = 0; i < size; i++) {
                    Pair p = q.poll();
                    long curr = p.idx - base;

                    if (i == 0) first = curr;
                    if (i == size - 1) last = curr;

                    if (p.node.left != null) {
                        q.add(new Pair(p.node.left, 2 * curr));
                    }
                    if (p.node.right != null) {
                        q.add(new Pair(p.node.right, 2 * curr + 1));
                    }
                }

                maxWidth = Math.max(maxWidth, (int) (last - first + 1));
            }

            return maxWidth;
        }
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              3     2
             /       \
            5         9
           /           \
          6             7

        Expected max width = 8
        (positions 0 to 7 at last level)
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        Solution sol = new Solution();
        int result = sol.widthOfBinaryTree(root);

        System.out.println("Maximum Width = " + result);
    }
}
