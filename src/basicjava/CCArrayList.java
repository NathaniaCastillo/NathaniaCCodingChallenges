package basicjava;

import java.util.ArrayList;
import java.util.Arrays;

public class CCArrayList {
	
	public static int indexOfIgnoreCase(ArrayList<String> strs,String toFind) {
		//Arrays.sort(strs,String.CASE_INSENSITIVE_ORDER);
		for(int num = 0; num < strs.size(); num++) {
			String str = strs.get(num);
			if(str.equalsIgnoreCase(toFind)){
				return num;
			}
				
			
		}
		
		
		return -1;
}

//used wrapper class Double for ArrayList since a Double cannot be used as a type of argument for generics
	public static void insert(ArrayList<Double>nums,double numToInsert, int insertAtIndex) {
		

	}
	}

