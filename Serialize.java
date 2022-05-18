import java.util.ArrayList;
import java.util.Iterator;

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

    public class Node {
        String value;
        Node left;
        Node right;

        private Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        // [V] do we need helper functions? - no
    }

    public String serialize(Node node) {
        if (node == null) {
            return "#";
        }
        return node.value + " " + serialize(node.left) + " " + serialize(node.right);
    }

    public Node deserialize(String serialization) {
        String[] strs = serialization.split(" ");
        ArrayList<String> strList = new ArrayList<>();
        for (String str : strs) {
            strList.add(str);
        }
        Iterator<String> iter = strList.iterator();
        return helper(iter);
    }

    public Node helper(Iterator iter) {
        String val = (String) iter.next();
        if (val.equals("#")) {
            return null;
        }
        Node newNode = new Node(val, null, null);
        newNode.left = helper(iter);
        newNode.right = helper(iter);
        return newNode;
    }

    public static void main(String[] args) {
        Serialize obj = new Serialize();
        Node n1 = obj.new Node("A", obj.new Node("B", null, null), 
            obj.new Node("C", null, null));
        System.out.println(obj.serialize(n1));
        Node n2 = obj.deserialize(obj.serialize(n1));
        System.out.println(n2.value);
        System.out.println(n2.left.value);
        System.out.println(n2.right.value);
    }
}