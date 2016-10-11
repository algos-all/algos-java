package io.github.all3fox.sort;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CheckSort {
    @DataProvider
    public Object[][] checkOnSorted() {
        return new Object[][] {
                createSorted(0, 1),
                createSorted(0, 2),
                createSorted(0, 5),
                createSorted(0, 9),
                createSorted(-1, 0),
                createSorted(-2, 0),
                createSorted(-9, 0),
                createSorted(-42, +42),
                createSorted(-100, +100)
        };
    }

    @DataProvider
    public Object[][] checkOnRandom() {
        return new Object[][]{
                createRandom(1, -1024, 1024, 0),
                createRandom(9, -1024, 1024, 0),
                createRandom(9, -1024, 1024, 1),
                createRandom(9, -1024, 1024, 2),
                createRandom(10, -1024, 1024, 0),
                createRandom(10, -1024, 1024, 1),
                createRandom(10, -1024, 1024, 2),
                createRandom(1000, -10000, 10000, 0),
                createRandom(1000, -10000, 10000, 1),
                createRandom(1000, -10000, 10000, 2),
                createRandom(1000, -10000, 10000, 3)
        };
    }

    private Object[] createSorted(int lo, int hi) {
        List<Integer> result = new ArrayList<>();

        for (int i = lo; i < hi; ++i)
            result.add(i);

        return result.toArray();
    }

    private Object[] createRandom(int n, int lo, int hi, int seed) {
        Random rng = new Random(seed);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            result.add(rng.nextInt((hi - lo + 1)) + lo);
        }

        return result.toArray();
    }
}