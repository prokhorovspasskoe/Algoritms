package ru.prokhorov;

public interface Graph {
    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, String... others);
    boolean addEdge(String startLabel, String secondLabel, int weight);

    int getSize();

    void display();

    void dfs(String startLabel);

    void dfsEdge(String startLabel);

    void bfs(String startLabel);

    public Edge[] getArrEdge();

    public int[] getBufResult();

}
