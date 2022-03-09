package ru.prokhorov;

public class PercentageOfUnbalancedTrees {
    public double PercentageCalculate(Tree<Integer>[] arrTree){
        TreeBalanceAnalysis treeBalanceAnalysis = new TreeBalanceAnalysis();
        int col = 0;

        for (int i = 0; i < arrTree.length; i++) {
            boolean isBalanced = treeBalanceAnalysis.isBalanced(arrTree[i].getRoot());
            if(!isBalanced){
                col++;
            }
        }
        return (double) arrTree.length / col;
    }
}
