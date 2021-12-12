package smithJoseph_Project6;

public class Road implements Comparable<Road>{

	private Town source;
	private Town destination;
	private int distance;
	private String name;
	
	public Road(Town source, Town destination, int distance, String name) {
		this.setSource(source);
		this.setDestination(destination);
		this.setDistance(distance);
		this.setName(name);
	}
	
	//Road with default distance of 1
	public Road(Town source, Town destinaton, String name) {
		this.setSource(source);
		this.setDestination(destination);
		this.setDistance(1);
		this.setName(name);
	}
	
	public boolean contains(Town town) {
		return town.equals(source) || town.equals(destination);
	}
	
	@Override
	public int compareTo(Road road) {
		return road.name.equals(this.name) ? 0 : -1;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public boolean equals(Object r) {
		
		//Check if both roads have matching source and destination towns OR vice versa.
		return (((Road) r).getSource().equals(this.getSource()) && ((Road) r).getDestination().equals(this.getDestination()) ||
				((Road) r).getSource().equals(this.getDestination()) && ((Road) r).getDestination().equals(this.getSource()));

		
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

	public void setDestination(Town dest) {
		this.destination = dest;
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

}
