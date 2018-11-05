package classesProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Part3 {
	
	public static void main(String [] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		String line;
		double start = 0, end = 0, aTime, lTime;
		File inFile = new File("items.txt");
		try {
			Scanner in = new Scanner(System.in);
			Scanner input = new Scanner(inFile);
			while (input.hasNext()) {
				line = input.nextLine();
				arrayList.add(line);
				linkedList.add(line);
			}
			Iterator<String> itr = arrayList.iterator();
			while (itr.hasNext()){
				start = System.nanoTime();
			    itr.next();
			}
			for (int i = arrayList.size() - 1; i >= 0; i--) {
			    //System.out.println(arrayList.get(i));
				System.out.print("");
			}
			end = System.nanoTime();
			aTime = end - start;
			System.out.println("ArrayList took " + aTime + 
					" nanoseconds to traverse twice");
			
			itr = linkedList.iterator();
			while (itr.hasNext()){
				start = System.nanoTime();
			    itr.next();
			}
			for (int i = linkedList.size() - 1; i >= 0; i--) {
			    System.out.print("");
			}
			end = System.nanoTime();
			lTime = end - start;
			System.out.println("LinkedList took " + lTime + 
					" nanoseconds to traverse twice");
			System.out.println("How many teams will play the game?");
			String answer = in.nextLine().trim();
			int numberOfTeams = Integer.parseInt(answer);
		/**Ask the user how many teams will play the game.
			Create this number of teams. For each team load all of the items 
			from the list. Shuffle the list after loading the items 
			each time. Find the total time it takes to add the items to all of the teams.
			*/
			ArrayList<String> teamList =  new ArrayList<String>();
			
			for ( int i = 0; i < numberOfTeams; i++) {
				teamList.add(arrayList.get(i));
			}
			Collections.shuffle(teamList);
			
			
			//System.currentTimeMillis()
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "File: " + inFile + " does not exist");
		}
		
		
		
		
		
		
	}

}
