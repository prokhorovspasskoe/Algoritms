package ru.prokhorov;

public class DegreeOf {

    public double pow(double base, int degree){
        if(degree == 1) return base;
        if(degree < 0) return base / pow(base, Math.abs(degree-1));
        return base * pow(base, degree-1);
    }
}
