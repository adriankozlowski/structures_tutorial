package pl.adriankozlowski.structures.lists.doubleDirection;

public class Node {
    private String napis;
    private Node nastepny;
    private Node poprzedni;

    public Node() {
        nastepny = null;
        poprzedni = null;
    }

    public Node(String napis, Node nastepny, Node poprzedni) {
        this.napis = napis;
        this.nastepny = nastepny;
        this.poprzedni = poprzedni;
    }

    public String getText() {
        return napis;
    }

    public Node getNext() {
        return nastepny;
    }

    public void setNext(Node nastepny) {
        this.nastepny = nastepny;
    }

    public Node getPrevious() {
        return poprzedni;
    }

    public void setPrevious(Node poprzedni) {
        this.poprzedni = poprzedni;
    }
}
