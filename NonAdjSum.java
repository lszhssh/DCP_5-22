public class NonAdjSum {
    // Problem from 5/22/22:

    // Given a list of integers, write a function that returns the largest sum of 
    // non-adjacent numbers. Numbers can be 0 or negative. 
    // For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5.
    // [5, 1, 1, 5] should return 10, since we pick 5 and 5.
    // Follow-up: Can you do this in O(N) time and constant space?

    // Solution time:

    // Plan:
    // - Without trying to optimize, a solution would be to iterate through the
    //   list while keeping track of the current sum and the largest sum. We 
    //   increase the counter by 2 each time to avoid taking adjacent numbers.
    //   - Initially, had trouble with negative numbers, but there's a quick 
    //     workaround: skip any non-positive numbers since they will not contribute
    //     to the maximum sum.
    //   - Fundamental problem: our algorithm is too greedy; it would fail to 
    //     discover more optimal combinations inaccessible to leap frogging

    // 1 3 9 -32 9 0

    public int nonAdjSum(int[] nums) {
        int largestSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            int currPos = i;
            while (currPos < nums.length) {
                if (nums[currPos] < 1) {
                    currPos--;
                } else {
                    
                }
            }
        }
        return largestSum;
    }
}
