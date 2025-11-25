package DP;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=hbTaCmQGqLg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=29">YouTube: LongestRepeatingSubsequence</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1">GFG: LongestRepeatingSubsequence</a>
 * <p>
 */
public class Q20_LongestRepeatingSubsequence {
    public int LongestRepeatingSubsequence(String s) {
        // code here
        if (s == null || s.isEmpty()) {
            return 0;
        }
        String s1 = s;
        String s2 = s;
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        return modifiedLCS(s1, s2, m, n, dp);
    }

    private int modifiedLCS(String s1, String s2, int m, int n, int[][] dp) {
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) { // Here is the tweak
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Q20_LongestRepeatingSubsequence obj = new Q20_LongestRepeatingSubsequence();

        System.out.println(obj.LongestRepeatingSubsequence("axxzxy")); // 2 ("xx")
        System.out.println(obj.LongestRepeatingSubsequence("aab"));    // 1 ("a")
        System.out.println(obj.LongestRepeatingSubsequence("aabb"));   // 2 ("ab" or "aa" or "bb")
        System.out.println(obj.LongestRepeatingSubsequence("abc"));    // 0
        System.out.println(obj.LongestRepeatingSubsequence("aaaa"));   // 3 ("aaa")
    }
}
