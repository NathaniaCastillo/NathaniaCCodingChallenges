package basicjava;

public class CCStringsIfAndWhile {

	public static boolean isDigit(char c ) {		

		if(c >= '0' && c <= '9' ){
			return true;
		}
		else 
			return false;
	}

	public static int count(String test, String letters) {
		int testLength = test.length();
		letters = letters.toLowerCase();
		test = test.toLowerCase();
		int counter = 0;
		
		while(testLength >= 1){
			testLength--;
			char currentTestLetter = test.charAt(testLength);
			int numLetters = letters.length();
			while(numLetters >= 1) {
				numLetters--;
				char currentLetter = letters.charAt(numLetters);
				if (currentTestLetter == currentLetter) {
					counter++;
					}
					
				}
		}



		
		return counter;
}



	public static int smallestDigit(int i) {
		int num = 9;
		int smallest = 9;
		if (i == 0) {
			return 0;
		}

		while (i != 0) {
			num = i % 10;
			
			if(num < 0) {
				num = -(num);
			}	
			if(smallest < 0 ) {
				smallest = -(smallest);
			}
			if(num < smallest) {
				smallest = num;
				
			}
			i = i / 10;
		}
		return smallest;

	}


}
