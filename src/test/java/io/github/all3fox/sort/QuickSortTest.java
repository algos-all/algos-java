package io.github.all3fox.sort;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class QuickSortTest extends CheckSort {
    @Test(dataProvider = "checkOnSorted")
    public void testOnSorted(Integer[] xs) {
        List<Integer> ys = Arrays.asList(xs.clone());
        List<Integer> zs = Arrays.asList(xs.clone());

        QuickSort.sort(ys);
        Collections.sort(zs);

        assertTrue(ys.equals(zs));
    }

    @Test(dataProvider = "checkOnRandom")
    public void testOnRandom(Integer[] xs) {
        List<Integer> ys = Arrays.asList(xs.clone());
        List<Integer> zs = Arrays.asList(xs.clone());

        QuickSort.sort(ys);
        Collections.sort(zs);

        assertTrue(ys.equals(zs));
    }
}
