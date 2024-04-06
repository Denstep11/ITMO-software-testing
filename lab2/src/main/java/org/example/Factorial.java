package org.example;

import org.example.trigonometric.UndefinedValueException;

public class Factorial {
    public static double result(int x) throws UndefinedValueException{
        double n = 1;

        if (x < 0) {
            throw new UndefinedValueException("Область опредления должна быть x>0");
        }

        if (x == 0) {
            return 1;
        }

        for (int i = 1; i <= x; i++) {
            n *= i;
        }
        return n;
    }
}
