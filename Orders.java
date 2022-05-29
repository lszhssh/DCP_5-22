public class Orders {
    // Problem from 5/29/22:
    
    // You run an e-commerce website and want to record the last N order ids in 
    // a log. Implement a data structure to accomplish this, with the following API:
    // record(order_id): adds the order_id to the log
    // get_last(i): gets the ith last element from the log. i is guaranteed 
    // to be smaller than or equal to N.
    // You should be as efficient with time and space as possible.

    // Solution time: 16 minutes

    // Plan:
    // - Use a stack; record is push, get_last is pop i times
        // - Time: record: O(1), get_last: O(i)
        // - Space: O(n)
        // - Doubly LL should be the same, but easier to implement get_last since
        // no need to make a copy
    // - Use an array; record is add, get_last is get(len - i)
        // - Time: record: O(n), get_last: O(i)
        // - Space: O(n)

    static class Node {
        String order_id;
        Node prev;
        Node next;

        public Node(String order_id) {
            this.order_id = order_id;
        }
    }

    Node head;
    Node tail;

    public Orders() {
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void record(String order_id) {
        Node newNode = new Node(order_id);
        Node currLastNode = this.tail.prev;
        currLastNode.next = newNode;
        newNode.prev = currLastNode;
        this.tail.prev = newNode;
        newNode.next = this.tail;
    }

    public String get_last(int i) {
        Node currNode = this.tail;
        for (int j = 0; j < i; j++) {
            currNode = currNode.prev;
        }
        return currNode.order_id;
    }

    public static void main(String[] args) {
        Orders log = new Orders();
        log.record("first");
        log.record("second");
        log.record("third");
        System.out.println(log.get_last(1));
        System.out.println(log.get_last(2));
        System.out.println(log.get_last(3));
    }
}