package pl.adriankozlowski.structures.tree;

public class Tree<T> {
    private Node<T> root; // referencja do korzenia

    public Tree(Node<T> root) { // konstruktor jednoparametrowy
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void preOrder(Node<T> n) {
        System.out.print(n + " ");
        Node<T> temp = n.getLeftMostChild();
        while (temp != null) {
            preOrder(temp);
            temp = temp.getRightSibling();
        }
    }

    public void inOrder(Node<T> n) {
        if (n.isLeaf())
            System.out.print(n + " ");
        else {
            Node<T> temp = n.getLeftMostChild();
            inOrder(temp);
            System.out.print(n + " ");
            temp = temp.getRightSibling();
            while (temp != null) {
                inOrder(temp);
                temp = temp.getRightSibling();
            }
        }
    }

    public void postOrder(Node<T> n) {
        Node<T> temp = n.getLeftMostChild();
        while (temp != null) {
            postOrder(temp);
            temp = temp.getRightSibling();
        }
        System.out.print(n + " ");
    }


}

