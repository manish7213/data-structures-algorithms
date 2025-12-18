package BinarySearch;

/**
 * @author manishkumar
 *
 * <a href="https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1">NumberOfOccurencesInSortedArray</a>
 */
public class NumberOfOccurencesInSortedArray {

    int countFreq(int[] arr, int target) {

        int first = findFirstPos(arr, target);
        int last = findLastPos(arr, target);

        if (first == -1) {
            first = 0;
        }

        return last - first + 1;

    }

    private int findFirstPos(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int n = arr.length;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) {
                res = mid;
                high = mid - 1;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }


    private int findLastPos(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int n = arr.length;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) {
                res = mid;
                low = mid + 1;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
}
