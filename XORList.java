public class XORList {
    // Problem from 5/19/22:
    // An XOR linked list is a more memory efficient doubly linked list. 
    // Instead of each node holding next and prev fields, it holds a 
    // field named both, which is an XOR of the next node and the previous node.
    // Implement an XOR linked list; it has an add(element) which adds the 
    // element to the end, and a get(index) which returns the node at index.
    // If using a language that has no pointers (such as Python), you can 
    // assume you have access to get_pointer and dereference_pointer functions
    // that converts between nodes and memory addresses.

    // Solution time: incomplete

    // Plan:
    // [] How does "both" work? What's the result of XORing 2 nodes? Is the 
    //    result its own class or is it still a node?
    // [] How do the conversion methods mentioned in the prompt help me? Do we 
    //    have to use pointers to solve this problem?

    // How do you even XOR addresses? Are you doing this bitwise?
    // (A XOR C) XOR C = A
    // https://www.geeksforgeeks.org/xor-linked-list-a-memory-efficient-doubly-linked-list-set-1/#:~:text=This%20memory%20efficient%20Doubly%20Linked,of%20previous%20and%20next%20nodes.

    // T: curr tail, N: new node/tail
    // Currently: T's address is (prev)
}
