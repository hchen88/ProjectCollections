package projectCollections;
/**
 * 
 * Scott Arima & Howard Chen
 * November 5, 2018
 * Purpose of program: analyze ArrayList and LinkedList on efficiency for loading data and searching data
 * Inputs: text file names through the command line arguments
 * Outputs: loading data and searching data times in nanoseconds for ArrayList and LinkedList
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Part3  {

	
	public static void main(String [] args) {
		   	
		   
			String line;
			double start = 0, end = 0, lTime;
			File inFile = new File("items.txt");
			List<String> list = null;
			if(args[0].equals("ArrayList")) {
				list = new ArrayList<String>();
			} else if (args[0].equals("LinkedList")) {
				list = new LinkedList<String>();
			}
			
			
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
				lTime = end - start;

				System.out.println(args[0] +" took " + lTime + 
						" nanoseconds to traverse twice");
				
				System.out.println("How many teams will play the game?");
				String answer = in.nextLine().trim();
				int numberOfTeams = Integer.parseInt(answer);
				

				start = 0;
				end = 0;
				double teamTime;
				List[] teams = new List[numberOfTeams];
				
				if(args[0].equals("ArrayList")) {
					teams = new ArrayList[numberOfTeams];
				} else if (args[0].equals("LinkedList")) {
					teams = new LinkedList[numberOfTeams];
				}
				

				//Loading List time
				start = System.nanoTime();
				for(int i = 0; i < numberOfTeams ; i++) { 
						teams[i] = list; 
						Collections.shuffle(teams[i]);
				}
				
				end = System.nanoTime();	
				teamTime = end - start;
				System.out.println("It took " + teamTime + 
						" nanoseconds to add/shuffle 100 items");
				
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
				System.out.println("\nIt took " + teamTime + 
						" nanoseconds to retrieve  an item at position " + position);
				
				// inserting an element at position in each of the lists
				start = System.nanoTime();
				for(int i = 0; i < teams.length ; i++) {
					teams[i].add(position, "Spray bottle");
				}
				end = System.nanoTime();	
				teamTime = end - start;
				System.out.println("\nIt took " + teamTime + 
						" nanoseconds to add an item at position "  + position);
				
				Random rand = new Random();
				position = rand.nextInt(100) + 0; 
				
				//Retrieving an random element time
				start = System.nanoTime();
				for(int i = 0; i < teams.length ; i++) {
					teams[i].get(position);
				}
				end = System.nanoTime();	
				teamTime = end - start;
				System.out.println("\nIt took " + teamTime + 
						" nanoseconds to retrieve  a random item at position " + position);
				

				//System.nanoTime()
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println( "File: " + inFile + " does not exist");
			}

		}

		     
}
