package DP;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=29">YouTube: MinNoOfInsertionAndDeletionToConvertStringAtoB</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1">GFG: MinNoOfInsertionAndDeletionToConvertStringAtoB</a>
 * <p>
 * Hint :
 * {
 * Min Deletion : len(s1) - lcs(s1,s2),
 * Min Insertion : len(s2) - lcs(s1,s2)
 * }
 */
public class MinNoOfInsertionAndDeletionToConvertStringAtoB {

    public int minOperations(String s1, String s2) {
        // Your code goes here
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        int lcs = lcs(s1, s2, m, n, dp);
        return m + n - 2 * lcs;
    }

    private int lcs(String s1, String s2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }

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
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];

    }

    public static void main(String[] args) {
        String s1 = "heap";
        String s2 = "pea";
        System.out.println(new MinNoOfInsertionAndDeletionToConvertStringAtoB().minOperations(s1, s2));
    }
}
