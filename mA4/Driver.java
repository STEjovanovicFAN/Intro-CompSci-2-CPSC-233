/*
  Author:  James Tam
  Version: October 21, 2015
*/

public class Driver
{
    public static void main(String [] args)
    {
        Bird aBird = new Bird();
        System.out.println(aBird);
        aBird.fly();
        aBird.walk();
        System.out.println(aBird);
    }
}