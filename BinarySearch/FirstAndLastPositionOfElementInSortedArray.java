package BinarySearch;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/">FirstAndLastPositionOfElementInSortedArray</a>
 */
public class FirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirstPos(nums, target);
        int last = findLastPos(nums, target);

        return new int[]{first, last};
    }

    private int findFirstPos(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == nums[mid]) {
                res = mid;
                high = mid - 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    private int findLastPos(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == nums[mid]) {
                res = mid;
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
}
