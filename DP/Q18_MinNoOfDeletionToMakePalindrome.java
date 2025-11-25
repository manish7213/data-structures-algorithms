package DP;

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

    public static void main(String[] args) {
        System.out.println(minDeletions("aebcbda")); // 2
        System.out.println(minDeletions("geeksforgeeks")); // 8
        System.out.println(minDeletions("abcda")); // 2
        System.out.println(minDeletions("aaaa")); // 0
        System.out.println(minDeletions("abcd")); // 3
    }
}

