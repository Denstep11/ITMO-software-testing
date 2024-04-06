package org.example;

import lombok.SneakyThrows;
import org.example.logarithm.*;
import org.example.trigonometric.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class Function {
    Ln ln;
    Log2 log2;
    Log3 log3;
    Log5 log5;
    Log10 log10;
    Cos cos;
    Cot cot;
    Csc csc;
    Sec sec;
    Sin sin;

    public Function(){
        ln = new Ln();
        log2 = new Log2();
        log3 = new Log3();
        log5 = new Log5();
        log10 = new Log10();
        cos = new Cos();
        cot = new Cot();
        csc = new Csc();
        sec = new Sec();
        sin = new Sin();
    }

    public Function(Ln ln, Log2 log2, Log3 log3, Log5 log5, Log10 log10, Cos cos, Cot cot, Csc csc, Sec sec, Sin sin){
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
        this.cos = cos;
        this.cot = cot;
        this.csc = csc;
        this.sec = sec;
        this.sin = sin;
    }

    public double result(double x, double eps){
       if(x<=0){
            return (((((sin.result(x, eps) - csc.result(x, eps)) * sec.result(x, eps)) - csc.result(x, eps))
                    / (Math.pow((sec.result(x, eps) + sec.result(x, eps)) - sin.result(x,eps),2))) +
                    (((cos.result(x, eps) - cot.result(x, eps)) / csc.result(x, eps))
                            / (Math.pow(csc.result(x, eps) / sec.result(x, eps),2))));
       }
       else{
            return (((((log5.result(x,eps) / log5.result(x,eps)) - ln.result(x,eps)) - log10.result(x,eps))
                    - (log2.result(x,eps) - log2.result(x,eps))) - (((log10.result(x,eps)
                    - (log3.result(x,eps) - log3.result(x,eps))) + log3.result(x,eps))
                    + ((ln.result(x,eps) + log2.result(x,eps)) - log5.result(x,eps))));
       }
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
//        for (BigDecimal i = BigDecimal.valueOf(start); i.compareTo(BigDecimal.valueOf(stop)) <= 0; i = i.add(BigDecimal.valueOf(step))){
//            printer.println(i + "," + result(i.doubleValue(), eps));
//        }
        while (start<stop){
            printer.println(start + "," + result(start, eps));
            start+=step;
        }
        printer.close();
    }
}
