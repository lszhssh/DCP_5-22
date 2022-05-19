import java.util.Arrays;

public class MissingInt {
    /**
     * Problem from 5/17/22:
     * Given an array of integers, find the first missing positive integer in linear
     * time and constant space. In other words, find the lowest positive integer that
     * does not exist in the array. The array can contain duplicates and negative 
     * numbers as well.
     * 
     * For example, the input [3, 4, -1, 1] should give 2. 
     * The input [1, 2, 0] should give 3.
     * 
     * You can modify the input array in-place.
     */

    // Solution time: incomplete

    /**
     * Plan: 
     * - linear time => iterate thru the arr once
     * - constant space => keep 1 or 2 vars
     * - looking for lowest positive int => negatives don't matter
     * [X] currNum init to 0 and incr if found in arr; when finished trav arr,
     *   currNum+1 is the return value
     *   - this approach fails when the missing value of the first n-1 ints
     *     is the last int; e.g. [3,4,6,7,5] should return 8, but will return 6
     * - what if we sort the arr? if we can sort in linear time, then iter in 
     *   linear time, then the function has a linear time complexity (this may also
     *   be why the problem said we can modify the input arr in place)
     *   - radix sort, which works exclusively for ints, is linear time
     *   [X] use radix sort to sort the int arr in place, then iterate thru the 
     *       sorted arr to find the missing positive int
     *       [V] how to implement radix sort (with neg nums)?
     *       - this doesn't work because radix sort has a linear time space 
     *         complexity, of which we need a constant time
     */

    public int missingInt(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && nums[i] <= nums.length) {
                int val = nums[i];
                int temp = nums[val - 1];
                nums[i] = temp;
                nums[val - 1] = val;
            }
        }
        int currNum = 1;
        for (int num : nums) {
            if (num == currNum) {
                currNum++;
            }
        }
        return currNum;
    }

    public static void main(String args[]) {
        MissingInt obj = new MissingInt();

        int[] d = {121, 432, 564, 23, 1, 45, 788};
        System.out.println(obj.missingInt(d)); //exp: 2

        int[] d2 = {1, 2, 4, 3, 5};
        System.out.println(obj.missingInt(d2)); //exp: 6

        int[] d3 = {0, 3, 2, 6, 9};
        System.out.println(obj.missingInt(d3)); //exp: 1

        int[] d4 = {};
        System.out.println(obj.missingInt(d4)); //exp: 1

        int[] d5 = {0};
        System.out.println(obj.missingInt(d4)); //exp: 1
    }
}