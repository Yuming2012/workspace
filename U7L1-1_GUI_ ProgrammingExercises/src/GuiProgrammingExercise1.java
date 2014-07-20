import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class GuiProgrammingExercise1  extends JFrame {

	public GuiProgrammingExercise1() {
		setLayout(new FlowLayout());
		int dim1 = 500;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Exercise1");
		setSize(dim1,dim1);

		JLabel label = new JLabel(Integer.toString(dim1));
		add(label);
		setVisible(true);
	
	}
	
	public static void main(String[] args) {

		new GuiProgrammingExercise1();

	}

}