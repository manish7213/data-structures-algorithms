package DP.Pattern_03_LCS;

import java.util.Arrays;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22">YouTube: LongestCommonSubstring</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/longest-common-substring1452/1">GFG: LongestCommonSubstring</a>
 */
public class Q13_LongestCommonSubstring {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;
        return longestCommonSubstrHelper(s1, s2, m, n, dp, maxLen);
    }

    private int longestCommonSubstrHelper(String s1, String s2, int m, int n, int[][] dp, int maxLen) {

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
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLen;
    }

    int max = 0;

    public int longCommSubstrRecursive(String s1, String s2) {
        max = 0;
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int t = helper(s1, s2, m, n, dp);
        return max;

    }

    private int helper(String s1, String s2, int m, int n, int[][] dp) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = 1 + helper(s1, s2, m - 1, n - 1, dp);
            max = Math.max(max, dp[m][n]);
        } else {
            dp[m][n] = 0;
        }

        helper(s1, s2, m - 1, n, dp);
        helper(s1, s2, m, n - 1, dp);

        return dp[m][n];
    }

    public static void main(String[] args) {
        Q13_LongestCommonSubstring obj = new Q13_LongestCommonSubstring();

        String a1 = "ABCDGH";
        String b1 = "ACDGHR";

        String a2 = "abcdef";
        String b2 = "zcdemf";

        String a3 = "xyz";
        String b3 = "abc";

        System.out.println("\"ABCDGH\" vs \"ACDGHR\" → LCSstr length = "
                + obj.longestCommonSubstr(a1, b1));   // Expected: 4 ("CDGH")

        System.out.println("\"abcdef\" vs \"zcdemf\" → LCSstr length = "
                + obj.longestCommonSubstr(a2, b2));   // Expected: 3 ("cde")

        System.out.println("\"xyz\" vs \"abc\" → LCSstr length = "
                + obj.longestCommonSubstr(a3, b3));   // Expected: 0
    }
}
