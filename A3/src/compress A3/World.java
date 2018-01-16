import java.util.Scanner;
import java.util.Random;

/*
  Author:  James Tam
  Version: October 12, 2015

  Features implemented:
  * Reads start positions from the file "data.txt" 
  * (Input file must be in the curent working directory).
  * Array is initialized based on these starting positions and
    world is displayed once.

  To-do:
  * All other program requirements specified in the assignment
    description.
*/

public class World
{
    public static final int SIZE = 10;
    public static final int START = 1;
    private Entity [][] aWorld;
    private int currentRow;
    private int currentColumn;  
  
    // Post-condition: the position of the characters in the
    // starting input file will determine the position of the
    // objects in the array. The type of character in the file
    // determines the appearance of the Entity(O or D) or if the
    // element is empty (spaces become null elements)
    public World()
    {
        aWorld = new Entity[SIZE][SIZE];
        int r;
        int c;
        for (r = 0; r < SIZE; r++)
        {
            for (c = 0; c < SIZE; c++)
            {
                aWorld[r][c] = null;
            }
        }
        aWorld = FileInitialization.read();
    }

    // Displays array elements on at a time one row per line
    // Each element is bound above, below, left and right by 
    // bounding lines
    public void display()
    {
        int b;
        int r;
        int c;
        for (r = 0; r < SIZE; r++)
        {
            for (b = 0; b < SIZE; b++)
                System.out.print(" -");
            System.out.println();
            for (c = 0; c < SIZE; c++)
            {
                if(aWorld[r][c] == null)
                    System.out.print("| ");
                else
                    System.out.print(
                      "|" + aWorld[r][c].getAppearance()); 
            }
            System.out.println("|");
        }
        for (b = 0; b < SIZE; b++)
            System.out.print(" -");
        System.out.println();
    }

    // Shows the position of the Entities immediately after
    // file initialization has occured. It's up the student
    // to fill in the rest of the program!
    public void start()
    {
    	int infinite = -1;
		Scanner keyboard = new Scanner(System.in);
    	
    	//display how it initially looks
    	display();
    	System.out.println("Would you like to contiune?");
    	String input = keyboard.nextLine();
    	
    	//create loop that never ends
    	for(int i = 0 ; i > infinite ; i++){

    		resetActionCounter();
    		//find orcs and dwarfs in the world and then move them
    		find();
    		//display updated world
    		display();
    		//check if array is null then quit program
    		boolean check = checkNull();
    		if(check == true){
    			System.out.println("End");
    			break;
    		}

    		//pause and wait for user input
    		System.out.print("Would you like to continue? ");
			input = keyboard.nextLine();
			
			//spacing
			System.out.println("");
			System.out.println("");

    	}
    	//close scanner
    	keyboard.close();
    }
    public boolean checkNull(){
    	boolean arrayNull = false;
    	int x;
    	int y;
    	
    	for(x = 0 ; x < 10 ; x++){
			for(y = 0 ; y < 10 ; y++){
				if(aWorld [x][y] != null){
					//if there are people in array then arrayNull is false 
					arrayNull = false;
					break;
					
				}
				else{
					arrayNull = true;
					
				}
			}	
		}
    	
    	return(arrayNull);
    }
    
    public void resetActionCounter(){
    	//reset the move counter for each dwarf and orc
    	int x;
    	int y;
    	
    	for(x = 0 ; x < 10 ; x++){
			for(y = 0 ; y < 10 ; y++){
				if(aWorld [x][y] != null)
					//refresh counter to 1 
					aWorld[x][y].setActionCounter(1);

			}
		}
    }

    public void find(){
    	int x;
    	int y;
    	
    	for(x = 0 ; x < 10 ; x++){
			for(y = 0 ; y < 10 ; y++){
				//find an Orc or Dawarf 
				if(aWorld [x][y] != null && aWorld[x][y].getActionCounter() == 1){
					int actionCounter = aWorld[x][y].getActionCounter();
					char speices = aWorld[x][y].getAppearance();
					boolean check = false;
					check = checkPosition(speices,x,y);
					
					//if check is true move to location
					if(check == true){
						//because it moved take action point away
						aWorld[x][y].setActionCounter(0);
						actionCounter--;
						move(speices,x,y);
						
					}
					//if action point not used character can attack this turn
					if(actionCounter == 1){
						findTarget(speices,x,y);
					}
					
				}
			}
		}
    }
    
