public class LongestAbsPath {
    // Problem from 5/30/22:

    // Suppose we represent our file system by a string in the following manner:
    // The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
    // dir
    //     subdir1
    //     subdir2
    //         file.ext
    // The directory dir contains an empty sub-directory subdir1 and a 
    // sub-directory subdir2 containing a file file.ext.
    // Given a string representing the file system in the above format, return
    // the length of the longest absolute path to a file in the abstracted file
    // system. If there is no file in the system, return 0.
    // Note:
    // The name of a file contains at least a period and an extension.
    // The name of a directory or sub-directory will not contain a period.

    // Solution time: incomplete

    public int longestAbsPath(String fileSystem) {
        if (fileSystem.indexOf(".") == -1) {
            return 0;
        } else {
            // build k-ary tree (use helper)
            // find files and paths to them
            // calc and comp # of chars
            // ret longest
        }
    }
}
