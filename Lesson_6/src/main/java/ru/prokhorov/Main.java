package ru.prokhorov;

public class Main {
    public static void main(String[] args) {
        TreeGenerator treeGenerator = new TreeGenerator();
        Tree<Integer>[] resTreeArr = treeGenerator.generator(5, -25, 25, 20);
    }
}
