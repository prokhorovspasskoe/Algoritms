package ru.prokhorov;

public class SelectionSort {
    public Notebook[] sort(Notebook[] notebooks){
        for (int i = 0; i < notebooks.length; i++) {
            int min = i;
            for (int j = min + 1; j < notebooks.length; j++) {
                if(notebooks[j].getPrice() < notebooks[min].getPrice()){
                    min = j;
                }else if(notebooks[j].getPrice() == notebooks[min].getPrice()){
                    if((notebooks[j].getManufacturer().compareTo(notebooks[min].getManufacturer()) != 0)){
                        min = j;
                    }
                    else if(notebooks[j].getRam() < notebooks[min].getRam()){
                        min = j;
                    }
                }
            }
            Notebook temp = notebooks[i];
            notebooks[i] = notebooks[min];
            notebooks[min] = temp;
        }
        return notebooks;
    }
}
