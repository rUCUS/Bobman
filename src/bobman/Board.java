package bobman;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import javafx.scene.shape.Circle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


@SuppressWarnings("unused")
public class Board  extends JFrame implements ActionListener{

	private static final long serialVersionUID = -2926933215387776929L;
	private GameMenu gameMenu;
	private Graphics g;
	private JPanel startMenu,gameBoard;
	private JSplitPane split;
	private JButton button1,button2,button3,button4;
	private JLabel player1, player2;
	private TreeMap<Integer,Tiles> tiles;
	private Levels levels;
	private Timer timer1,timer2,timer3,timer4,timer5;
	private float wastetime1,wastetime2,wastetime3;
	private Tiles resetTile1,resetTile2;
	private BombExplode bombExplode;
<<<<<<< Updated upstream
	private float wastetime4;
=======
	

	



>>>>>>> Stashed changes
	Random rand = new Random();
	
	private ClockD clock;
    private boolean clockRunning = false;
    private TimerThread timerThread;
    private JButton buttonTimer;
	
	
	
	
	public Board() throws IOException
	{ 	
		super();
		this.setDefaultCloseOperation(Board.EXIT_ON_CLOSE);
		timer1= new Timer(20,this);
		timer2 = new Timer(1000,this);
		timer3 = new Timer(1000,this); 
		timer4 = new Timer(1000,this);
		timer5 = new Timer(1000,this);
		tiles = new TreeMap<>();
		levels = new Levels(this,tiles);
		gameMenu = new GameMenu(this,levels);
		bombExplode = new BombExplode(tiles,this);
<<<<<<< Updated upstream
		clock = new ClockD();
=======
		
		
		
>>>>>>> Stashed changes
		initStartmenu();
		initBoard();
		
		
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, startMenu,gameBoard);
		this.getContentPane().add(split);
		this.pack();
		this.setVisible(true);
		timer1.start();
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
	//////// Init
	
	public void initStartmenu() 
	{
		
		startMenu = new JPanel();
		startMenu.setBackground(Color.black);
		player1 = new JLabel("P1 life: ",JLabel.LEFT);
		player1.setForeground(Color.white);
		startMenu.add(player1);
		player2 = new JLabel("P2 life: ",JLabel.RIGHT);
		player2.setForeground(Color.white);
		startMenu.add(player2);
		button1 = new JButton("New Game");
		button1.addActionListener(this);
		startMenu.add(button1);
		button1.setBackground(Color.white);	
		button2 = new JButton("Restart");
		button2.addActionListener(this);
		startMenu.add(button2);
		button2.setBackground(Color.white);
		button3 = new JButton("Quit");
		button3.addActionListener(this);
		startMenu.add(button3);
		button3.setBackground(Color.white);
		button4 = new JButton("Pause");
		button4.addActionListener(this);
		startMenu.add(button4);
		button4.setBackground(Color.white);
		buttonTimer = new JButton("00:00");
		startMenu.add(buttonTimer);
		buttonTimer.setBackground(Color.lightGray);
	}
	
	public void initBoard() throws IOException 
	{	
		setTitle("Bobman");
		gameBoard = new JPanel();
		gameBoard.setLayout(new GridLayout(13,13));
		Tiles k;
		for( int i=0; i<169; i++)
		{
			gameBoard.add(k =new Tiles(i%13,i/13,i));
			tiles.put(i, k);
		}
		levels.initBaseLevel();
		
	}

	///////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
	//////// Avsluta bomb samt elden
	public void clockStarter() {
		startClock();
	}
	
	public void clockStop() {
		stopClock();
	}
	
	public void resetClock(){
		stopClock();
		clock.reset();
		buttonTimer.setText("00:00");
	}
	
	//klockmetoder
	 private void startClock()
	    {
	        clockRunning = true;
	        timerThread = new TimerThread();
	        timerThread.start();
	    }
	 
	 
	 private void stopClock()
	    {
	        clockRunning = false;
	    }
	 
	 
	 private void stepClock()
	    {
	        clock.timeTick();
	        buttonTimer.setText(clock.getTime());
	    }
	////slut på klockmetoder
	 
	 
	private void resetWalkable3() 
	{
		resetTile1.makeWalkable();
		resetTile1.removeAll();
		bombExplode.BombExploded(resetTile1,1);
		
	}
	
