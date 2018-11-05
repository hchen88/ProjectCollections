package projectCollections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Part1 {

	public static void main(String[] args) {

		File scrabbleFile = new File(args[0]);
		File wordFile = new File(args[1]);
		
		//HashMap Time Test (hash map is faster for searching)
		HashMap<String, Integer> scrabbleHashMap = new HashMap<String, Integer>();
		HashMap<String, Integer> wordHashMap = new HashMap<String, Integer>();
		try {
			Scanner scrabbleIn = new Scanner(scrabbleFile);
			Scanner wordIn = new Scanner(wordFile);
			
			double start1 = System.nanoTime();
			while(scrabbleIn.hasNext()) {
				String character = scrabbleIn.nextLine();
				String point = scrabbleIn.nextLine();
				int pointValue = Integer.parseInt(point);
				scrabbleHashMap.put(character, pointValue);
			}
			double end1 = System.nanoTime();
			double hashLoadTime = end1 - start1;
			System.out.println("HashMap loading data time: " + hashLoadTime + " nanoseconds\n");
			
			double start2 = System.nanoTime();
			while(wordIn.hasNext()) {
				String word = wordIn.nextLine();
				int counter = 0;
				for(int i = 0; i < word.length(); i++) {
					String letter = Character.toString(word.charAt(i));
					counter += scrabbleHashMap.get(letter);
				}
				wordHashMap.put(word, counter);
			}
			System.out.println(wordHashMap);
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
			while(scrabbleIn.hasNext()) {
				String character = scrabbleIn.nextLine();
				String point = scrabbleIn.nextLine();
				int pointValue = Integer.parseInt(point);
				scrabbleTreeMap.put(character, pointValue);
			}
			double end1 = System.nanoTime();
			double treeLoadTime = end1 - start1;
			System.out.println("TreeMap loading data time: " + treeLoadTime + " nanoseconds\n");
			
			double start2 = System.nanoTime();
			while(wordIn.hasNext()) {
				String word = wordIn.nextLine();
				int counter = 0;
				for(int i = 0; i < word.length(); i++) {
					String letter = Character.toString(word.charAt(i));
					counter += scrabbleTreeMap.get(letter);
				}
				wordTreeMap.put(word, counter);
			}
			System.out.println(wordTreeMap);
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
