/*
 * GUI template: to create a GUI use this template and follow the steps they are numbered
 * Author:  Boutanos
 * November 24, 2011
 */
 
 
import javax.swing.*;
import java.awt.event.*;  
import java.util.Random;


//Make sure the name of the class is the same as the .java file name.
//If you change the class name you should change the class object name in runGUI method
public class GuiButtonIconBox implements ActionListener {
 
 //#### STEP 1 ####
 //declare all GUI compnents variables
 //Follow a naming convesion
  //to add more variables just add , followed by the variable name
  JFrame frame;          //Jframe varaible 
  JPanel contentPane;    //Jpanel varaible
  JLabel lblLabel1;      //Lables
  JButton btnButton1;     //Buttons
  JButton btnButton2;     //Buttons
  JTextField txtText1;  //Text fields 
  Icon imgicon = new ImageIcon("saveIcon.JPG");

  
  //to adjust the frame size chang ethe valuse in pixels
  int width = 600;
  int length = 400;
  int MyScore =0;
  int OppScore = 0;
  
  Random generator = new Random(); // generates random number from 1 - 3
  int opponent = 0;   //  generator.nextInt(3)+1;
  
  
  //Here you can more global variables if needed
  String textLabel = "Hello World";                     
  
  /* In this method this where you want to initialize all the frame, buttons, etc 
   * 
   * */
  public GuiButtonIconBox(){
    /* Create and set up the frame 
     * you can change the frame title*/
    frame = new JFrame("Frame Title");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    /* Create a content panel */
    contentPane = new JPanel();
    //contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.PAGE_AXIS));  //box laywout, Grid layout
    //contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.LINE_AXIS));
    contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.X_AXIS ));
    //contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS ));
    contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
    //#### STEP 2 ####        
    //Create and add compnents (labels, buttons, txt fields) to the panel
    //Compnents will shos in the order you create them
    
    /* Create and add label Hello Wrold to create will be displayed to the screen */
    lblLabel1 = new JLabel(textLabel);
    //lblLabel1 = new JLabel("Hello World");   //to hard code the text 
    //lblLabel1.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    //lblLabel1.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
    // any time you create the variable you have to added to the Panel
    contentPane.add(lblLabel1);     
    
    
    /*Create a text box*/
    txtText1 = new JTextField();
    //txtText1.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    //txtText1.setBorder(BorderFactory.createEmptyBorder(100, 50, 20, 50));
    contentPane.add(txtText1);
    //name.setVisible(false); //you can chose to set to visibale or hide any time by changing from true to false
    
    
    
    /* Create and add buttons Hello World will be displayed to the screen */
    btnButton1 = new JButton("Hide");  // Click here will appear as text on the button
    //btnButton1.setAlignmentX(JButton.CENTER_ALIGNMENT);
    btnButton1.setIcon(imgicon);
    btnButton1.setActionCommand("CLICK");    ///This the action label it helps the action listner to
    //identify which button was clicked
    btnButton1.addActionListener(this);      //add this button to the lsitner  
    //any time you create the variable you have to added to the Panel
    contentPane.add(btnButton1);  
    
    btnButton2 = new JButton("Display");  // Click here will appear as text on the button
    //btnButton1.setAlignmentX(JButton.CENTER_ALIGNMENT);
    btnButton2.setIcon(imgicon);
    btnButton2.setActionCommand("CLICK");    ///This the action label it helps the action listner to
    //identify which button was clicked
    btnButton2.addActionListener(this);      //add this button to the lsitner  
    //any time you create the variable you have to added to the Panel
    contentPane.add(btnButton2);  
      
       
    
    /* Add content pane to frame */
    frame.setContentPane(contentPane);
    /* Size and then display the frame. */
    frame.pack();
    frame.setSize(width,length);
    frame.setVisible(true);
  }
  
  /*/#### STEP 3 ####   
   * Handle button click action event
   * pre: none
   * post: Clicked button has different text and label
   * displays message depending on when the button was clicked.
   */
  public void actionPerformed(ActionEvent event) {
    String eventName = event.getActionCommand();
     if (eventName.equals("CLICK")) {
      if (btnButton1.getText().equals("Hide")){
        lblLabel1.setText(" ");   //set text to nothing 
        txtText1.setText("Empty");
        //lblLabel1.setVisible(false); //or you can use set visible
        btnButton1.setText("Show");
        txtText1.enable(false);
        lblLabel1.setVisible(false);
        //btnButton1.setActionCommand("Show");   change the action title
      } else {
        lblLabel1.setText(textLabel);
        txtText1.setText("Type anything");
        btnButton1.setText("Hide");
        txtText1.enable(true);
        lblLabel1.setVisible(true);
        //lblLabel1.setVisible(true)
        //btnButton1.setActionCommand("Hide");
      }
    }
  
  }
  //#### STEP 3 ####  
  /**
   * Create and show the GUI.
   */
  private static void runGUI() {
    JFrame.setDefaultLookAndFeelDecorated(true);
    //if you change the class name you should change the class name
    //class name    //object name      //class name
    GuiButtonIconBox        greeting     = new GuiButtonIconBox();
  }
  
  
  
  //Do not change this method
  public static void main(String[] args) {
    /* Methods that create and show a GUI should be run from an event-dispatching thread */
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        runGUI();
      }
    });
  }
}