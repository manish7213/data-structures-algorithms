package Trees.BinarySearchTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://www.geeksforgeeks.org/problems/floor-in-bst/1">FloorInBST</a>
 */
public class Q6_FloorInBST {

    int res = -1;

    public int findFloorRecursive(TreeNode root, int x) {
        helper(root, x);
        return res;
    }

    private void helper(TreeNode root, int key) {

        if (root == null) {
            return;
        }

        if (root.val <= key) {
            res = root.val;
            helper(root.right, key);
        } else {
            helper(root.left, key);
        }
    }

    public static int floorIterative(TreeNode root, int x) {

        int floor = -1;


        while (root != null) {

            if (x == root.val) {
                floor = root.val;
                return floor;
            }

            if (x > root.val) {
                floor = root.val;
                root = root.right;

            } else {
                root = root.left;
            }

        }
        return floor;
    }
}
