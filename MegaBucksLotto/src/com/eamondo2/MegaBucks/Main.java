package com.eamondo2.MegaBucks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args){
		Util.sendmessage("WELCOME TO MEGABUCKS LOTTO!");
		Util.sendmessage("ENTER 1 TO MANUALLY SELECT YOUR NUMBERS");
		Util.sendmessage("OR PRESS 2 TO HAVE THE COMPUTER SELECT THEM FOR YOU");
		
		
		
		HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> winfreq = new HashMap<Integer, Integer>();
		
		ArrayList<Integer> inputArray = new ArrayList<Integer>();
		ArrayList<Integer> userArray = new ArrayList<Integer>();
		int[] compChoice = new int[7];
		int[] userChoice = new int[6];
		//This loop gets user input, and provides an EasyPick option.
		//It also ensures that the user does not repeat numbers.
		while (true){
			int x = Util.parseInput(scan);
			if (x == 1){
				Util.sendmessage("ENTER YOUR SIX NUMBERS: ");
				for (int i = 0; i < 6; i++){
					int in = Util.parseInput(scan);
					
					while (in > 42){
						Util.sendmessage("ERROR: Cannot enter a number higher than 42. Try Again");
						in = Util.parseInput(scan);
					}
					while (inputArray.contains(in)){
						Util.sendmessage("ERROR: Cannot enter same number twice. Try again.");
						
						in = Util.parseInput(scan);
					}

					inputArray.add(in);
				
					//Util.sendmessage(inputArray[i]);
				}
				int count = 0;
				for (int k : inputArray){
					userChoice[count] = k;
					count ++;
				
				}
				break;
			} else if (x==2){
				userChoice = Util.user_EasyPick();
				Util.sendmessage("THESE ARE YOUR SIX NUMBERS");
				Util.printArray(userChoice);
				Util.sendmessage("\n");
				break;
			}else {
				Util.sendmessage("ERROR: ENTER ONE OR TWO");
			}
			
		}
		//This sets the computer choice to 7 randomly generated numbers.
		compChoice = Util.lotto_7_pick();
		
		Util.printArray(userChoice);
		Util.printArray(compChoice);
		//Adds user's input to a more easily comparable array.
		for (int k : userChoice){
			userArray.add(k);
		}
		
		//This section of the code loops for the 104 days that the numbers are drawn
		int i = 0;
		while (i != 104){
			//Set the computer choice for today
			compChoice = Util.lotto_7_pick();
			
			Util.printEntry(userChoice, compChoice, i + 1);
			//Add up total frequency of numbers
			for (int k : compChoice){
				int g = 0;
				if (freq.containsKey(k)){
					g = freq.get(k);
				}

				freq.put(k, g + 1);
				
			}
			//Find total matches overall
			int match = 0;
			Util.sendmessage("Matching numbers are: " + "\n");
			for (int k : compChoice){
				HashMap<Integer, Integer> tempfreq = new HashMap<Integer, Integer>();
				if (userArray.contains(k)){
					int g = 0;
					if (winfreq.containsKey(k)){
						g = winfreq.get(k);
					}
					winfreq.put(k, g + 1);
					g = 0;
					if (tempfreq.containsKey(k)){
						g = tempfreq.get(k);
					}
					tempfreq.put(k, g + 1);
					match = match + 1;
					Iterator<Entry<Integer, Integer>> it = tempfreq.entrySet().iterator();
					while (it.hasNext()){
						Map.Entry pairs = (Map.Entry)it.next();
						System.out.print(pairs.getKey() + ", " + pairs.getValue() + " time(s)" + "\n" + "\n");
						it.remove(); 
						
					}
				}
				
				
			}
			
			
			
			
			i++;
		}
		
		
		
		
		
		
		
		
		
		return;
	}

}