    public boolean checkPosition(char speices,int x, int y){
    	boolean move= false;

    	//figure out if it is an O or D
    	//Orc
    	if(speices == 'O'){
    		int xPlus1 = x + 1;
    		int yPlus1 = y + 1;
    		
    		//check if space is out of world
    		//check x axis 
    		if(xPlus1 >= 0 && xPlus1 <= 9){
    			//check y axis
    			if(yPlus1 >= 0 && yPlus1 <= 9){
    				//check if space is occupied  
    	    		if(aWorld[xPlus1][yPlus1] == null){
    	    			move = true;
    	    			
    	    		}
    				
    			}
    				
    		}
    
    	}
    	//Dwarf
    	if(speices == 'D'){
    		int xMinus1 = x -1;
    		int yMinus1 = y -1;
    		
    		//check if space is out of world
    		//check x axis 
    		if(xMinus1 >= 0 && xMinus1 <= 9){
				//check y axis
				if(yMinus1 >= 0 && yMinus1 <= 9){
					//check if space is occupied  
					if(aWorld[xMinus1][yMinus1] == null){
						move = true;
    			
					}
				}
			}
    	}
    	return(move);
    }
    
    public void move(char speices,int x, int y){
    	
    	// figure out if its a dwarf or Orc
    	//Orc
    	if(speices == 'O'){
       		int xPlus1 = x + 1;
    		int yPlus1 = y + 1;
    		
    		//move to new location
    		aWorld[xPlus1][yPlus1] = aWorld[x][y];
    		//erase old location
    		aWorld[x][y] = null;
    		
    	}
    	//Dwarf
    	if(speices == 'D'){
       		int xMinus1 = x - 1;
    		int yMinus1 = y - 1;
    		
    		//move to new location
    		aWorld[xMinus1][yMinus1] = aWorld[x][y];
    		//erase old location
    		aWorld[x][y] = null;
    		
    	}
    	
    }
    
