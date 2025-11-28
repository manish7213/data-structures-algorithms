package DP.Pattern_03_LCS;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=QVntmksK2es&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30">YouTube: SequencePatternMatching</a>
 * <p>
 * <a href="https://leetcode.com/problems/is-subsequence/description/">Leetcode: SequencePatternMatching</a>
 * <p>
 * if lcs(s,t) == s.length() the true else false
 * <p>
 */
public class Q21_SequencePatternMatching {
    public boolean isSubsequence(String s, String t) {

        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        int lcs = lcs(s, t, m, n, dp);

        return lcs == s.length();
    }

    private int lcs(String s, String t, int m, int n, int[][] dp) {
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Q21_SequencePatternMatching matcher = new Q21_SequencePatternMatching();

        // Test Case 1
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println("Is \"" + s1 + "\" a subsequence of \"" + t1 + "\"? " + matcher.isSubsequence(s1, t1));
        // Expected: true

        // Test Case 2
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println("Is \"" + s2 + "\" a subsequence of \"" + t2 + "\"? " + matcher.isSubsequence(s2, t2));
        // Expected: false

        // Test Case 3
        String s3 = "ace";
        String t3 = "abcde";
        System.out.println("Is \"" + s3 + "\" a subsequence of \"" + t3 + "\"? " + matcher.isSubsequence(s3, t3));
        // Expected: true

        // Test Case 4
        String s4 = "aec";
        String t4 = "abcde";
        System.out.println("Is \"" + s4 + "\" a subsequence of \"" + t4 + "\"? " + matcher.isSubsequence(s4, t4));
        // Expected: false

        // Test Case 5
        String s5 = "";
        String t5 = "abc";
        System.out.println("Is \"" + s5 + "\" a subsequence of \"" + t5 + "\"? " + matcher.isSubsequence(s5, t5));
        // Expected: true (empty string is a subsequence of any string)

        // Test Case 6
        String s6 = "abc";
        String t6 = "";
        System.out.println("Is \"" + s6 + "\" a subsequence of \"" + t6 + "\"? " + matcher.isSubsequence(s6, t6));
        // Expected: false
    }
}