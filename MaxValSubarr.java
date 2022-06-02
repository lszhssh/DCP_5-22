// Problem from 5/31/22:
// Given an array of integers and a number k, where 1 <= k <= length of the 
// array, compute the maximum values of each subarray of length k.
// For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should
// get: [10, 7, 8, 8], since:
// 10 = max(10, 5, 2)
// 7 = max(5, 2, 7)
// 8 = max(2, 7, 8)
// 8 = max(7, 8, 7)
// Do this in O(n) time and O(k) space. You can modify the input array 
// in-place and you do not need to store the results. You can simply print them out as you compute them.

// Solution time: incomplete

public class MaxValSubarr {
    // Helper methods
    public static int max(int n1, int n2) {
        if (n2 > n1) {
            return n2;
        }
        return n1;
    }

    public static void printNums(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    // Naive solution
    public static int[] naiveMaxValSubarr(int[] nums, int k) {
        int resultArrLen = nums.length - k + 1;
        int[] result = new int[resultArrLen];
        for (int i = 0; i < resultArrLen; i++) {
            int maxValSubarr = nums[i];
            for (int j = 0; j < k; j++) {
                maxValSubarr = max(maxValSubarr, nums[i + j]);
            }
            result[i] = maxValSubarr;
        }
        return result;
        // Time: O(nk)
        // Space: O(n-k) = O(n)
    }

    // Optimized solution
    public static void optimMaxValSubarr(int[] nums, int k) {
        int resultArrLen = nums.length - k + 1;
        for (int i = 0; i < resultArrLen; i++) {
            int maxValSubarr = nums[i];
            for (int j = 0; j < k; j++) {
                maxValSubarr = max(maxValSubarr, nums[i + j]);
            }
            System.out.print(maxValSubarr + " ");
        }
        // Time: O(nk)
        // Space: O(1)
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10, 5, 2, 7, 8, 7};
        int k = 3;
        int[] result = naiveMaxValSubarr(nums, k);
        printNums(result);

        optimMaxValSubarr(nums, k);
    }
}