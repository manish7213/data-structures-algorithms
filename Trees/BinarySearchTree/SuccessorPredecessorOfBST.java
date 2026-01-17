package Trees.BinarySearchTree;

import Trees.TreeNode;

import java.util.ArrayList;

public class SuccessorPredecessorOfBST {
    TreeNode pre = null;
    TreeNode succ = null;

    public ArrayList<TreeNode> findPreSuc(TreeNode root, int key) {

        preDfs(root, key);
        succDfs(root, key);

        ArrayList<TreeNode> res = new ArrayList<>();
        res.add(pre);
        res.add(succ);

        return res;

    }

    private void preDfs(TreeNode root, int key) {

        if (root == null) {
            return;
        }

        if (root.val < key) {
            pre = root;
            preDfs(root.right, key);
        } else {
            preDfs(root.left, key);
        }

    }

    private void succDfs(TreeNode root, int key) {

        if (root == null) {
            return;
        }

        if (root.val > key) {
            succ = root;
            succDfs(root.left, key);
        } else {
            succDfs(root.right, key);
        }

    }
}
