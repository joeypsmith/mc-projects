package project6;

/***
 * Town class for town graph
 * 
 * @author Joseph Smith
 *
 */
public class Town implements Comparable<Town> {

	private String name;

	public Town(String name) {

		this.name = name;

	}

	public Town(Town town) {

		this.name = town.getName();

	}

	public String getName() {

		return name;

	}

	@Override
	public int hashCode() {

		return name.hashCode();

	}

	@Override
	public String toString() {

		return name;

	}

	@Override
	public int compareTo(Town town) {

		return name.compareTo(town.getName());

	}

	@Override
	public boolean equals(Object o) {

		return name.equals(((Town) o).getName());

	}
}
