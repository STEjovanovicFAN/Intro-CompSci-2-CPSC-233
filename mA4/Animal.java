/*
  Author:  James Tam
  Version: October 21, 2015

  Learning concept:
  * Base class definition used to illustrate inheritance 
    concepts including method overriding/polymorphism.
  
*/
public class Animal
{
    private int energy;
    public static final int DEFAULT_ENERGY = 25;
    public static final int MAX_ENERGY = 99;
    //public static final int DRAINED = 0;

    public Animal() 
    {
        energy = DEFAULT_ENERGY;
    }

    public void eat()
    {
        System.out.println("Yum!");
        increaseEnergy();
    }

    protected void increaseEnergy()
    {
        if (energy < MAX_ENERGY)
            energy++;
        else if (energy >= MAX_ENERGY)
            System.out.println("Error: Energy cannot exceed"+ 
               MAX_ENERGY);
    }

    protected void reduceEnergy() 
    {
        if (energy >= 1)
            energy--;
        else if (energy <= 0)
            System.out.println("Error: Energy cannot" +
              " be negative");
    }

    public String toString()
    {
        String state = "";
        state = state + "Energy: " + energy + "\n";
        return(state);
    }

    public void walk()
    {
        System.out.println("Hiho!");
        reduceEnergy();
    }
}