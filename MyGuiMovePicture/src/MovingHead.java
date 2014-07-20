import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class MovingHead extends JPanel implements ActionListener {
	final static int WIDTH = 1200;
	final static int HEIGHT = 700;

	Timer t = new Timer(5, this);
	int x = 0, y = 0, velX = 2, velY = 2;
	private BufferedImage head, head2, head3;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		try {
//			head = ImageIO.read(new File("shuke.gif"));
//			head = ImageIO.read(new File("monica.gif"));
			head = ImageIO.read(new File("jenny.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ellipse2D circle = new Ellipse2D.Double(x, y, 40, 40);
		//g2.fill(circle);
		g2.drawImage(head, (int)x, (int)y, this);
		t.start();
		
	}
		
		
	public static void main(String[] args) {
		MovingHead panel = new MovingHead();
		JFrame f = new JFrame();
		JPanel panel2 = new JPanel();
//		panel2.setForeground(Color.RED);
		panel2.setBackground(Color.RED);
		panel2.setBounds(400, 200, 400, 200);
//		panel2.setAlignmentX(500);
//		panel2.setAlignmentX(200);
//		panel2.setLocation((400,200));
		panel.add(panel2);
		f.add(panel);
		
		f.setVisible(true);
		f.setSize(WIDTH,  HEIGHT);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Save me Mr. B!!!");

		// String bip = "off i go- greg laswell.mp3";
		String bip = "mission theme song 2012.wav";
		  try {
		      // Open an audio input stream.
		      File soundFile = new File(bip);
		      AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
		
		      // Get a sound clip resource.
		      Clip clip = AudioSystem.getClip();
		      // Open audio clip and load samples from the audio input stream.
		      clip.open(audioIn);
		      clip.start();
		      clip.loop(Clip.LOOP_CONTINUOUSLY);
		   } catch (UnsupportedAudioFileException e) {
		      e.printStackTrace();
		   } catch (IOException e) {
		      e.printStackTrace();
		   } catch (LineUnavailableException e) {
		      e.printStackTrace();
		   }

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(x<0 || x>(getWidth() - head.getWidth())) {
			velX = -velX;
		}
		if(y<0 || y>(getHeight() - head.getHeight())) {
			velY = -velY;
		}
		x += velX;
		y += velY;
		repaint();
		
	}

}
