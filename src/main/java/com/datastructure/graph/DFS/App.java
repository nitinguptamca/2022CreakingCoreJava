package com.datastructure.graph.DFS;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");


        a.addNeighbour(b);
        a.addNeighbour(f);
        a.addNeighbour(g);
        b.addNeighbour(c);
        b.addNeighbour(d);
        d.addNeighbour(e);
        g.addNeighbour(h);

        List<Vertex> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.add(g);
        list.add(h);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.dfs(list);
        System.out.println("\n *************************");
        list.forEach( v -> v.setVisited(false));
        DepthFirstSearchRecursion depthFirstSearchRecursion = new DepthFirstSearchRecursion();
        depthFirstSearchRecursion.dfs(list);

    }
}
