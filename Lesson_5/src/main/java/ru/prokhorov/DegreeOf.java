package ru.prokhorov;

public class DegreeOf {

    public double pow(double base, int degree){
        if(degree == 1) return base;
        return base * pow(base, degree-1);
    }
}
