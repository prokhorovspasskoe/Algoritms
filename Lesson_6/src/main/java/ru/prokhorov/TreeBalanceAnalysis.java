package ru.prokhorov;

import ru.prokhorov.Node;

public class TreeBalanceAnalysis {
    public boolean isBalanced(Node<Integer> node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private int height(Node<Integer> node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}
