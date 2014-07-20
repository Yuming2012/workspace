import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author SHUKE WANG
 *
 */
public class RockPaperScissorsGui {
	JFrame gui;
	JPanel panel = new JPanel();
	JButton buttons[] = new JButton[3];
	JLabel label = new JLabel();
	
	public RockPaperScissorsGui() {
		gui = new JFrame();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setTitle("Rock - Paper - Scissors ");
		gui.setSize(400, 200);
		
		Event event = new Event();

		for(int i=0; i<3; i++) {
			buttons[i] = new JButton();
			buttons[i].setText(RockPaperScissors.names[i]);
			buttons[i].setActionCommand(Integer.toString(i+1));
			buttons[i].addActionListener(event);
			panel.add(buttons[i]);
		}
		
		label.setSize(200, 50);
		label.setText("Bet one from Rock, Paper, Scissors!");
		panel.add(label);
		gui.add(panel);
		gui.setVisible(true);
	}

	public class Event implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = Integer.parseInt(e.getActionCommand());
			RockPaperScissors game = new RockPaperScissors(i);
			label.setText(game.getResult());
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RockPaperScissorsGui();
	}

}
