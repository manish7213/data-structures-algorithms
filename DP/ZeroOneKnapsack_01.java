package DP;

/**
 * @author manishkumar
 * https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=5
 *
 * https://www.geeksforgeeks.org/dsa/0-1-knapsack-problem-dp-10/
 */
public class ZeroOneKnapsack_01 {
    static int knapsack(int W, int[] val, int[] wt) {
        int n = val.length;
        int[][] mem = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                mem[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    mem[i][j] = Math.max(val[i - 1] + mem[i - 1][j - wt[i - 1]], mem[i - 1][j]);
                }
                else {
                    mem[i][j] = mem[i - 1][j];
                }
            }
        }
        return mem[n][W];
    }

    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int W = 4;

        System.out.println(knapsack(W, val, wt));
    }
}
