package oosequence;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Itinerary {
	private ArrayList<Flight> flights;
	private String name;
	
	
	public Itinerary (String name1) {
		name = name1;
		flights = new ArrayList<Flight>();
		//constructor bye
	}
	public void addFlight(Flight newFlight) {
		int i = 0;
		if (flights.size() == i){
			flights.add(newFlight);

			return;
		}
		if(newFlight.getArrival().before(flights.get(i).getDeparture())) {
			flights.add(i,newFlight);
			return;
		}		
		
		for (i = 0; i <= flights.size()-1;i++){
			if(newFlight.getDeparture().after(flights.get(i).getArrival())
				&& (i == flights.size()-1|| newFlight.getArrival().before(flights.get(i+1).getDeparture()))){
				flights.add(i+1,newFlight);
				return;
				
				}
				
			
				
			}
			
}


	public long getTotalLayover() {
		long totalLayover = 0;
		for(int i = 0; i < flights.size()-1;i++) {
			Flight finishedFlight = flights.get(i);
			Flight nextFlight= flights.get(i + 1);
			long singularLayover = nextFlight.getDeparture().getTime()
				- finishedFlight.getArrival().getTime();
			if (singularLayover > 0) {
				totalLayover = totalLayover + singularLayover;
			}
			}
		return totalLayover/60000;
		
		
		
	}
	public String getName() {
		return name;
	}
	public ArrayList<Flight> getFlights() {//not sure abt this one
		return flights;
	}
	 

}
