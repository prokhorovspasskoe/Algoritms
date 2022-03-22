package ru.prokhorov;

public class Main {
    public static void main(String[] args) {
        TreeGenerator treeGenerator = new TreeGenerator();
        Tree<Integer>[] resTreeArr = treeGenerator.generator(4, -25, 25, 20);
        PercentageOfUnbalancedTrees percentageOfUnbalancedTrees = new PercentageOfUnbalancedTrees();
        double Res = percentageOfUnbalancedTrees.PercentageCalculate(resTreeArr);
        System.out.println(Res);
    }
}
