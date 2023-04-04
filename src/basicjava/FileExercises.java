package basicjava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class FileExercises {

	public static int counting(String word) throws FileNotFoundException, IOException{
		int counter = 0;
		BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
		String line;  
		while((line = reader.readLine()) != null) {
			String[] words = line.split(" ");
			for(int i = 0; i < words.length; i++) {
				String wordIndex = words[i];//was doing this part wrong and chta gpt showed me how to do it in a different way
				if(wordIndex.equalsIgnoreCase(word)) {
					counter++;
				}
		}
		
		}
		
		
		return counter;
	}

	public void toUpper(String iFName, String oFName) throws IOException {
		try (
		BufferedReader reader = new BufferedReader(new FileReader(iFName));//took ths try method from chat gpt
		BufferedWriter writer = new BufferedWriter(new FileWriter(oFName));
		){
		String line;
		while((line = reader.readLine())!= null) {
			writer.write(line.toUpperCase());
			writer.newLine();
		}
		
	}

}
}
