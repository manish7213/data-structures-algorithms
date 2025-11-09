package DP;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26">YouTube: LongestPalindromicSubsequence {</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1">GFG: LongestPalindromicSubsequence</a>
 * <p>
 * Hint :
 * {
 *   Reverse the given String and consider it as S2, find the lcs, if lcs exist return it otherwise 0
 * }
 */
public class LongestPalindromicSubsequence_17 {
    public int longestPalinSubseq(String s) {
        // code here
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int m = s.length();

        String s2 = new StringBuilder(s).reverse().toString();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        return lcs(s, s2, m, n, dp);
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
        String s = "bbabcbcab";
        System.out.println(new LongestPalindromicSubsequence_17().longestPalinSubseq(s));
    }
}
