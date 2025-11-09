package DP;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=VDhRg-ZJTuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=28">YouTube: PrintShortestCommonSuperSequence {</a>
 * <p>
 * <a href="https://leetcode.com/problems/shortest-common-supersequence/">LC: PrintShortestCommonSuperSequence</a>
 * <p>
 */
public class PrintShortestCommonSuperSequence_19 {
    public String shortestCommonSupersequence(String s1, String s2) {
        if ((s1 == null || s1.isEmpty()) && (s2 != null && !s2.isEmpty())) {
            return s2;
        } else if ((s2 == null || s2.isEmpty()) && (s1 != null && !s1.isEmpty())) {
            return s1;
        } else {
            int m = s1.length();
            int n = s2.length();
            int[][] dp = new int[m + 1][n + 1];
            int[][] dpMat = getLcsDPMatrix(s1, s2, m, n, dp);
            return getCommonSuperSequence(dpMat, s1, s2, m, n);
        }
    }


    private int[][] getLcsDPMatrix(String s1, String s2, int m, int n, int[][] dp) {
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

    private String getCommonSuperSequence(int[][] dp, String s1, String s2, int m, int n) {
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while (i >= 1 && j >= 1) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(s1.charAt(i - 1));
                i--;
            } else {
                sb.append(s2.charAt(j - 1));
                j--;
            }
        }

        while (i >= 1) {
            sb.append(s1.charAt(i - 1));
            i--;
        }

        while (j >= 1) {
            sb.append(s2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "cab";
        System.out.println(new PrintShortestCommonSuperSequence_19().shortestCommonSupersequence(s1, s2));
    }
}
