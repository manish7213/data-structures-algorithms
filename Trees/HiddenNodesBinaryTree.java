package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * A node is hidden if it does not appear in left view AND does not appear in right view.

 1. DFS left-to-right to record earliest node per depth → left view.

 2.  DFS right-to-left to record earliest node per depth → right view.

 3.  DFS again to list nodes not in left/right sets.

 */
public class HiddenNodesBinaryTree {

    public static List<Integer> hiddenNodes(TreeNode root) {
        if (root == null) return List.of();

        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        leftView(root, 0, left);
        rightView(root, 0, right);

        List<Integer> res = new ArrayList<>();
        collectHidden(root, left, right, res);
        return res;
    }

    private static void leftView(TreeNode node, int depth, Map<Integer, Integer> map) {
        if (node == null) return;
        if (!map.containsKey(depth)) map.put(depth, node.val);
        leftView(node.left, depth + 1, map);
        leftView(node.right, depth + 1, map);
    }

    private static void rightView(TreeNode node, int depth, Map<Integer, Integer> map) {
        if (node == null) return;
        if (!map.containsKey(depth)) map.put(depth, node.val);
        rightView(node.right, depth + 1, map);
        rightView(node.left, depth + 1, map);
    }

    private static void collectHidden(TreeNode node,
                                      Map<Integer, Integer> left,
                                      Map<Integer, Integer> right,
                                      List<Integer> res) {
        if (node == null) return;
        if (!left.containsValue(node.val) && !right.containsValue(node.val))
            res.add(node.val);

        collectHidden(node.left, left, right, res);
        collectHidden(node.right, left, right, res);
    }

}
