package ru.prokhorov;

public class Main {
    public static void main(String[] args) {
        GenerateNotebook generateNotebook = new GenerateNotebook();
        int COUNT = 10000;
        generateNotebook.setMaxCount(COUNT);
        Notebook[] arrNotebook = generateNotebook.arrGenerate();

        SelectionSort selectionSort = new SelectionSort();
        arrNotebook = selectionSort.sort(arrNotebook);

        for (int i = 0; i < COUNT; i++) {
            System.out.println(arrNotebook[i].getManufacturer());
            System.out.println(arrNotebook[i].getPrice());
            System.out.println(arrNotebook[i].getRam());
        }
    }
}
