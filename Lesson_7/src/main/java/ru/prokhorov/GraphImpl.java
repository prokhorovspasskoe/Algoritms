package ru.prokhorov;

import java.util.*;

public class GraphImpl implements Graph{
    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;
    private final Edge[] arrEdge;
    private int[] bufResult;
    private int count;
    private int sum;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
        arrEdge = new Edge[maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int weight) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        Edge edge = new Edge(startLabel, secondLabel, weight);
        arrEdge[count] = edge;
        count++;

        adjMatrix[startIndex][endIndex] = weight;
        adjMatrix[endIndex][startIndex] = weight;

        return true;
    }

    @Override
    public Edge[] getArrEdge() {
        return arrEdge;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    private int indexOfArrEdge(String label){
        for (int i = 0; i < arrEdge.length; i++) {
            if(arrEdge[i].getStartPoint().equals(label)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(startLabel, other);
        }

        return result;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }

    @Override
    public void dfsEdge(String startLabel) {
        //???
        int startIndex = indexOfArrEdge(startLabel);
        count = 0;

        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный путь! " + startLabel);
        }
        Stack<Edge> stack = new Stack<>();
        Edge edge = arrEdge[startIndex];
        visitEdge(stack, edge);

        while (!stack.isEmpty()){
            edge = getNearUnvisitedEdge(stack.peek());
            if(edge != null){
                sum += edge.getWeight();
                visitEdge(stack, edge);
            }else {
                bufResult[count] = sum;
                count++;
                stack.pop();
            }
        }
    }

    @Override
    public int[] getBufResult() {
        return bufResult;
    }

    private Edge getNearUnvisitedEdge(Edge edge) {
        for (int i = 0; i < arrEdge.length; i++) {
            if(!arrEdge[i].isVisited()){
                return arrEdge[i];
            }
        }
        return null;
    }

    private void visitEdge(Stack<Edge> stack, Edge edge) {
        stack.push(edge);
        edge.setVisited(true);
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);

        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        stack.push(vertex);
        vertex.setIsVisited(true);
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setIsVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }

        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.remove();
            }
        }
    }
}
