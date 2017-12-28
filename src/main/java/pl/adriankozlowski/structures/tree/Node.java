package pl.adriankozlowski.structures.tree;

import java.util.LinkedList;

public class Node<T> {
    private T data; // dane
    private Node<T> parent; // referencja do rodzica
    private LinkedList<Node<T>> children; // lista dzieci

    /**
     * konstruktor domyślny
     */
    public Node() {
        parent = null;
        children = new LinkedList<Node<T>>();
    }

    public Node(Node<T> parent) { // konstruktor jednoparametrowy
        this();
        this.parent = parent;
    }

    public Node(Node<T> parent, T data) { // konstruktor dwuparametrowy
        this(parent);
        this.data = data;
    }


    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getDegree() {
        return children.size();
    }

    public Node<T> getChild(int i) {
        return children.get(i);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public Node<T> addChild(Node<T> child) {
        child.setParent(this);
        children.add(child);
        return child;
    }

    public Node<T> addChild(T data) {
        Node<T> child = new Node<T>(this, data);
        children.add(child);
        return child;
    }

    public Node<T> removeChild(int i) {
        return children.remove(i);
    }

    public void removeChildren() {
        children.clear();
    }

    public Node<T> getLeftMostChild() {
        if (children.isEmpty()) return null;
        return children.get(0);
    }

    public LinkedList<Node<T>> getChildren() {
        if (children.isEmpty()) return null;
        return children;
    }

    public Node<T> getRightSibling() {
        if (parent != null) {
            LinkedList<Node<T>> childrenParent = parent.getChildren();
            int pozycja = childrenParent.indexOf(this);
            if (childrenParent.size() > pozycja + 1)
                return childrenParent.get(pozycja + 1);
        }
        return null;
    }

    public String toString() {
        return data.toString();
    }
}
