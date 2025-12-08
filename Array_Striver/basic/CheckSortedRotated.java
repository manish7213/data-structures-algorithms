package Array_Striver.basic;

import java.util.Arrays;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/">CheckSortedRotated</a>
 */
public class CheckSortedRotated {

    private static boolean isSortedRotated(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 1, 2};
        int[] arr2 = {2, 1, 3, 4};
        int[] arr3 = {1, 2, 3};
//        System.out.println(isSortedRotated(arr1));
        System.out.println(isSortedRotated(arr2));
//        System.out.println(isSortedRotated(arr3));
    }
}
