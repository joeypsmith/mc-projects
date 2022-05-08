package project6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*** Graph class STUDENT test file
 * 
 * @author Joseph Smith
 *
 */
class Graph_STUDENT_Test {

	private Graph graph;

	private Road[] roads;
	private Town[] towns;

	@BeforeEach
	void setUp() throws Exception {

		graph = new Graph();

		towns = new Town[10];
		roads = new Road[5];

		for (int i = 0; i < towns.length; i++) {

			towns[i] = new Town("Town_" + i);
			graph.addVertex(towns[i]);

		}

		for (int i = 0; i < roads.length; i++) {

			Town source = towns[i];
			Town destination = (i > 1) ? towns[i * 2] : towns[i + 1];
			int distance = i * 2 % roads.length;
			String name = "Road_" + i;
			roads[i] =  new Road(source, destination, distance, name);
			graph.addEdge(source, destination, distance, name);
			
		}

	}

	@AfterEach
	void tearDown() throws Exception {

		graph = null;
		towns = null;
		roads = null;

	}

	@Test
	void testGetEdge() {
		
		assertEquals(roads[0], graph.getEdge(towns[0], towns[1]));
		assertEquals(roads[4], graph.getEdge(towns[4], towns[8]));
		assertEquals(roads[3], graph.getEdge(towns[3], towns[6]));
		
	}
	
	@Test
	void testAddEdge() {
		
		assertEquals(new Road(towns[0], towns[5], "New Road"), graph.addEdge(towns[0], towns[5], 0, "New Road"));
		assertEquals("New Road", graph.getEdge(towns[0], towns[5]).getName());
		assertTrue(graph.containsEdge(towns[0], towns[5]));
		
	}
	
	@Test
	void testAddVertex() {
		
		Town town = new Town("Town_11");
		assertTrue(graph.addVertex(town));
		assertTrue(graph.containsVertex(town));
		
	}
	
	@Test
	void testContainsEdge() {
		
		assertTrue(graph.containsEdge(towns[0], towns[1]));
		
	}
	
	@Test
	void testContainsVertex() {
		
		assertTrue(graph.containsVertex(towns[4]));
		
	}
	
	@Test
	void testEdgeSet() {
		
		Set<Road> testRoads = new HashSet<>();
		for(int i = 0; i < roads.length; i++)
			testRoads.add(roads[i]);
	
		List<Road> graphRoadList = new LinkedList<>(graph.edgeSet());
		List<Road> testRoadList = new LinkedList<>(testRoads);
		
		Collections.sort(graphRoadList);
		Collections.sort(testRoadList);
		
		assertTrue(testRoadList.containsAll(graphRoadList));
		
	}
	
	@Test
	void testRemoveEdge() {
		
		assertEquals("Road_0", graph.removeEdge(towns[0], towns[1], 0, "Road_0").getName());
		assertFalse(graph.containsEdge(towns[0], towns[1]));
		
	}
	
	@Test
	void testRemoveVertex() {
		
		graph.removeVertex(towns[0]);
		assertFalse(graph.containsVertex(towns[0]));
		
	}
	
	@Test
	void testVertexSet() {
		
		Set<Town> testTowns = new HashSet<>();
		for(int i = 0; i < towns.length; i++)
			testTowns.add(towns[i]);
	
		List<Town> graphTownList = new LinkedList<>(graph.vertexSet());
		List<Town> testTownList = new LinkedList<>(testTowns);
		
		Collections.sort(graphTownList);
		Collections.sort(testTownList);
		
		assertTrue(testTownList.containsAll(graphTownList));
		
	}

}
