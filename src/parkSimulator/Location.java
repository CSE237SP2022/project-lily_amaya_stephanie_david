package parkSimulator;

public class Location {
	private String locationName;
	
	/**
	 * Constructor for a Location
	 * @param name The location name
	 */
	public Location(String name) {
		this.locationName = name;
	}
	
	/**
	 * Gets the name of a location
	 * @return a string containing the name of a location
	 */
	public String getLocationName() {
		return this.locationName;
	}
}
