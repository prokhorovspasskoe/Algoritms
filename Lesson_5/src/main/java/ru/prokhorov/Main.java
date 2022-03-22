package ru.prokhorov;

import ru.prokhorov.backpack.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        DegreeOf degree = new DegreeOf();
//        double result = degree.pow(2, -3);
//        System.out.println(result);


        Backpack backpack = new Backpack();
        Subject television = new Television(100, 5, "Television");
        Subject glasses = new Glasses(25, 1, "Glasses");
        Subject laptop = new Laptop(200, 3, "Laptop");
        Subject necklace = new Necklace(300, 1, "Necklace");
        Subject smartphone = new Smartphone(150, 1, "Smartphone");
        Subject[] things = {television, glasses, laptop, necklace, smartphone};

        int firstMass = backpack.calculateAllMass(things, things.length);
        int firstPrice = backpack.calculateAllPrice(things);
        if (firstMass > 4) backpack.find(things.length);
        System.out.println(Arrays.toString(backpack.getTempArrSubject()));
    }
}
