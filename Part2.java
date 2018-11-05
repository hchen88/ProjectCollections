package classesProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Part2 {
	
	public static void main(String [] args) {
		double start = 0; // start time
		double end = 0; // end time
		double hSetTime, tSetTime;
		HashSet<String> hashSet = new HashSet<String>();
		TreeSet<String> treeSet =  new TreeSet<String>();
		File inFile = new File("alice.txt");
		
		try {
			Scanner in = new Scanner(inFile);
	        while (in.hasNext()) {
	        	start = System.nanoTime();
	            hashSet.add(in.next());
	        }
	        end = System.nanoTime();

	        hSetTime = end - start;
	        
	        System.out.println("HashSet took " + hSetTime + " nanoseconds to input "
	        		+ "every word in alice.txt File");
	        
	        in = new Scanner(inFile);
	        while (in.hasNext()) {
	        	start = System.nanoTime();
	            treeSet.add(in.next());
	        }
	        end = System.nanoTime();
	        
	        tSetTime = end - start;
	        
	        System.out.println("TreeSet took " + tSetTime + " nanoseconds to input "
	        		+ "every word in alice.txt File");
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "File: " + inFile + " does not exist");
		}			
		
		
	}

}
