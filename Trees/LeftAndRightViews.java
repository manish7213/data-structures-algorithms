package Trees;

import Trees.TreeNode;

import java.util.*;

/**
 * @author manishkumar
 *
 */
public class LeftAndRightViews {

    public static List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
//        dfsLeft(root, 0, res);
        dfsRight(root, 0, res);
        return res;
    }

    private static void dfsLeft(TreeNode node, int depth, List<Integer> res) {
        if(node == null) return;
        if(depth == res.size()) res.add(node.val);
        dfsLeft(node.left, depth + 1, res);
        dfsLeft(node.right, depth + 1, res);
    }

    public static List<Integer> rightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfsRight(root, 0, res);
        return res;
    }

    private static void dfsRight(TreeNode node, int depth, List<Integer> res) {
        if(node == null) return;
        if(depth == res.size()) res.add(node.val);
        dfsRight(node.right, depth + 1, res);
        dfsRight(node.left, depth + 1, res);
    }

}