	private void resetWalkable4() 
	{
		resetTile2.makeWalkable();
		resetTile2.removeAll();
		bombExplode.BombExploded(resetTile2,2);
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
	////////Setters and getters
	
	public Timer getTimer2() 
	{
		return timer2;
	}



	public void setTimer2(Timer timer2) 
	{
		this.timer2 = timer2;
	}

	public Timer getTimer3() 
	{
		return timer3;
	}



	public void setTimer3(Timer timer3) 
	{
		this.timer3 = timer3;
	}
	
	public float getWastetime1() {
		return wastetime1;
	}

	public void setWastetime1(float wastetime1) {
		this.wastetime1 = wastetime1;
	}

	public float getWastetime2() {
		return wastetime2;
	}

	public void setWastetime2(float wastetime2) {
		this.wastetime2 = wastetime2;
	}

	public float getWastetime3() {
		return wastetime3;
	}

	public void setWastetime3(float wastetime3) {
		this.wastetime3 = wastetime3;
	}

	public Tiles getResetTile1() {
		return resetTile1;
	}

	public void setResetTile1(Tiles resetTile1) {
		this.resetTile1 = resetTile1;
	}

	public Tiles getResetTile2() {
		return resetTile2;
	}

	public void setResetTile2(Tiles resetTile2) {
		this.resetTile2 = resetTile2;
	}

	public float getWastetime4() {
		return wastetime4;
	}

	public void setWastetime4(float wastetime4) {
		this.wastetime4 = wastetime4;
	}
	
<<<<<<< Updated upstream
	public JLabel getPlayer1() 
	{
		return player1;
	}

	public void setPlayer1(JLabel player1) {
		this.player1 = player1;
	}

	public JLabel getPlayer2() {
		return player2;
	}

	public void setPlayer2(JLabel player2) {
		this.player2 = player2;
	}
	
=======
	public Levels getLevels() {
		return levels;
	}

	public void setLevels(Levels levels) {
		this.levels = levels;
	}

>>>>>>> Stashed changes

	////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	/////// Start and Pause the Game
	
	
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
	public void pauseTheGame()
	{
		timer1.stop();
		JOptionPane.showMessageDialog(null, "you have paused the game");
		button4.setText("resume");
		//try {
			//TimeUnit.SECONDS.sleep(1);
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
		//}
		
	}

	public void startTheGame() 
	{
		timer1.start();
		button4.setText("Pause");
		
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////
	//////// ActionListener
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		update();
		
		if(timer2.isRunning())
		{
			wastetime1= wastetime1 +0.2f;
			if (wastetime1 >= 15.0f)
			{
				resetWalkable3();
				timer2.stop();
				wastetime1 =0f;
			}
		}
		
		if(timer3.isRunning())
		{
			wastetime2= wastetime2 +0.2f;
			if (wastetime2 >= 15.0f)
			{
				
				resetWalkable4();
				timer3.stop();
				wastetime2 =0f;
			}
		}
		
		
		if (e.getSource() == button1)
			
		{
			try {
				gameMenu.newGame();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if (e.getSource() == button2)
		{
			try {
				gameMenu.restart();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
		if (e.getSource() == button3)
		{
			gameMenu.Quit();
			
		}
		
		if (e.getSource() == button4)
		{
			gameMenu.Pause();
			
		}
	}
	
	

	private void update() 
	{	
		this.repaint();
		this.setVisible(true);
	}
	
	class TimerThread extends Thread
    {
        public void run()
        {
            while (clockRunning) {
                stepClock();
                pauseClock();
            }
        }
        
        private void pauseClock()
        {
            try {
                Thread.sleep(1000);   // pause for 300 milliseconds
            }
            catch (InterruptedException exc) {
            }
        }
    }

	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	

}