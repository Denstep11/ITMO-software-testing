package org.example.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadixSortTest {

    @Test
    void testSort() {
        assertAll(
                () -> assertArrayEquals(new int[]{2, 2, 20, 33, 100}, RadixSort.sort(new int[]{20, 33, 2, 100, 2})),
                () -> assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5}, RadixSort.sort(new int[]{3, 0, 4, 2, 1, 5})),
                () -> assertArrayEquals(new int[]{2, 11, 68, 80, 167, 189, 192, 228, 245, 385, 463, 477, 511, 544, 585, 590, 596, 606, 626, 644, 661, 699, 752, 757, 794, 823, 882, 898, 913, 938},
                        RadixSort.sort(new int[]{661, 385, 626, 463, 898, 228, 192, 606, 68, 167, 189, 80, 477, 757, 245, 644, 882, 590, 794, 2, 752, 585, 511, 596, 913, 11, 823, 544, 699, 938}))
        );
    }

    @Test
    void testZero() {
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, RadixSort.sort(new int[]{0, 0, 0, 0, 0}));
    }

    @Test
    void testEmpty() {
        assertArrayEquals(new int[]{}, RadixSort.sort(new int[]{}));
    }

    @Test
    void testNull() {
        assertThrows(NullPointerException.class, () -> RadixSort.sort(null));
    }

    @Test
    void testNegative() {
        assertThrows(NegativeValuesException.class, () -> RadixSort.sort(new int[]{-10, 3, -8, 43}));
    }
}
