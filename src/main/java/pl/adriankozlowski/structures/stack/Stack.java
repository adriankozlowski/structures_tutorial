package pl.adriankozlowski.structures.stack;


public class Stack {

    /**
     * wierzcholek stosu
     */
    Elem start;

    Stack() {
        start = null;
    }

    /**
     * zwracam wartosc wierzcholka
     */
    public Elem getStart() {
        return start;
    }

    /**
     * dodaje element do stosu
     */
    public void push(int x) {
        Elem temp = new Elem(x, start);
        start = temp;
    }

    /**
     * sciagam element ze stosu
     */
    public void pop() {
        if (start != null) {
            start = start.getNext();
        } else {
            System.out.println("Stos jest pusty");
        }

    }

    /**
     * wyswietlam zawartosc stosu
     */
    public void show() {
        if (start != null) {
            Elem temp = start;
            while (temp != null) {
                System.out.print(temp.getValue() + " ");
                temp = temp.getNext();
            }
            System.out.println();
        } else {
            System.out.println("Stos jest pusty");
        }
    }

    /**
     * zwracam ile elementow jest na stosie
     */
    public int size() {
        if (start != null) {
            Elem temp = start;
            int licznik = 0;
            while (temp != null) {
                licznik++;
                temp = temp.getNext();
            }
            return licznik;
        } else return 0;
    }

    /**
     * odwracam kolejnosc elemetow na stosie
     * wspomagajac sie dodatkowymi dwoma stosami
     */
    public void reverse(Stack stos2, Stack stos3) {
        if (start != null) {
            Elem temp = start;
            while (temp != null) {
                stos2.push(temp.getValue());
                this.pop();
                temp = temp.getNext();
            }
            while (stos2.getStart() != null) {
                stos3.push(stos2.getStart().getValue());
                stos2.pop();
            }
            while (stos3.getStart() != null) {
                this.push(stos3.getStart().getValue());
                stos3.pop();
            }
        }
    }

    /**
     * porzadkuje kolejnosc elementow na
     * stosie (od min do max)
     */
    public void sort(Stack stos2) {
        if (start != null) {
            int licznik = this.size();
            int max, licznik2 = 0;

            while (licznik != 0) {

                Elem temp = start;
                max = temp.getValue();
                while (temp != null) {
                    if (max > temp.getValue()) {
                        max = temp.getValue();
                    }
                    temp = temp.getNext();
                }

                while (start != null) {
                    if (start.getValue() != max) {
                        stos2.push(start.getValue());
                        this.pop();
                        licznik2++;
                    } else {
                        this.pop();
                        while (licznik2 != 0) {
                            this.push(stos2.getStart().getValue());
                            stos2.pop();
                            licznik2--;
                        }
                        stos2.push(max);
                        break;
                    }
                }
                licznik--;
            }

            while (stos2.getStart() != null) {
                this.push(stos2.getStart().getValue());
                stos2.pop();
            }
        } else {
            System.out.println("Stos jest pusty");
        }
    }


}