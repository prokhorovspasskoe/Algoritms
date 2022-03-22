package ru.prokhorov;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Graph graph = new GraphImpl(10);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орёл");
        graph.addVertex("Курск");

        graph.addEdge("Москва", "Тула", 183);
        graph.addEdge("Тула", "Липецк", 291);
        graph.addEdge("Липецк", "Воронеж", 125);
        graph.addEdge("Москва", "Рязань", 199);
        graph.addEdge("Рязань", "Тамбов", 293);
        graph.addEdge("Тамбов", "Саратов", 385);
        graph.addEdge("Саратов", "Воронеж", 511);
        graph.addEdge("Москва", "Калуга", 181);
        graph.addEdge("Калуга", "Орёл", 254);
        graph.addEdge("Орёл", "Курск", 169);
        graph.addEdge("Курск", "Воронеж", 227);

        graph.dfsEdge("Москва");
        int[] res = graph.getBufResult();
        System.out.println(Arrays.toString(res));
    }
}
