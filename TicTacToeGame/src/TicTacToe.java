/*
 * TicTacToe.java
 *
 */
 
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
public class TicTacToe extends JFrame {

    final int ALL = 9;
    final int N = 3;

    int moveCount = 0;
    
    // Player 1 is "X"; player 2 is "O".
    int player1Score = 0;
    int player2Score = 0;

    boolean xTurn = true;
    boolean xGameTurn = true;
    boolean onGoing = true;

    GridLayout theLayout = new GridLayout(0,3);
    JButton buttons[] = new JButton[ALL];

    JLabel label1Score;
    JLabel label2Score;
    
    JLabel info;
    
    JTextField textName1 = new JTextField();
    JTextField textName2 = new JTextField();
    
    public TicTacToe(String name) {
        super(name);
        setResizable(false);
    }
     
    public void addComponentsToPane(final Container pane) {
        final JPanel panel = new JPanel();
        panel.setLayout(theLayout);
         
        //Set up components preferred size
        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
        panel.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 5.0),
                (int)(buttonSize.getHeight() * 7.0) * 2));
         
        Event event = new Event();
        //Initiate and add buttons to the panel with Grid Layout
        for(int i = 0; i<ALL; i++) {
        	buttons[i] = new JButton();
        	buttons[i].setActionCommand(Integer.toString(i));
        	buttons[i].setFont(new Font("Dialog", 1, 28));
        	buttons[i].setForeground(Color.GREEN);
        	buttons[i].addActionListener(event);
        	panel.add(buttons[i]);
        }
        
        panel.add(new JLabel("Enter Player 1 name:"));
        panel.add(textName1);
        label1Score = new JLabel("Score " + player1Score);
        panel.add(label1Score);

        panel.add(new JLabel("Enter Player 2 name:"));
        panel.add(textName2);
        label2Score = new JLabel("Score " + player2Score);
        panel.add(label2Score);

        JButton clearButtons = new JButton("Clear Buttons / start again");
        panel.add(clearButtons);

        //Process the clearButtons button press
        clearButtons.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	resetBoard();
            }
        });

        
        JButton clearScore = new JButton("Clear Score");
        panel.add(clearScore);

        //Process the clearScore button press
        clearScore.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	resetScore();
            }
        });

        info = new JLabel();
        info.setText("Moves: " + moveCount + ", turn:" + (xTurn? "O":"X"));
        panel.add(info);
        

        pane.add(panel, BorderLayout.NORTH);
    }
     
    class Event implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!onGoing)
				return;
			
			int i = Integer.parseInt(e.getActionCommand());
			
			if(textName1.getText().isEmpty() || textName2.getText().isEmpty()) {
				buttons[i].setText("Name?");
	        	buttons[i].setForeground(Color.RED);
			} else {
				
				if(xTurn) {
		        	buttons[i].setForeground(Color.RED);
					buttons[i].setText("X");
				} else {
		        	buttons[i].setForeground(Color.GREEN);
					buttons[i].setText("O");
				}
				moveCount++;
		        info.setText("Moves: " + moveCount + ", turn:" + (xTurn? "O":"X"));

				// check if win
				String result = checkResult(i); 
				if(result == "G") {
					switchTurn();
				} else if(result == "T") {
					// TIE!
					updateScore("");
			        info.setText("Moves: " + moveCount + ", we TIE!");
				} else if(result == "X") {
			        info.setText("Moves: " + moveCount + ", " + textName1.getText() + " win!!!");
					updateScore("X");
				} else if(result == "O") {
					// O WIN!
			        info.setText("Moves: " + moveCount + ", " + textName2.getText() + " win!!!");
					updateScore("O");
				}
			
			}
			
		}
		
    }
    
	void switchTurn() {
    	if(xTurn)
    		xTurn = false;
    	else
    		xTurn = true;
	}

	void switchGameTurn() {
    	if(xGameTurn)
    		xGameTurn = false;
    	else
    		xGameTurn = true;
    	
    	xTurn = xGameTurn;
	}

	void resetBoard() {
    	for(int i = 0; i < ALL; i++) {
    		buttons[i].setText("");
    	}
    	
    	switchGameTurn();
    	onGoing = true;
    	moveCount = 0;
	}
	
	void resetScore() {
	    player1Score = 0;
	    player2Score = 0;
        label1Score.setText("Score: " + player1Score);
        label2Score.setText("Score: " + player2Score);
        resetBoard();
	}

	void updateScore(String winner) {
		if(winner == "X") {
			player1Score++;
	        label1Score.setText("Score: " + player1Score);
		}
		else if(winner == "O") {
		    player2Score++;
	        label2Score.setText("Score: " + player2Score);
		}
		onGoing = false;
	}

	String checkResult(int index) {
		// in first 4 steps no-one can win
		if(moveCount<5)
			return "G";	// ongoing
		
		String checkParty = xTurn ? "X" : "O";
		
		// check row
		switch(index) {
		case 0:
			if((buttons[1].getText().equals(checkParty) && buttons[2].getText().equals(checkParty)) || 
			   (buttons[3].getText().equals(checkParty) && buttons[6].getText().equals(checkParty)) ||
			   (buttons[4].getText().equals(checkParty) && buttons[8].getText().equals(checkParty)) ) {
				// checkParty win!
				return checkParty;
			}
			break;

		case 1:
			if((buttons[0].getText().equals(checkParty) && buttons[2].getText().equals(checkParty)) || 
			   (buttons[4].getText().equals(checkParty) && buttons[7].getText().equals(checkParty)) ) {
				// checkParty win!
				return checkParty;
			}
			break;
		case 2:
			if((buttons[0].getText().equals(checkParty) && buttons[1].getText().equals(checkParty)) || 
			   (buttons[5].getText().equals(checkParty) && buttons[8].getText().equals(checkParty)) ||
			   (buttons[6].getText().equals(checkParty) && buttons[4].getText().equals(checkParty)) ) {
				// checkParty win!
				return checkParty;
			}
			break;
		case 3:
			if((buttons[4].getText().equals(checkParty) && buttons[5].getText().equals(checkParty)) || 
			   (buttons[0].getText().equals(checkParty) && buttons[6].getText().equals(checkParty)) ) {
				// checkParty win!
				return checkParty;
			}
			break;
		case 4:
			if((buttons[3].getText().equals(checkParty) && buttons[5].getText().equals(checkParty)) || 
			   (buttons[1].getText().equals(checkParty) && buttons[7].getText().equals(checkParty)) ||
			   (buttons[0].getText().equals(checkParty) && buttons[8].getText().equals(checkParty)) ||
			   (buttons[2].getText().equals(checkParty) && buttons[6].getText().equals(checkParty)) ) {
				// checkParty win!
				return checkParty;
			}
			break;
		case 5:
			if((buttons[3].getText().equals(checkParty) && buttons[4].getText().equals(checkParty)) || 
			   (buttons[2].getText().equals(checkParty) && buttons[8].getText().equals(checkParty)) ) {
				// checkParty win!
				return checkParty;
			}
			break;
		case 6:
			if((buttons[7].getText().equals(checkParty) && buttons[8].getText().equals(checkParty)) || 
			   (buttons[0].getText().equals(checkParty) && buttons[3].getText().equals(checkParty)) ||
			   (buttons[2].getText().equals(checkParty) && buttons[4].getText().equals(checkParty)) ) {
				// checkParty win!
				return checkParty;
			}
			break;
		case 7:
			if((buttons[6].getText().equals(checkParty) && buttons[8].getText().equals(checkParty)) || 
			   (buttons[1].getText().equals(checkParty) && buttons[4].getText().equals(checkParty)) ) {
				// checkParty win!
				return checkParty;
			}
			break;
		case 8:
			if((buttons[6].getText().equals(checkParty) && buttons[7].getText().equals(checkParty)) || 
			   (buttons[2].getText().equals(checkParty) && buttons[5].getText().equals(checkParty)) ||
			   (buttons[0].getText().equals(checkParty) && buttons[4].getText().equals(checkParty)) ) {
				// checkParty win!
				return checkParty;
			}
			break;

		default:
			// nothing to do - should not come to here
		}
		
		// check if the board is full
		if(moveCount >= ALL)
			return "T";
		else
			return "G";
	}
	
    public static void main(String[] args) {
        //Create and set up the window.
    	TicTacToe frame = new TicTacToe("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}