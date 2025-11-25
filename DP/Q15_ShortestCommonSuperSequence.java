package DP;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24">YouTube: ShortestCommonSupersequence</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/shortest-common-supersequence0322/1">GFG: ShortestCommonSupersequence</a>
 * <p>
 * Hint : m + n - LCS
 */
public class Q15_ShortestCommonSuperSequence {

    public static int shortestCommonSupersequence(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return 0;
        }

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return m + n - lcs(s1, s2, m, n, dp);

    }

    private static int lcs(String s1, String s2, int m, int n, int[][] dp) {
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

        String s1 = "geek";
        String s2 = "eke";

        System.out.println(Q15_ShortestCommonSuperSequence.shortestCommonSupersequence(s1, s2));
    }

}
