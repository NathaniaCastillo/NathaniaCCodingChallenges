package oosequence;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Itinerary extends TripComponent{
	private ArrayList<TripComponent> TripComponent;
	private String name;
	
	
	public Itinerary (String name1) {
		name = name1;
		TripComponent = new ArrayList<TripComponent>();
		
	}
	
	public void addTripComponent(TripComponent component) {
		


		if (TripComponent.size() == 0){
			System.out.println("has added 1");
			TripComponent.add(component);

			return;
		}
		System.out.println("Trip component size"+ TripComponent.size());
		for (int i = 0; i < TripComponent.size();i++){
			System.out.println("################Trip component size"+ TripComponent.size());
			if (component.isBefore(TripComponent.get(0))) {  
				System.out.println("has changed original time at position 0");
				TripComponent.add(0,component);
				return;
			}

			
			if (TripComponent.get(i).overlapsWith(component)) {
				System.out.println("theres an overlapping which shall be disregarded");
				return;
				
			
				
				//it is being put in the overlapwith but maybe just needs to be put in a different index
			}	
			if (component.isBefore(TripComponent.get(i))){
				System.out.println("adding at the next point");
				TripComponent.add(i,component);
				return;
			
			}
				}
		 
			TripComponent.add(component);//just know that this will be at the end if all other haven't
			
		
				
}



	public String getName() {
		return name;
	}

	public ArrayList<TripComponent> getTripComponents() {
		// TODO Auto-generated method stub
		return TripComponent;
	}
	 
	public  String toString() {
	
		StringBuilder schedule = new StringBuilder();//with help of chatGPT I was able to learn about stringbuilder
		schedule.append(this.name).append('\n');
		
		for (int i = 0; i < TripComponent.size();i++) {
			TripComponent TripComponents = this.TripComponent.get(i);//getting the index that is called to then be able to use it to find its start and end
				schedule.append(i).append('\t').append(TripComponents.getStart()).append('\t')
				.append(TripComponents.getEnd()).append('\n');
			}
		
		return String.valueOf(schedule);
		
	}
}
