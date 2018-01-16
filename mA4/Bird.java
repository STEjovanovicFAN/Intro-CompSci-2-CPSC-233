/*
 * Name: Stefan Jovanovic
 * Student ID #: 10135783
 * Version: 1 (because I'm awesome and did it in one go)
 */

public class Bird extends Animal{
	private int range;
	
	public Bird(){
		range = 400;
		
	}

	public void walk(){
		System.out.println("Errh mai gewrd, I'm walking!");
		//reduce energy 3 times 
		reduceEnergy();
		reduceEnergy();
		reduceEnergy();
		
	}
	
	public void fly(){
		//formating
		System.out.println("");
		System.out.println("Oh shit, I'm flying! Jesus take my wings!");
		//reduce energy 2 times 
		reduceEnergy();
		reduceEnergy();
		
	}
	
	public String toString(){
		//make string and add on to the string
		String s = "";
		s = super.toString() + "Range: " + range;
		return (s);
		
	}
}
