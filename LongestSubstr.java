import java.util.HashMap;

public class LongestSubstr {
    // Problem from 5/26/22:

    // Given an integer k and a string s, find the length of the longest substring
    // that contains at most k distinct characters.
    // For example, given s = "abcba" and k = 2, the longest substring with 
    // k distinct characters is "bcb".

    // Solution time: 31 minutes

    public static int longestSubstr(int k, String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<String, Boolean> ltrsSeen = new HashMap<>();
            int currIdx = i;
            int currLen = 0;
            while (currIdx < s.length()) {
                String ltr = s.substring(currIdx, currIdx + 1);
                if (ltrsSeen.containsKey(ltr) && ltrsSeen.size() <= k) {
                    currLen++;
                    currIdx++;
                }
                if (!ltrsSeen.containsKey(ltr)) {
                    if (ltrsSeen.size() < k) {
                        ltrsSeen.put(ltr, true);
                        currLen++;
                        currIdx++;
                    } else {
                        break;  
                    }
                }
            }
            if (currLen > maxLen) {
                maxLen = currLen;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcba";
        String s2 = "";
        String s3 = "aaaaa";

        int k = 2;
        System.out.println(longestSubstr(k, s)); //exp: 3
        System.out.println(longestSubstr(k, s2)); //exp: 0
        System.out.println(longestSubstr(k, s3)); //exp: 5

        int k2 = 0;
        System.out.println(longestSubstr(k2, s)); //exp: 0
        System.out.println(longestSubstr(k2, s2)); //exp: 0
        System.out.println(longestSubstr(k2, s3)); //exp: 0

        int k3 = 4;
        System.out.println(longestSubstr(k3, s)); //exp: 5
        System.out.println(longestSubstr(k3, s2)); //exp: 0
        System.out.println(longestSubstr(k3, s3)); //exp: 5

        int k4 = 100;
        System.out.println(longestSubstr(k4, s)); //exp: 5
        System.out.println(longestSubstr(k3, s2)); //exp: 0
        System.out.println(longestSubstr(k3, s3)); //exp: 5
    }
}