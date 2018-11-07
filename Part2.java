package classesProject;
/**	
 * Scott Arima and Howard Chen
 * 08 October 2018
 * Purpose of the program- Simulate Vending Machine with capabilities making transactions, 
 * 						   re-stocking products, withdrawing funds.  
 * Inputs: selections from vending menu
 * Output: Game Log - Displays vending actions, insufficient funds/stock.
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
		double setTime;
		Set set = null;
		
		if(args[0].equals("Tree")) {
			set = new TreeSet<String>();
		} else {
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

	        setTime = end - start;
	        
	        System.out.println(args[0] +"Set took " + setTime + " nanoseconds to input "
	        		+ "every word in alice.txt File");
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "File: " + inFile + " does not exist");
		}			
		
		
	}

}
