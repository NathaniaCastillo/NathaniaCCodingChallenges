/* Nathania castillo
 * UCID:30152619
 */
package oosequence;

import java.util.Date;

public class TripComponent {
	
	private Date start;
	private Date end;
	
	
	public Date getStart() {
		//System.out.print(" this is the start time: "+start);
		return start;
		
	}

	public Date getEnd() {
		//asserts that the new end date is correctly set by calling this function
		//System.out.println(" this is the end time: "+end);
		return end;
	}
	
	
	public void setStart(Date currentTime) {
		if (currentTime == null || end == null) {//if the current time is not nulll
			start = currentTime;
		
		}else if (currentTime.before(end)) {
			start = currentTime;
		}
		
		
		
	}

	public void setEnd(Date oneHourLaterTime) {
		
		if (oneHourLaterTime == null || start == null){//&& (end.equals(oneHourLaterTime)) ) {
			end = oneHourLaterTime;
		}else if (oneHourLaterTime.after(start)) {//change
			end = oneHourLaterTime;
		}
		

		
	}

	public void setArrival(Date realArrival) {//setting only arrival date
		//System.out.println("real arrival: " + realArrival);
		if (start == (null) || realArrival == (null)) {
			end = realArrival;//no more tests at this point
		}
		else if (start.before(realArrival)){
			end = realArrival;//this refers to instance and second is the local variable?
			
			// --> then departure date 
		}
			
	}

	public void setDeparture(Date realDeparture){//is this the one for when a departure changes? {//setting departure computer
		if(end == (null)|| realDeparture == (null)) {
			start = realDeparture;;//idk
		}
		else if(realDeparture.before(end)) {//idkkkkk
			start = realDeparture;
	}
	
		}

	

	
	public TripComponent (Date time1, Date time2) {
		//System.out.println("time1"+time1 + "time2" +time2);
		if (time1 == (null)|| time2 == (null)) {
			start = time1;
			end = time2;
		}
		else if (time1.after(time2)){{//||time1.equals(time1)){ {//not sure here
			start = time1;
			end = null;}}
		else if(time2.getTime() > time1.getTime()) {
			start = time1;
			end = time2;
		}else if (time1.getTime() > time2.getTime()) {
			start = time1;
			end = time2;
		}
		else {
			start = time1;
			

		}

				
	}
	
	public TripComponent(TripComponent toCopy){
		System.out.println("start2"+start);
		this.start = toCopy.start;
		this.end = toCopy.end;
		System.out.println("start1"+start);
		
	}

	public TripComponent() {
		this.start = new Date();
		this.end = new Date(start.getTime() + 3600000);

		
		
	}

	public long lengthInSeconds() {
		long realLengthSecs = 0;
		if (start != (null)&& end != (null)) {
			long minutesDeparture = start.getTime();//used get time to switch from date to long found by using chat gpt.
			long minutesArrival = end.getTime();
			
			realLengthSecs = (minutesArrival - minutesDeparture)/1000;//i think this is the right conversion pls check ltr
			
		}
		//System.out.println(realLengthSecs);

		return realLengthSecs;
		
		
	}






}
