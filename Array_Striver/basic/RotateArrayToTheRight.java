package Array_Striver.basic;

import java.util.Arrays;

/**
 * @author manishkumar
 * <a href="https://leetcode.com/problems/rotate-array/">RotateArrayToTheRight</a>
 */
public class RotateArrayToTheRight {

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        if (n < 2) {
            return;
        }

        k = k % n;

        if (k == 0) return;

        reverse(nums, 0, n - 1); // reverse the entire array
        reverse(nums, 0, k - 1); // reverse the first k
        reverse(nums, k, n - 1); // reverse the other n- k

    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void rotateWithExtraSpace(int[] nums, int k) {
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
        rotateWithExtraSpace(arr, k);
        Arrays.stream(arr).forEach((element) -> System.out.print(element + " "));

    }
}
