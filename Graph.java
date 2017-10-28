package com.company;

import java.util.*;

public class Graph {
    private Map<Integer, ArrayList<Vertex>> vertexMap = new HashMap<Integer, ArrayList<Vertex>>();
    public int vertexNumber;
    public int edgesNumber;
    private List<Vertex> vertexList = new LinkedList<>();

    Graph () {
        super();
    }

    Graph(Map<Integer, ArrayList<Vertex>> vertexMap) {
        this.vertexMap = vertexMap;
    }

    public void addVertex(Vertex x) {
        if (!hasVertex(x)) {
            vertexMap.put(x.getX(), new ArrayList<Vertex>());
            vertexList.add(x);
        }
    }

    public boolean hasVertex(Vertex x) {
        return vertexMap.containsKey(x.getX());
    }

    public boolean hasEdge(Vertex x1, Vertex x2) {
        if (!hasVertex(x1)) return false;
        if (!hasVertex(x2)) return false;
        List<Vertex> edges = vertexMap.get(x1);
        return Collections.binarySearch(edges, x2) != -1;
    }

    public void addEdge(Vertex x1, Vertex x2) {
        if (!hasVertex(x1)) addVertex(x1);
        if (!hasVertex(x2)) addVertex(x2);
        vertexMap.get(x1.getX()).add(x2);
        vertexMap.get(x2.getX()).add(x1);
        x1.setDegree(x1.getDegree() + 1);
        x2.setDegree(x2.getDegree() + 1);
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public Graph getSubgraph(List<Vertex> nodesList) {
        Map<Integer, ArrayList<Vertex>> new_v_map = new HashMap<Integer, ArrayList<Vertex>>();
        for (Vertex vertex : nodesList) {
            ArrayList<Vertex> buffer = vertexMap.get(vertex.getX());
            buffer.retainAll(nodesList);
            new_v_map.put(vertex.getX(), buffer);
        }
        return new Graph(new_v_map);
    }

    public List<Vertex> getAdjacentVertexes(Vertex x) {
        List<Vertex> adjacentVertList = new ArrayList<>();
        adjacentVertList.addAll(this.getVertexMap().get(x.getX()));
        return adjacentVertList;
    }

    public Map<Integer, ArrayList<Vertex>> getVertexMap() {
        return vertexMap;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public void setVertexNumber(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public int getEdgesNumber() {
        return edgesNumber;
    }

    public void setEdgesNumber(int edgesNumber) {
        this.edgesNumber = edgesNumber;
    }
}
