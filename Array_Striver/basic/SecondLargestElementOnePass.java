package Array_Striver.basic;

/**
 * @author manishkumar
 * <a href="https://www.geeksforgeeks.org/problems/second-largest3735/1">SecondLargestElementOnePass</a>
 */
public class SecondLargestElementOnePass {

    public static int getSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = -1;

        for (int n : arr) {
            if (n > max) {
                secondMax = max;
                max = n;
            } else if (n > secondMax && n < max) {
                secondMax = n;
            }
        }

        return secondMax;
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 35, 1, 10, 34, 1};
        int[] arr2 = {10, 5, 10};
        int[] arr3 = {10, 10, 10};

        System.out.println(getSecondLargest(arr1));
        System.out.println(getSecondLargest(arr2));
        System.out.println(getSecondLargest(arr3));
    }
}
