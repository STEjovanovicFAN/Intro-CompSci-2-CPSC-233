import java.util.Scanner;

public class UserInterface {
	private boolean done;
	private Scanner keyboard;
	private Manager manager; 
	
	public UserInterface(){
		done = false;
		keyboard = new Scanner(System.in);
		manager = new Manager();

	}
	
	public void start() {
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
	
	public void displayMenu(){
		//printed to screen
		System.out.println("");
		System.out.println("PROGRAM OPTIONS");
		System.out.println("---------------");
		System.out.println("(a)dd a movie");
		System.out.println("(d)isplay all movies");
		System.out.println("(r)emove a movie");
		System.out.println("(s)earch a movie");
		System.out.println("(q)uit program");
		System.out.print("Make your selection: ");
	}
	
	public void menuResult(char result){
		switch(result){
		//add movie
		case 'a':
		case 'A':
			String movieName;
			String cast1;
			String cast2;
			String cast3;
			String genre;
			int rating;
			
			System.out.print("What is the movie name?");
			movieName = keyboard.nextLine();
			System.out.println("What is the first member of the cast");
			cast1 = keyboard.nextLine();
			System.out.println("What is the second member of the cast");
			cast2 = keyboard.nextLine();
			System.out.println("What is the third member of the cast");
			cast3 = keyboard.nextLine();
			System.out.println("What is the genre of the movie?");
			genre = keyboard.nextLine();
			System.out.println("What is the rating of the movie?");
			rating = keyboard.nextInt();
			while(rating < 0 || rating > 5){
				System.out.println("Not a valid input!");
				System.out.println("Please enter a valid input (0-5): ");
				rating = keyboard.nextInt();
			}
			
			Movie movie = new Movie(movieName);
			
			manager.add(movie);
			break;
			
		//display all movies
		case 'd':
		case 'D':
			
			manager.display();
			break;
		
		//remove a movie
		case 'r':
		case 'R':
			
			manager.remove();
			break;
		
		//search a movie
		case 's':
		case 'S':
			
			manager.search();
			break;	
		
		case 'o':
		case 'O':
			manager.opposite();
		
		//quit the loop in userinterface and end the program
		case 'q':
		case 'Q':
			
			done = true;
			System.out.println("Program ending.");
			break;
		
		}
	}
}