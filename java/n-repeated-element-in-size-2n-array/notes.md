# Solution for 961. N-Repeated Element in Size 2N Array

## Problem Understanding

Given an array `nums` of size `2n` where:
- The array contains `n+1` unique elements.
- One of these elements is repeated exactly `n` times.

The task is to find and return the element that is repeated `n` times.

## Approach

### Key Insights

1. **HashSet to Track Seen Elements**: 
   - We can use a `HashSet` to keep track of the elements we've seen so far as we iterate through the array.
   - The first time we encounter an element that we've already seen, we know this is the element repeated `n` times, and we can return it immediately.

2. **Efficiency**:
   - This approach runs in O(N) time complexity, where `N` is the length of the array. This is because we only iterate through the array once.
   - The space complexity is also O(N) due to the storage required by the `HashSet`.

### Step-by-Step Explanation

1. **Initialize a HashSet**:
   - Create a `HashSet<Integer>` named `seen` to store the elements that have been encountered so far in the array.

2. **Iterate Through the Array**:
   - For each element `num` in the array `nums`:
     - Attempt to add the element to the `HashSet` using `seen.add(num)`.
     - If `seen.add(num)` returns `false`, it means `num` is already in the `HashSet`, so `num` is the repeated element.
     - Return this element immediately as it satisfies the condition of being repeated `n` times.

3. **Handle Edge Cases**:
   - The problem guarantees that there is exactly one element repeated `n` times, so the method will always return within the loop and no additional edge case handling is required.

### Code Implementation

```java
import java.util.HashSet;
import java.util.Set;

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
        System.out.println(solution.repeatedNTimes(nums1)); // Output: 3

        // Test case 2
        int[] nums2 = {2, 1, 2, 5, 3, 2};
        System.out.println(solution.repeatedNTimes(nums2)); // Output: 2

        // Test case 3
        int[] nums3 = {5, 1, 5, 2, 5, 3, 5, 4};
        System.out.println(solution.repeatedNTimes(nums3)); // Output: 5
    }
}
```
## Detailed Notes

### HashSet
- A `HashSet` is used here because it offers O(1) time complexity for `add` and `contains` operations, making it ideal for checking duplicates quickly.

### Set Operations
- `seen.add(num)`: Adds `num` to the set if it's not already present and returns `true`. If `num` is already in the set, it returns `false`.

### Early Return
- As soon as a duplicate is found, the function returns the duplicate element. This ensures the function terminates as early as possible, which is efficient.

## Test Cases

### Basic Case
- **Input:** `nums = [1, 2, 3, 3]`
- **Output:** `3`
- **Explanation:** `3` is repeated twice in the array.

### Multiple Occurrences
- **Input:** `nums = [2, 1, 2, 5, 3, 2]`
- **Output:** `2`
- **Explanation:** `2` is repeated three times in the array.

### Larger Array
- **Input:** `nums = [5, 1, 5, 2, 5, 3, 5, 4]`
- **Output:** `5`
- **Explanation:** `5` is repeated four times in the array.

## Constraints and Considerations

### Array Length
- The array length is always even and follows the condition `nums.length == 2 * n`.

### Unique Elements
- There are exactly `n+1` unique elements in the array.

### Element Range
- Each element in the array is within the range `0 <= nums[i] <= 10^4`.
