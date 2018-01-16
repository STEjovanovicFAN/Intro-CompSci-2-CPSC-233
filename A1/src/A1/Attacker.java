
import java.util.Random;

public class Attacker {
	
	private int highPercent;
	private int mediumPercent;
	private int lowPercent;
	private int punch;
	
	public Attacker(){
		
		/*33.33333 is the correct value, but made High 34 and low/medium 33
		to get 100%*/
		//default values of Attacker
		highPercent = 34;
		mediumPercent = 33;
		lowPercent = 33;
	}
	public int attackerRoll(){
		//create dice
		Random roll = new Random();
		//roll dice between numbers 1-100
		int dice = roll.nextInt(100) + 1;
	
		/*if dice rolls in certain range(of percentages) then that will be
		the punch thrown*/
		//high punch
		if(dice >= 1 && dice <= highPercent){
			punch = 1;
		}
		//medium punch
		if(dice > highPercent && dice <= highPercent +mediumPercent){
			punch = 2;
		}
		//low punch
		if(dice > highPercent + mediumPercent && dice <= 100){
			punch = 3;
		}
		return(punch);
	}
	
	//mutator methods to set percentages
	public void setHighPercent(int somePercent){
		highPercent = somePercent;
	}
	public void setMediumPercent(int somePercent){
		mediumPercent = somePercent;
	}
	public void setLowPercent(int somePercent){
		lowPercent = somePercent;
		
	}

}

