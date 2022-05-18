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

    // Courtesy of https://www.programiz.com/dsa/radix-sort
    // Using counting sort to sort the elements in the basis of significant places
    void countingSort(int array[], int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
        if (array[i] > max)
            max = array[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
        count[i] = 0;

        // Calculate count of elements
        for (int i = 0; i < size; i++)
        count[(array[i] / place) % 10]++;

        // Calculate cumulative count
        for (int i = 1; i < 10; i++)
        count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
        output[count[(array[i] / place) % 10] - 1] = array[i];
        count[(array[i] / place) % 10]--;
        }

        for (int i = 0; i < size; i++)
        array[i] = output[i];
    }

    // Courtesy of https://www.programiz.com/dsa/radix-sort
    // Function to get the largest element from an array
    int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
        if (array[i] > max)
            max = array[i];
        return max;
    }

    // Courtesy of https://www.programiz.com/dsa/radix-sort
    // Main function to implement radix sort
    void radixSort(int array[], int size) {
        // Get maximum element
        int max = getMax(array, size);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10)
        countingSort(array, size, place);
    }

    public int missingInt(int[] nums) {
        radixSort(nums, nums.length);
        int currNum = 1;
        for (int num: nums) {
            if (num > 0 && num == currNum) {
                currNum++;
            } else {
                break;
            }
        }
        return currNum;
    }

    public static void main(String args[]) {
        int[] data = { 121, 432, 564, 23, 1, 45, 788 };
        MissingInt obj = new MissingInt();
        // obj.radixSort(data, size);
        // System.out.println("Sorted Array in Ascending Order: ");
        // System.out.println(Arrays.toString(data));
        // System.out.println(obj.missingInt(data));

        int[] data2 = {3, 4, 6, 7, 5};
        System.out.println(obj.missingInt(data2));
    }
}