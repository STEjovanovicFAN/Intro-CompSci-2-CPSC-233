import java.util.Scanner;

public class World {
	
	private char [][] worldArray;
	private int trackRow = 1;
	private int trackCol = 1;
	
	public World(){
		worldArray = new char[5][5];
		//create object and pass ' ' (space) as null by using overload constructor
		Entity entity = new Entity(' ');
		
		//x and y are coordinates of the array 
		int x = 0;
		int y = 0;

		//set entire array to null (empty space)
		for(x = 0 ; x < 5 ; x++){
			
			for(y = 0 ; y < 5 ; y++){
				worldArray [x][y] = entity.getAppearance();
			
			}
		}
		//set [1][1] coordinates to "X" by using default constructor 
		Entity anotherEntity = new Entity();
		worldArray [1][1] = anotherEntity.getAppearance(); 
	}
	
	public void start(){
		
		int infinte = -1;
		final int ARRAYROWS = 5;
		final int ARRAYCOLS = 5;
		
		int userInputRow = 0;
		int userInputCol = 0; 
		Scanner keyboard = new Scanner(System.in);

		//start the infinite loop
		for(int i = 0 ; i > infinte ; i++){
			int xCoord = 0;
			
			//made simpler to read the columns (v3)
			System.out.println();
			System.out.println(" Columns");
			System.out.println(" 1 2 3 4 5");
			//go though the array and print each element in it  
			for(int s = 0 ; s < ARRAYROWS ; s++){
				System.out.println(" - - - - -");
				
				int yCoord = 0;
				for(int z = 0 ; z < ARRAYCOLS ; z++){
					System.out.print("|");
					System.out.print(worldArray[xCoord][yCoord]);
					//update yCoord
					yCoord++;

				}
				//made simpler to read the rows (v3)
				System.out.print("|");
				if(xCoord +1 != 3){
					System.out.println(" " + (xCoord +1));
				}
				
				if(xCoord +1 == 3){
					System.out.println(" " + (xCoord +1) + " Rows");
				}
				
				//update xCoord
				xCoord++;
			}
			System.out.println(" - - - - - ");
			System.out.println();
			
			//get input for next coordinates 
			System.out.print("Destination row (1-5): ");
			userInputRow = keyboard.nextInt();
			System.out.print("Destination column (1-5): ");
			userInputCol = keyboard.nextInt();
			
			//convert user input by -1 to be able to put it in the array without problems 
			userInputRow = userInputRow -1;
			userInputCol = userInputCol -1;
			
			//check if row or column are negative, break the loop and end the program
			if(userInputRow < 0 || userInputCol < 0){
				System.out.println("Row/Column: " + userInputRow + "/" + userInputCol + " outside world");
				System.out.println("End simulation");
				break;
			}
			
			//check if row or column are > 5, if so then prompt that they are outside world and keep "X" on the same spot
			if(userInputRow >= 5 || userInputCol >= 5){
				System.out.println("Row/Column: " + (userInputRow +1) + "/" + (userInputCol + 1) + " outside world");
			}
			
			//otherwise if the 2 above conditions are false then change location and track it 
			else{
				//make the user input have the X in it 
				worldArray[userInputRow][userInputCol] = worldArray[trackRow][trackCol];
				
				//make previous space X was in to null 
				Entity entity = new Entity(' ');
				worldArray[trackRow][trackCol] = entity.getAppearance(); 
				
				//track new location
				trackRow = userInputRow;
				trackCol = userInputCol;
				
			}
		}
		//close scanner keyboard
		keyboard.close();
		
	}
}	
