package org.example.trigonometric;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Cot {

    private final Sin sin;
    private final Cos cos;


    public Cot(Sin sin, Cos cos){
        this.sin = sin;
        this.cos = cos;
    }

    public Cot(){
        cos = new Cos();
        sin = new Sin();
    }


    @SneakyThrows
    public double result(double x, double eps){
        if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x) {
            return Double.NaN;
        }
        if(sin.result(x,eps)==0){
            return Double.NaN;
            //k*pi
        }
        return cos.result(x,eps)/sin.result(x,eps);
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
