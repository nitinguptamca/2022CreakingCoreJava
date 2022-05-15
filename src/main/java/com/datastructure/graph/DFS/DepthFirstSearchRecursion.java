package com.datastructure.graph.DFS;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearchRecursion {

    public void dfs(List<Vertex> vertexList){
        //it may happen that we have independent clusters
        for (Vertex vertex:vertexList){
            if(!vertex.isVisited()){
                vertex.setVisited(true);
                dfsHelper(vertex);
            }
        }
    }

    private void dfsHelper(Vertex rootVertex) {
        System.out.print(" , "+rootVertex);

        for (Vertex v:rootVertex.getNeighbour() ) {
            if(!v.isVisited()){
                v.setVisited(true);
                dfsHelper(v);
            }
        }
    }
}
