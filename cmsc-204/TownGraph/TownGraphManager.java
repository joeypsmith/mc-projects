package smithJoseph_Project6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface {

	private Graph townGraph;

	public TownGraphManager() {
		townGraph = new Graph();
	}

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		
		Town t1 = null, t2 = null;
		
		if(!containsTown(town1)) {
			addTown(town1);
			t1 = getTown(town1);
		}
		
		if(!containsTown(town2)) {
			addTown(town2);
			t2 = getTown(town2);
		}
			
		
		t1 = getTown(town1);
		t2 = getTown(town2);
		
		townGraph.addVertex(t1);
		townGraph.addVertex(t2);

		townGraph.addEdge(t1, t2, weight, roadName);

		return true;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Set<Road> roads = townGraph.edgeSet();

		for (Road r : roads) {
			if ((r.getSource().getName().equals(town1) && r.getDestination().getName().equals(town2))
					|| r.getSource().getName().equals(town2) && r.getDestination().getName().equals(town1))
				return r.getName();

		}

		return null;
	}

	public Road getRoadObject(String road) {

		Set<Road> roads = townGraph.edgeSet();

		for (Road r : roads) {
			if (r.getName().equals(road)) {
				return r;
			}
		}

		return null;
	}

	@Override
	public boolean addTown(String v) {

		Town t = new Town(v);
		townGraph.addVertex(t);
		return true;

	}

	@Override
	public Town getTown(String name) {

		Set<Town> towns = townGraph.vertexSet();

		for (Town t : towns) {
			if (t.getName().equals(name)) {
				return t;
			}
		}

		return null;

	}

	@Override
	public boolean containsTown(String v) {

		return getTown(v) != null;

	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {

		return getRoad(town1, town2) != null;

	}

	@Override
	public ArrayList<String> allRoads() {

		ArrayList<String> list = new ArrayList<>();
		Set<Road> roadSet = townGraph.edgeSet();

		for (Road r : roadSet) {
			list.add(r.toString());
		}

		Collections.sort(list);
		return list;

	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {

		Town t1 = getTown(town1);
		Town t2 = getTown(town2);

		Road r = getRoadObject(road);

		townGraph.removeEdge(t1, t2, r.getDistance(), r.getName());
		return true;

	}

	@Override
	public boolean deleteTown(String v) {

		townGraph.removeVertex(getTown(v));
		return true;

	}

	@Override
	public ArrayList<String> allTowns() {

		ArrayList<String> list = new ArrayList<>();
		Set<Town> townSet = townGraph.vertexSet();

		for (Town t : townSet) {
			list.add(t.toString());
		}

		Collections.sort(list);
		return list;

	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town t1 = getTown(town1), t2 = getTown(town2);
		ArrayList<String> result = new ArrayList<String>();

		if (t1 != null && t2 != null) {
			result = townGraph.shortestPath(t1, t2);
			return result;
		}
		
		return null;

	}

	@Override
	public void populateTownGraph(File file) throws FileNotFoundException, IOException {

		Scanner reader = new Scanner(file);

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			String[] information = line.split(";");

			String[] roadInfo = information[0].split(",");
			
			if(information.length < 3 || roadInfo.length < 2)
				throw new IOException("File not formatted correctly!");

			String name = roadInfo[0];
			int distance = Integer.parseInt(roadInfo[1]);

			String source = information[1];
			String dest = information[2];

			addRoad(source, dest, distance, name);

		}

		reader.close();

	}

}
