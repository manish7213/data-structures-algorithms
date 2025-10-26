package DP;
/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22">YouTube: LongestCommonSubstring</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/longest-common-substring1452/1">GFG: LongestCommonSubstring</a>
 */
public class LongestCommonSubstring_13 {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        if(s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        int maxLen = 0;
        return longestCommonSubstrHelper(s1,s2,m,n,dp,maxLen);
    }

    private int longestCommonSubstrHelper(String s1, String s2, int m, int n, int[][] dp, int maxLen) {

        for(int i = 0 ;i <= m;i++) {
            dp[i][0] = 0;
        }

        for(int j = 0; j <= n ;j++) {
            dp[0][j] = 0;
        }

        for(int i = 1 ;i <=m;i++) {
            for( int j = 1 ; j <=n ;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        System.out.println(new LongestCommonSubstring_13().longestCommonSubstr(s1, s2));
    }
}