    public void findTarget(char speices,int x, int y){

    	int xPlus1 = x + 1;
    	int yPlus1 = y + 1;
    	int xMinus1 = x -1;
    	int yMinus1 = y -1;
    	int amountOfEnemys = 0;
    		
    	//create an array for which opponent to attack 
    	int [] enemiesArray = new int [8];
    		for(int i = 0 ; i <= 7 ; i ++){
    			enemiesArray[i] = 0;
    			
    		}  		

    	//check top left (1)   
    	//check if out of bounds 
   		if(xMinus1 >= 0 && yMinus1 >= 0){
   			//check if space it not null and the spices is opposite of it
   			if(aWorld[xMinus1][yMinus1] != null && aWorld[xMinus1][yMinus1].getAppearance() != speices ){
   				//attack
    			//attack(speices,x,y,xMinus1,yMinus1);
   				enemiesArray[amountOfEnemys] = 1;
    			amountOfEnemys++;
    		}
   		}
   		
   		//check top (2)
   		//check if out of bounds 
    	if(yMinus1 >= 0){
    		//check if space it not null and the spices is opposite of it
    		if(aWorld[x][yMinus1] != null && aWorld[x][yMinus1].getAppearance() != speices){
    			//attack
   				//attack(speices,x,y,x,yMinus1);
    			enemiesArray[amountOfEnemys] = 2;
   				amountOfEnemys++;
   			}
   		}
    		
    	//check top right (3)
    	//check if out of bounds 
   		if(xPlus1 <= 9 && yMinus1 >= 0){
   			//check if space it not null and the spices is opposite of it
   			if(aWorld[xPlus1][yMinus1] != null && aWorld[xPlus1][yMinus1].getAppearance() != speices){
   				//attack
    			//attack(speices,x,y,xPlus1,yMinus1);
   				enemiesArray[amountOfEnemys] = 3;
    			amountOfEnemys++;
    		}
   		}
   		
   		//check left side (4)
   		//check if out of bounds 
    	if(xMinus1 >= 0){
    		//check if space it not null and the spices is opposite of it
    		if(aWorld[xMinus1][y] != null && aWorld[xMinus1][y].getAppearance() != speices){
   				//attack
   				//attack(speices,x,y,xMinus1,y);
    			enemiesArray[amountOfEnemys] = 4;
   				amountOfEnemys++;
   			}
    	}
    		
    	//check right (5)
   		//check if out of bounds 
   		if(xPlus1 <=9){
   			//check if space it not null and the spices is opposite of it
   			if(aWorld[xPlus1][y] != null && aWorld[xPlus1][y].getAppearance() != speices){
    			//attack
    			//attack(speices,x,y,xPlus1,y);
   				enemiesArray[amountOfEnemys] = 5;
    			amountOfEnemys++;
    		}
    	}
    		
    	//check bottom left (6)
    	//check if out of bounds 
    	if(xMinus1 >= 0 && yPlus1 <= 9){    			
    		//check if space it not null and the spices is opposite of it
   			if(aWorld[xMinus1][yPlus1] != null && aWorld[xMinus1][yPlus1].getAppearance() != speices){
   				//attack
   				//attack(speices,x,y,xMinus1,yPlus1);
   				enemiesArray[amountOfEnemys] = 6;
   				amountOfEnemys++;
    		}
    	}
    		
   		//check bottom (7)
   		//check if out of bounds 
   		if(yPlus1 <= 9){
   			//check if space it not null and the spices is opposite of it
    		if(aWorld[x][yPlus1] != null && aWorld[x][yPlus1].getAppearance() != speices){
    			//attack
    			//attack(speices,x,y,x,yPlus1);
    			enemiesArray[amountOfEnemys] = 7;
    			amountOfEnemys++;
   			}
   		}
    		
    	//check bottom right (8)
    	//check if out of bounds 
    	if(xPlus1 <= 9 && yPlus1 <= 9){
    		//check if space it not null and the spices is opposite of it
    		if(aWorld[xPlus1][yPlus1] != null && aWorld[xPlus1][yPlus1].getAppearance() != speices){
    			//attack
    			//attack(speices,x,y,xPlus1,yPlus1);
    			enemiesArray[amountOfEnemys] = 8;
    			amountOfEnemys++;
    		}
    	}
    	//randomly pick an enemy around the person
    	if (amountOfEnemys >= 1){
    		boolean attackThem = false;
    		
    		while(attackThem == false){
    			//roll a 0-7
    			int roll = eightSidedDice();
    			
    			if(enemiesArray[roll] != 0){
    				attackThem = true;
    				//if array has 1 then it is top left
    				if(enemiesArray[roll] == 1){
    					//pass in values to prep for attack
    					attack(speices,x,y,xMinus1,yMinus1);
    					
    				}
    				//if array has 2 then it is top
    				else if(enemiesArray[roll] == 2){
    					//pass in values to prep it for attack
    					attack(speices,x,y,x,yMinus1);
    					
    				}
    				//top right
    				else if(enemiesArray[roll] == 3){
    					attack(speices,x,y,xPlus1,yMinus1);
    				}
    				//left
    				else if(enemiesArray[roll] == 4){
    					attack(speices,x,y,xMinus1,y);
    				}
    				//right
    				else if(enemiesArray[roll] == 5){
    					attack(speices,x,y,xPlus1,y);
    				}
    				//bottom left
    				else if(enemiesArray[roll] == 6){
    					attack(speices,x,y,xMinus1,yPlus1);
    				}
    				//bottom
    				else if(enemiesArray[roll] == 7){
    					attack(speices,x,y,x,yPlus1);
    				}
    				//bottom right
    				else if(enemiesArray[roll] == 8){
    					attack(speices,x,y,xPlus1,yPlus1);
    					
    				}	
    			}
    		}
    	}
    }
  
    public void attack(char speices,int x, int y, int enemyX, int enemyY){
    	//roll dice 
    	int roll = sixSidedDice();
    	
    	//set default 
    	char otherSpeices = 'A';
    	//change to opposite speices
    	if(speices == 'O'){
    		otherSpeices = 'D';
    	}
    	//change to opposite speices
    	if(speices == 'D'){
    		otherSpeices = 'O';
    	}
    	
    	System.out.println("Speices " + speices + " at " + (x+1) + "," + (y+1) + " did " + 
    	roll + " damage to " + otherSpeices + " at " + (enemyX+1) + "," + (enemyY+1));
    	
    	//get HP
    	int enemyHP = aWorld[enemyX][enemyY].getHP();
    	//modify HP
    	enemyHP = enemyHP - roll;
    	//transfer it to object
    	aWorld[enemyX][enemyY].setHP(enemyHP);
    	
    	//check if the enemy is dead
    	if(aWorld[enemyX][enemyY].getHP() <= 0){
    		//if dead set to null
    		aWorld[enemyX][enemyY] = null;
    		System.out.println(otherSpeices +" at " + (enemyX +1)+ "," + (enemyY + 1) + " has been slain!");
    	}
    
    }
    public int sixSidedDice(){
    	//make a dice 
    	Random sixSidedDice = new Random();
    	//roll dice between 1-6
    	int roll = sixSidedDice.nextInt(5) + 1;
    	return(roll);
    }
    public int eightSidedDice(){
    	//make a dice 
    	Random sixSidedDice = new Random();
    	//roll dice between 0-7
    	int roll = sixSidedDice.nextInt(7);
    	return(roll);
    }
    
}