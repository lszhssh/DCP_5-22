import java.util.HashMap;

public class NonAdjSum {
    // Problem from 5/22/22:

    // Given a list of integers, write a function that returns the largest sum of 
    // non-adjacent numbers. Numbers can be 0 or negative. 
    // For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5.
    // [5, 1, 1, 5] should return 10, since we pick 5 and 5.
    // Follow-up: Can you do this in O(N) time and constant space?

    // Solution time: incomplete

    // Plan:
    // - Without trying to optimize, a solution would be to iterate through the
    //   list while keeping track of the current sum and the largest sum. We 
    //   increase the counter by 2 each time to avoid taking adjacent numbers.
    //   - Initially, had trouble with negative numbers, but there's a quick 
    //     workaround: skip any non-positive numbers since they will not contribute
    //     to the maximum sum.
    //   - Fundamental problem: our algorithm is too greedy; it would fail to 
    //     discover more optimal combinations inaccessible to simple leap frogging
    // - What if we approached this problem recursively while keeping track of the
    //   maximum sum currently found? How to implement that?
    //   - Base case: if you have one number, choose that number.
    //   - Recursive step: return the best combination of the array not including
    //     current digit and the digit immediately after it

    // Post-answer reveal analysis: I was on the right track; I correctly identified 
    // that any naive approach at leap frogging was too greedy and will miss more 
    // optimal combinations. I also correctly conceived that we should look at this
    // problem recursively. However, I failed to implement the non-optimal
    // recursive solution, and frankly, it's because I overthought it. A cool and 
    // possibly unintuitive part of recursion is that for the algorithm to work, 
    // you must assume it works (aka the recursive call will return the correct
    // results).

    public int max(int num1, int num2) {
        if (num1 >= num2) {
            return num1;
        }
        return num2;
    }

    public int recNonAdjSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] n1 = new int[nums.length - 1];
        for (int i = 0; i < n1.length; i++) {
            n1[i] = nums[i + 1];
        }
        int[] n2 = new int[nums.length - 2];
        for (int j = 0; j < n2.length; j++) {
            n2[j] = nums[j + 2];
        }
        return max(recNonAdjSum(n1), nums[0] + recNonAdjSum(n2));
    }

    public int memNonAdjSum(int[] nums, HashMap<Integer, Integer> memo) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (memo.containsKey(nums.length)) {
            return memo.get(nums.length);
        }
        int[] n1 = new int[nums.length - 1];
        for (int i = 0; i < n1.length; i++) {
            n1[i] = nums[i];
        }
        int[] n2 = new int[nums.length - 2];
        for (int j = 0; j < n2.length; j++) {
            n2[j] = nums[j];
        }
        memo.put(nums.length, max(recNonAdjSum(n1), nums[nums.length - 1] + recNonAdjSum(n2)));
        return memo.get(nums.length);
    }

    public static void main(String[] args) {
        NonAdjSum obj = new NonAdjSum();
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        int[] nums1 = new int[] {5, 1, 1, 5};
        System.out.println(obj.memNonAdjSum(nums1, memo));

        memo.clear();
        int[] nums2 = new int[] {2, 4, 6, 2, 5};
        System.out.println(obj.memNonAdjSum(nums2, memo));
    }
}