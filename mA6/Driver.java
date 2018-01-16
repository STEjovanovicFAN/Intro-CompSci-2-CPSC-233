import java.util.Random;

/*
    All code for this class was written by James Tam.
*/

public class Driver
{
    public static final int MAX = 10;

    public static void main(String [] args)
    {
        int i;
        Manager aManager;
        Random aGenerator;

        aManager = new Manager();
        aGenerator = new Random();
        for (i = 0; i < MAX; i++)
        {
            aManager.add(new Node(aGenerator.nextInt(MAX+1)));
        }

        aManager.display();
        System.out.println();
        aManager.displayOverCutOff();
    }
}