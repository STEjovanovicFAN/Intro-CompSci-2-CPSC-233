/*
 * Name: Stefan Jovanovic
 * Student ID #: 10135783
 */

import java.util.Scanner;

public class Exponents {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		//get base
		System.out.print("Please enter in a base: ");
		int base = keyboard.nextInt();
		
		//get power
		System.out.print("Please enter in a power: ");
		int power = keyboard.nextInt();
		
		//answer that will be shown on screen 
		long onScreenAns = 1;
		
		//branching to determine if the power is 0 or not
		if(power == 0){
			onScreenAns = 1;
			
		}
		else{
			//create loop to find answer by multiplying the power-1 times
			for(int counter = 0 ; counter < power ; counter++ )
			{
				onScreenAns = onScreenAns * base;
				
			}
		}
		//show output
		System.out.println("The answer is: "+ onScreenAns);
	}
	
}
