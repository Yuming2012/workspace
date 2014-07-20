
	import java.awt.Color;
	import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;

	public class GuiProgrammingExercise4  {
		//declare all GUI compnents variables
		JFrame gui;
		JButton ClickMe;
		
		
		public GuiProgrammingExercise4() {
			gui = new JFrame();
			gui.setLayout(new FlowLayout());
			
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gui.setBackground(Color.red);
			
			ClickMe = new JButton("Click Me!");
			gui.add(ClickMe);

			gui.setSize(500, 300);
			gui.setVisible(true);
		
			// Add 4 events to the 4 buttons
			Event event = new Event();
			ClickMe.addActionListener(event);
			
		}

		// Define events and their handlers
		public class Event implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Color c = gui.getContentPane().getBackground();
				if(c == Color.RED)
					gui.getContentPane().setBackground(Color.GREEN);
					
				else if(c == Color.GREEN)
					gui.getContentPane().setBackground(Color.BLUE);
					
				else if(c == Color.BLUE)
					gui.getContentPane().setBackground(Color.GRAY);
					
				else if(c == Color.GRAY)
					gui.getContentPane().setBackground(Color.RED);

				else
					gui.getContentPane().setBackground(Color.RED);
			}
		}
		
		
		public static void main(String[] args) {
			JFrame.setDefaultLookAndFeelDecorated(true);
			new GuiProgrammingExercise4();

		}

	}
