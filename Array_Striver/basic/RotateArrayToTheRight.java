package Array_Striver.basic;

import java.util.Arrays;

/**
 * @author manishkumar
 * <a href="https://leetcode.com/problems/rotate-array/">RotateArrayToTheRight</a>
 */
public class RotateArrayToTheRight {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] copy = nums.clone();
        for (int i = 0; i < n; i++) {
            nums[(i + k) % n] = copy[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
//        int[] arr = {-1,-100,3,99};
//        int k = 2;
        Arrays.stream(arr).forEach((element) -> System.out.print(element + " "));
        System.out.println();
        rotate(arr, k);
        Arrays.stream(arr).forEach((element) -> System.out.print(element + " "));

    }
}
