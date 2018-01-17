package pl.adriankozlowski.algorythms.sorting;

public class BubbleSort {
    /**
     * Wersja najprostsza i najbardziej nieoptymalna.
     *
     * @param tablica tablica liczb do posortowania
     */
    public static void bubblesort1(int[] tablica) {
        for (int i = 0; i < tablica.length - 1; i++) {
            for (int j = 0; j < tablica.length - 1; j++) {
                if (tablica[j] > tablica[j + 1]) {
                    swap(tablica, j, j + 1);
                }
            }
        }
    }

    /**
     * Pierwsza optymalizacja. Wewnętrzna pętla zmniejsza się o 1, ponieważ
     * za każdym jej przebiegiem największy element jest na swojej pozycji.
     * Nie trzeba z nim zatem porównywać innych liczb.
     *
     * @param tablica tablica liczb do posortowania
     */
    public static void bubblesort2(int[] tablica) {
        for (int i = 1; i < tablica.length; i++) {
            for (int j = 0; j < tablica.length - i; j++) {
                if (tablica[j] > tablica[j + 1]) {
                    swap(tablica, j, j + 1);
                }
            }
        }
    }

    /**
     * Druga optymalizacja. Zewnętrzna pętla zatrzymuje się gdy w pętli
     * wewnętrznej nie dokonano ani jednej zamiany.
     * W tej wersji optymistyczna złożoność obliczeniowa wynosi O(n).
     *
     * @param tablica tablica liczb do posortowania
     */
    public static void bubblesort3(int[] tablica) {
        boolean b = true;

        for (int i = 1; i < tablica.length && b; i++) {
            b = false;
            for (int j = 0; j < tablica.length - i; j++) {
                if (tablica[j] > tablica[j + 1]) {
                    swap(tablica, j, j + 1);
                    b = true;
                }
            }
        }
    }

    /**
     * Trzecia optymalizacja. Podobnie jak w drugiej optymalizacji zewnętrzna
     * pętla zatrzymuje się gdy w pętli wewnętrznej nie dokonano ani jednej
     * zamiany. Dodatkowo pętla wewnętrzna nie sprawdza ostatnich posortowanych
     * elementów nawet jeśli jest ich więcej niż wynikałoby to z obiegów pętli
     * zewnętrznej.
     * W tej wersji optymistyczna złożoność obliczeniowa wynosi O(n).
     *
     * @param tablica tablica liczb do posortowania
     */
    public static void bubblesort4(int[] tablica) {
        int n = tablica.length - 1;

        while (n > 0) {
            int last = 0;
            for (int j = 0; j < n; j++) {
                if (tablica[j] > tablica[j + 1]) {
                    swap(tablica, j, j + 1);
                    last = j;
                }
            }
            n = last;
        }
    }

    private static void swap(int[] tablica, int i, int j) {
        int temp = tablica[i];
        tablica[i] = tablica[j];
        tablica[j] = temp;
    }
}
