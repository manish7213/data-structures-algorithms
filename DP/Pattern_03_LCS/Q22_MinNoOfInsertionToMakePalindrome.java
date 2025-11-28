package DP.Pattern_03_LCS;

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
