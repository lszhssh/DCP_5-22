public class Unival {
    // Problem from 5/21/22:
    // A unival tree (which stands for "universal value") is a tree where all nodes
    // under it have the same value. Given the root to a binary tree, count the
    // number of unival subtrees.

    // Solution time: 35 minutes

    // Plan:
    // - Recursively passing the roots of subtrees seems promising
        // - Base case: if children are null, then return 1
        // - Recursive step: if children are different from parent and each other,
        // return the sum of the method calls with the children as the arguments;
        // if children and parent are equal, then return 1 + the sum of the method
        // calls with the children as the arguments
    // - Need a basic Node class

    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this(value, null, null);
        }
    }

    public int countUnival(Node root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null || root.right == null) {
            if (root.left == null) {
                return countUnival(root.right);
            } else {
                return countUnival(root.left);
            }
        }
        if (root.left.value == root.right.value) {
            if (root.left.value == root.value) {
                return 1 + countUnival(root.left) + countUnival(root.right);
            } else {
                return countUnival(root.left) + countUnival(root.right);
            }
        }
        return countUnival(root.left) + countUnival(root.right);
    }

    public static void main(String[] args) {
        Unival obj = new Unival();
        Node n1 = obj.new Node(0, obj.new Node(1), obj.new Node(0, obj.new Node(1, obj.new Node(1), obj.new Node(1)), obj.new Node(0)));
        System.out.println(obj.countUnival(n1)); //exp: 5
    }
}
