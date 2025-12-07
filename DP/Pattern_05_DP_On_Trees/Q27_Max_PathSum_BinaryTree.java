package DP.Pattern_05_DP_On_Trees;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=Osz-Vwer6rw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=48">YouTube: Max_PathSum_BinaryTree</a>
 * <p>
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/1848935992/">LC: Max_PathSum_BinaryTree</a>
 * <p>
 * <p>
 */
public class Q27_Max_PathSum_BinaryTree {

    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, dfs(node.left, res));
        int right = Math.max(0, dfs(node.right, res));

        int tempNode = Math.max(Math.max(left, right) + node.val, node.val);

        int ans = left + right + node.val;

        res[0] = Math.max(res[0], ans);


        return tempNode;
    }


}
