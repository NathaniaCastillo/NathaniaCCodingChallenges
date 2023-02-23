package basicjava;

import java.util.Arrays;

public class CCArrays {
	public static void replace(char[] charArray,char toReplace, char replaceWith  ) {
		int i = 0;
		//System.out.println("1replace" + toReplace);
		//System.out.println("replacer" + replaceWith);
		System.out.println ("this is the length" + charArray.length);
		System.out.println("first batch1:" + i);
		while(i < (charArray.length)) {
			
			System.out.println("first batch2: " + i);
			
			//System.out.println(charArray[0]);
			if (Character.toLowerCase(charArray[i]) == Character.toLowerCase(toReplace)){
				charArray[i] = replaceWith;
					
			}
		i++;
		System.out.println(i);
		}
		
	}
	
	public static void sortAlphabetic(String[] strArray) {
		int i = 0;
		//System.out.println("1replace" + toReplace);
		//System.out.println("replacer" + replaceWith);
		//System.out.println ("this is the length" + strArray.length);
		//System.out.println("first batch1:" + i);
		while(i < (strArray.length)) {
			Arrays.sort(strArray);
			//System.out.println("first batch2: " + i);
			
			//System.out.println(charArray[0]);
			//if (Character.toLowerCase(strArray[i]) == Character.toLowerCase(toReplace)){
				//strArray[i] = replaceWith;
					
			}
		i++;
		//System.out.println(i);
		}
		
	
}
