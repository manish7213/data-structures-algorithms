package DP.Pattern_05_DP_On_Trees;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=zmPj_Ee3B8c&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=47">YouTube: DiameterOfBinaryTree</a>
 * <p>
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">LC: DiameterOfBinaryTree</a>
 * <p>
 * <p>
 */
public class Q26_Diameter_Binary_Tree {
    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root).diameter;
    }

    private TreeInfo dfs(TreeNode root) {

        if(root == null) {
            return new TreeInfo(0,0);
        }

        TreeInfo left = dfs(root.left);
        TreeInfo right = dfs(root.right);

        int height = 1 + Math.max(left.height, right.height);

        int diameter = Math.max(left.height + right.height, Math.max(left.diameter,right.diameter));

        return new TreeInfo(height,diameter);

    }

    private static class TreeInfo {
        int height;
        int diameter;
        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
}
