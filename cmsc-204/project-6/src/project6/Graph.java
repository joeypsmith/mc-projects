package project6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/***
 * Graph class for storing Towns, Road, and pathfinding
 * 
 * @author Joseph Smith
 *
 */
public class Graph implements GraphInterface<Town, Road> {

	// Adjacency list uses a HashMap to store:
	// Key: Any given town, Value: A set of Towns adjacent to the corresponding Key
	// Town
	private Map<Town, HashSet<Town>> adjacencyList;

	// Road and Towns are stored in a HashSet, to prevent duplicates / replace towns
	// easily
	private Set<Town> townSet;
	private Set<Road> roadSet;

	// Dijkstra's shortest path uses two HashMaps to store the data on the Graph itself,
	// not on the individual Towns and Roads
	private Map<Town, Integer> distanceFromTown;
	private Map<Town, LinkedList<Town>> shortestPaths;

	public Graph() {

		townSet = new HashSet<>();
		roadSet = new HashSet<>();

		adjacencyList = new HashMap<>();

	}

	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {

		for (Road r : roadSet) {

			if (r.contains(sourceVertex) && r.contains(destinationVertex))
				return r;

		}

		return null;

	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		Road newEdge = null;

		if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex))
			throw new IllegalArgumentException("Source and/or destination vertex is not found in the graph.");

		if (sourceVertex == null || destinationVertex == null)
			throw new NullPointerException("Source and/or destination vertex is null.");

		newEdge = new Road(sourceVertex, destinationVertex, weight, description);

		// Connect the source and destination, and add the road to the roadSet
		adjacencyList.get(destinationVertex).add(sourceVertex);
		adjacencyList.get(sourceVertex).add(destinationVertex);

		roadSet.add(newEdge);

		return newEdge;

	}

	@Override
	public boolean addVertex(Town v) {

		if (v == null)
			throw new NullPointerException("Specified vertex is null.");

		// If the adjacency list doesn't already contain the town
		// Add the town to the graph
		if (!adjacencyList.containsKey(v)) {

			adjacencyList.put(v, new HashSet<Town>());
			townSet.add(v);
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

		for (Town t : townSet) {

			if (t.equals(v))
				return true;

		}

		return false;

	}

	@Override
	public Set<Road> edgeSet() {

		return roadSet;

	}

	@Override
	public Set<Road> edgesOf(Town vertex) {

		// Add roads containing specified vertex to an edge set
		// Loop through the existing road set and use "contains" method
		// to find adjacent edges
		if (vertex == null)
			throw new NullPointerException("Specified vertex is null.");

		if (!containsVertex(vertex))
			throw new IllegalArgumentException("Specified vertex is not found in the graph.");

		Set<Road> edgeSet = new HashSet<>();
		for (Road r : roadSet) {

			if (r.contains(vertex))
				edgeSet.add(r);

		}

		return edgeSet;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		// Remove adjacency reference to destinationVertex in sourceVertex
		if (adjacencyList.containsKey(sourceVertex))
			if (adjacencyList.get(sourceVertex).contains(destinationVertex))
				adjacencyList.get(sourceVertex).remove(destinationVertex);

		// Remove adjacency reference to sourceVertex in destinationVertex
		if (adjacencyList.containsKey(destinationVertex))
			if (adjacencyList.get(destinationVertex).contains(sourceVertex))
				adjacencyList.get(destinationVertex).remove(sourceVertex);
				
		// Remove specified road from roadSet
		for (Road r : roadSet) {

			if (r.getName().equals(description)) {
				roadSet.remove(r);
				return r;
			}

		}

		return null;

	}

	@Override
	public boolean removeVertex(Town v) {

		// Remove vertex from adjacency list and townSet if the town exists in both
		// Every valid town will be contained in the adjacency list AND the town set
		if (adjacencyList.containsKey(v) && townSet.contains(v)) {

			for (Town t : adjacencyList.get(v)) {

				Road r = getEdge(v, t);

				if (r != null)
					roadSet.remove(r);

			}

			adjacencyList.remove(v);
			townSet.remove(v);

			return true;

		}

		return false;

	}

	@Override
	public Set<Town> vertexSet() {

		return townSet;

	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {

		ArrayList<String> pathList = new ArrayList<>();

		// Call shortest path algorithm
		// Save the shortest path list to the destination vertex
		dijkstraShortestPath(sourceVertex);
		LinkedList<Town> shortestPath = shortestPaths.get(destinationVertex);

		// If there is no shortest path, return null list
		if (shortestPath.isEmpty())
			return pathList;

		// Loop through each Town in the shortest path list
		// Previous and current towns are grabbed at the same time
		// Road is found using "getEdge" method
		Town previous = shortestPath.get(0);
		for (int i = 1; i < shortestPath.size(); i++) {

			Town current = shortestPath.get(i);

			if (previous != null && current != null) {
				Road road = getEdge(previous, current);
				pathList.add(previous + " via " + road + " to " + current + " " + road.getDistance() + " mi ");
			}

			previous = current;

		}

		// Finally, add destination vertex with it's previous town and road to the list
		// The destination vertex is not included in the shortest path list
		Road road = getEdge(previous, destinationVertex);
		pathList.add(previous + " via " + road + " to " + destinationVertex + " " + road.getDistance() + " mi ");

		return pathList;

	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {

		// If the source vertex is null, throw exception
		if (sourceVertex == null) {

			throw new NullPointerException("Source vertex is null.");

		}

		// Initialize maps and populate with default values
		distanceFromTown = new HashMap<>();
		shortestPaths = new HashMap<>();

		for (Town town : townSet) {

			distanceFromTown.put(town, Integer.MAX_VALUE);
			shortestPaths.put(town, new LinkedList<>());

		}

		// Source vertex's distance to the source is 0
		distanceFromTown.put(sourceVertex, 0);
		
		// Store settled / unsettled (visited) towns
		Set<Town> settledTowns = new HashSet<>();
		Set<Town> unsettledTowns = new HashSet<>();

		// Add source as first unsettled town and start algorithm
		unsettledTowns.add(sourceVertex);
		while (unsettledTowns.size() != 0) {

			// Current town iteration is the closest town within the unsettled towns
			// Remove the current town iteration from unsettled towns
			Town currentTown = getClosestTown(unsettledTowns);
			unsettledTowns.remove(currentTown);
			
			// Loop through all adjacent towns from the current town
			for (Town adjacentTown : adjacencyList.get(currentTown)) {

				// Find the distance between towns using the connecting road
				// This road will never be null, because a town cannot be adjacent
				// if there isn't a road there
				int distance = getEdge(currentTown, adjacentTown).getDistance();
				
				// If the adjacent town hasn't already been settled,
				// Call "calculateMinDistance" (explained in that method)
				// Add adjacentTown to unsettledTowns
				if (!settledTowns.contains(adjacentTown)) {

					calculateMinDistance(adjacentTown, distance, currentTown);
					unsettledTowns.add(adjacentTown);

				}
			}

			// Add the currentTown to settledTowns once all adjacent towns
			// have been evaluated
			settledTowns.add(currentTown);

		}

	}

	/*** Find the closest town from a set of unsettledTowns
	 * 
	 * @param unsettledTowns Unvisited towns
	 * @return Closest town
	 */
	private Town getClosestTown(Set<Town> unsettledTowns) {

		Town closest = null;
		int distance = Integer.MAX_VALUE;

		// Find the closest town within unsettledTowns, using distance map
		for (Town town : unsettledTowns) {

			int townDistance = distanceFromTown.get(town);
			if (townDistance < distance) {

				distance = townDistance;
				closest = town;

			}

		}

		return closest;

	}

	/*** Calculate the minimum distance from the adjacent town to the current town
	 * 
	 * @param adjacent Adjacent town
	 * @param distance Road distance
	 * @param current Current town
	 */
	private void calculateMinDistance(Town adjacent, int distance, Town current) {

		int currentDistance = distanceFromTown.get(current);

		// Check the distance of the current town added to the road distance
		// If that distance is less than the distance from the adjacent town
		// Update the distance and add the town to the shortest path
		if (currentDistance + distance < distanceFromTown.get(adjacent)) {

			distanceFromTown.put(adjacent, currentDistance + distance);
			LinkedList<Town> shortestPath = new LinkedList<>(shortestPaths.get(current));
			shortestPath.addLast(current);
			shortestPaths.put(adjacent, shortestPath);

		}

	}

}
