package projectCollections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * 
 * Scott Arima & Howard Chen
 * November 5, 2018
 * Purpose of program: analyze Hashmaps and Treemaps on efficiency for loading data and searching data
 * Inputs: text file names through the command line arguments
 * Outputs: loading data and searching data times in nanoseconds for Hashmaps and Treemaps
 *
 */
public class Part1 {

	public static void main(String[] args) {

		//ScrabblePoints.txt QWords.txt
		File scrabbleFile = new File("ScrabblePoints.txt");
		File wordFile = new File("QWords.txt");
		
		Map<String, Integer> scrabbleMap = null;
		Map<String, Integer> wordMap = null;
		
		if(args[0].equals("HashMap")) {
			scrabbleMap = new HashMap<String, Integer>();
			wordMap = new HashMap<String, Integer>();
		}
		else if(args[0].equals("TreeMap")) {
			scrabbleMap = new TreeMap<String, Integer>();
			wordMap = new TreeMap<String, Integer>();
		}
		
		//Time Test (hash map is faster for searching) (tree map is faster for loading)
		try {
			Scanner scrabbleIn = new Scanner(scrabbleFile);
			Scanner wordIn = new Scanner(wordFile);
			
			double start1 = System.nanoTime();
			while(scrabbleIn.hasNext()) { //creates the map for the scrabble points
				String character = scrabbleIn.nextLine();
				String point = scrabbleIn.nextLine();
				int pointValue = Integer.parseInt(point);
				scrabbleMap.put(character, pointValue);
			}
			double end1 = System.nanoTime();
			double hashLoadTime = end1 - start1;
			System.out.println(args[0] + " loading data time: " + hashLoadTime + " nanoseconds\n");
			
			double start2 = System.nanoTime();
			while(wordIn.hasNext()) { //creates the map for Q words with point values
				String word = wordIn.nextLine();
				int counter = 0;
				for(int i = 0; i < word.length(); i++) {
					String letter = Character.toString(word.charAt(i));
					counter += scrabbleMap.get(letter); //keeps track of the point value for the Q word
				}
				wordMap.put(word, counter);
			}
			System.out.println(wordMap); //prints out the full map of the words
			double end2 = System.nanoTime();
			double hashSearchTime = end2 - start2;
			System.out.println(args[0] + " searching data time: " + hashSearchTime + " nanoseconds\n");
			scrabbleIn.close();
			wordIn.close();
		} catch(FileNotFoundException exception) {
			System.out.println("File does not exist.");
		}
	}
}
