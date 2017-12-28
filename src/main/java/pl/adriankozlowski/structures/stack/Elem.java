package pl.adriankozlowski.structures.stack;

/**
 * pojedynczy element
 */
public class Elem {
    private int value;
    private Elem next;

    /**
     * konstruktor
     */
    public Elem(int x, Elem n) {
        next = n;
        value = x;
    }

    /**
     * zwracam wskzaznik na nastepny obiekt
     */
    public Elem getNext() {
        return next;
    }

    /**
     * zwracam przechowywana value
     */
    public int getValue() {
        return value;
    }
}
