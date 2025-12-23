package Trees;

/**
 * @author manishkumar
 *
 * <a href="https://www.geeksforgeeks.org/problems/children-sum-parent/1">ChildrenSumInBinaryTree</a>
 */
public class ChildrenSumInBinaryTree {
    public boolean isSumProperty(TreeNode root) {

        boolean flag = false;
        if (root == null) {
            return true;
        }
        if (root.right == null && root.left == null) {
            return true;
        }

        int leftData = root.left != null ? root.left.val : 0;
        int rightData = root.right != null ? root.right.val : 0;

        if (root.val == leftData + rightData) {
            flag = true;
        }
        boolean isSumPropertyLeft = isSumProperty(root.left);

        boolean isSumPropertyRight = isSumProperty(root.right);

        return flag && isSumPropertyLeft && isSumPropertyRight;
    }
}
