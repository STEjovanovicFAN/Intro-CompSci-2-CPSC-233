/*
 * Name: Stefan Jovanovic
 * Student ID #: 10135783
 * Version 1
 */
import java.util.Scanner;
/*
 * How the program works:
 * 
 * 1) it will ask for the amount of rounds
 * 		if you enter in a number more then 100 or less then 1
 * 		it will set the amount of rounds to 10
 * 
 * 2) it will ask you to set percentages for the attacker class
 * 		if you put in a percentage that is not equal to 100%
 * 		it will put in the default values of 33,33,34
 * 
 * 3) It will go though a loop and call the attacker class
 * 
 * 4) The attacker class will roll a dice set by the percentages 
 * 		in step 2 then it will return the punch that was thrown
 * 
 * 5) In the loop it will pass the information from the attacker 
 * 		class to the defender class
 * 
 * 6) The defender class will then roll the dice for the defender 
 * 		and record both the attacker and defender results 
 * 
 * 7) In the defendeResult is the AI function of the code
 * 		it will update the Percentage of blocks in the defender
 * 		class by how much times the attacker threw its punch
 * 		this will happen every 10 rounds
 * 
 * 8) It will now compare the attack and defense in that round
 * 		if the attack and defense are equal then it is a block
 * 		otherwise if attack != defense then it is a hit
 * 
 * 9) In the defender class it will print out what happened in that
 * 		round
 * 
 * 10) After the loop is completed (Manager class) it will show the 
 * 		stats of what happened that fight
 * 		
 * 		WARNING: THERE IS A BUG IN HERE
 * 				 I USED THE Math.round() FUNCTION TO ROUND THE PERCENTAGES
 * 				 THIS MEANS THAT THE PERCENTAGE OF ATTACKS MIGHT NOT EQUAL
 * 				 100%, IT WILL BE OFF BY 1% AT THE MOST.
 * 				 THIS DOES NOT HAPPEN ALL THE TIME ONLY SOMETIMES
 * 
 * Other notes about the program: The AI kinda blows. Like it adapts to the
 * 								  hits but not very well as you will see.
 *
 */
public class Manager {
	public static void main(String []args){
		Scanner keyboard = new Scanner(System.in);
		
		//get attack rounds
		System.out.print("Please enter the number of attack rounds: ");
		int attackRounds = keyboard.nextInt();
		
		//if attackRounds is >100 or <1 then set to default rounds to 10
		if(attackRounds < 1 || attackRounds > 100){
			attackRounds = 10;
		}
		
		System.out.println("Enter percentages for the number of attack"
				+ " that will be directed: low, medium, high. The total"
				+ "of the three percentages must sum to 100%.");
		
		//get percent values for the attacker
		System.out.println();
		System.out.print("Percentage of attacks that will be aimed low: ");
		int low = keyboard.nextInt();
		System.out.print("Percentage of attacks that will be aimed medium: ");
		int medium = keyboard.nextInt();
		System.out.print("Percentage of attacks that will be aimed high: ");
		int high = keyboard.nextInt();
		
		//close scanner
		keyboard.close();

		//create object of attacker and defender
		Attacker attacker = new Attacker();
		Defender defender = new Defender();
		
		
		/*if percent values equals 100 set them to attacker percent 
		if percent values does not equal 100 it will have default values*/
		int percent = low + medium + high;
		if (percent == 100){
			attacker.setLowPercent(low);
			attacker.setMediumPercent(medium);
			attacker.setHighPercent(high);
		}
		
		//format for when combat begins 
		System.out.println();
		System.out.println("Combat Begins!");
		System.out.println("--------------");
		
		//begin loop for the amount of rounds
		for(int counter = 0; counter < attackRounds; counter++){
			
			//attacker rolls for punch
			int attackerTurn = attacker.attackerRoll();
			//pass information to defender class
			defender.defenderStart(attackerTurn);
			
			//defender class takes over, prints info to screen
		}
		
		//Show end of combat stats after loop is completed
		defender.stats();
	}
}
