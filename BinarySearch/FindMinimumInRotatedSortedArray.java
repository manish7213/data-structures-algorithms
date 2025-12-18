package BinarySearch;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/">FindMinimumInRotatedSortedArray</a>
 *
 * Same as number of times a sorted array is rotated because the minimum element will be on the same index the same number of times an array is rotated
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;

            if (nums[mid] < nums[prev] && nums[mid] < nums[next]) {
                return nums[mid];
            } else if (nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
