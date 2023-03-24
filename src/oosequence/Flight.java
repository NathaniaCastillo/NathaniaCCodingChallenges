package oosequence;

import java.util.Date;

public class Flight extends TripComponent{
	private String departureAirport;
	private String arrivalAirport;
	
	
	
	
	
	public Flight(Date departureTime, Date arrivalTime, String departureAirport, String arrivalAirport) {
		super(departureTime,arrivalTime);
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}





	public Flight(Flight toCopy) {
		super(toCopy);
		this.arrivalAirport = toCopy.arrivalAirport;
		this.departureAirport = toCopy.departureAirport;
		
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

		if (arrivalAirport == null) {
			return "";
		}
	    else if (arrivalAirport.length() < 3 || arrivalAirport.length() > 3) {
			return "";
			
		}else {
			return arrivalAirport;
		}
		
	}





	public String getDepartureAirport() {
		if (departureAirport == null) {
			return "";
		}
	    else if (departureAirport.length() < 3 || departureAirport.length() > 3) {
			return "";
			
		}else {
			return departureAirport;
		}
		
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
		if(arrivalAirport != null) {
			return arrivalAirport + " " + super.getEnd();
		}
		else {
			return "";
		}}
	public String getStart() {

		if (departureAirport != null) {
			return departureAirport + " " + super.getStart();
		}
		else {
			return "";
		}
	}
	
	

}


