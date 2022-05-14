public class CanSum {
    /**
     * Given a list of numbers and a number k, return whether any two numbers from
     * the list add up to k.
     * 
     * Bonus: Can you do this in one pass?
     */

    /**
     * plan:
     * - as the name of the file suggests, this is the classic canSum problem that 
     * I learnt while doing dynamic programming
     * - use tabulation
     * - assume only positive numbers allowed
     * - watch out for off-by-one errors
     */

    public boolean canSum(int target, int[] nums) {
        boolean[] table = new boolean[target + 1];
        table[0] = true;
        for (int i = 0; i < table.length; i++) {
            if (table[i]) {
                for (int num : nums) {
                    if (i + num < table.length) {
                        table[i + num] = true;
                    }
                }
            }
        }
        return table[target];
    }

    /**
     * plan for bonus:
     * - assume "one pass" means one iteration; it's not at all clear if that's what
     * the question intended, but given what I have to work with, this is my best
     * guess
     * - no idea how to do this in one iteration; however, if the problem meant to 
     * not use memoization, so "one pass" means one function call, then my tabulated
     * solution already suffices
     */

    public static void main(String[] args) {
        CanSum obj = new CanSum();
        int[] nums1 = new int[] {3, 7};
        System.out.println(obj.canSum(10, nums1)); //true, use both num once
        System.out.println(obj.canSum(13, nums1)); //true, use one num mult times
        System.out.println(obj.canSum(20, nums1)); //true, use both num mult times
        System.out.println(obj.canSum(11, nums1)); //false, use one num mult times
    }
}