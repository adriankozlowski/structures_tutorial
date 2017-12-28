package pl.adriankozlowski.structures.lists.doubleDirection;

public class Lista {
    public static void main(String[] args) {
        DoubleDirectionList lista = new DoubleDirectionList();
        lista.insert("Metallica");
        lista.insert("Judas Priest");
        lista.insert("AC/DC");
        lista.insert("Iron Maiden");
        lista.insert("Black Sabbath");
        lista.insert("Nirvana");
        lista.getSize();
        lista.showAscending();
        lista.remove("Depeche Mode");
        lista.showDescending();
    }
}
