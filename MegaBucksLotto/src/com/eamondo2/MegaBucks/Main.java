package com.eamondo2.MegaBucks;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args){
		Util.sendmessage("WELCOME TO MEGABUCKS LOTTO!");
		Util.sendmessage("ENTER YOUR SIX NUMBERS: ");
		ArrayList<Integer> inputArray = new ArrayList<Integer>();
		int[] compChoice = new int[7];
		int[] userChoice = new int[6];
		
		for (int i = 0; i < 6; i++){
			int in = Util.parseInput(scan);
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
			
		
		compChoice = Util.lotto_7_pick();
		Util.printArray(userChoice);
		Util.printArray(compChoice);
		
		
		
		
		
		
		
		
		return;
	}

}
