package com.datastructure.graph.DAGSortedPath;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<Vertex> graph = new ArrayList<>();
		
		Vertex s = new Vertex("S");
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		
		s.addNeighbor(new Edge(a, 1));
		s.addNeighbor(new Edge(c, 2));
		
		a.addNeighbor(new Edge(b, 6));
		
		b.addNeighbor(new Edge(d, 1));
		b.addNeighbor(new Edge(e, 2));
		
		c.addNeighbor(new Edge(a, 4));
		c.addNeighbor(new Edge(d, 3));
		
		d.addNeighbor(new Edge(e, 1));
		
		graph.add(s);
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		
		ShortestPath algorithm = new ShortestPath(graph);
		algorithm.compute();
		
		for(Vertex v : graph)
			System.out.println("Distance from s: " + v.getMinDistance() 
			+ " - " + v.getPredecessor());
	}
}
