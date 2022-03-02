package ru.prokhorov.backpack;

public class Glasses implements Subject{
    private final int price;
    private final int weight;

    public Glasses(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
