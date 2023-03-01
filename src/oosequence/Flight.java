/* Nathania castillo
 * UCID:30152619
 */
package oosequence;

import java.util.Date;

public class Flight {
	
	private Date departure;
	private Date arrival;
	
	public Object getDeparture() {
		return departure;
	}

	public Object getArrival() {
		return arrival;
	}

	public void setArrival(Date realArrival) {//setting only arrival date
		if (departure == (null) || realArrival == (null)) {
			arrival = realArrival;//no more tests at this point
		}
		else if (departure.before(realArrival)){
			arrival = realArrival;//this refers to instance and second is the local variable?
			
			// --> then departure date 
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
		if (time1 == (null)|| time2 == (null)) {
			departure = time1;
			arrival = time2;
		}
		else if (time1 != (null) && time2 != (null)) {
			if (time1.before(time2)){
				departure = time1;
				arrival = time2;
			}
			else {
				departure = (null);
				arrival = (null);
			}
		}
		
	}
	
	public Flight(Flight toCopy) {
		departure = toCopy.departure;
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
