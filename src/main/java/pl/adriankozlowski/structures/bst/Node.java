package pl.adriankozlowski.structures.bst;

/**
 * Klasa węzeł - która jest używana jako struktura
 */
public class Node {
    public int key;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int key) {
        this.key = key;
    }
}
