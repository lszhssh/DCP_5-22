public class ExclusiveMult {
    /**
     * Problem from 5/15/22:
     * Given an array of integers, return a new array such that each element at 
     * index i of the new array is the product of all the numbers in the 
     * original array except the one at i.
     */

    /**
     * Solution time: 13 minutes
     */

    /**
     * plan:
     * - iterative approach
     * - create result arr
     * - for each elem in result, iter thru original arr and mult the correct elem
     */

    public int[] exclusiveMult(int[] original) {
        int[] result = new int[original.length];
        for (int i = 0; i < result.length; i++) {
            int product = 1;
            for (int j = 0; j < original.length; j++) {
                if (i != j) {
                    product *= original[j];
                }
            }
            result[i] = product;
        }
        return result;
    }

    public void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ExclusiveMult obj = new ExclusiveMult();

        int[] original1 = new int[] {1, 2, 3, 4, 5};
        int[] result1 = obj.exclusiveMult(original1);
        obj.printArray(result1);

        int[] original2 = new int[] {3, 2, 1};
        int[] result2 = obj.exclusiveMult(original2);
        obj.printArray(result2);
    }
}