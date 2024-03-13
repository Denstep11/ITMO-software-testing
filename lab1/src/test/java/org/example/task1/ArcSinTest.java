package org.example.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArcSinTest {


    @ParameterizedTest
    @ValueSource(doubles = {0.9, 0.8, 0.7, 0.5, 0.3, 0.2, 0.1, 0, -0.2, -0.4, -0.5, -0.7, -0.8, -0.9})
    void testArcSinRow(double number) {
        assertEquals(Math.asin(number), ArcSin.result(number), 0.25);
    }

    @Test()
    void testArcSinBorders() {
        assertEquals(Math.asin(-1), ArcSin.result(-1), 0.25);
        assertEquals(Math.asin(1), ArcSin.result(1), 0.25);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.1, 1.1, 20,2,-10,5,5242,-892})
    void testArcSinAbroad(double number) {
        assertThrows(UndefinedValueException.class, () -> ArcSin.result(number));
    }
}
