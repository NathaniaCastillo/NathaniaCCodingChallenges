package basicjava;

import java.util.ArrayList;



public class CCArrayList {
	
	public static int indexOfIgnoreCase(ArrayList<String> strs,String toFind) {
		
		for(int num = 0; num < strs.size(); num++) {
			String str = strs.get(num);//new .get() is used to find the certain string in array 
			if(str.equalsIgnoreCase(toFind)){//new method here ignore if it is upper case or lower case for string, learnt in chat gpt
				return num;
			}
			
			
		}
		
		
		return -1;
}

//used wrapper class Double for ArrayList since a Double cannot be used as a type of argument for generics
	public static void insert(ArrayList<Double>nums,double numToInsert, int insertAtIndex) {
		if(nums.size() > 0) {
			nums.add(insertAtIndex,numToInsert);//adding the place where it wants to be added
			System.out.println(nums);
		}
	}}
		


