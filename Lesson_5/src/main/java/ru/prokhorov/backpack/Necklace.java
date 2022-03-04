package ru.prokhorov.backpack;

public class Necklace implements Subject{
    private final int price;
    private final int weight;
    private final String name;

    public Necklace(int price, int weight, String name) {
        this.price = price;
        this.weight = weight;
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }
}
