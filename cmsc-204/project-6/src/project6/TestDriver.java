package project6;

public class TestDriver {

	private static Graph graph;
	
	public static void main(String[] args) {
		
		graph = new Graph();
		
		Town home, school;
		home = new Town("Home");
		school = new Town("School");
		
		graph.addVertex(home);
		graph.addVertex(school);
		
		graph.addEdge(home, school, 5, "Main Street");
		
		System.out.println(graph.vertexSet());
		System.out.println(graph.edgeSet());
		
		System.out.println(graph.shortestPath(home, school));
		
	}
	
}
