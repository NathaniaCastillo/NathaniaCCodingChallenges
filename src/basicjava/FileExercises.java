package basicjava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class FileExercises {

	public static int counting(String word) throws FileNotFoundException, IOException{
		int counter = 0;
		System.out.println("++++"+word);
		BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
		String line;
		while((line = reader.readLine()) != null) {
			String[] words = line.split(" ");
			for(int i = 0; i < words.length; i++) {
				String wordIndex = words[i];
				if(wordIndex.equalsIgnoreCase(word)) {
					counter++;
				}
		}
		
		}
		
		
		return counter;
	}

	public void toUpper(String iFName, String oFName) throws FileNotFoundException, IOException {
		
		
	}

}
