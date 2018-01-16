import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MyButtonListener implements ActionListener {
	final static int width = 200;
	final static int height = 150;
	public void actionPerformed (ActionEvent e){
		JButton button = (JButton) e.getSource();
		//change text
		button.setText("Pressed");
		
		//open new gui frame
		JFrame openFrame = new JFrame("Pressed");
		//set size to be smaller
		openFrame.setSize(width, height);

		//make it so you can close it when you press x
		openFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//make it visible
		openFrame.setVisible(true);
		openFrame.setSize(width, height);
		
	}

}
