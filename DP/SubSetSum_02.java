package DP;

/**
 * @author manishkumar
 *
 * <a href="https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7">YouTube:subset-sum-problem</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1">GFG:subset-sum-problem</a>
 */
public class SubSetSum_02 {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;

        boolean[][] mem = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            mem[i][0] = true;
        }

        for (int j = 1; j <= sum; j++) {
            mem[0][j] = false;

        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    mem[i][j] = mem[i - 1][j - arr[i - 1]] || mem[i - 1][j];
                } else {
                    mem[i][j] = mem[i - 1][j];
                }
            }
        }
        return mem[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        if (isSubsetSum(arr, sum)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }


}
