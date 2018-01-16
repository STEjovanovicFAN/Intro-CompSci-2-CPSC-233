/*
    All code for this class was written by James Tam.
*/

public class Node
{
    private int data;
    private Node next;

    public Node(int someData)
    {
        data = someData;
        next = null;
    }

    public Node(int someData, Node next)
    {
        data = someData;
        this.next = next;
    }

    public int getData() 
    {
        return(data);
    }

    public Node getNext()
    {
        return(next);
    }

    public void setData(int someData) 
    {
        data = someData;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

    public String toString()
    {
        String s = "";
        s = s + data;
        return(s);
    }
}