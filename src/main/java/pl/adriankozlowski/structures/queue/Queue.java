package pl.adriankozlowski.structures.queue;

/**
 * kolejka
 */
public class Queue {
    private Elem first, last;

    public Queue() {
        first = last = null;
    }

    public Elem getFirst() {
        return first;
    }

    public void setFirst(Elem e) {
        first = e;
    }

    public Elem getLast() {
        return last;
    }

    public void setLast(Elem e) {
        last = e;
    }

    /**
     * dodaje element na koniec kolejki
     */
    public void add(int x) {

        Elem temp = new Elem(x);
        if (first == null) {
            first = last = temp;
        } else {
            last.setNext(temp);
//temp.setNext(last);
            last = temp;
        }

    }

    /**
     * sciaga z kolejki element na 1 miejscu
     */
    public void delete() {
        if (first != null) {
            if (first.getNext() == null) {
                last = null;
            }

            first = first.getNext();
        } else System.out.println("kolejka jest pusta");
    }

    /**
     * wyswietla zawartosc kolejki
     */
    public void show() {
        if (first != null) {
            Elem temp = first;
            while (temp != null) {
                System.out.print(temp.getValue() + " ");
                temp = temp.getNext();
            }
            System.out.println();
        } else {
            System.out.println("kolejka jest pusta");
        }
    }

    /**
     * zlicza liczbe elemenetow na kolejce
     */
    public int count() {
        if (first != null) {
            int licznik = 0;
            Elem temp = first;
            while (temp != null) {
                licznik++;
                temp = temp.getNext();
            }
            return licznik;
        }
        return 0;
    }

    /**
     * kopiuje cala kolejke1 do kolejki k2
     * (kolejka 1 zostaje bez zmian
     */
    public void copy(Queue queue2) {
        Elem temp = first;
        if (temp != null) {
            while (temp != null) {
                queue2.add(temp.getValue());
                temp = temp.getNext();
            }
        } else {
            System.out.println("kolejka jest pusta");
        }
    }

    /**
     * scala 2 kolejki
     * wynik znajduje sie w kolejce 1
     * kolejka 2 jest pusta
     */

    public void merge(Queue queue2) {
        if (first == null) {
            first = queue2.getFirst();
            last = queue2.getLast();
        } else if (first != null && queue2.getFirst() != null) {
            last.setNext(queue2.getFirst());
            last = queue2.getLast();
        }
        queue2.setLast(null);
        queue2.setFirst(null);
    }


}
