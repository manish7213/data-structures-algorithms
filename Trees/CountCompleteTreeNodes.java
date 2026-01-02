package Trees;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/count-complete-tree-nodes/">CountCompleteTreeNodes</a>
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        if (lh == rh) {
            return (1 << lh) - 1; // Equivalent to (int)Math.pow(2,lh) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getLeftHeight(node.left);
    }

    private int getRightHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getRightHeight(node.right);
    }
}
