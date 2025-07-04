### Sliding window:

- The sliding window technique is a commonly used approach in programming, especially for solving problems involving arrays or strings.
- It is particularly useful when you need to examine a subrange (window) of a collection and slide this window across the collection to solve problems efficiently, often reducing the time complexity from O(n²) to O(n).

- How Sliding Window Works
- Fixed Size Window: The window has a fixed length, and you move it from the start to the end of the array or string.
- Variable Size Window: The window size can change depending on the problem’s constraints.

Fixed sized window example:

Find the maximum sum of a subarray of size k.

```java
public int maxSumSubarray(int[] nums, int k) {
    int maxSum = 0, windowSum = 0;
    // Calculate the sum of the first window
    for (int i = 0; i < k; i++) {
        windowSum += nums[i];
    }
    maxSum = windowSum;

    // Slide the window and find out maxSum
    for (int end = k; end < nums.length; end++) {
        windowSum += nums[end] - nums[end - k];
        maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
}
```

