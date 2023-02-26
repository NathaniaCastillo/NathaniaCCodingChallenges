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
	
	public Flight(Flight flightToCopy) {
		
	}

	
	public long length() {
		return 0;
		
		
	}

}
