package pl.adriankozlowski.structures.lists.doubleDirection;


public class DoubleDirectionList {
    private Node first;
    private Node last;

    public DoubleDirectionList() {
        first = null;
        last = null;
    }

    public void insert(String text) {
        Node node = new Node(text, null, null);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            Node tmpNode = first;
            while (tmpNode != null) {
                if ((tmpNode.getText()).compareToIgnoreCase(text) < 0) {
                    tmpNode = tmpNode.getNext();
                } else {
                    if (tmpNode == first) {
                        node.setNext(tmpNode);
                        tmpNode.setPrevious(node);
                        first = node;
                        break;
                    } else {
                        node.setNext(tmpNode);
                        node.setPrevious(tmpNode.getPrevious());
                        (tmpNode.getPrevious()).setNext(node);
                        tmpNode.setPrevious(node);
                        break;

                    }
                }
            }
            if (tmpNode == null) {
                last.setNext(node);
                node.setPrevious(last);
                last = node;
            }

        }

    }

    public void remove(String text) {
        Node node = first;
        while (node != null) {
            if (node.getText().equals(text)) {
                if (node == first) {
                    first = (node.getNext());
                    break;
                } else if (node == last) {
                    last = (node.getPrevious());
                    break;
                } else {
                    (node.getPrevious()).setNext(node.getNext());
                    (node.getNext()).setPrevious(node.getPrevious());
                    break;
                }
            }
            node = node.getNext();
        }
        if (node == null) {
            System.out.println();
            System.out.println("Wyraz " + text + " nie znajduje sie na liście");
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void showAscending() {
        Node pomoc = first;
        System.out.println("Lista ułożona alfabetycznie od początku: ");
        while (pomoc != null) {
            System.out.print(pomoc.getText() + "   ");
            pomoc = pomoc.getNext();
        }
    }

    public void showDescending() {
        Node node = last;
        System.out.println("Lista ułożona alfabetycznie od końca: ");
        while (node != null) {
            System.out.print(node.getText() + "   ");
            node = node.getPrevious();
        }
    }

    /**
     *
     */
    public void getSize() {
        Node node = first;
        int i = 0;
        while (node != null) {
            i++;
            node = node.getNext();
        }
        System.out.println("Rozmiar listy: " + i);
    }
}

