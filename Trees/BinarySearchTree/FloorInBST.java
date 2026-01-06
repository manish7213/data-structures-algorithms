package Trees.BinarySearchTree;

import Trees.TreeNode;

/**
 * @author manishkumar
 *
 * <a href="https://www.geeksforgeeks.org/problems/floor-in-bst/1">FloorInBST</a>
 */
public class FloorInBST {
    public static int floor(TreeNode root, int x) {

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
