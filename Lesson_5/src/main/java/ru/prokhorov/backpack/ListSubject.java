package ru.prokhorov.backpack;

import java.util.List;

public class ListSubject {
    private int weight;
    private int price;
    private List<String> arrName;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getArrName() {
        return arrName;
    }

    public void addName(String name){
        arrName.add(name);
    }

}
