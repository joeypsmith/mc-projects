package smithJoseph_Project6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {

	private Set<Town> townSet;
	private Set<Road> roadSet;

	private Map<Town, LinkedList<Town>> adjacencyList;
	
	private Map<Town, Town> shortestPaths;

	public Graph() {
		townSet = new HashSet<Town>();
		roadSet = new HashSet<Road>();

		adjacencyList = new HashMap<Town, LinkedList<Town>>();
	}

	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {

		if (sourceVertex == null || destinationVertex == null)
			throw new NullPointerException("A specified town is null!");

		if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex))
			throw new IllegalArgumentException("A specified town is not apart of this map!");

		for (Road r : roadSet) {
			if (r.getSource().equals(sourceVertex) && r.getDestination().equals(destinationVertex)
					|| r.getSource().equals(destinationVertex) && r.getDestination().equals(sourceVertex)) {
				return r;
			}
		}

		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		containsEdge(sourceVertex, destinationVertex);

		Road r = new Road(sourceVertex, destinationVertex, weight, description);

		adjacencyList.get(sourceVertex).add(destinationVertex);
		adjacencyList.get(destinationVertex).add(sourceVertex);

		roadSet.add(r);
		return r;

	}

	@Override
	public boolean addVertex(Town v) {
		if (v == null)
			throw new NullPointerException("Specified town is null!");

		if (!containsVertex(v)) {

			townSet.add(v);
			adjacencyList.put(v, new LinkedList<Town>());
			return true;

		} else {
			return false;
		}
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		return getEdge(sourceVertex, destinationVertex) != null;
	}

	@Override
	public boolean containsVertex(Town v) {
		return getVertex(v) != null;
	}

	public Town getVertex(Town v) {
		if (v == null)
			throw new NullPointerException("Specified town is null!");

		for (Town t : townSet) {
			if (t.equals(v))
				return t;
		}

		return null;
	}

	@Override
	public Set<Road> edgeSet() {
		return roadSet;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> edges = new HashSet<Road>();

		for (Road r : roadSet) {
			if (r.contains(vertex))
				edges.add(r);
		}

		return edges;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (!containsEdge(sourceVertex, destinationVertex))
			return null;


		Road road = getEdge(sourceVertex, destinationVertex);

		//Check if weight matches, if 1 or above
		if(weight >= 1 && weight != road.getDistance()) 
			return null;
		
		//Check if name matches, if not null
		if(description != null && !description.equals(road.getName())) 
			return null;
		
		
		adjacencyList.get(sourceVertex).remove(destinationVertex);
		adjacencyList.get(destinationVertex).remove(sourceVertex);

		roadSet.remove(road);
		return road;

	}

	@Override
	public boolean removeVertex(Town v) {
		//Check to make sure vertex is in graph
		if (!containsVertex(v))
			return false;

		Set<Road> roadsOf = edgesOf(v);

		//Remove the vertex from the adjacency list
		adjacencyList.remove(v);

		//Remove every road connected to the town
		roadSet.removeAll(roadsOf);
		
		//Finally, remove the vertex from the set
		townSet.remove(v);

		return true;

	}

	@Override
	public Set<Town> vertexSet() {
		return townSet;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
		//Create path ArrayList and call the dijkstraShortestPath method
		ArrayList<String> path = new ArrayList<>();
		dijkstraShortestPath(sourceVertex);
		
		//Loop through each town BEHIND THE DESTINATION using the shortestPath map
		for (Town t = destinationVertex; t != null; t = shortestPaths.get(t)) {

			Town dest = t;
			Town source = shortestPaths.get(t);

			//If both towns exist, find the road and add the connection String to the list
			if (dest != null && source != null) {
				Road r = getEdge(dest, source);
				path.add(source + " via " + r + " to " + dest + " " + r.getDistance() + " mi");
			}
		}

		//Reverse the collection (We went from destination to source, so we need to reverse it
		//to source to destination
		Collections.reverse(path);
		return path;

	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		//Town Queue (Priority Queue) will sort and remove Town objects based on their distance from the source vertex
		PriorityQueue<Town> townQueue = new PriorityQueue<Town>();
		//Settled Towns (Linked List) will contain each town already visited with their distance from the source vertex
		List<Town> settledTowns = new LinkedList<Town>();
		//Shortest Paths (Hash Map) contains each town and their respective "previous" town in the path.
		//For example, If the shortest path is town1 -> town2 -> town3, town3's "previous" town will be town2, etc.
		shortestPaths = new HashMap<Town, Town>();

		//Reset all town distances from source to infinity (maximum double value)
		for(Town t : townSet) {
			t.setDistance(Double.MAX_VALUE);
		}
		
		//Set distance to source vertex FROM source vertex to 0 (distance from itself to itself is always 0)
		//Add to queue
		sourceVertex.setDistance(0);
		townQueue.add(sourceVertex);

		while (!townQueue.isEmpty()) {
			Town closestTown = townQueue.poll();

			//Look through all of the current towns adjacent towns using adjacency list
			for (Town t : adjacencyList.get(closestTown)) {

				//Check if current adjacent town is already settled or not
				if (!settledTowns.contains(t)) {

					Town adjacentTown = t;
					
					//Add the road's distance to the current distance from source vertex
					double distance = closestTown.getDistance() + getEdge(closestTown, adjacentTown).getDistance();

					//If this distance is smaller than the current adjacent town's distance,
					//Set the adjacent town's distance to the new distance and add it to the queue.
					//Put the closest town as the adjacent town's "previous" town
					if (distance < adjacentTown.getDistance()) {
						adjacentTown.setDistance(distance);
						shortestPaths.put(adjacentTown, closestTown);
						townQueue.add(adjacentTown);
					}

				}

			}

			//Add the current town to the settledTowns list
			settledTowns.add(closestTown);

		}

	}

}
