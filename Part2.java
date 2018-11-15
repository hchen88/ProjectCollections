package projectCollections;

/**
 * 
 * Scott Arima & Howard Chen
 * November 5, 2018
 * Purpose of program: analyze HashSet and TreeSet on efficiency for loading data and searching data
 * Inputs: text file names through the command line arguments
 * Outputs: loading data and searching data times in nanoseconds for HashSet and TreeSet
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Part2 {
	
	public static void main(String [] args) {
		double start = 0; // start time
		double end = 0; // end time
		double addTime, searchTime;
		Set set = null;
		
		if(args[0].equals("TreeSet")) {
			set = new TreeSet<String>();
		} else if(args[0].equals("HashSet")) {
			set = new HashSet<String>();
		}
		
		File inFile = new File("alice.txt");
		
		try {
			Scanner in = new Scanner(inFile);
	        while (in.hasNext()) {
	        	start = System.nanoTime();
	            set.add(in.next());
	        }
	        end = System.nanoTime();

	        addTime = end - start;
	        
	        System.out.println(args[0] +" took " + addTime + " nanoseconds to input "
	        		+ "every word in alice.txt File");
	        
	        //search time
	        start = System.nanoTime();
	        for( int i = 0; i < 100; i++) {
	        	set.contains("remove");
	        }
	        end = System.nanoTime();
	        searchTime = end - start;
	        
	        System.out.println(args[0] +" took " + searchTime + 
	        		" nanoseconds to search  for \"remove\" 100 times "
	        		+ "every word in alice.txt File");
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "File: " + inFile + " does not exist");
		}			
		
		
	}

}
