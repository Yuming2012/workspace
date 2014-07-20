import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class MovingHead extends JPanel implements ActionListener, KeyListener {
	final static int DEFAULT_WIDTH = 900; // Default width of the window
	final static int DEFAULT_HEIGHT = 700; // Default height of the window
	final static int DEFAULT_SPEED = 16;  // Default moving speed of the objects
	final static int NUMBER_OF_GIRLS = 3; // Number of girls you can choose to save

	Timer t = new Timer(5, this);
	int x = 200, y = 200, velX = DEFAULT_SPEED, velY = DEFAULT_SPEED;
	int keyX = 100, keyY = 200, velKeyY = 0;
//	private BufferedImage currentHead;	// current head
	private BufferedImage[] girlsPicture = new BufferedImage[NUMBER_OF_GIRLS];
	private JRadioButton[] girlsSelect = new JRadioButton[NUMBER_OF_GIRLS];
	private String[] names = {"shuke", "monika", "jenny"};
	private int currentGirl = 0;
	
	private BufferedImage bossPic;

	private ButtonGroup bG;

	private JTextField speed;
	private int tempSpead = DEFAULT_SPEED;
	
	private JCheckBox musicCheckBox = null;
	private Clip clip = null;
	
	private JButton playButton;
	private JButton pauseButton;
	private JButton exitButton;
	
	JFrame exitFrame = null;
	
	MovingHead() {
		JLabel chooseWhom = new JLabel("Select picture:");
		add(chooseWhom);

		bG = new ButtonGroup();
		for(int i = 0; i<NUMBER_OF_GIRLS; i++) {
			girlsSelect[i] = new JRadioButton(names[i]);
			bG.add(girlsSelect[i]);
			add(girlsSelect[i]);
		}
		
		girlsSelect[0].setSelected(true);

		JLabel speedLbl = new JLabel("Left/Right arrow to set speed:");
		add(speedLbl);
		
		speed = new JTextField(" 10"); 
		add(speed);

		musicCheckBox = new JCheckBox("Music", true);
		add(musicCheckBox);

		playButton = new JButton("Play");
		add(playButton);
		
		pauseButton = new JButton("Pause");
		add(pauseButton);

		exitButton = new JButton("Exit");
		add(exitButton);

		ClickButtonEvent event = new ClickButtonEvent();
		playButton.addActionListener(event);
		pauseButton.addActionListener(event);
		exitButton.addActionListener(event);

		for(int i = 0; i<NUMBER_OF_GIRLS; i++) {
			girlsSelect[i].addActionListener(event);
		}

		// Load and play music
		String bip = "background.wav";
		try {
		    // Open an audio input stream.
		    File soundFile = new File(bip);
		    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
		
		    // Get a sound clip resource.
		    clip = AudioSystem.getClip();
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

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void start() {
		t.start();
		setBackground(Color.WHITE);

		playButton.setEnabled(false);
		pauseButton.setEnabled(true);
		exitButton.setEnabled(true);
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// head
		try {
			for(int i = 0; i<NUMBER_OF_GIRLS; i++) {
				girlsPicture[i] = ImageIO.read(new File(names[i]+".jpg"));
				if(girlsSelect[i].isSelected())
					currentGirl = i;
			}

			bossPic = ImageIO.read(new File("boss.jpg"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(bossPic, keyX, keyY + velKeyY, this);
		g.drawImage(girlsPicture[currentGirl], (int)x, (int)y, this);
	}
		
		
	public static void main(String[] args) {
		
        String yourName;        // your original name
       
        // entering the name for user 
        yourName = JOptionPane.showInputDialog(null, "Enter your full name here please");

        // results shown 
        JOptionPane.showMessageDialog(null, "Your have entered " + yourName);
   

        
        Object[] possibleValues = { "First", "Second", "Third" };
        Object selectedValue = JOptionPane.showInputDialog(null, 
                                                           "Choose one", "Input",
                                                            JOptionPane.INFORMATION_MESSAGE, null,
                                                            possibleValues, possibleValues[0]);
                                                            
        int again = JOptionPane.showConfirmDialog(null, "Do you want to play again");

		
		
		MovingHead panel = new MovingHead();
		JFrame gui = new JFrame();
		gui.setVisible(true);
		gui.setSize(DEFAULT_WIDTH,  DEFAULT_HEIGHT);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setTitle("Save me Mr. B!!!");
		gui.add(panel);
		panel.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkSettings();
		
		if(x < keyX) {
			if((y+girlsPicture[currentGirl].getHeight() > keyY) && (y<(keyY + bossPic.getHeight()))) {
				velX = -velX;
			}
		}

		if(x>(getWidth() - girlsPicture[currentGirl].getWidth())) {
			velX = -velX;
		}

		if(y<0 || y>(getHeight() - girlsPicture[currentGirl].getHeight())) {
			velY = -velY;
		}
		
		// Die - game over!
		if(x<0) {
			setBackground(Color.RED);
			t.stop();
			reset();
			clip.stop();
		}
		x += velX;
		y += velY;

		// the boss picture
		if(velKeyY <0 && keyY < 0) {
			velKeyY = -velKeyY;
		} else if(velKeyY > 0 && (keyY > (getHeight() - bossPic.getHeight()))) {
			velKeyY = -velKeyY;
		} else {
			keyY += velKeyY;
		}
		
		repaint();
		requestFocusInWindow();
		
	}
	
	private void checkSettings() {
		if(!musicCheckBox.isSelected() && clip.isRunning()) {
			clip.stop();
		} else if (musicCheckBox.isSelected() && !clip.isRunning()) {
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		switch(c) {
		// Press Up Arrow Key to move the bar up
		case KeyEvent.VK_UP:
			velKeyY = -DEFAULT_SPEED;
			break;

		// Press Down Arrow Key to move the bar down
		case KeyEvent.VK_DOWN:
			velKeyY = DEFAULT_SPEED;
			break;
			
		// Press Left Arrow Key to decrease the speed
		case KeyEvent.VK_LEFT:
			if(tempSpead > 0) {
				tempSpead--;
				speed.setText(Integer.toString(tempSpead));
			}
			break;

		// Press Right Arrow Key to increase the speed
		case KeyEvent.VK_RIGHT:
			if(tempSpead < 100) {
				tempSpead++;
				speed.setText(Integer.toString(tempSpead));
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_UP || c == KeyEvent.VK_DOWN) {
			velKeyY = 0;
		} else if(c == KeyEvent.VK_LEFT || c == KeyEvent.VK_RIGHT) {
			velX = tempSpead;
			if(velX<0) {
				velX = 0;
			}
			
			if(velX>100) {
				velX = 100;
			}
			velY = velX;
			tempSpead = velX;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	// In PAUSED status
	private void reset() {
		x = 0;
		y = 0;
		velX = DEFAULT_SPEED;
		velY = DEFAULT_SPEED;
		tempSpead = velX;
		keyX = 100;
		keyY = 200;
		velKeyY = 0;
		speed.setText(Integer.toString(velX));
		
		playButton.setEnabled(true);
		pauseButton.setEnabled(false);
		exitButton.setEnabled(true);
	}
	
	public class ClickButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String op =e.getActionCommand();
			
			if(op.equals("Play")) {
				System.out.println("Play button pressed") ;
				start();
			} else if(op.equals("Pause")) {
				System.out.println("Pause button pressed") ;
				pause();
			} else if(op.equals("Exit")) {
				System.out.println("Exit button pressed") ;
				exit();
			} else {
				for(int i = 0; i<NUMBER_OF_GIRLS; i++) {
					if(op.equals(names[i])) {
						currentGirl = i;
						System.out.println(names[i] + " is selected!") ;
					}
				}
				
			}
			
		}
		
	}
	
	private void pause() {
		if(clip.isRunning()) {
			clip.stop();
		}
		t.stop();
		
		playButton.setEnabled(true);
		pauseButton.setEnabled(false);
		exitButton.setEnabled(true);
	}

	private void exit() {
		
		pause();
		
		if(exitFrame == null) {
			exitFrame = new JFrame("Are you sure");
			JButton ok = new JButton("OK");
			JButton cancel = new JButton("Cancel");
			exitFrame.setSize(360,80);
			exitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			exitFrame.setTitle("You sure to exit the super fun game?");
			JPanel p = new JPanel();
			p.add(ok);
			p.add(cancel);
			exitFrame.add(p);
			
			ExitEvent e = new ExitEvent();
			ok.addActionListener(e);
			cancel.addActionListener(e);
		} 
		exitFrame.setVisible(true);
	}

	public class ExitEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String op =e.getActionCommand();
			
			if(op.equals("OK")) {
				System.out.println("OK button pressed") ;
				System.exit(0);
			} else if(op.equals("Cancel")) {
				System.out.println("Cancel button pressed") ;
				exitFrame.setVisible(false);
				start();
			}
			
		}
		
	}

}

