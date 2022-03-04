package ru.prokhorov.backpack;

import java.util.LinkedHashSet;
import java.util.Set;

public class Backpack {
    private final Set<Subject> resultSet = new LinkedHashSet<>();
    private Subject[] arraySubject;
    private ListSubject[] tempArrSubject;
    private ListSubject tempSubject;
    private int mass;
    private final int MAX_MASS = 4;

    public Backpack() {
        this.tempSubject = new ListSubject();
    }

    public int calculateAllMass(Subject[] arraySubject, int max_mass){
        int resultMass = 0;
        for (int i = 0; i < arraySubject.length; i++) {
            resultMass += arraySubject[i].getWeight();
        }
        return resultMass;
    }

    public int calculateAllPrice(Subject[] arraySubject){
        int resultPrice = 0;
        for (int i = 0; i < arraySubject.length; i++) {
            resultPrice += arraySubject[i].getPrice();
        }
        return resultPrice;
    }

    public void find(int length){
        int bufMass = 0;
        int bufPrice = 0;
        int indexTemp = 0;

        if(length == 1) return;

        find(length - 1);

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length - 1; j++) {
                bufMass += arraySubject[j].getWeight();
            }

            if(bufMass > MAX_MASS){
                rotate(length);
            }else{
                for (int k = 0; k < length - 1; k++) {
                    bufPrice += arraySubject[k].getPrice();
                    tempSubject.addName(arraySubject[k].getName());
                }

                tempSubject.setWeight(bufMass);
                tempSubject.setPrice(bufPrice);

                tempArrSubject[indexTemp] = tempSubject;
                indexTemp++;
            }
        }
    }

    private void rotate(int length){
        int index = arraySubject.length - length;
        Subject temp = arraySubject[index];
        for (int i = index + 1; i < arraySubject.length; i++) {
            arraySubject[i - 1] = arraySubject[i];
        }
        arraySubject[arraySubject.length - 1] = temp;
    }

    public ListSubject[] getTempArrSubject() {
        return tempArrSubject;
    }
}
