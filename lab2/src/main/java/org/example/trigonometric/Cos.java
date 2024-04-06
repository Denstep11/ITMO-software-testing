package org.example.trigonometric;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Cos {

    private final Sin sin;

    public Cos(Sin sin){
        this.sin = sin;
    }

    public Cos(){
        sin = new Sin();
    }

    public double result(double x, double eps){
        if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x) {
            return Double.NaN;
        }
        double pi = Math.PI;
        return sin.result(pi/2+x, eps);
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
