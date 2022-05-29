public class RandElemInStream {
    // Problem from 5/28/22:

    // Given a stream of elements too large to store in memory, pick a random 
    // element from the stream with uniform probability.

    // Solution time: incomplete

    // Post-answer reveal analysis: I correctly deduced that since the stream of
    // elements is too large to be stored in memory, we cannot simply wait for
    // the stream to finish, then choose a random element in this stream which
    // we would store in an array. Then, I was also correct in deducing that we
    // would need to pick the element dynamically. Here, I perhaps should have
    // exercised more patience and perseverance, for the eventual solution is not
    // as exotic as I thought it may be. For the solution I will implement below,
    // I will treat an array as a data stream currently being read.

    public static int randElemInStream(int[] nums) {
        int toReturn = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((int) (Math.random() * (i + 1) + 1) == 1) {
                toReturn = nums[i];
            }
        }
        return toReturn;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        System.out.println(randElemInStream(nums));
    }
}