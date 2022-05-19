public class Pair {
    // Problem from 5/18/22
    // cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first
    // and last element of that pair. For example, car(cons(3, 4)) returns 3, and
    // cdr(cons(3, 4)) returns 4.
    // Given this implementation of cons:
    // def cons(a, b):
    //     def pair(f):
    //         return f(a, b)
    //     return pair
    // Implement car and cdr.

    // Solution time:

    // Plan:
    // [X] Implement Pair class in Java according to the prompt
        // Wouldn't this be too easy? e.g. write a class that has two fields, first
        // and last, and car(pair) returns pair.first, cdr(pair) returns pair.last?
    // [X] How am I misunderstanding the prompt as to trivialize its difficulty?
        // It's a CS concept called closure, which I'm yet to understand.
        // Refer to Pair.py for the solution; I'm not sure how closure and first-class
        // functions are implemented in Java yet, but after watching some tutorials, I
        // do feel like I understand the concept sufficiently well.

    int first, last;

    public Pair(int first, int last) {
        this.first = first;
        this.last = last;
    }

    public int car() {
        return this.first;
    }

    public int cdr() {
        return this.last;
    }

    public static void main(String[] args) {
        Pair p1 = new Pair(3, 4);
        System.out.println(p1.car());
        System.out.println(p1.cdr());
    }
}