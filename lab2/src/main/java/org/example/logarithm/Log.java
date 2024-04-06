package org.example.logarithm;

import org.example.trigonometric.Sin;

public class Log {
    private final Ln ln;

    public Log(Ln ln){
        this.ln = ln;
    }

    public Log(){
        this.ln = new Ln();
    }
    public double result(double a, double x, double eps){
        return ln.result(x,eps)/ln.result(a,eps);
    }
}
