import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class GuiProgrammingExercise5  {
	//declare all GUI compnents variables
	JFrame gui;
	final int numOfButtons = 10;

	// Create array for the 10 buttons
	JButton buttons[] = new JButton[numOfButtons];

	String [] numbers = new String[3];
	int step;
	
	public GuiProgrammingExercise5() {
		gui = new JFrame();
		gui.setLayout(new FlowLayout());
		
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Event event = new Event();

		for (int i = 0; i < numOfButtons; i++) {
			// Create button and assign it a text
			buttons[i] = new JButton(Integer.toString(i));
			// Associate a command string to the button
			buttons[i].setActionCommand(Integer.toString(i));
			// Add event to the button
			buttons[i].addActionListener(event);
			// Add the button to the JFrame gui
			gui.add(buttons[i]);
		}

		gui.setSize(800, 100);
		gui.layout();
		gui.setVisible(true);
		
		reset();
	}

	void reset() {
		step = 0;
		// Generate 3 random numbers
		numbers[0] = Integer.toString((int) Math.floor(Math.random()*10.0));
		numbers[1] = Integer.toString((int) Math.floor(Math.random()*10.0));
		numbers[2] = Integer.toString((int) Math.floor(Math.random()*10.0));
		gui.setTitle(numbers[0]+numbers[1]+numbers[2]);
		
	}

	// Define events and their handlers
	public class Event implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String a = e.getActionCommand();
			if(a.equals(numbers[step])) {
				gui.getContentPane().setBackground(Color.blue);
				step++;
				if(step == 3) { // succeeded
					gui.getContentPane().setBackground(Color.green);
					reset();
				}
			} else { // failed
				gui.getContentPane().setBackground(Color.RED);
				reset();
			}
		}
	}
	

	public static void main(String[] args) {
		new GuiProgrammingExercise5();

	}

}