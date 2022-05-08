package project6;

/***
 * Road class for town graph
 * 
 * @author Joseph Smith
 *
 */
public class Road implements Comparable<Road> {

	private Town source, destination;
	private int distance;
	private String name;

	private final static int DEFAULT_DISTANCE = 1;

	public Road(Town source, Town destination, int distance, String name) {

		this.setSource(source);
		this.setDestination(destination);
		this.setDistance(distance);
		this.setName(name);

	}

	public Road(Town source, Town destination, String name) {

		this(source, destination, DEFAULT_DISTANCE, name);

	}

	public boolean contains(Town town) {

		return (source.equals(town) || destination.equals(town));

	}

	public Town getSource() {
		return source;
	}

	public void setSource(Town source) {
		this.source = source;
	}

	public Town getDestination() {
		return destination;
	}

	public void setDestination(Town destination) {
		this.destination = destination;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Road road) {

		return name.compareTo(road.getName());

	}

	@Override
	public boolean equals(Object o) {

		Town src = ((Road) o).getSource();
		Town dest = ((Road) o).getDestination();

		return (source.equals(src) || source.equals(dest))
				&& (destination.equals(src) || destination.equals(destination));

	}

	@Override
	public String toString() {

		return name;

	}

}
