package org.example.logarithm;

import lombok.SneakyThrows;
import org.example.Factorial;
import org.example.trigonometric.UndefinedValueException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Ln {

    @SneakyThrows
    public double result(double x, double eps){
        long n = 0;
        double res = 0;
        if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x) {
            return Double.NaN;
        }
        if (x<=0) {
            return Double.NaN;
        }

        if(x>2){
            while (x/2>=1){
                x=x/2;
                n++;
            }
        }
        for(int i=0;i<n;i++){
            res+=ln1(2,eps);
        }
        res+=ln1(x,eps);
        return res;
    }

    @SneakyThrows
    private double ln1(double x, double eps) {
        double res = 0;
        double res_1 = 1;
        int i = 1;
        x=x-1;
        if (x <= -1 || x > 1) {
            return Double.NaN;
        }
        while (Math.abs(res_1 - res) > eps) {
            res_1 = res;
            res += (Math.pow(-1,i-1)*Math.pow(x,i))/(i);
            i++;
        }
        if (Math.abs(res) < eps) return 0;
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
