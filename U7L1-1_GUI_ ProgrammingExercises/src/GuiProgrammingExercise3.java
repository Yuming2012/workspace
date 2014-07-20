import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class GuiProgrammingExercise3  {
	//declare all GUI compnents variables
	JFrame gui;
	JButton red, green, blue, gray;
	
	
	public GuiProgrammingExercise3() {
		gui = new JFrame();
		gui.setLayout(new FlowLayout());
		
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		red = new JButton("Red");
		gui.add(red);

		green = new JButton("Green");
		gui.add(green);

		blue = new JButton("Blue");
		gui.add(blue);

		gray = new JButton("Gray");
		gui.add(gray);

		gui.setSize(500, 300);
		gui.layout();
		gui.setVisible(true);
	
		// Add 4 events to the 4 buttons
		EventRed eventRed = new EventRed();
		red.addActionListener(eventRed);
		
		EventGreen eventGreen = new EventGreen();
		green.addActionListener(eventGreen);
		
		EventBlue eventBlue = new EventBlue();
		blue.addActionListener(eventBlue);

		EventGray eventGray = new EventGray();
		gray.addActionListener(eventGray);
	}

	// Define events and their handlers
	public class EventRed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gui.getContentPane().setBackground(Color.RED);
		}
	}
	
	public class EventGreen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gui.getContentPane().setBackground(Color.GREEN);
		}
	}
	
	public class EventBlue implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gui.getContentPane().setBackground(Color.BLUE);
		}
	}
	
	public class EventGray implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gui.getContentPane().setBackground(Color.GRAY);
		}
	}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new GuiProgrammingExercise3();

	}

}
