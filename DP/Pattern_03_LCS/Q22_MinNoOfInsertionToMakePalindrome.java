package DP.Pattern_03_LCS;

import java.util.Arrays;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=AEcRW4ylm_c&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=31">YouTube: MinNoOfInsertionToMakePalindrome</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/form-a-palindrome2544/1">GFG: MinNoOfInsertionToMakePalindrome</a>
 * <p>
 * SAME Q18 - MinmNoOfDeletion
 * <p>
 */
public class Q22_MinNoOfInsertionToMakePalindrome {

    int findMinInsertions(String s) {
        // code here
        String s1 = new StringBuilder(s).reverse().toString();

        int m = s.length();
        int n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        return m - lcs(s, s1, m, n, dp);
    }

    private int lcs(String s1, String s2, int m, int n, int[][] dp) {

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

    int findMinInsertionsRecursive(String s1) {
        int m = s1.length();
        String s2 = new StringBuilder(s1).reverse().toString();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int lcs = helper(s1, s2, m, n, dp);

        return m - lcs;

    }

    private int helper(String text1, String text2, int m, int n, int[][] dp) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            dp[m][n] = 1 + helper(text1, text2, m - 1, n - 1, dp);
        } else {
            dp[m][n] = Math.max(helper(text1, text2, m - 1, n, dp), helper(text1, text2, m, n - 1, dp));
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Q22_MinNoOfInsertionToMakePalindrome obj = new Q22_MinNoOfInsertionToMakePalindrome();

        String[] testCases = {
                "abcd",       // Output: 3
                "aba",        // Output: 0
                "race",       // Output: 3
                "aebcbda",    // Output: 2
                "abcde",      // Output: 4
                "a",          // Output: 0
                "",           // Output: 0
                "aa",         // Output: 0
                "ab",         // Output: 1
                "google"      // Output: 2
        };

        for (String test : testCases) {
            int result = obj.findMinInsertions(test);
            System.out.println("Input: \"" + test + "\" → Min Insertions: " + result);
        }
    }

}
