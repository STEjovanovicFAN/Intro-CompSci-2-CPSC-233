/*
 * Name: Stefan Jovanovic
 * Student ID #: 10135783
 * Version 1
 */

import javax.swing.JButton;
import javax.swing.JFrame;

public class Driver {
	final static int frameHight = 300;
	final static int frameWidth = 400;

	public static void main(String[]arg){
		//make frame
		JFrame frame = new JFrame("Java GUI");
		//set size
		frame.setSize(frameWidth, frameHight);

		//make it so you can close it when you press x
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//make button
        JButton button = new JButton("Not Pressed");
        //make button listener 
        MyButtonListener buttonListener = new MyButtonListener();
        button.addActionListener(buttonListener);

		//show the frame
        frame.setVisible(true);
        //show button on the frame
        frame.add(button);
	}

}