package basicjava;

import java.util.ArrayList;
import java.util.List;

public class RecursionExercises {

	public static int countDigits(int number) {
		
		//termanating condition
		if(number <= 9) return 1;
		number = 1 + countDigits(number/10);
		return number;
	}

	public static int addDigits(int number) {
		
		if(number <= 9) return number;
		int lastNumber = number % 10;
		int addition = lastNumber + addDigits(number/10);
		return addition;
	}

	public static int sum(int sumFrom, int sumTo) {
		//termanating condition
		if(sumFrom <= 0 || sumTo <= 0 ||sumFrom > sumTo) {return 0;
		}else if(sumFrom == sumTo) {
			return sumFrom;
		}else {
		
		return sumFrom + sum(sumFrom + 1, sumTo);
	}}

	public static int sumEvenNumbers(int number) {
		//termanating condition
		if(number%2 != 0 || number <= 0)return 0;
		//recursive call
		return number + sumEvenNumbers(number - 2);		
	}

	public static int countVowels(String word) {
		//termanating condition
		int index = 0;
		int count = 0;
		if(word == null)return 0;
		if (word.length() == index)return 0;
		//recursive
		if(word.charAt(index) == 'a'||word.charAt(index) == 'e'||word.charAt(index) == 'i'
				||word.charAt(index) == 'o'|| word.charAt(index) == 'u'|| word.charAt(index) == 'A'||word.charAt(index) == 'E'||
				word.charAt(index) == 'I'||word.charAt(index) == 'O'||word.charAt(index) == 'U') {
			count = 1 +countVowels(word.substring(1));
		}else {
			count = countVowels(word.substring(1));
		}
		
		return count;
	}

	public static String removeVowels(String word) {
		int index = 0;
		StringBuilder newWord = new StringBuilder();
		if(word == null)return word;
		if (word.length() <= index)return word;
		//recursive
		if(word.charAt(0) == 'a' || word.charAt(0) == 'e'|| word.charAt (0)=='i'||
				 word.charAt(0) == 'o'|| word.charAt(0) == 'u'|| word.charAt(0) == 'A' || word.charAt(0) == 'E'
				|| word.charAt(0) == 'I'|| word.charAt(0) == 'O'|| word.charAt(0) == 'U') { //worked with chat gpt to find the error and it was just a mix of using the wrong boolean
			
			return removeVowels(word.substring(1));
			
			
			
		}else {
			return word.charAt(0) + removeVowels(word.substring(1));
		}
}
	
	public static int sumOfMultiple(ArrayList<Integer> list) {
		int index = 0;
		if(list == null)return 0;
		if(index == list.size())return 0;
		
		int number = list.remove(0);
		int sum = sumOfMultiple(list);
		
		if(number%5 == 0) {
			sum += number;
			
		}
				
		return sum;	
	}

}
