package Trees.BinaryTree;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author manishkumar
 *
 * <a href="https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1">LeftView</a>
 */
public class Q3_LeftView {
    public ArrayList<Integer> leftView(TreeNode root) {


        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0 ; i < size ;i++) {
                TreeNode temp = q.poll();
                if(i == 0) {
                    res.add(temp.val);
                }
                if(temp.left != null) {
                    q.add(temp.left);
                }

                if(temp.right != null) {
                    q.add(temp.right);
                }
            }
        }

        return res;

    }
}
