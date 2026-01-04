package Trees.BinaryTree;

import Trees.TreeNode;

import java.util.*;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/">AllNodesAtDistanceK</a>
 */
public class AllNodesAtDistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParentMap(root, parent);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int dist = 0;

        while (!q.isEmpty()) {

            if (dist == k)
                break;

            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.add(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.add(node.right);
                }

                TreeNode p = parent.get(node);
                if (p != null && !visited.contains(p)) {
                    visited.add(p);
                    q.add(p);
                }
            }

            dist++;
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }

    private void buildParentMap(TreeNode root, Map<TreeNode, TreeNode> parent) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                parent.put(node.left, node);
                q.add(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
    }
}
