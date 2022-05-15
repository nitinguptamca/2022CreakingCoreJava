package com.datastructure.graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {

    public void traversal(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        root.setVisited(true);
        queue.add(root);
        while (!queue.isEmpty()) {
            Vertex actualVertex = queue.remove();
            System.out.println("Actual visited vertex   " + actualVertex);
            for (Vertex vertex : actualVertex.getAdjacencyList()) {
                vertex.setVisited(true);
                queue.add(vertex);
            }
        }
    }
}
