package pl.adriankozlowski.algorythms.sorting;

import java.util.Arrays;
import java.util.Random;

public class Quick {

    private int tablica[];
    private int ile_liczb;

    public Quick(int tablica[]) {
        this.tablica = tablica;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(20);
        }

        System.out.println(Arrays.toString(ints));
        Quick quick = new Quick(ints);
        quick.sort();

        System.out.println(Arrays.toString(ints));
    }

    public void sort() {
        quicksort(tablica, 0, tablica.length - 1);
    }

    private void quicksort(int tablica[], int x, int y) {

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
