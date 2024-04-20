package org.example;

import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.example.trigonometric.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileReader;
import java.io.Reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrigonometricTest {
    static double eps = 0.01;
    static double testEps = 0.1;

    static Cos cosMock;
    static Cot cotMock;
    static Csc cscMock;
    static Sec secMock;
    static Sin sinMock;

    static Cos cos;
    static Cot cot;
    static Csc csc;
    static Sec sec;
    static Sin sin;

    static Reader cosRead;
    static Reader cotRead;
    static Reader cscRead;
    static Reader secRead;
    static Reader sinRead;

    @SneakyThrows
    @BeforeAll
    static void init(){
        cos = new Cos();
        cot = new Cot();
        csc = new Csc();
        sec = new Sec();
        sin = new Sin();

        cosMock = mock(Cos.class);
        cotMock = mock(Cot.class);
        cscMock = mock(Csc.class);
        secMock = mock(Sec.class);
        sinMock = mock(Sin.class);

        cosRead = new FileReader("src/main/resources/modules/cos.csv");
        cotRead = new FileReader("src/main/resources/modules/cot.csv");
        cscRead = new FileReader("src/main/resources/modules/csc.csv");
        secRead = new FileReader("src/main/resources/modules/sec.csv");
        sinRead = new FileReader("src/main/resources/modules/sin.csv");

        Iterable<CSVRecord> records;

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
    @CsvFileSource(resources = "/modules/cot.csv")
    void testWithCotMocks(double value, double expected) {
        cot = new Cot(sinMock, cosMock);
        assertEquals(expected, cot.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/cot.csv")
    void testWithCotCosMocks(double value, double expected) {
        cot = new Cot(new Sin(), cosMock);
        assertEquals(expected, cot.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/cot.csv")
    void testWithCotSinMocks(double value, double expected) {
        cot = new Cot(sinMock, new Cos());
        assertEquals(expected, cot.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/csc.csv")
    void testWithCscMocks(double value, double expected) {
        csc = new Csc(sinMock);
        assertEquals(expected, csc.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/sec.csv")
    void testWithSecMocks(double value, double expected) {
        sec = new Sec(cosMock);
        assertEquals(expected, sec.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/sin.csv")
    void testWithSin(double value, double expected) {
        assertEquals(expected, sin.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/cos.csv")
    void testWithCos(double value, double expected) {
        assertEquals(expected, cos.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/cot.csv")
    void testWithCot(double value, double expected) {
        assertEquals(expected, cot.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/csc.csv")
    void testWithCsc(double value, double expected) {
        assertEquals(expected, csc.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/sec.csv")
    void testWithSec(double value, double expected) {
        assertEquals(expected, sec.result(value, eps), testEps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modules/cos.csv")
    void testWithCosMocks(double value, double expected) {
        cos = new Cos(sinMock);
        assertEquals(expected, cos.result(value, eps), testEps);
    }

}
