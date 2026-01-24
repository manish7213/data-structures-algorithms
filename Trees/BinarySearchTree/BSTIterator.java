package Trees.BinarySearchTree;

import Trees.TreeNode;

import java.util.Stack;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/binary-search-tree-iterator/description/">BSTIterator</a>
 */
public class BSTIterator {

    private final Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAllToStack(root);

    }

    public int next() {
        TreeNode top = stack.pop();

        pushAllToStack(top.right);

        return top.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllToStack(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
