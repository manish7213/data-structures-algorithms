package DP;

import java.util.List;
/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=x5hQvnUcjiM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24">YouTube: Print LongestCommonSubsequence</a>
 * <p>
 */
public class PrintLCS_14 {
    public String printLCS(String s1, String s2) {
        // Code here
        StringBuilder sb = new StringBuilder();
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return "";
        }

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        int[][] dpMat = getLCSMatrix(s1, s2, m, n, dp);
        int i = m, j = n;
        while (i >= 1 && j >= 1) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dpMat[i - 1][j] > dpMat[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }


        return sb.reverse().toString();

    }

    private int[][] getLCSMatrix(String s1, String s2, int m, int n, int[][] dp) {
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

        return dp;


    }

    public static void main(String[] args) {
        String s1 = "abaaa";
        String s2 = "baabaca";
        System.out.println(new PrintLCS_14().printLCS(s1, s2));
    }
}
