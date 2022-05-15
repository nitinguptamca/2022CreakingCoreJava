package com.datastructure.graph.DFS;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    private Stack<Vertex> stack;

    public DepthFirstSearch(){
        this.stack = new Stack<>();
    }

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
        stack.add(rootVertex);
        rootVertex.setVisited(true);
        while (!stack.isEmpty()){
          Vertex actualVertex=  stack.pop();
            System.out.print(" , "+actualVertex);
            //now consider all actual vertex
            for (Vertex v: actualVertex.getNeighbour()) {
                if(!v.isVisited()){
                    v.setVisited(true);
                    stack.add(v);
                }
            }
        }
    }
}
