package io.github.all3fox.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShellSort {
    public static <T extends Comparable<? super T>>
    void sort(List<T> xs) {sort(xs, T::compareTo);}

    public static <T>
    void sort(List<T> xs, Comparator<? super T> cmp) {
        int m = 1, n = xs.size();

        while (m < n / 3) {
            m = 3 * m + 1;
        }

        while (m != 0) {
            for (int i = m; i < n; ++i) {
                for (int j = i; j > m - 1; j -= m) {
                    if (cmp.compare(xs.get(j - m), xs.get(j)) <= 0)
                        break;

                    Collections.swap(xs, j - m, j);
                }
            }

            m /= 3;
        }
    }
}
