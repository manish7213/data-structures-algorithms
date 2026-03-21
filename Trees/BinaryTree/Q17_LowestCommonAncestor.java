package Trees.BinaryTree;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manishkumar
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">LowestCommonAncestor</a>
 */
public class Q17_LowestCommonAncestor {

    public TreeNode lowestCommonAncestorBruteForce(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();

        findPath(root, p, pPath, temp);
        // temp.clear();
        findPath(root, q, qPath, temp);

        return findLCA(pPath, qPath);

    }

    private void findPath(TreeNode root, TreeNode p, List<TreeNode> list, List<TreeNode> temp) {

        if (root == null) {
            return;
        }
        if (root == p) {
            temp.add(p);
            // temp.stream().map(e -> e.val).forEach(e -> System.out.print(e + " "));
            list.addAll(temp);
            temp.remove(temp.size() - 1);
            // System.out.println();
            return;
        }
        temp.add(root);
        findPath(root.left, p, list, temp);
        findPath(root.right, p, list, temp);

        temp.remove(temp.size() - 1);

    }

    private TreeNode findLCA(List<TreeNode> l1, List<TreeNode> l2) {
        TreeNode prev = null;
        for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
            if (l1.get(i) == l2.get(i)) {
                prev = l1.get(i);
            }
        }

        return prev;
    }

    public TreeNode lowestCommonAncestorOptimized(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestorOptimized(root.left, p, q);
        TreeNode right = lowestCommonAncestorOptimized(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;

    }
}
