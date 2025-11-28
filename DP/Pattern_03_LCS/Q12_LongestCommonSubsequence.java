package DP.Pattern_03_LCS;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=g_hIx4yn9zg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=20">YouTube: LongestCommonSubsequence</a>
 * <p>
 * <a href="https://leetcode.com/problems/longest-common-subsequence/">Leetcode: LongestCommonSubsequence</a>
 */
public class Q12_LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.isEmpty() || text2 == null || text2.isEmpty()) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
         return lcsHelperBottomup(text1, text2, m, n, dp);
//        return lcsTopDown(text1, text2, m , n, dp);

    }

    private int lcsTopDown(String text1, String text2, int m, int n, int[][] dp) {

        for(int i = 0 ; i <=m ; i++) {
            dp[i][0] = 0;
        }


        for(int j = 0 ; j <=n ; j++) {
            dp[0][j] = 0;
        }

        for(int i=1 ; i <= m ;i++) {
            for(int j = 1 ; j<=n ;j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];

    }

    private int lcsHelperBottomup(String text1, String text2, int m, int n, int[][] dp) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            dp[m][n] = 1 + lcsHelperBottomup(text1, text2, m - 1, n - 1, dp);
        } else {
            dp[m][n] = Math.max(lcsHelperBottomup(text1, text2, m - 1, n, dp), lcsHelperBottomup(text1, text2, m, n - 1, dp));
        }

        return dp[m][n];
    }
    public static void main(String[] args) {
        Q12_LongestCommonSubsequence obj = new Q12_LongestCommonSubsequence();

        String s1 = "abcde";
        String s2 = "ace";

        String s3 = "AGGTAB";
        String s4 = "GXTXAYB";

        String s5 = "abcdgh";
        String s6 = "aedfhr";

        System.out.println("\"abcde\" vs \"ace\" → LCS length = "
                + obj.longestCommonSubsequence(s1, s2));       // Expected: 3

        System.out.println("\"AGGTAB\" vs \"GXTXAYB\" → LCS length = "
                + obj.longestCommonSubsequence(s3, s4));       // Expected: 4  (GTAB)

        System.out.println("\"abcdgh\" vs \"aedfhr\" → LCS length = "
                + obj.longestCommonSubsequence(s5, s6));       // Expected: 3  (adh)
    }

}
