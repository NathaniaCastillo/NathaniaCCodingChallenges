/* Nathania castillo
 * UCID:30152619
 */
package oosequence;

import java.util.Date;

public class Flight{
	
	private Date departure;
	private Date arrival;
	
	public Date getDeparture() {
		//sharing a reference to departure data with who ever called this methos
		//prevention is to make a copy
		if (departure == null) {
			return null;
		}
		
		
		return new Date(departure.getTime());//how to change from date to flight
		
	}

	public Date getArrival() {
		if(arrival == null) {
			return null;
		}
		
		return new Date(arrival.getTime());
	}

	public void setArrival(Date realArrival) {//setting only arrival date
		if (departure == (null) || realArrival == (null)) {
			arrival = realArrival;//no more tests at this point
		}
		else if (departure.before(realArrival)){
			arrival = realArrival;//this refers to instance and second is the local variable?
			
			
		}
			
	}

	public void setDeparture(Date realDeparture){//is this the one for when a departure changes? {//setting departure computer
		if(arrival == (null)|| realDeparture == (null)) {
			departure = realDeparture;;//idk
		}
		else if(realDeparture.before(arrival)) {//idkkkkk
			departure = realDeparture;
	}
	
		}

	

	
	public Flight (Date time1, Date time2) {//this naming either
		if (time1 == (null)&& time2 != null) {
			//don't use reference directly if i do not want to share my own
			this.departure = time1;
			this.arrival = new Date(time2.getTime());
		}
		else if (time2 == (null) && time1 != null) {
			this.departure =  new Date(time1.getTime());
			this.arrival = time2;
		}
		else if (time1 != (null) && time2 != (null)) {
			if (time1.before(time2)){
				this.departure =  new Date(time1.getTime());
				this.arrival = new Date(time2.getTime());
		}else {
				this.departure = (null);
				this.arrival = (null);
			}
		}
		
	}
	
	public Flight(Flight toCopy) {
		departure = toCopy.departure;//which type of variable to use??
		arrival = toCopy.arrival;
		
	}

	
	public long length() {
		long realLength = 0;
		if (departure != (null)&& arrival != (null)) {
			long minutesDeparture = departure.getTime();//used get time to switch from date to long found by using chat gpt.
			long minutesArrival = arrival.getTime();

			realLength = (minutesArrival - minutesDeparture)/60000;
			
		}

		return realLength;
		
	}


}
