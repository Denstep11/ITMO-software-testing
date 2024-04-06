package org.example.trigonometric;

import lombok.SneakyThrows;
import org.example.Factorial;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Sin {

    @SneakyThrows
    public double result(double x, double eps){
        double res = 0;
        double res_1=1;
        int i =0;
        if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x) {
            return Double.NaN;
        }

        while (Math.abs(res_1 - res) > eps) {
                res_1 = res;
                res += (Math.pow(-1,i)*Math.pow(x,2*i+1))/(Factorial.result(2 * i + 1));
                i++;
        }
        if(Math.abs(res)<eps) return 0;
        return res;
    }

    @SneakyThrows
    public void writeToCSV(String fileName, double start, double stop, double step, double eps) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getName());
            } else {
                System.out.println("Файл уже существует.");
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка при создании файла.");
        }

        PrintWriter printer = new PrintWriter(file);
        while (start<stop){
            printer.println(start + "," + result(start, eps));
            start+=step;
        }
        printer.close();
    }
}
