package DP.Pattern_03_LCS;

import java.util.Arrays;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=CFwCCNbRuLY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=27">YouTube: MinNoOfDeletionToMakePalindrome {</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/minimum-deletitions1648/1">GFG: MinNoOfDeletionToMakePalindrome</a>
 * <p>
 * Hint :
 * {
 *  s1 = s;
 *  s2 = reverse(s);
 *  return len(s) - lcs(s1,s2);
 * }
 */

public class Q18_MinNoOfDeletionToMakePalindrome {
    static int minDeletions(String s) {
        // code here
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int m = s.length();
        String s1 = new StringBuilder(s).reverse().toString();
        int n = s1.length();
        int[][] dp = new int[m + 1][n + 1];
        return m - lcs(s, s1, m, n, dp);
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

    static int minDeletionsRecursive(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int lcs = recursiveLCSHelper(s1, s2, m, n, dp);

        return m - lcs;
    }

    static int recursiveLCSHelper(String s1, String s2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = 1 + recursiveLCSHelper(s1, s2, m - 1, n - 1, dp);
        } else {
            dp[m][n] = Math.max(recursiveLCSHelper(s1, s2, m - 1, n, dp), recursiveLCSHelper(s1, s2, m, n - 1, dp));
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minDeletions("aebcbda")); // 2
        System.out.println(minDeletions("geeksforgeeks")); // 8
        System.out.println(minDeletions("abcda")); // 2
        System.out.println(minDeletions("aaaa")); // 0
        System.out.println(minDeletions("abcd")); // 3
    }
}

