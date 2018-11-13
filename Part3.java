package projectCollections;
import java.awt.List;
/**	
 * Scott Arima and Howard Chen
 * 05 November 2018
 * Purpose of the program- Analyze different the
 *  efficiency of different Collection TYpoes
 * Inputs: item text file, user input for number 
 * of teams in scavenger hunt 
 * Output: 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;



public class Part3 {
	
	public static void main(String [] args) {
		
		String line;
		double start = 0, end = 0, aTime, lTime;
		File inFile = new File("items.txt");
//		List list = null;	
//		if(args[0].equals("ArrayList")) {
//			list = new ArrayList<String>();
//		} else if (args[0].equals("ArrayList")) {
//			list = new LinkedList<String>();
//		}
		
		ArrayList<String>list = new ArrayList<String>();
		//LinkedList<String>list = new LinkedList<String>();
		
		try {
			Scanner in = new Scanner(System.in);
			Scanner input = new Scanner(inFile);
			while (input.hasNext()) {
				line = input.nextLine();
				list.add(line);				
			}
			Iterator<String> itr = list.iterator();
			while (itr.hasNext()){
				start = System.nanoTime();
			    itr.next();
			}
			for (int i = list.size() - 1; i >= 0; i--) {
			    //System.out.println(arrayList.get(i));
				System.out.print("");
			}
			end = System.nanoTime();
			aTime = end - start;
			System.out.println("ArrayList took " + aTime + 
					" nanoseconds to traverse twice");
			
			itr = list.iterator();
			while (itr.hasNext()){
				start = System.nanoTime();
			    itr.next();
			}
			for (int i = list.size() - 1; i >= 0; i--) {
			    System.out.print("");
			}
			end = System.nanoTime();
			lTime = end - start;
			System.out.println("LinkedList took " + lTime + 
					" nanoseconds to traverse twice");
			System.out.println("How many teams will play the game?");
			String answer = in.nextLine().trim();
			int numberOfTeams = Integer.parseInt(answer);
			

			start = 0;
			end = 0;
			double teamTime;
			
			ArrayList<String>[] teams = new ArrayList[numberOfTeams];
			//LinkedList<String>[] teams = new LinkedList[numberOfTeams];

			
			//Loading List time
			start = System.nanoTime();
			for(int i = 0; i < numberOfTeams ; i++) { 
					teams[i] = list; 
					Collections.shuffle(teams[i]);
			}
			end = System.nanoTime();	
			teamTime = end - start;
			System.out.println("It takes " + teamTime + 
					" nanoseconds to add/shuffle 100 items into " + numberOfTeams 
					+ " team lists\n");
			
			//Retrieving an element time
			System.out.print("Enter in a position in the list for retrieving "
					+ "and inserting elements: ");
			answer = in.nextLine().trim();
			int position = Integer.parseInt(answer);
			
			start = System.nanoTime();
			for(int i = 0; i < teams.length ; i++) {
				teams[i].get(position);
			}
			end = System.nanoTime();	
			teamTime = end - start;
			System.out.println("\nIt takes " + teamTime + 
					" nanoseconds to retieve an item at position " + position + 
					" from " + numberOfTeams 
					+ " team lists");
			
			// inserting an element at position in each of the lists
			start = System.nanoTime();
			for(int i = 0; i < teams.length ; i++) {
				teams[i].add(position, "Spray bottle");
			}
			end = System.nanoTime();	
			teamTime = end - start;
			System.out.println("\nIt takes " + teamTime + 
					" nanoseconds to add an item at position "  + position
					+ numberOfTeams + " team lists");
			
			Random rand = new Random();
			position = rand.nextInt(100) + 0; 
			
			//Retrieving an random element time
			start = System.nanoTime();
			for(int i = 0; i < teams.length ; i++) {
				teams[i].get(position);
			}
			end = System.nanoTime();	
			teamTime = end - start;
			System.out.println("\nIt takes " + teamTime + 
					" nanoseconds to retieve a random item at position " + position + 
					" from " + numberOfTeams 
					+ " team lists");
			

			//System.nanoTime()
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "File: " + inFile + " does not exist");
		}
		
		
		
		
		
		
	}

}
