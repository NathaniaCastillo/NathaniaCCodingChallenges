package oosequence;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Itinerary{
	private ArrayList<Flight> flights;
	private String name;
	
	
	public Itinerary (String name1) {
		name = new String(name1);
		flights = new ArrayList<Flight>();

	}
	public void addFlight(Flight newFlight) {
		//System.out.println("size$$$$ " + flights.size());
		if (flights.size() == 0){
			//System.out.println("hello");
			flights.add(newFlight);
			//System.out.println("size#### " + flights.size());
			return;
		}//not here where deep copy needs to be added

		if(newFlight.getArrival().before(flights.get(0).getDeparture())) {
			flights = new ArrayList<Flight>();
			flights.add(0,newFlight);
			return;
		}		
		for (int i = 0; i <= flights.size()-1;i++ ){
			if (newFlight.getDeparture().after(flights.get(i).getArrival()) &&
					i == flights.size()-1|| newFlight.getArrival().before(flights.get(i+1).
							getDeparture())){
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
		
		return new String(name);
	}

	public ArrayList<Flight> getFlightList() {
		if (flights == null) {
			flights = new ArrayList<Flight>();	
			return flights ;
			}
		
		return flights;

}
}
