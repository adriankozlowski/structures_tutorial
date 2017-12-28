package pl.adriankozlowski.structures.tree;

public class RunTree {
    public static void main(String[] args) {
        Node<String> root = new Node<String>(null, "G");

        Node<String> n1 = root.addChild("E");
        Node<String> n2 = root.addChild("C");
        Node<String> n3 = root.addChild("V");
        n1.addChild("Z");
        Node<String> n4 = n1.addChild("M");
        n1.addChild("P");
        n4.addChild("J");
        Node<String> n5 = n2.addChild("X");
        n5.addChild("H");
        n5.addChild("O");
        n3.addChild("B");
        Node<String> n6 = n3.addChild("S");
        n6.addChild("F");

        Tree<String> drzewo = new Tree<String>(root);

        System.out.print("Pre Order: ");
        drzewo.preOrder(root);
        System.out.print("\nPost Order: ");
        drzewo.postOrder(root);
        System.out.print("\nIn Order: ");
        drzewo.inOrder(root);
        System.out.println();

    }
}
