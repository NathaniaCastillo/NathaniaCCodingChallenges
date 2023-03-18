package oosequence;

import java.util.Date;

public class Flight extends TripComponent{
	private String departureAirport;
	private String arrivalAirport;
	
	
	
	
	
	public Flight(Date departureTime, Date arrivalTime, String departureAirport, String arrivalAirport) {
		// TODO Auto-generated constructor stub
	}





	public Flight(Flight toCopy) {
		// TODO Auto-generated constructor stub
	}





	public void setArrivalAirport(String arrivalAirport1) {
		
		if (arrivalAirport1 == null) {
			arrivalAirport = "";
		}
	    else if (arrivalAirport1.length() < 3 || arrivalAirport1.length() > 3) {
			arrivalAirport = "";
			
		}else {
			arrivalAirport = arrivalAirport1;
		}
		
	}





	public String getArrivalAirport() {
		// TODO Auto-generated method stub
		return arrivalAirport;
	}





	public String getDepartureAirport() {
		// TODO Auto-generated method stub
		return departureAirport;
	}





	public void setDepartureAirport(String departureAirport1) {
		if (departureAirport1 == null) {
			departureAirport = "";
		}
	    else if (departureAirport1.length() < 3 || departureAirport1.length() > 3) {
			departureAirport = "";
			
		}else {
			departureAirport = departureAirport1;
		}
		
	}


	public String getDuration() {
		long longSecs= lengthInSeconds();
		long longMinutes = longSecs/60;
		
		return String.valueOf(longMinutes) + " minutes";
	}

	public String getEnd() {
		return null;
		
	}
	public String getStart() {
		return null;
	}
	
	

}


