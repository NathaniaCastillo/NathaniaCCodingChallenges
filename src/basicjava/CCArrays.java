package basicjava;

import java.util.Arrays;

public class CCArrays {
	public static void replace(char[] charArray,char toReplace, char replaceWith  ) {
		int i = 0;

		while(i < (charArray.length)) {
			

			if (Character.toLowerCase(charArray[i]) == Character.toLowerCase(toReplace)){
				charArray[i] = replaceWith;
					
			}
		i++;
		
		}}
	
	public static void sortAlphabetic(String[] strArray) {
		Arrays.sort(strArray,String.CASE_INSENSITIVE_ORDER);//with this code found on a website i can use it to ignore if it is uppercase or lower case

	}}
		
	
