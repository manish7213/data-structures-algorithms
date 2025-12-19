package Array_Striver;

import java.util.Arrays;

public class RotateArrayToTheLeft {

    public static void rotateLeft(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return;
        }

        k = k % n;

        if (k == 0) {
            return;
        }

        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);


    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void rotateLeftExtraSpace(int[] nums, int k) {
        int n = nums.length;
        int[] copy = nums.clone();
        for (int i = 0; i < n; i++) {
            nums[(i + (n - k)) % n] = copy[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
//        int[] arr = {-1,-100,3,99};
//        int k = 2;
        Arrays.stream(arr).forEach((element) -> System.out.print(element + " "));
        System.out.println();
        rotateLeftExtraSpace(arr, k);
        Arrays.stream(arr).forEach((element) -> System.out.print(element + " "));

    }
}
