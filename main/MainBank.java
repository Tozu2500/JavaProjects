package main;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

//This will be the main page of the bank! Remember that opening the main method is equal to exit!
 
public class MainBank extends JFrame implements ActionListener {
	
	// Creating the required amount of labels
	private JLabel label1;

	// Creating the required amount of buttons
	private JButton button1;
	
	public void MainBank() {
		
	//	label1.setText("Hello " +userName+ ", we hope you are having a wonderful day!" +time and date);
		
	}
	
	private static void main(String[] args, Window frame) {
		
		SwingUtilities.invokeLater(() -> {
			//private new run() {
		//		   classNameToRun();
//			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	/*
	@Override
	private void actionPerformed(ActionEvent e) {

		
	}
	*/
}
