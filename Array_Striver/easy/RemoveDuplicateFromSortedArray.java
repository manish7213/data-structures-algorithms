package Array_Striver.easy;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">...</a>
 */
public class RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (nums.length == 0) {
            return 0;
        }
        int idx = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicateFromSortedArray().removeDuplicates(nums));
    }

}
