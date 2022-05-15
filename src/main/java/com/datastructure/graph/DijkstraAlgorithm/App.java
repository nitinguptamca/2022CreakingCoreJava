package com.datastructure.graph.DijkstraAlgorithm;

public class App {

	public static void main(String[] args) {
		
			Vertex a = new Vertex("A"	);
			Vertex b = new Vertex("B"	);
			Vertex c = new Vertex("C"	);
			Vertex d = new Vertex("D"	);
			Vertex e = new Vertex("E"	);
			Vertex f = new Vertex("F"	);
			Vertex g = new Vertex("G"	);
			Vertex h = new Vertex("H"	);
			
			a.addNeighbor(new Edge(5, a, b));
			a.addNeighbor(new Edge(9, a, e));
			a.addNeighbor(new Edge(8, a, h));
			
			b.addNeighbor(new Edge(12, b, c));
			b.addNeighbor(new Edge(15, b, d));
			b.addNeighbor(new Edge(4, b, h));
			
			c.addNeighbor(new Edge(3, c, d));
			c.addNeighbor(new Edge(11, c, g));
			
			d.addNeighbor(new Edge(9, d, g));
			
			e.addNeighbor(new Edge(4, e, f));
			e.addNeighbor(new Edge(20, e, g));
			e.addNeighbor(new Edge(5, e, h));
			
			f.addNeighbor(new Edge(1, f, c));
			f.addNeighbor(new Edge(13, f, h));
			
			h.addNeighbor(new Edge(7, h, c));
			h.addNeighbor(new Edge(6, h, f));
			
			DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
			algorithm.computePath(a);
			
			System.out.println(algorithm.getShortestPathTo(d));
	}
}
