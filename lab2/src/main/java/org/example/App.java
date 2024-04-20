package org.example;

import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.example.logarithm.*;
import org.example.trigonometric.*;

import java.io.FileReader;
import java.io.Reader;

public class App 
{
    @SneakyThrows
    public static void main(String[] args )
    {
        Ln ln = new Ln();
        Log log = new Log();
        Sin sin = new Sin();
        Cos cos = new Cos();
        Csc csc = new Csc();
        Sec sec = new Sec();
        Cot cot = new Cot();
        Log2 log2 = new Log2();
        Log3 log3 = new Log3();
        Log5 log5 = new Log5();
        Log10 log10 = new Log10();

        Function function = new Function();
//        System.out.println(sin.result(-2.4324,0.0000001));
//        System.out.println(cos.result(-2.4324,0.0000001));
//        System.out.println(cot.result(-2.4324,0.0000001));
//        System.out.println(csc.result(-2.4324,0.0000001));
//        System.out.println(sec.result(-2.4324,0.0000001));
//        System.out.println(ln.result(3.123,0.0000001));
//        System.out.println(log.result(10,3.123,0.0000001));
//        System.out.println(function.result(-10,0.0001));
//        System.out.println(2 + ","+ln.result(2, 0.001));
//        System.out.println(3 + "," + ln.result(3, 0.001));
//        System.out.println(5 + ","+ln.result(5, 0.001));
//        System.out.println(10 + "," + ln.result(10, 0.001));
//        ln.writeToCSV("src/main/resources/output/ln.csv", -5, 5, 0.1, 0.001);
//        log2.writeToCSV("src/main/resources/output/log2.csv", -5, 5, 0.1, 0.001);
//        log3.writeToCSV("src/main/resources/output/log3.csv", -5, 5, 0.1, 0.001);
//        log5.writeToCSV("src/main/resources/output/log5.csv", -5, 5, 0.1, 0.001);
//        log10.writeToCSV("src/main/resources/output/log10.csv", -5, 5, 0.1, 0.001);
//        sin.writeToCSV("src/main/resources/output/sin.csv", -5, 5, 0.1, 0.001);
//        cos.writeToCSV("src/main/resources/output/cos.csv", -5, 5, 0.1, 0.001);
//        cot.writeToCSV("src/main/resources/output/cot.csv", -5, 5, 0.1, 0.001);
//        csc.writeToCSV("src/main/resources/output/csc.csv", -5, 5, 0.1, 0.001);
//        sec.writeToCSV("src/main/resources/output/sec.csv", -5, 5, 0.1, 0.001);
//        function.writeToCSV("src/main/resources/output/fun.csv", -5, 5, 0.1, 0.001);
    }
}
