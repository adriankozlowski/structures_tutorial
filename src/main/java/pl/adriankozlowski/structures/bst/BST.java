package pl.adriankozlowski.structures.bst;

import java.util.ArrayList;
import java.util.List;

public class BST {
    private Node root = null;      // korzeń naszego drzewa
    int depth = 0;

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(6);
        bst.insert(7);
        bst.insert(10);
        bst.insert(4);
        bst.insert(5);
        bst.insert(9);
        bst.insert(19);
        bst.insert(1);
        bst.insert(12);
        bst.insert(21);
        bst.insert(13);
        bst.insert(11);
//        int d = bst.dept(bst.root);
        print(bst.root);
        Node node = bst.recursiveSearch(bst.root, 7);
        System.out.println(node.key);
    }

    /**
     * Rysowanie drzewa:
     * 8
     * ┌─────┴─────┐
     * 6           9
     * ┌──┴──┐
     * 5     7
     * <p>
     * Process finished with exit code 0
     *
     * @param root
     */
    public static void print(Node root) {
        List<List<String>> lines = new ArrayList<List<String>>();
        List<Node> level = new ArrayList<Node>();
        List<Node> next = new ArrayList<Node>();

        level.add(root);
        int nn = 1;
        int widest = 0;
        while (nn != 0) {
            List<String> line = new ArrayList<String>();
            nn = 0;
            for (Node n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa = Integer.toString(n.key);
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();
                    next.add(n.left);
                    next.add(n.right);
                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;
            lines.add(line);
            List<Node> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int piece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(piece / 2f) - 1;
            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);
                    if (line.get(j) == null) {
                        for (int k = 0; k < piece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            for (int j = 0; j < line.size(); j++) {
                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(piece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(piece / 2f - f.length() / 2f);
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            piece /= 2;
        }
    }

    private int dept(Node node) {
        int i = 0;
        if (node != null) {
            deeper(node, ++i);
        }
        return depth;
    }

    private void deeper(Node node, int i) {
        if (node != null) {
            if (i > depth) {
                depth = i;
            }
            i++;
            deeper(node.left, i);
            deeper(node.right, i);
        }
    }

    /**
     * Dodawanie elementów
     */
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
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

    public Node recursiveSearch(Node node, int searchKey) {
        Node nodeLeft = null;
        Node noreRight = null;
        if (node != null) {
            if (node.key == searchKey) {
                return node;
            }
            nodeLeft = recursiveSearch(node.left, searchKey);
            noreRight = recursiveSearch(node.right, searchKey);
        }
        return nodeLeft != null ? nodeLeft : noreRight;
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
            System.out.print(node.key);
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