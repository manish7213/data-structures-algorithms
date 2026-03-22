package Trees.BinaryTree;

import Trees.TreeNode;

import java.util.*;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/">AllNodesAtDistanceK</a>
 */
public class Q24_AllNodesAtDistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode parent = null;
        dfs(root, map, parent); // This will calculate parent map

        return helper(target, k, map);

    }

    private List<Integer> helper(TreeNode target, int k, Map<TreeNode, TreeNode> map) {
        Set<TreeNode> set = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        q.add(new Pair(target, 0));

        set.add(target);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair temp = q.poll();

                if (temp.distance > k) {
                    break;
                }

                if (temp.node.left != null && !set.contains(temp.node.left)) {
                    q.add(new Pair(temp.node.left, temp.distance + 1));
                    set.add(temp.node.left);
                }

                if (temp.node.right != null && !set.contains(temp.node.right)) {
                    q.add(new Pair(temp.node.right, temp.distance + 1));
                    set.add(temp.node.right);
                }
                TreeNode p = map.get(temp.node);
                if (!set.contains(p) && p != null) {
                    q.add(new Pair(p, temp.distance + 1));
                    set.add(p);
                }
                if (temp.distance == k) {
                    ans.add(temp.node.val);
                }
            }
        }

        return ans;
    }

    private void dfs(TreeNode root, Map<TreeNode, TreeNode> map, TreeNode parent) { // Map will contain parents of each node
        if (root == null) {
            return;
        }

        map.put(root, parent);

        dfs(root.left, map, root);
        dfs(root.right, map, root);
    }

    static class Pair {
        TreeNode node;
        int distance;

        Pair(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
