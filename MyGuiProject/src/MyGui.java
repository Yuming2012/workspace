import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MyGui extends JFrame {

	private JButton button1;
	private JLabel label1;
	
	private JButton button2;
	private JLabel label2;

	public MyGui() {
		
		setLayout(new FlowLayout());
		
		button1 = new JButton("Button1");
		add(button1);
		
		label1 = new JLabel("Label1");
		add(label1);
		
		button2 = new JButton("Button2");
		add(button2);
		
		label2 = new JLabel("Label2");
		add(label2);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyGui gui = new MyGui();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(100, 300);
		gui.setVisible(true);

	}

}
