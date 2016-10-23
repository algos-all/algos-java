package io.github.all3fox;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class BinarySearchTest {
    @Test
    public void testOnZero() {
        List<Integer> xs = new ArrayList<>();

        assertTrue(BinarySearch.search(xs, 42) == 0);
    }

    @Test
    public void testOnOne() {
        List<Integer> xs = new ArrayList<>(Arrays.asList(42));

        assertTrue(BinarySearch.search(xs, 42) == 0);
        assertTrue(BinarySearch.search(xs, 41) == 1);
        assertTrue(BinarySearch.search(xs, 43) == 1);
    }

    @Test
    public void testOnTwo() {
        List<Integer> xs = new ArrayList<>(Arrays.asList(42, 44));

        assertTrue(BinarySearch.search(xs, 41) == xs.size());
        assertTrue(BinarySearch.search(xs, 42) == 0);
        assertTrue(BinarySearch.search(xs, 43) == xs.size());
        System.out.println(BinarySearch.search(xs, 44));
        assertTrue(BinarySearch.search(xs, 44) == 1);
        assertTrue(BinarySearch.search(xs, 45) == xs.size());
    }

    @Test
    public void testOnThree() {
        List<Integer> xs = new ArrayList<>(Arrays.asList(-42, 0, 42));

        assertTrue(BinarySearch.search(xs, -100) == xs.size());
        assertTrue(BinarySearch.search(xs, -42) == 0);
        assertTrue(BinarySearch.search(xs, -12) == xs.size());
        assertTrue(BinarySearch.search(xs, 0) == 1);
        assertTrue(BinarySearch.search(xs, 12) == xs.size());
        assertTrue(BinarySearch.search(xs, 42) == 2);
        assertTrue(BinarySearch.search(xs, 100) == xs.size());
    }
}
