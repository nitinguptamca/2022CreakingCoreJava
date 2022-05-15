package com.datastructure.graph.DFS;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private  boolean visited;
    private List<Vertex> adjacencyList;

    public Vertex(String name){
        this.name=name;
        this.adjacencyList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return  name ;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbour() {
        return adjacencyList;
    }

    public void addNeighbour(Vertex vertex) {
        this.adjacencyList.add(vertex);
    }
}
