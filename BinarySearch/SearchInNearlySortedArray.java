package BinarySearch;

/**
 * @author manishkumar
 *
 * <a href="https://www.geeksforgeeks.org/problems/search-in-an-almost-sorted-array/1">SearchInNearlySortedArray</a>
 */
public class SearchInNearlySortedArray {
    public int findTarget(int arr[], int target) {
        // code here
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) {
                return mid;
            }

            if (mid - 1 >= low && target == arr[mid - 1]) {
                return mid - 1;
            }

            if (mid + 1 <= high && target == arr[mid + 1]) {
                return mid + 1;
            }

            if (target < arr[mid]) {
                high = mid - 2;
            } else {
                low = mid + 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 40, 20, 50, 80, 70};
        int target = 40;
        SearchInNearlySortedArray obj = new SearchInNearlySortedArray();
        int res = obj.findTarget(arr, target);
        System.out.println(res);
    }
}
