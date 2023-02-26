/* Nathania castillo
 * UCID:30152619
 */
package oosequence;

import java.util.Date;

public class Flight {
	Date departure;
	Date arrival;
	
	public Flight (Date time1, Date time2) {
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
			long minutesDeparture = departure.getTime();//used get time to switch from date to long found byusing chat gpt.
			long minutesArrival = arrival.getTime();

			realLength = (minutesArrival - minutesDeparture)/60000;
			
		}

		return realLength;
		
	}

}
