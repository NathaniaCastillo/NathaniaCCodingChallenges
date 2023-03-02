package oosequence;
import java.util.ArrayList;

public class Itinerary {
	private ArrayList<Flight> flights;
	private String name;
	
	
	public Itinerary (String name1) {
		name = name1;
		
		//constructor
	}
	public void addFlight(Flight flights1) {
		
		flights = new ArrayList<Flight>();
		//constructor
	}
	public long getTotalLayover() {
		return 0;
		//prpccess information
		
		
	}
	public String getName() {
		return "";
	}
	public ArrayList<Flight> getFlights() {//not sure abt this one
		return flights;
	}
	 

}
