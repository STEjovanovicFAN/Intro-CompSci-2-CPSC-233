
/*
  Author:  James Tam
  Version: October 12, 2015

*/

public class Entity
{
    public static final char DEFAULT = 'X';
    private char appearance;
    private int hitPoints;
    //add action counter
    private int actionCounter;
    
    public Entity()
    {
        setAppearance(DEFAULT);
    }

    public Entity(char anAppearance, int newHP)
    {
        appearance = anAppearance;
        hitPoints = newHP;
    }
    
    public Entity(char newAppearance)
    {
        setAppearance(newAppearance);

    }

    public char getAppearance()
    {
        return(appearance);
    }

    private void setAppearance(char newAppearance)
    {
        appearance = newAppearance;
    }
    //get the move counter 
    public int getActionCounter(){
    	return(actionCounter);
    }
    //set the move counter
    //make public because we want to reset the counter after we use it
    public void setActionCounter(int newActionCounter){
    	actionCounter = newActionCounter;
    	
    }
    //set hp of object
    public void setHP(int hp){
    	hitPoints = hp;
    }
    //get hp of object
    public int getHP(){
    	return(hitPoints);
    }
    
}