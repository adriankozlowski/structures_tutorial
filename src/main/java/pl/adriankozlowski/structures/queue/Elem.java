package pl.adriankozlowski.structures.queue;

/**
 * jeden wezel
 */
public class Elem {
    private int value;
    private Elem next;

    public Elem(int x) {
        value = x;
        next = null;
    }

    public Elem getNext() {
        return next;
    }

    public void setNext(Elem e) {
        next = e;
    }

    public int getValue() {
        return value;
    }

}
