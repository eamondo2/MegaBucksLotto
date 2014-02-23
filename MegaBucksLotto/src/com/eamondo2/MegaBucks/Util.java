package com.eamondo2.MegaBucks;

import java.util.ArrayList;
import java.util.Scanner;

public class Util {
	//Sketching out random # generator
	//generates a random number under 42.
	public static int rand_lotto_pick(){

		
		int[] num_array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42};
		int picker = (int) (Math.random()*100 % 42);
		
		//System.out.println(picker);
		
		int last = 0;
		for (int k = 0; k <=picker; k++){

			last = num_array[k];
				
		}
		return last + 1;

	}
	//Merely a more convenient method of outputting data than System.out.println();
	public static void sendmessage(Object input){
		input = input.toString();
		System.out.print((String)input);
		System.out.print(" " + "\n");
		
		
		
		
	}
	//Again, a shortcut to read the next integer.
	public static int parseInput(Scanner scan){
		System.out.print("\n" + "> ");
		int testInt = scan.nextInt();

		
		
		
		
		
		
		
		
		return testInt;
	}
	//The meat of the Util class, this generates 7 numbers, none of which repeat, from one to 42.
	
	public static int[] lotto_7_pick(){
		int[] result = new int[7];
		ArrayList<Integer> temp_Storage = new ArrayList<Integer>();
		int c = 0;
		while (c < 7){
			
			int test = rand_lotto_pick();
			while (temp_Storage.contains(test)){
				//sendmessage(test);
				test = rand_lotto_pick();
			}
			temp_Storage.add(test);
			
			
			c++;
		}
		c = 0;
		for (int k : temp_Storage){
			//sendmessage(k);
			result[c] = k;
			
			c++;
		}
		
		
		
		
		
		
		
		
		
		return result;
	}
	
	public static void printArray(int[] k){
		for (int x : k){
			sendmessage(x);
		}
		
		
		
	}

}
