package ru.prokhorov;

import java.util.Random;

public class TreeGenerator {
    private Tree<Integer>[] arrTree;

    private Tree<Integer> tree;

    public  Tree<Integer>[] generator(int level, int min, int max, int number){
        int count = (int) Math.pow(2, level) - 1;
        arrTree = new Tree[number];
        System.out.println("Количество элементов на " + level + " уровнях " + "в дереве - " + count);

        for (int i = 0; i < number; i++) {
            tree = new TreeImpl<>();
            for (int j = 0; j < count; j++) {
                int num = (int)(Math.random() * ((max - min) + 1)) + min;
                tree.add(num);
            }
            arrTree[i] = tree;
        }
        return arrTree;
    }
}
