package io.github.all3fox.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class QuickSort implements SortFunction {
    private static final Random rng = new Random();

    @Override
    public <T extends Comparable<? super T>> void sort(List<T> xs) {
        sort(xs, 0, xs.size() - 1);
    }

    @Override
    public <T> void sort(List<T> xs, Comparator<? super T> cmp) {
        sort(xs, 0, xs.size() - 1, cmp);
    };

    private static <T extends Comparable<? super T>>
    void sort(List<T> xs, int fst, int lst) {
        sort(xs, fst, lst, (x, y) -> x.compareTo(y));
    }

    private static <T>
    void sort(List<T> xs, int fst, int lst, Comparator<? super T> cmp) {
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

        sort(xs, fst, j, cmp);
        sort(xs, i, lst, cmp);
    }
}
