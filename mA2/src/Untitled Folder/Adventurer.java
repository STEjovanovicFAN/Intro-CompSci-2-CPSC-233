

public class Adventurer {
	
	private int health;
	private String name;
	
	//constructor to set name and health to default values
	public Adventurer(){
		health = -1;
		name = "nameless";
		
	}
	
	
	public int gainLevel(){
		System.out.println("Congratulations!");
		health = health + 5;
		
		return (health);
		
	}
	
	//Accessor and Mutator methods to get the values and set the values of health and name
	public int getHealth(){
		return (health);
	}
	
	public String getName(){
		return (name);
	}
	
	public void setHealth(int someHealth){
		health = someHealth;
		
	}
	
	public void setName(String someName){
		name = someName;
	}
}
