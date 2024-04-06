package org.example;


import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.example.logarithm.*;
import org.example.trigonometric.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.io.FileReader;
import java.io.Reader;


public class FunctionTest {
    static double eps = 0.001;
    static double testEps = 0.1;

    static Cos cosMock;
    static Cot cotMock;
    static Csc cscMock;
    static Sec secMock;
    static Sin sinMock;
    static Ln lnMock;
    static Log2 log2Mock;
    static Log3 log3Mock;
    static Log5 log5Mock;
    static Log10 log10Mock;

    static Reader lnRead;
    static Reader log2Read;
    static Reader log3Read;
    static Reader log5Read;
    static Reader log10Read;
    static Reader cosRead;
    static Reader cotRead;
    static Reader cscRead;
    static Reader secRead;
    static Reader sinRead;

    @SneakyThrows
    @BeforeAll
    static void init() {
        cosMock = mock(Cos.class);
        cotMock = mock(Cot.class);
        cscMock = mock(Csc.class);
        secMock = mock(Sec.class);
        sinMock = mock(Sin.class);
        lnMock = mock(Ln.class);
        log2Mock = mock(Log2.class);
        log3Mock = mock(Log3.class);
        log5Mock = mock(Log5.class);
        log10Mock = mock(Log10.class);

        lnRead = new FileReader("src/main/resources/input/ln.csv");
        log2Read = new FileReader("src/main/resources/input/log2.csv");
        log3Read = new FileReader("src/main/resources/input/log3.csv");
        log5Read = new FileReader("src/main/resources/input/log5.csv");
        log10Read = new FileReader("src/main/resources/input/log10.csv");
        cosRead = new FileReader("src/main/resources/input/cos.csv");
        cotRead = new FileReader("src/main/resources/input/cot.csv");
        cscRead = new FileReader("src/main/resources/input/csc.csv");
        secRead = new FileReader("src/main/resources/input/sec.csv");
        sinRead = new FileReader("src/main/resources/input/sin.csv");

        Iterable<CSVRecord> records;

        records = CSVFormat.DEFAULT.parse(lnRead);
        for (CSVRecord record : records) {
            when(lnMock.result(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.parseDouble(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(log2Read);
        for (CSVRecord record : records) {
            when(log2Mock.result(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.parseDouble(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(log3Read);
        for (CSVRecord record : records) {
            when(log3Mock.result(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.parseDouble(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(log5Read);
        for (CSVRecord record : records) {
            when(log5Mock.result(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.parseDouble(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(log10Read);
        for (CSVRecord record : records) {
            when(log10Mock.result(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.parseDouble(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(cosRead);
        for (CSVRecord record : records) {
            when(cosMock.result(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.parseDouble(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(cotRead);
        for (CSVRecord record : records) {
            when(cotMock.result(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.parseDouble(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(cscRead);
        for (CSVRecord record : records) {
            when(cscMock.result(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.parseDouble(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(secRead);
        for (CSVRecord record : records) {
            when(secMock.result(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.parseDouble(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(sinRead);
        for (CSVRecord record : records) {
            when(sinMock.result(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.parseDouble(record.get(1)));
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithMocks(double value, double expected) {
        Function function = new Function(lnMock, log2Mock, log3Mock, log5Mock, log10Mock, cosMock, cotMock, cscMock, secMock, sinMock);
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithLn(double value, double expected) {
        Function function = new Function(new Ln(), log2Mock, log3Mock, log5Mock, log10Mock, cosMock, cotMock, cscMock, secMock, sinMock);
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithLog2LnMock(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(lnMock), log3Mock, log5Mock, log10Mock, cosMock, cotMock, cscMock, secMock, sinMock);
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithLog2(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), log3Mock, log5Mock, log10Mock, cosMock, cotMock, cscMock, secMock, sinMock);
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithLog3LnMock(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(lnMock), log5Mock, log10Mock, cosMock, cotMock, cscMock, secMock, sinMock);
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithLog3(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), log5Mock, log10Mock, cosMock, cotMock, cscMock, secMock, sinMock);
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithLog5LnMock(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(lnMock), log10Mock, cosMock, cotMock, cscMock, secMock, sinMock);
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithLog5(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), log10Mock, cosMock, cotMock, cscMock, secMock, sinMock);
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithLog10LnMock(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), new Log10(lnMock), cosMock, cotMock, cscMock, secMock, sinMock);
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithLog10(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), new Log10(), cosMock, cotMock, cscMock, secMock, sinMock);
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithSin(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), new Log10(), cosMock, cotMock, cscMock, secMock, new Sin());
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithCosSinMock(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), new Log10(), new Cos(sinMock), cotMock, cscMock, secMock, new Sin());
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithCos(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), new Log10(), new Cos(), cotMock, cscMock, secMock, new Sin());
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithCotSinMockCosMock(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), new Log10(), new Cos(), new Cot(sinMock, cosMock), cscMock, secMock, new Sin());
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithCotSinCosMock(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), new Log10(), new Cos(), new Cot(new Sin(), cosMock), cscMock, secMock, new Sin());
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithCot(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), new Log10(), new Cos(), new Cot(), cscMock, secMock, new Sin());
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithCscSinMock(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), new Log10(), new Cos(), new Cot(), new Csc(sinMock), secMock, new Sin());
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithCsc(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), new Log10(), new Cos(), new Cot(), new Csc(), secMock, new Sin());
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithSecCosMock(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), new Log10(), new Cos(), new Cot(), new Csc(), new Sec(cosMock), new Sin());
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithSecCosSinMock(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), new Log10(), new Cos(), new Cot(), new Csc(), new Sec(new Cos(sinMock)), new Sin());
        assertEquals(expected, function.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/fun.csv")
    void testWithSec(double value, double expected) {
        Function function = new Function(new Ln(), new Log2(), new Log3(), new Log5(), new Log10(), new Cos(), new Cot(), new Csc(), new Sec(), new Sin());
        assertEquals(expected, function.result(value, eps), testEps);
    }
}
