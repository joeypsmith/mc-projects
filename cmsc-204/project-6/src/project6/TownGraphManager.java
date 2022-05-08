package project6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/*** TownGraphManager class for managing the Graph class functions
 * 
 * @author Joseph Smith
 *
 */
public class TownGraphManager implements TownGraphManagerInterface {

	private Graph graph;

	public TownGraphManager() {

		graph = new Graph();

	}

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {

		try {
			return graph.addEdge(new Town(town1), new Town(town2), weight, roadName) != null;
		} catch (Exception e) {
			printException(e);
			return false;
		}

	}

	@Override
	public String getRoad(String town1, String town2) {

		return graph.getEdge(getTown(town1), getTown(town2)).toString();

	}

	@Override
	public boolean addTown(String v) {

		try {
			return graph.addVertex(new Town(v));
		} catch (NullPointerException e) {
			printException(e);
			return false;
		}

	}

	@Override
	public Town getTown(String name) {

		Iterator<Town> iterator = graph.vertexSet().iterator();
		while (iterator.hasNext()) {

			Town t = iterator.next();
			if (t.getName().equals(name))
				return t;

		}

		return null;

	}

	@Override
	public boolean containsTown(String v) {

		return getTown(v) != null;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {

		return graph.containsEdge(getTown(town1), getTown(town2));

	}

	@Override
	public ArrayList<String> allRoads() {

		ArrayList<String> roadList = new ArrayList<String>();

		for (Road r : graph.edgeSet()) {

			roadList.add(r.toString());

		}

		Collections.sort(roadList);
		return roadList;

	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {

		Town src = getTown(town1);
		Town dest = getTown(town2);

		Road r = graph.getEdge(src, dest);

		return graph.removeEdge(src, dest, r.getDistance(), r.toString()) != null;

	}

	@Override
	public boolean deleteTown(String v) {

		return graph.removeVertex(getTown(v));

	}

	@Override
	public ArrayList<String> allTowns() {

		ArrayList<String> townList = new ArrayList<>();

		for (Town t : graph.vertexSet()) {

			townList.add(t.toString());

		}

		Collections.sort(townList);
		return townList;

	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {

		return graph.shortestPath(getTown(town1), getTown(town2));

	}

	@Override
	public void populateTownGraph(File file) throws FileNotFoundException, IOException {

		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {

			String entry = scanner.nextLine();

			if (entry.isBlank())
				continue;

			String[] entries = entry.split(";");

			try {
				if (entries.length != 3) {
					throw new IOException("Invalid entry format");
				}
			} catch (IOException e) {
				printException(e, "for entry: '" + entry + "'");
				continue;
			}

			String[] roadInfo = entries[0].split(",");

			try {
				if (roadInfo.length != 2) {
					throw new IOException("Invalid road info");
				}
			} catch (IOException e) {
				printException(e, "for entry: '" + entry + "'");
				continue;
			}

			String roadName = roadInfo[0];
			Integer roadDistance;

			try {
				roadDistance = Integer.parseInt(roadInfo[1]);
			} catch (NumberFormatException e) {
				try {
					// TODO Throw Exception: Invalid road distance
					throw new IOException("Invalid road distance");
				} catch (IOException e1) {
					printException(e, "for entry: '" + entry + "'");
					continue;
				}

			}
			String srcTown = entries[1];
			String destTown = entries[2];

			addTown(srcTown);
			addTown(destTown);
			addRoad(srcTown, destTown, roadDistance, roadName);

		}

		scanner.close();

	}

	/***
	 * Print exception to console
	 * 
	 * @param e Exception
	 */
	private void printException(Exception e) {

		System.out.println("Exception thrown: " + e.getMessage());

	}

	/***
	 * Print exception to console, with a following message
	 * 
	 * @param e   Exception
	 * @param msg Message to follow exception
	 */
	private void printException(Exception e, String msg) {

		System.out.println("Exception thrown: " + e.getMessage() + " " + msg);

	}

}
