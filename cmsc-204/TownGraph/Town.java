package smithJoseph_Project6;


public class Town implements Comparable<Town>{

	private String name;
	
	private double distance = Double.MAX_VALUE;

	public Town(String name) {
		this.name = name;
	}
	
	public Town(Town templateTown) {
		this.name = templateTown.name;
	}
	
	public String getName() {
		return name;
	}
	
	
	@Override
	public int compareTo(Town town) {
		return Double.compare(distance, town.getDistance());

	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Town) obj).name.equals(this.name);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public String toString() {
		return name;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
}
