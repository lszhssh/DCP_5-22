public class Encode {
    // Problem from 5/20/22:
    // Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the
    // number of ways it can be decoded. For example, the message '111' would give 
    // 3, since it could be decoded as 'aaa', 'ka', and 'ak'. You can assume that 
    // the messages are decodable. For example, '001' is not allowed.

    // Solution time: 33 min

    // Plan:
    // - 1 message: all single digits
    // - each spot in the encoded message can either be part of a pair or be a single
        // - if digit > 2, it must be a single
        // try traversing the string and recursively finding number of possibilities
    
    public int numEncodings(String encoded) {
        if (encoded.length() == 0) {
            return 1;
        }
        if (encoded.length() == 1) {
            return 1;
        }
        if (Integer.valueOf(encoded.substring(0, 2)) > 26) {
            return numEncodings(encoded.substring(1));
        } else {
            return numEncodings(encoded.substring(1)) + numEncodings(encoded.substring(2));
        }
        // return 0;
    }

    public static void main(String[] args) {
        Encode obj = new Encode();
        
        String m1 = "111";
        System.out.println(obj.numEncodings(m1)); //exp: 3

        String m2 = "92618";
        System.out.println(obj.numEncodings(m2)); //exp: 4

        String m3 = "99999";
        System.out.println(obj.numEncodings(m3)); //exp: 1

        String m4 = "11111";
        System.out.println(obj.numEncodings(m4)); //exp: 8
        // no "11": 1 1 1 1 1
        // one "11": 4 options
        // two "11": 11 11 1, 1 11 11, 11 1 11
    }
}