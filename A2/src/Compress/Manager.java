import java.util.Random;

public class Manager {
	private double [] storage; 
	private int numberOfGrades;
	
	
	public Manager(){
		//sets the array to 40 
		storage = new double[40];
		/*storage at place 0 is -1, methods besides "setGrades" and "randomGrades" will check to see if it is not null
		  if it is null then they will say that the list is empty*/
		storage[0] = -1;
	}
	
	public void average(){
		if (storage[0] != -1.0){
			double average = 0.0;
			int counter = 0;
			//loop will take all the averages and add them all up together 
			for(counter = 0 ; counter < numberOfGrades; counter++ ){
				average = average + storage [counter];
				
			}
			//variable "convertAverage" will then divide the average by how many averages it has, and round 
			double convertAverage = Math.round((average / counter) * 10) / 10.0;
			System.out.println("Average grade: " + convertAverage); 
		}
		
		else
			System.out.println("Empty list"); 

	}
	
	public void displayList(){
		//title display
		System.out.println("DISPLAYING GRADES");
		System.out.println("-----------------");
		
		//loop will go though the array and print the values stored in the array (fixed formating for >9)
		if(storage[0] != -1){
			for (int counter = 0 ; counter < numberOfGrades ; counter++){
				int counter2 = counter +1;
				System.out.printf("%11s","Grade #" + counter2 +": ");
				System.out.print("     ");
				System.out.println(storage[counter]);
			}
		}
		
		else
			System.out.println("Empty class: No grades to show");
		
	}	
	
	public void displayHighest(){	
		//create highestGrade as the lowest value so that we know for sure that the method will find the highest value
		double highestGrade = 0.0;
		
		if(storage[0] != -1){
			for(int counter = 0 ; counter < numberOfGrades ; counter++){
				/*compare the value at some position in the array to the highestGrade, if greater (array value) 
				then replace highestGrade with the new value*/
				if(storage[counter] > highestGrade){
					highestGrade = storage[counter];
				}

			}
			
			System.out.println("Highest grade: " + highestGrade);
		}

		else{
			System.out.println("Empty list");
		}
	}
	
	public void displayLowest(){
		//create lowestGrade as the highest value so that we know for sure that the method will find the lowest value
		double lowestGrade = 4.0;
	
		if(storage[0] != -1){
			for(int counter = 0 ; counter < numberOfGrades ; counter++){
				/*compare the value at some position in the array to the lowestGrade, if lower (array value) 
				then replace lowestGrade with the new value*/
				if(storage[counter] < lowestGrade){
					lowestGrade = storage[counter];
				}
			}
			
			System.out.println("Lowest grade: " + lowestGrade);
		}

		else{
			System.out.println("Empty list");
		}
		
	}
	
	public void randomGrades(){
		Random roll = new Random();
		double dice = 0.0;
		numberOfGrades = 40;
		for(int counter = 0 ; counter < numberOfGrades ; counter++ ){
			//roll dice between values 0-4
			int tempVar = roll.nextInt(5);
			//convert the int to double (to get an example: 3.0) 
			dice = tempVar;
			
			//set the dice roll value in the array
			storage[counter] = dice;
			
		}
	}
	
	public void setGrades(){
		final int DEFAULT = 10;
		
		for(int counter = 0 ; counter < DEFAULT; counter++){
			//set 2.0 for every # of grades (10)
			storage[counter] = 2.0;
			
		}
		numberOfGrades = DEFAULT;
		System.out.println("Fixed values given for the first 10 entires");
		
	}
	
	public boolean quit(){
		//display message to visually see that the program is done
		System.out.println("");
		System.out.println("Have a nice day!");
		return true;	
	}

}
