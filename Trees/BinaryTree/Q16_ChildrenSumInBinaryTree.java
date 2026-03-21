package Trees.BinaryTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://www.geeksforgeeks.org/problems/children-sum-parent/1">ChildrenSumInBinaryTree</a>
 */
public class Q16_ChildrenSumInBinaryTree {
    boolean flag = true;
    public boolean isSumProperty(TreeNode root) {
        helper(root);
        return flag;
    }

    private int helper(TreeNode root) {

        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return root.val;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        if (root.val != left + right) {
            flag = false;
        }

        return root.val;
    }

}
