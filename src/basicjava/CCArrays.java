package basicjava;

import java.util.Arrays;

public class CCArrays {
	public static void replace(char[] charArray,char toReplace, char replaceWith  ) {
		int i = 0;
		//System.out.println("1replace" + toReplace);
		//System.out.println("replacer" + replaceWith);
		//System.out.println ("this is the length" + charArray.length);
		//System.out.println("first batch1:" + i);
		while(i < (charArray.length)) {
			
			//System.out.println("first batch2: " + i);
			
			//System.out.println(charArray[0]);
			if (Character.toLowerCase(charArray[i]) == Character.toLowerCase(toReplace)){
				charArray[i] = replaceWith;
					
			}
		i++;
		//System.out.println(i);
		}
		
	}
	
	public static void sortAlphabetic(String[] strArray) {
		Arrays.sort(strArray,String.CASE_INSENSITIVE_ORDER);//with this code found on a website i can use it to ignore if it is uppercase or lower case

	}}
		
	
