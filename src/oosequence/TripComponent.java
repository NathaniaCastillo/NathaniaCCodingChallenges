/* Nathania castillo
 * UCID:30152619
 */
package oosequence;

import java.util.Date;


public class TripComponent{
	
	private Date start;
	private Date end;
	
//changed get start method to a string
	public String getStart() {
		{if (start == null) {			
			return "";
		}else 
			
		return String.valueOf(start);
		
	}
	}
//changed to string as well
	public String getEnd(){
		if (end == null) {
			return "";
		}else {

		return String.valueOf(end);
	}}
	
	
	public void setStart(Date currentTime) {
		

		if (currentTime == null ||end == null) {//if current time is null or end is null ; start is current Time
			start = currentTime;
		
		}else if (currentTime.before(end)){
			start = currentTime;
		}
		
		
		
	}

	public void setEnd(Date oneHourLaterTime) {
		
		if (oneHourLaterTime == null || start == null){
			end = oneHourLaterTime;

		}else if (oneHourLaterTime.after(start)) {//change
			end = oneHourLaterTime;
		}
		
	}

	public void setArrival(Date realArrival) {//setting only arrival date
		
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
			start = realDeparture;;//
		}
		else if(realDeparture.before(end)) {
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
		
		this.start = toCopy.start;
		this.end = toCopy.end;
		
		
	}

	public TripComponent() {
		this.start = new Date();
		this.end = new Date(start.getTime() + 3600000);

		
		
	}
	//CHANGED TO PROTECTED

	protected long lengthInSeconds() {
		long realLengthSecs = 0;
		if (start != (null)&& end != (null)) {
			long minutesDeparture = start.getTime();//used get time to switch from date to long found by using chat gpt.
			long minutesArrival = end.getTime();
			
			realLengthSecs = (minutesArrival - minutesDeparture)/1000;//i think this is the right conversion pls check ltr
			
		}
		return realLengthSecs;
		
		
	}
	
	//ADDED TWO METHODS
	public boolean isBefore(TripComponent otherC) {

		if(this.end.getTime() < otherC.start.getTime()) {return true;}

		return false;
	}


	public boolean overlapsWith(TripComponent otherC) {
		if( !(start==null) && !(end==null) && !(otherC.start==null) && !(otherC.end==null)) {

		return !(this.isBefore(otherC) || otherC.isBefore(this));



		}
		return false;
	}
/*
	public boolean overlapsWith(TripComponent otherC) {

		if( !(start==null) && !(end==null) && !(otherC.start==null) && !(otherC.end==null)) {

			return !(this.isBefore(otherC));

		}

		return false;



	}

*/

}
