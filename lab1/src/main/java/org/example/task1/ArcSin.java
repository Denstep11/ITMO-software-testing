package org.example.task1;

import lombok.SneakyThrows;

public class ArcSin {

    @SneakyThrows
    public static double result(double x)  {

        if (x > 1 || x < -1) {
            throw new UndefinedValueException("Область опредления должна быть [-1,1]");
        }
        int n = 10;

        double res = 0;
        for (int i = 0; i < n; i++) {
            res += ((factorial(2 * i)) / (Math.pow(2, 2 * i) * Math.pow(factorial(i), 2)))
                    * ((Math.pow(x, 2 * i + 1)) / (2 * i + 1));
        }
        return res;
    }

    private static int factorial(int x) throws UndefinedValueException {
        int n = 1;

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
