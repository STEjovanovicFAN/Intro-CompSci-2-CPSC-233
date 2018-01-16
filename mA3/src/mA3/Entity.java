/*
  Author:  James Tam
  Version: September 2, 2015

*/

public class Entity
{
    public static final char DEFAULT = 'X';
    private char appearance;

    public Entity()
    {
        setAppearance(DEFAULT);
    }
    //overloading
    public Entity(char newAppearance)
    {
        setAppearance(newAppearance);
    }
    //get
    public char getAppearance()
    {
        return(appearance);
    }
    //set
    private void setAppearance(char newAppearance)
    {
        appearance = newAppearance;
    }
}