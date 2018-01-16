/*
 * Name: Stefan Jovanovic
 * Student ID #: 10135783
 */

public class Driver {
	public static void main(String[] args){
		
		//create object hero of class Adventurer
		Adventurer hero;
		hero = new Adventurer();
		
		//using accessor method in class adventurer to get name and health
		System.out.println("Name = " + hero.getName());
		System.out.println("Health = " + hero.getHealth());
		
		//using mutator methods set name and health to different values
		hero.setName("Balin");
		hero.setHealth(10);
		
		hero.gainLevel();
		
		////using accessor method in class adventurer to get updated name and health
		System.out.println("Name = " + hero.getName());
		System.out.println("Health = " + hero.getHealth());
		
		
	}

}
