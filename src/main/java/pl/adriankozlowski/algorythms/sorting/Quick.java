package pl.adriankozlowski.algorythms.sorting;

public class Quick {

    private static int tablica[];
    private static int ile_liczb;

    private static void quicksort(int tablica[], int x, int y) {

        int i, j, v, temp;

        i = x;
        j = y;
        v = tablica[(x + y) / 2];
        do {
            while (tablica[i] < v)
                i++;
            while (v < tablica[j])
                j--;
            if (i <= j) {
                temp = tablica[i];
                tablica[i] = tablica[j];
                tablica[j] = temp;
                i++;
                j--;
            }
        }
        while (i <= j);
        if (x < j)
            quicksort(tablica, x, j);
        if (i < y)
            quicksort(tablica, i, y);
    }
}
