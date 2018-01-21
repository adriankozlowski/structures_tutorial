package pl.adriankozlowski.structures.bst;

public class BST {
    private Node root = null;      // korzeń naszego drzewa

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(8);
        bst.insert(7);
        bst.insert(6);
    }

    /**
     * Dodawanie elementów
     */
    public void insert(int key) {
        if (root == null)
            root = new Node(key);
        else {
            Node actual = root;
            Node parent = null;
            while (actual != null) {
                parent = actual;
                actual = (actual.key > key) ? actual.left : actual.right;
            }
            if (parent.key > key) {
                parent.left = new Node(key);
                parent.left.parent = parent;
            } else {
                parent.right = new Node(key);
                parent.right.parent = parent;
            }
        }
    }

    /**
     * Wyszukiwanie elementu
     */
    public Node search(int key) throws Exception {
        Node actual = root;
        while (actual != null && actual.key != key)
            actual = (actual.key > key) ? actual.left : actual.right;
        if (actual == null)
            throw new Exception("Key not found");
        return actual;
    }

    /**
     * Znajdowanie minimalnego klucza
     */
    private Node min(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    /**
     * Znajdowanie minimalnego klucza
     */
    private Node max(Node node) {
        while (node.right != null)
            node = node.right;
        return node;
    }

    /**
     * Znajdowanie następnika
     */
    private Node successor(int key) throws Exception {
        Node node = this.search(key);
// Szukanie następnika gdy węzeł ma prawego potomka
        if (node.right != null) {
            node = node.right;
            while (node.left != null)
                node = node.left;
            return node;
        }
// Szukanie następnika gdy węzeł nie ma prawgo potomka
        else if (node.right == null && node != root && node != this.max(root)) {
            Node parent = node.parent;
            while (parent != root && parent.key < node.key)
                parent = parent.parent;
            return parent;
        } else
            throw new Exception("Not Found Successor");
    }

    /**
     * Znajodwanie poprzednika
     */
    private Node predecessor(int key) throws Exception {
        Node node = this.search(key);
// Szukanie poprzednika gdy węzeł ma lewego potomka
        if (node.left != null) {
            node = node.left;
            while (node.right != null)
                node = node.right;
            return node;
        }
// Szukanie poprzednika gdy węzeł nie ma lewego potomka
        else if (node.left == null && node != root && node != this.min(root)) {
            Node parent = node.parent;
            while (parent != root && parent.key > node.key)
                parent = parent.parent;
            return parent;
        } else
            throw new Exception("Not Found Predecessor");
    }

    /**
     * Usuwanie elementu
     */
    public Node remove(int key) throws Exception {
        Node node = this.search(key);
        Node parent = node.parent;
        Node tmp;
        if (node.left != null && node.right != null) {
            tmp = this.remove(this.successor(key).key);
            tmp.left = node.left;
            if (tmp.left != null)
                tmp.left.parent = tmp;
            tmp.right = node.right;
            if (tmp.right != null)
                tmp.right.parent = tmp;
        } else
            tmp = (node.left != null) ? node.left : node.right;
        if (tmp != null)
            node.parent = parent;
        if (parent == null)
            root = tmp;
        else if (parent.left == node)
            parent.left = tmp;
        else
            parent.right = tmp;
        return node;
    }

    /**
     * InOrder
     */
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + ", ");
            inOrder(node.right);
        }
    }

    /**
     * preOrder
     */
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + ", ");
            if (node.left != null)
                System.out.print(node.left.key + ", ");
            else
                System.out.print("-, ");
            if (node.right != null)
                System.out.println(node.right.key);
            else
                System.out.println("-");

            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * PostOrder
     */
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + ", ");
            if (node.left != null)
                System.out.print(node.left.key + ", ");
            else
                System.out.print("-, ");
            if (node.right != null)
                System.out.println(node.right.key);
            else
                System.out.println("-");
        }
    }
    public void remove (Integer key, Node pos)
    {
        if (pos == null) return;
        if (key.compareTo(pos.key)<0)
            remove (key, pos.left);
        else if (key.compareTo(pos.key)>0)
            remove (key, pos.right);
        else {
            if (pos.left != null && pos.right != null)
            {
                Node maxFromLeft = findMax(pos.left); //need to make a findMax helper
                pos.key = maxFromLeft.key;
                remove (maxFromLeft.key, pos.left);
            }
            else if(pos.left != null) {
                Node trash = pos;
                pos = pos.left;
                trash = null;
            }
            else if(pos.right != null) {
                Node trash = pos;
                pos = pos.right;
                trash = null;
            }
            else {
                pos = null;
            }
        }
    }

    private Node findMax(Node node) {
        if(node.right == null){
            return node;
        }else {
            return findMax(node.right);
        }
    }
}