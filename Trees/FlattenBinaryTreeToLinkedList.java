package Trees;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/">FlattenBinaryTreeToLinkedList</a>
 */
public class FlattenBinaryTreeToLinkedList {

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;

    }

}
