/*
    All code except for the display() and displayOverCutOff() 
    methods were written by James Tam.
*/

public class Manager
{
    public static final int CUT_OFF = 5;
    private Node head;

    public Manager()
    {
        head = null;
    }

    public void add(Node aNode)
    {
        if (head == null)
        {
            head = aNode;
        }
        else
        {
            Node current = head;
            Node previous = null;
            while (current != null)
            {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(aNode);
        }
    }

    /*
     * Name: Stefan Jovanovic
     * Student ID #: 10135783
     * Version 1
     */
    public void display()
    {
        // Write your code here
    	Node previous = null;
    	Node current = head;
    	
    	//go through the link in a 2 step process 
    	while (current != null){
    		previous = current;
    		current = current.getNext();
    		System.out.println(previous);
    	}
    	
    }  

    public void displayOverCutOff()
    {
        // Write your code here
    	Node previous = null;
    	Node current = head;
    	int counter = 1;
    	
    	//go through the link in a 2 step process 
    	while(current != null){
    		previous = current;
    		current = current.getNext();
    		
    		//if our counter is greater than the cutoff print the remaining numbers 
    		if(counter > 5){
    			System.out.println(previous);
    			
    		}
    		counter ++;
    	}
    }
}