package org.example;

import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.example.logarithm.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileReader;
import java.io.Reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LogarithmTest {

    static double eps = 0.001;
    static double testEps = 0.1;

    static Ln lnMock;
    static Log2 log2Mock;
    static Log3 log3Mock;
    static Log5 log5Mock;
    static Log10 log10Mock;

    static Ln ln;
    static Log2 log2;
    static Log3 log3;
    static Log5 log5;
    static Log10 log10;

    static Reader lnRead;
    static Reader log2Read;
    static Reader log3Read;
    static Reader log5Read;
    static Reader log10Read;

    @SneakyThrows
    @BeforeAll
    static void init(){
        ln = new Ln();
        log2 = new Log2();
        log3 = new Log3();
        log5 = new Log5();
        log10 = new Log10();

        lnMock = mock(Ln.class);
        log2Mock = mock(Log2.class);
        log3Mock = mock(Log3.class);
        log5Mock = mock(Log5.class);
        log10Mock = mock(Log10.class);

        lnRead = new FileReader("src/main/resources/modules/ln.csv");
        log2Read = new FileReader("src/main/resources/modules/log2.csv");
        log3Read = new FileReader("src/main/resources/modules/log3.csv");
        log5Read = new FileReader("src/main/resources/modules/log5.csv");
        log10Read = new FileReader("src/main/resources/modules/log10.csv");

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
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/log2.csv")
    void testWithLog2Mocks(double value, double expected) {
        log2 = new Log2(lnMock);
        assertEquals(expected, log2.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/log3.csv")
    void testWithLog3Mocks(double value, double expected) {
        log3 = new Log3(lnMock);
        assertEquals(expected, log3.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/log5.csv")
    void testWithLog5Mocks(double value, double expected) {
        log5 = new Log5(lnMock);
        assertEquals(expected, log5.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/log10.csv")
    void testWithLog10Mocks(double value, double expected) {
        log10 = new Log10(lnMock);
        assertEquals(expected, log10.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/ln.csv")
    void testWithLn(double value, double expected) {
        assertEquals(expected, ln.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/log2.csv")
    void testWithLog2(double value, double expected) {
        assertEquals(expected, log2.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/log3.csv")
    void testWithLog3(double value, double expected) {
        assertEquals(expected, log3.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/log5.csv")
    void testWithLog5(double value, double expected) {
        assertEquals(expected, log5.result(value, eps), testEps);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/modules/log10.csv")
    void testWithLog10(double value, double expected) {
        assertEquals(expected, log10.result(value, eps), testEps);
    }

}
