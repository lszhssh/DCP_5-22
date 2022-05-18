public class Serialize {
    /**
     * Problem from 5/16/22:
     * Given the root to a binary tree, implement serialize(root), which serializes
     * the tree into a string, and deserialize(s), which deserializes the string 
     * back into the tree.
     */

    // Solution time: incomplete

    /**
     * plan:
     * - use some form of binary tree traversal; not sure which is best for
     *   reconstructing the tree
     *   - serialize and deserialize are inverses, so it doesn't matter what 
     *     traversal we use, as long as they both use the same traversal logic
     *   - need to have indicators/labels since this isn't necesarily balanced
     *     e.g. "a b c" can be construed as a balanced tree or a skewed tree
     *     while both using the same traversal method 
     * - write a basic Node class
     */

    protected class Node {
        String value;
        Node left;
        Node right;

        private Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        // [] do we need helper functions?
    }

    public String serialize(Node node) {
        
        return "";
    }

    public Node deserialize(String serialization) {
        return new Node();
    }
}
