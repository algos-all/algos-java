package io.github.all3fox;

import java.util.Comparator;
import java.util.List;

public class BinarySearch {
    public static <T extends Comparable<? super T>>
    int search(List<T> xs, T x) {
        return search(xs, x, T::compareTo);
    }

    public static <T>
    int search(List<T> xs, T x, Comparator<? super T> cmp) {
        int l = 0, r = xs.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (cmp.compare(xs.get(mid), x) == 0)
                return mid;

            if (cmp.compare(xs.get(mid), x) < 0)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return xs.size();
    }
}
