package com.datastructure.graph.BFS;

public class BFSTesting {
    public static void main(String[] args) {
        BreathFirstSearch bsf = new BreathFirstSearch();
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

        bsf.traversal(a);

    }
}
