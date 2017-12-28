package pl.adriankozlowski.structures.bst;

/**
 * Klasa węzeł - która jest używana jako struktura
 */
public class Node {
    int key;
    Node left, right, parent = null;

    Node(int key) {
        this.key = key;
    }
}
