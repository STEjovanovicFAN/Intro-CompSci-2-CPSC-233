
public class Movie {
	/*
	private String movieName;
	private String cast1;
	private String cast2;
	private String cast3;
	private String genre;
	private String rating;
	*/
	
    private String data;
    private Movie next;

    public Movie(String title)
    {
    	/*
    	data = new String [6];
    	
    	data [0] = title;
    	data [1] = cast1;
    	data [2] = cast2;
    	data [3] = cast3;
    	data [4] = genre;
    	data [5] = rating;
    	*/
    	data = title;
        next = null;
    }

    public Movie(String someData, Movie next)
    {
        data = someData;
        this.next = next;
    }

    public String getData() 
    {
        return(data);
    }

    public Movie getNext()
    {
        return(next);
    }

    public void setData(String someData) 
    {
        data = someData;
    }

    public void setNext(Movie next)
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
