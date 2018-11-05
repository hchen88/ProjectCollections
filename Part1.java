package projectCollections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
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
		File scrabbleFile = new File(args[0]);
		File wordFile = new File(args[1]);
		
		//HashMap Time Test (hash map is faster for searching)
		HashMap<String, Integer> scrabbleHashMap = new HashMap<String, Integer>();
		HashMap<String, Integer> wordHashMap = new HashMap<String, Integer>();
		try {
			Scanner scrabbleIn = new Scanner(scrabbleFile);
			Scanner wordIn = new Scanner(wordFile);
			
			double start1 = System.nanoTime();
			while(scrabbleIn.hasNext()) { //creates the hashmap for the scrabble points
				String character = scrabbleIn.nextLine();
				String point = scrabbleIn.nextLine();
				int pointValue = Integer.parseInt(point);
				scrabbleHashMap.put(character, pointValue);
			}
			double end1 = System.nanoTime();
			double hashLoadTime = end1 - start1;
			System.out.println("HashMap loading data time: " + hashLoadTime + " nanoseconds\n");
			
			double start2 = System.nanoTime();
			while(wordIn.hasNext()) { //creates the hashmap for Q words with point values
				String word = wordIn.nextLine();
				int counter = 0;
				for(int i = 0; i < word.length(); i++) {
					String letter = Character.toString(word.charAt(i));
					counter += scrabbleHashMap.get(letter); //keeps track of the point value for the Q word
				}
				wordHashMap.put(word, counter);
			}
			System.out.println(wordHashMap); //prints out the full hashmap of the words
			double end2 = System.nanoTime();
			double hashSearchTime = end2 - start2;
			System.out.println("HashMap searching data time: " + hashSearchTime + " nanoseconds\n");
			scrabbleIn.close();
			wordIn.close();
		} catch(FileNotFoundException exception) {
			System.out.println("File does not exist.");
		}
		
		//TreeMap Time Test (tree map is faster for loading)
		TreeMap<String, Integer> scrabbleTreeMap = new TreeMap<String, Integer>();
		TreeMap<String, Integer> wordTreeMap = new TreeMap<String, Integer>();
		try {
			Scanner scrabbleIn = new Scanner(scrabbleFile);
			Scanner wordIn = new Scanner(wordFile);
			
			double start1 = System.nanoTime();
			while(scrabbleIn.hasNext()) { //creates the treemap for the scrabble points
				String character = scrabbleIn.nextLine();
				String point = scrabbleIn.nextLine();
				int pointValue = Integer.parseInt(point);
				scrabbleTreeMap.put(character, pointValue);
			}
			double end1 = System.nanoTime();
			double treeLoadTime = end1 - start1;
			System.out.println("TreeMap loading data time: " + treeLoadTime + " nanoseconds\n");
			
			double start2 = System.nanoTime();
			while(wordIn.hasNext()) { //creates the treemap for Q words with point values
				String word = wordIn.nextLine();
				int counter = 0;
				for(int i = 0; i < word.length(); i++) {
					String letter = Character.toString(word.charAt(i));
					counter += scrabbleTreeMap.get(letter); //keeps track of the point value for the Q word
				}
				wordTreeMap.put(word, counter);
			}
			System.out.println(wordTreeMap); //prints out the full treemap of the words
			double end2 = System.nanoTime();
			double treeSearchTime = end2 - start2;
			System.out.println("TreeMap searching data time: " + treeSearchTime + " nanoseconds\n");
			scrabbleIn.close();
			wordIn.close();
		} catch(FileNotFoundException exception) {
			System.out.println("File does not exist.");
		}
	}
}
