import java.util.Scanner;

public class UserInterface {
	private Scanner keyboard;
	private boolean done;
	private Manager manager; 
	
	public UserInterface(){
		//create an object scanner
		keyboard = new Scanner(System.in);
		//create object manager 
		manager = new Manager();
		done = false;
	}

	public void displayMenu(){
		//printed to screen
		System.out.println("");
		System.out.println("PROGRAM OPTIONS");
		System.out.println("---------------");
		System.out.println("(a)verage grade");
		System.out.println("(d)isplay all grades");
		System.out.println("(h)ighest grade");
		System.out.println("(l)owest grade");
		System.out.println("(r)andom grades");
		System.out.println("(s)et fixed grades");
		System.out.println("(q)uit program");
		System.out.print("Make your selection: ");

	}
	
	public void menuResult(char result){
		switch(result){
			//show average
			case 'a':
			case 'A':
				
				manager.average();
				break;
				
			//display array contents
			case 'd':
			case 'D':
				
				manager.displayList();
				break;
			
			//show highest grade
			case 'h':
			case 'H':
				
				manager.displayHighest();
				break;
			
			//show lowest grade	
			case 'l':
			case 'L':
				
				manager.displayLowest();
				break;
			
			//create 40 random grades and store in an array	
			case 'r':
			case 'R':
				
				manager.randomGrades();
				break;
			
			//create 10 same "2.0" grades and store it in an array	
			case 's':
			case 'S':
				
				manager.setGrades();
				break;	
			
			//quit the loop	
			case 'q':
			case 'Q':
				
				done = manager.quit();
				break;
				
		}
		
	}

	public void start(){
		final int FIRSTCHARACTER = 0;
		String input = null;
		char result = ' ';		
		
		//loop repeats till user wants to quit
		while (done == false){
			//display choices
			displayMenu();
			
			//get input
			input = keyboard.nextLine();
			//get first letter from word
			result = input.charAt(FIRSTCHARACTER);
			
			//use switch function to determine  what to do 
			menuResult(result);
			
		}

	}

}
