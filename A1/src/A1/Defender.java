
import java.util.Random;

public class Defender {
	
	private double highPercent;
	private double mediumPercent;
	private double lowPercent;

	//high(1)
	private double attackH = 0;
	private double defenseH = 0;
	//medium(2)
	private double attackM = 0;
	private double defenseM = 0;
	//low(3)
	private double attackL = 0;
	private double defenseL = 0;
	
	private int counter = 1;
	private int tempCounter = 10;
	private int defenderHit = 0;
	private int defenderBlocked = 0;
	
	public Defender(){
		//default values for the Defender
		highPercent = 34;
		mediumPercent = 33;
		lowPercent = 33;
	}
	public void defenderStart (int attackerRoll){
		//roll defender 
		int defenderRoll = defenderRoll();
		
		//write down the attacks result
		attackerResult(attackerRoll);
		//write down the defenders results and will do the AI of defender
		defenderResult(defenderRoll);
		
		compare(attackerRoll,defenderRoll);
	}

	public void attackerResult(int attackerRoll){
		//update amount of x punches thrown
		if(attackerRoll == 1){
			//high
			attackH++;
		}
		if(attackerRoll == 2){
			//medium
			attackM++;
		}
		if(attackerRoll == 3){
			//low
			attackL++;
		}

	}
	
	public void defenderResult(int defenderRoll){
		//update amount of x defenses 
		if(defenderRoll == 1){
			//high
			defenseH++;
		}
		if(defenderRoll == 2){
			//medium
			defenseM++;
		}
		if(defenderRoll == 3){
			//low
			defenseL++;
		}
		
		//AI of the defender updates every 10 attacks
		if(counter == tempCounter){
			//a counter
			double counter2 = counter;
			
			/*amount of high attacks thrown converted to a percentage for 
			the defender */
			highPercent = (double) attackH/counter2 * 100;
			
			/*amount of medium attacks thrown converted to a percentage for 
			the defender */
			mediumPercent = (double) attackM/counter2 * 100;
			
			/*amount of low attacks thrown converted to a percentage for 
			the defender */
			lowPercent = (double) attackL/counter2 * 100;
			
			//update counter so that it updates the AI every 10 attacks
			tempCounter = tempCounter +10;
			
		}
		
	}
	public void compare(int attacker, int defender ){
		/*convert the number to a word for the print output 
		attacker convert number ---> word*/
		String attackerHit = null;
		if(attacker == 1){
			attackerHit = "High";
		}
		if(attacker == 2){
			attackerHit = "Medium";
		}
		if(attacker == 3){
			attackerHit = "Low";
		}
		
		/*convert the number to a word for the print output 
		defender convert number ---> word*/
		String defenderBlock = null;
		if(defender == 1){
			defenderBlock = "High";
		}
		if(defender == 2){
			defenderBlock = "Medium";
		}
		if(defender == 3){
			defenderBlock = "Low";
		}
		
		String hit = null;
		/*if attacker punch and defender block numbers are the same
		count it as a block and record the block*/
		if(attacker == defender){
			hit = "Blocked";
			defenderBlocked++;
		}
		//otherwise it was a hit and record it as a hit
		else{
			hit = "Hit";
			defenderHit++;
		}

		/*display to screen the round, attacker punch, defender block, 
		and if it was a hit or a block*/
		System.out.printf("%12s","Round " + counter + "...");
		System.out.print("     ");
		System.out.printf("%-20s","Attacker: " + attackerHit);
		System.out.printf("%-25s","Defender: " + defenderBlock);
		System.out.printf("%-25s", hit);
		System.out.println();
		
		//update counter
		counter++;
	}
	
	public void stats(){
		//provide the summary of the combat
		System.out.println();
		System.out.println("Summary of Combat");
		System.out.println("Total hits: " + defenderHit);
		System.out.println("Total blocks: " + defenderBlocked);
		System.out.println();
		
		//get the percentages of each attack that was thrown 
		double highAttack = attackH/counter * 100;
		double mediumAttack = attackM/counter * 100;
		double lowAttack = attackL/counter * 100;
		
		//get the percentages of each defense that was implemented 
		double highDefense = defenseH/counter * 100;
		double mediumDefense = defenseM/counter * 100;
		double lowDefense = defenseL/counter * 100;
		
		//print to screen the percentages of each punch or block
		//HOWEVER I USED THE ROUND FUNCTION SO PERCENTAGES MIGHT NOT EQUAL TO 100%
		System.out.println("Attacker proportions:   " + "High: " + Math.round(highAttack)+ "%" +
				"   Medium: " + Math.round(mediumAttack) + "%" + "   Low: " + Math.round(lowAttack) + "%");
		System.out.println("Defender proportions:   " + "High: " + Math.round(highDefense) + "%" +
				"   Medium: " + Math.round(mediumDefense) + "%" + "   Low: " + Math.round(lowDefense) + "%");
	}
	
	//roll defender 
	public int defenderRoll(){
		//create dice
		Random roll = new Random();
		int dice = roll.nextInt(100) + 1;
		int block = 0;
		
		/*if dice rolls in certain range(of percentages) then that will be
		the block thrown*/
		//high block
		if(dice >= 1 && dice <= highPercent){
			block = 1;
		}
		//medium block
		if(dice > highPercent && dice <= highPercent +mediumPercent){
			block = 2;
		}
		//low block
		if(dice > highPercent + mediumPercent && dice <= 100){
			block = 3;
		}
		return (block);
	}
}
