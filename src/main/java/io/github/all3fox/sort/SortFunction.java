package io.github.all3fox.sort;

import java.util.Comparator;
import java.util.List;

public interface SortFunction {
    <T extends Comparable<? super T>> void sort(List<T> xs);
    <T> void sort(List<T> xs, Comparator<? super T> cmp);
}
