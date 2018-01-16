import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.Insets;

public class MyFrame extends JFrame
{
	private JButton save;
	private JButton clear;
	private JTextField tField1;
	private JTextField tField2;
	private JLabel nameLabel;
	private JLabel addressLabel;
	private ImageIcon leftPicture;
	private JLabel leftPic;
	private GridBagLayout layout;
	private GridBagConstraints constraint;
	private int padding;
	
	public MyFrame(){	
		//set the Jframe to be in the center of the screen(700,200) and the size to be (500,400)
		setBounds(700,200,500,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Order Information");
		
		//make constraints and layout
		constraint = new GridBagConstraints();
		layout = new GridBagLayout();
	    
		padding = 5;
		constraint.insets = new Insets(padding,padding,padding,padding);
		constraint.anchor= GridBagConstraints.NORTHWEST; 

		setLayout(layout);
		
		//make the things that will be on the JFrame
		createButtons();
		createTxtBoxes();
		createLabels();
		createImage();
		
		//add the components that were made on the JFrame
		//picture
		addWidget(leftPic,0,0,2,1);
		//label
		addWidget(nameLabel,1,1,1,1);
		addWidget(addressLabel,2,1,1,1);
		//text fields
		addWidget(tField1,1,2,1,1);
		addWidget(tField2,2,2,1,2);
		//buttons
		addWidget(save,1,4,1,1);
		addWidget(clear,2,4,1,1);
	
	}
	
    private void createLabels() {
    	//make labels for name and address to be above txt boxes
		nameLabel = new JLabel("Name");
		addressLabel = new JLabel("Address");
		
	}
    
	private void createTxtBoxes() {
		//add text boxes 
        tField1 = new JTextField(15);
        tField2 = new JTextField(15);
        
        //set the size of the second text field to be taller
        tField2.setPreferredSize(new Dimension(15,80));
       
	}
	
	private void createImage(){
		//make pictures that will be on the top 
		leftPicture = new ImageIcon("logo.png");

		//make labels and put the pictures on them 
		leftPic = new JLabel(leftPicture);
		
	}
	
	private void createButtons() {
		//make the pictures that will go on the buttons
    	ImageIcon saveIcon = new ImageIcon("save1.gif");
    	ImageIcon clearIcon = new ImageIcon("close.gif");
    	
    	//make new buttons and add the images and words on them
    	save = new JButton("Save", saveIcon);
    	clear = new JButton("Clear", clearIcon);
		
    	//add action listener to save button 
    	save.addActionListener(new ActionListener (){
    		public void actionPerformed(ActionEvent e){
    			JButton aButton = (JButton)e.getSource();
    			//initialize the writers and scanner
    			Scanner in = new Scanner(System.in);
    			PrintWriter pw = null;
    			FileWriter fw = null;
    	        
    	        //get text from boxes and put them into a string
    			String field1 = tField1.getText();
    			String field2 = tField2.getText();
    			
    			try {
    				//make file writer link to text and the print writer link to the file writer
					fw = new FileWriter("data.txt");
					pw = new PrintWriter(fw);
					
					//make print writer print the text of the name and address on the txt document
					pw.println(field1);
					pw.println(field2);
					
					//once saves change title to make it visible for the user
					setTitle("Information Saved");
					//close the scanner class
					fw.close();
					
				} 
    			//if anything goes wrong (which it wont) print message saying something went wrong during the save process
    			catch (IOException e1) {
    				System.out.println("ERROR OCCURED WHEN WRITING TO FILE");
    				
				}  
    		}
    	});
    			
    	//add action listener to clear button 
    	clear.addActionListener(new ActionListener (){
    		public void actionPerformed(ActionEvent e){
    			JButton aButton = (JButton)e.getSource();
    			//set the fields to empty
    			tField1.setText("");
    			tField2.setText("");
    		}
    	});
		
	}
	public void addWidget (Component widget, int x, int y, int w, int h){
        constraint.gridx = x;
        constraint.gridy = y;
        constraint.gridwidth = w;
        constraint.gridheight = h;
        layout.setConstraints (widget, constraint);
        add(widget);        // Calling method of super class.
    }
	
}
