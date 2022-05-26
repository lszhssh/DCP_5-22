public class Staircase {
    /**
     * Problem from 5/25/22:
     * There's a staircase with N steps, and you can climb 1 or 2 steps at a time.
     * Given N, write a function that returns the number of unique ways you can 
     * climb the staircase. The order of the steps matters.
     * 
     * What if, instead of being able to climb 1 or 2 steps at a time, you could 
     * climb any number from a set of positive integers X? For example, 
     * if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time. 
     * Generalize your function to take in X.
     */

    /**
     * Plan:
     * - I think this is a dynamic programming problem
     * - similar to (maybe even the same as) ___Sum problems I did while learning DP
     */

    /**
     * Returns the number of ways to make N steps given user-specified step-lengths
     * @return the number of ways to make N steps given user-specified step-lengths
     */
    public int numSum(int target, int[] stepLen) {
        /**
         * Plan:
         * - using tabulation
         * - similar to countConstruct (if idx can be constructed, add to elem the 
         * curr cnt, i.e. the ways to construct the curr idx)
         */
        int[] table = new int[target + 1];
        table[0] = 1;
        for (int i = 0; i <= target; i++) {
            if (table[i] != 0) {
                for (int len : stepLen) {
                    if (i + len <= target) {
                        table[i + len] += table[i];
                    }
                }
            }
        }
        // for testing purposes:
        // for (int i = 0; i < table.length; i++) {
        //     System.out.print(table[i] + " ");
        // }
        return table[target];
    }

    public static void main(String[] args) {
        Staircase obj = new Staircase();

        int[] len1 = new int[] {1, 2};
        System.out.println(obj.numSum(4, len1));

        int[] len2 = new int[] {1, 3, 5};
        System.out.println(obj.numSum(7, len2));
    }
}