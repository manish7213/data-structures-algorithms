package Trees.BinarySearchTree;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/two-sum-iv-input-is-a-bst/">BST2Sum</a>
 */
public class BST2Sum {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return isPairExist(list, k);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    private boolean isPairExist(List<Integer> list, int k) {
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) + list.get(j) == k) {
                return true;
            } else if (list.get(i) + list.get(j) < k) {
                i++;
            } else if (list.get(i) + list.get(j) > k) {
                j--;
            }
        }

        return false;
    }
}
