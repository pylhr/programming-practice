import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
public class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return num;
            }
        }
        return -1; // this line should never be reached since the problem guarantees a solution
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 2, 3, 3};
        System.out.println(Arrays.toString(nums1));
        System.out.println(solution.repeatedNTimes(nums1)); // Output: 3

        // Test case 2
        int[] nums2 = {2, 1, 2, 5, 3, 2};
        System.out.println(Arrays.toString(nums2));
        System.out.println(solution.repeatedNTimes(nums2)); // Output: 2

        // Test case 3
        int[] nums3 = {5, 1, 5, 2, 5, 3, 5, 4};
        System.out.println(Arrays.toString(nums3));
        System.out.println(solution.repeatedNTimes(nums3)); // Output: 5
    }
}
