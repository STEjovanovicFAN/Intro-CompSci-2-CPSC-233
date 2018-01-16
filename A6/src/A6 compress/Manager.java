
public class Manager {
	private MovieNode head;
	
    public Manager()
    {
        head = null;
    }
	
	public void add(MovieNode aNode){
        if (head == null)
        {
            head = aNode;
        }
        else
        {
            MovieNode current = head;
            MovieNode previous = null;
            while (current != null)
            {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(aNode);
        }
		
	}
	
	public void remove(MovieNode aNode){
		
	}
	
	public void search(MovieNode aNode){
		
	}
	
	public void display(MovieNode aNode){
        // Write your code here
    	Movie previous = null;
    	Movie current = head;
    	
    	//go through the link in a 2 step process 
    	while (current != null){
    		previous = current;
    		current = current.getNext();
    		System.out.println(previous);
    	}
		
	}
	
}
