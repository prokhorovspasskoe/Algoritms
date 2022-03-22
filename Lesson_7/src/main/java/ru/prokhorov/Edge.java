package ru.prokhorov;

public class Edge {
    private final String startPoint;
    private final String endPoint;
    private final int weight;
    private boolean isVisited;

    public Edge(String startPoint, String endPoint, int weight) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.weight = weight;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
