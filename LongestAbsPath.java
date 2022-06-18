import java.util.ArrayDeque;

// 5/30/22

// Solution: https://leetcode.com/problems/longest-absolute-file-path/discuss/2126192/Java-Stack-Solution
// Annotations are mine

public class LongestAbsPath {
    public static int lengthLongestPath(String input) {
        var stack = new ArrayDeque<Integer>(); // stack is storing the length of the current level
        int max = 0;
        String[] lines = input.split("\n");
        for(var line: lines) {
            int tabs = countTabs(line);
            while(tabs < stack.size()) {
                // this only occurs when there's another directory at this level without a file,
                // and since we are looking for the file with the longest path, the aforementioned
                // directory will not be part of it
                // we're popping the most recent directory that will not be part of the path
                stack.pop();
            }
            int current = stack.isEmpty() ? 0: stack.peek(); 
            // current represents the current length of the path so far
            int nameLength = line.length() - tabs; 
            // nameLength represents the number of chars in this new line (excluding tabs)
            if(isFilename(line)) {
                max = Math.max(max, current + nameLength);
                // we don't add 1 here b/c there's no forward slash char at the 
                // end of the path
            } else {
                stack.push(current + nameLength + 1); 
                // add 1 is for the forward slash char in the path
            }
        }
        return max;
    }
    
    private static int countTabs(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '\t') return i;
        }
        return 0;
    }
    
    private static boolean isFilename(String s) {
        return s.lastIndexOf(".") != -1;
    }

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(LongestAbsPath.lengthLongestPath(input));
    }
}
