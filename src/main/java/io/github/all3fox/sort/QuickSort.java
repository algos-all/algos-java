package io.github.all3fox.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class QuickSort {
    private static final Random rng = new Random();

    public static <T extends Comparable<? super T>> void sort(List<T> xs) {
        sort(xs, T::compareTo, 0, xs.size() - 1);
    }

    public static <T> void sort(List<T> xs, Comparator<? super T> cmp) {
        sort(xs, cmp, 0, xs.size() - 1);
    };

    private static <T>
    void sort(List<T> xs, Comparator<? super T> cmp, int fst, int lst) {
        if (fst >= lst) return;

        int i = fst, j = lst;

        T pivot = xs.get(rng.nextInt(xs.size()));

        while (i <= j) {
            while (cmp.compare(xs.get(i), pivot) < 0)
                i++;
            while (cmp.compare(pivot, xs.get(j)) < 0)
                j--;

            if (i <= j)
                Collections.swap(xs, i++, j--);
        }

        sort(xs, cmp, fst, j);
        sort(xs, cmp, i, lst);
    }
}