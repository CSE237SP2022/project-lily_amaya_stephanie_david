package parkSimulator;
import java.util.ArrayList;
import java.util.List;

public class Park {
	private String parkName;
	private List<Location> parkLocations = new ArrayList<Location>();
	
	public Park(String name) {
		this.parkName = name;
	}
	
	public String getParkName() {
		return this.parkName;
	}
	
	public int getLocationCount() {
		return this.parkLocations.size();
	}
	
	public void addLocation(Location newLocation) {
		this.parkLocations.add(newLocation);
	}
	
	public void printLocations() {
		for (int i=0;i<parkLocations.size();i++) {
			System.out.println(parkLocations.get(i));
		}
	}
	
}
