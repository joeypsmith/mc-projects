package smithJoseph_Project6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Graph_STUDENT_Test {

	private Graph graph;
	private Town pw, ch, te, kh, po, not;
	
	@BeforeEach
	void setUp() throws Exception {
		graph = new Graph();
		
		//Town names generated online randomly
		pw = new Town("Park Wogib");
		ch = new Town("Chardra");
		te = new Town("Tonstine");
		kh = new Town("Kmultiobia Harbour");
		po = new Town("Port Oilwilkession");
		not = new Town("Not apart of graph");
		
		graph.addVertex(pw);
		graph.addVertex(ch);
		graph.addVertex(te);
		graph.addVertex(kh);
		graph.addVertex(po);
		
		graph.addEdge(pw, te, 6, "Braeside Leas");
		graph.addEdge(ch, pw, 3, "Southland Brambles");
		graph.addEdge(kh,  po, 10, "Longfellow Highway");
		graph.addEdge(po, pw, 2, "Newland Avenue");
		graph.addEdge(kh, ch, 2, "Furlong Walk");
		graph.addEdge(te, po, 5, "Chantry Street");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		graph = null;
		
	}

	@Test
	void testGetEdge() {
		assertEquals(new Road(pw, te, 6, "Braeside Leas"), graph.getEdge(pw, te));
	}
	
	@Test
	void testAddEdge() {
		assertEquals(false, graph.containsEdge(po, ch));
		graph.addEdge(po, ch, 20, "New Road");
		assertEquals(true, graph.containsEdge(po, ch));
	}
	
	@Test
	void testAddVertex() {
		assertEquals(false, graph.containsVertex(not));
		graph.addVertex(not);
		assertEquals(true, graph.containsVertex(not));
	}
	
	@Test
	void testEdgeSet() {

		Set<Road> edgeSet = graph.edgeSet();
		ArrayList<String> roads = new ArrayList<String>();
		for(Road r : edgeSet) {
			roads.add(r.getName());
		}
		
		assertTrue(roads.contains("Braeside Leas"));
		assertTrue(roads.contains("Southland Brambles"));
		assertTrue(roads.contains("Longfellow Highway"));
		assertTrue(roads.contains("Newland Avenue"));
		assertTrue(roads.contains("Furlong Walk"));
		assertTrue(roads.contains("Chantry Street"));
		
	}
	
	@Test
	void testEdgesOf() {
		
		Set<Road> roadsOfTownPW = graph.edgesOf(pw);
		ArrayList<String> roads = new ArrayList<String>();
		for(Road r : roadsOfTownPW) {
			roads.add(r.getName());
		}
		
		assertTrue(roads.contains("Braeside Leas"));
		assertTrue(roads.contains("Southland Brambles"));
		assertTrue(roads.contains("Newland Avenue"));
		
	}
	
	@Test
	void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(kh, ch));
		//Checking for correct road name
		assertEquals(null, graph.removeEdge(kh, ch, 2, "Newland Avenue"));
		//Checking for correct road distance
		assertEquals(null, graph.removeEdge(kh, ch, 10, "Furlong Walk"));
		
		graph.removeEdge(kh, ch, 2, "Furlong Walk");
		assertEquals(false, graph.containsEdge(kh, ch));
	}
	
	@Test
	void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(po));
		graph.removeVertex(po);
		assertEquals(false, graph.containsVertex(po));
	}
	
	@Test
	void testVertexSet() {
		Set<Town> townSet = graph.vertexSet();
		ArrayList<String> towns = new ArrayList<String>();
		for(Town t : townSet) {
			towns.add(t.getName());
		}
		
		
		assertTrue(towns.contains("Park Wogib"));
		assertTrue(towns.contains("Chardra"));
		assertTrue(towns.contains("Tonstine"));
		assertTrue(towns.contains("Kmultiobia Harbour"));
		assertTrue(towns.contains("Port Oilwilkession"));
		
	}
	
	@Test
	void testPwToKh() {
		ArrayList<String> path = graph.shortestPath(pw, kh);
		assertTrue(path.size() > 0);
		assertEquals(path.get(0), "Park Wogib via Southland Brambles to Chardra 3 mi");
		assertEquals(path.get(1), "Chardra via Furlong Walk to Kmultiobia Harbour 2 mi");
	}
	
	@Test
	void testTeToCh() {
		ArrayList<String> path = graph.shortestPath(te, kh);
		assertTrue(path.size() > 0);
		assertEquals(path.get(0), "Tonstine via Braeside Leas to Park Wogib 6 mi");
		assertEquals(path.get(1), "Park Wogib via Southland Brambles to Chardra 3 mi");
		assertEquals(path.get(2), "Chardra via Furlong Walk to Kmultiobia Harbour 2 mi");
	}

}
