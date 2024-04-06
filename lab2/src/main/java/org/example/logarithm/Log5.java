package org.example.logarithm;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Log5{
        private final Ln ln;

        public Log5(Ln ln){
            this.ln = ln;
        }

        public Log5(){
            this.ln = new Ln();
        }
        public double result(double x, double eps){
            if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x) {
                return Double.NaN;
            }
            return ln.result(x,eps)/ln.result(5,eps);
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
