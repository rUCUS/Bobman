package bobman;
import java.util.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.Timer;

/*
 * This class is used to generate our gameboard along with all
 * of its features such as players, time, gamemenu etc
 * 
 * @author Liban Aden, Danny Lam, Hamza Kadric, Mehdi Adelzadeh
 * @version 2016-03-02
 */


public class Board  extends JFrame implements ActionListener
{

	private static final long serialVersionUID = -2926933215387776929L;
	private GameMenu gameMenu;
	private JPanel startMenu,gameBoard;
	private JSplitPane split;
	private JButton button1,button2,button3,button4,buttonTimer;
	private JLabel player1, player2;
	private TreeMap<Integer,Tiles> tiles;
	private Levels levels;
	private Timer timer;
	private float wastetime1,wastetime2;
	private Tiles resetTile1,resetTile2;
	private BombExplode bombExplode;
	private ClockD clock;
	private int timeWaster;
	private int rucus1;
	private int rucus;

    
	
	
	public Board() throws IOException
	{ 	
		super();
		this.setDefaultCloseOperation(Board.EXIT_ON_CLOSE);
		timer= new Timer(1,this);
		tiles = new TreeMap<>();
		levels = new Levels(this,tiles);
		gameMenu = new GameMenu(this,levels);
		bombExplode = new BombExplode(this,tiles);
		clock = new ClockD(this);

		initStartmenu();
		initBoard();
		
		
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, startMenu,gameBoard);
		this.getContentPane().add(split);
		this.pack();
		this.setVisible(true);
		timer.start();
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	/*
	 * 
	 * initialize our startmenu 
	 *
	 */
	
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
	
	/*
	 * intialize our board
	 * 
	 */
	
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



	/*
	 * this applies for player 1
	 * This method clears the bomb and generates fire and makes
	 * the tile that the bomb appeared on walkable
	 * 
	 */
	
	 
	 
	private void resetWalkable3() 
	{
		resetTile1.makeWalkable();
		resetTile1.removeAll();
		bombExplode.BombExploded(resetTile1,1);
		
	}
	
	/* this applies for player 2
	 * This method clears the bomb and generates fire and makes
	 * the tile that the bomb appeared on walkable
	 * 
	 */
	
	private void resetWalkable4() 
	{
		resetTile2.makeWalkable();
		resetTile2.removeAll();
		bombExplode.BombExploded(resetTile2,2);
		
	}
	
	
	
	
	
	/*
	 * @returns the games menu.
	 */
	
	public GameMenu getGameMenu() {
		return gameMenu;
	}
	
	/*
	 * @returns the class that handles explosions.
	 */

	public BombExplode getBombExplode() {
		return bombExplode;
	}
	
	

	public void setBombExplode(BombExplode bombExplode) {
		this.bombExplode = bombExplode;
	}
	
	/*
	 * @returns the time variable for player2's bombs
	 */

	public int getRucus1() {
		return rucus1;
	}

	/*
	 * @ sets a new time variable for player2's bombs
	 * @param rucus1
	 */
	
	public void setRucus1(int rucus1) {
		this.rucus1 = rucus1;
	}
	
	/*
	 * @returns the time variable for player1's bombs
	 */

	public int getRucus() {
		return rucus;
	}

	/*
	 * sets a new time variable for player1's bombs
	 * @param rucus
	 */
	
	public void setRucus(int rucus) {
		this.rucus = rucus;
	}

	/*
	 * sets a new game menu
	 * @param gameMenu
	 */
	
	public void setGameMenu(GameMenu gameMenu) {
		this.gameMenu = gameMenu;
	}
	
	/*
	 * time delay for player1's bomb explosion
	 * @return wastetime1
	 */
	
	public float getWastetime1() {
		return wastetime1;
	}
	
	/*
	 * sets a new delay for player1's bomb to explode
	 * @param wastetime1
	 */

	public void setWastetime1(float wastetime1) {
		this.wastetime1 = wastetime1;
	}
	
	/*
	 * time delay for player2's bomb explosion
	 * @return wastetime2
	 */

	public float getWastetime2() {
		return wastetime2;
	}
	
	/*
	 * sets a new delay for player2's bomb to explode
	 * @param wastetime2
	 */

	public void setWastetime2(float wastetime2) {
		this.wastetime2 = wastetime2;
	}

	/*
	 * resets a specific tile where the bomb was laid on for player1
	 * @returns resetTile1
	 */

	public Tiles getResetTile1() {
		return resetTile1;
	}

	/*
	 * sets a new tile for the given position for player1
	 * @param resetTile1
	 */
	
	public void setResetTile1(Tiles resetTile1) {
		this.resetTile1 = resetTile1;
	}
	
	/*
	 * resets a specific tile where the bomb was laid on for player2
	 * @returns resetTile1
	 */

	public Tiles getResetTile2() {
		return resetTile2;
	}
	
	/*
	 * sets a new tile for the given position for player2
	 * @param resetTile2
	 */

	public void setResetTile2(Tiles resetTile2) {
		this.resetTile2 = resetTile2;
	}


	/*
	 * returns the amount of life for player1
	 * @returns player1
	 */
	
	public JLabel getPlayer1() 
	{
		return player1;
	}
	
	/*
	 * sets the amount of life for player1
	 * @param player1
	 */

	public void setPlayer1(JLabel player1) {
		this.player1 = player1;
	}
	
	/*
	 * returns the amount of life for player2
	 * @returns player2
	 */
	

	public JLabel getPlayer2() {
		return player2;
	}

	/*
	 * sets the amount of life for player2
	 * @param player2
	 */

	
	public void setPlayer2(JLabel player2) {
		this.player2 = player2;
	}
	
	/*
	 * returns the level
	 * @returns levels
	 */
	

	public Levels getLevels() {
		return levels;
	}
	
	/*
	 * sets level
	 * @param levels
	 */

	public void setLevels(Levels levels) {
		this.levels = levels;
	}
	
	/*
	 * returns a button with a time-text
	 * @returns buttonTimer
	 */
	
	public JButton getButtonTimer() {
		return buttonTimer;
	}
	
	/*
	 * sets our button
	 * @param buttonTimer
	 */

	public void setButtonTimer(JButton buttonTimer) {
		this.buttonTimer = buttonTimer;
	}
	
	/*
	 * returns our clock
	 * @returns clock
	 */
	
	public ClockD getClock() {
		return clock;
	}
	
	/*
	 * sets the clock
	 * @param clock
	 */

	public void setClock(ClockD clock) {
		this.clock = clock;
	}
	

	/*
	 * this method pauses the time and the game
	 */

	public void pauseTheGame()
	{
		timer.stop();
		JOptionPane.showMessageDialog(null, "you have paused the game");
		button4.setText("resume");
		
	}
	
	/*
	 * starts the time and the game
	 */

	public void startTheGame() 
	{
		timer.start();
		button4.setText("Pause");
		
	}	

	/*
	 * this method check which of our option is choosen
	 * and performs a certain operation
	 */
	
	public void actionPerformed(ActionEvent e) 
	{
		try {
			update();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		if(wastetime1 >=10f)
		{
			wastetime1= wastetime1 +0.2f;
			if (wastetime1 >= 100.0f)
			{
				resetWalkable3();
				//timer2.stop();
				wastetime1 =0f;
			}
		}
		
		if(wastetime2 >=10f)
		{
			wastetime2= wastetime2 +0.2f;
			if (wastetime2 >= 100.0f)
			{
				
				resetWalkable4();
				//timer3.stop();
				wastetime2 =0f;
			}
		}
		

		if (rucus > 0)
		{
			rucus++;
			if (rucus >= 100)
			{
				bombExplode.fireReset1();
				rucus =0;
			}
			
		}
		
		if (rucus1 > 0)
		{
			rucus1++;
			if (rucus1 >=100)
			{
				bombExplode.fireReset2();
				rucus1 = 0;
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
	
	/*
	 * this method ticks the timer and repaints our board
	 * it also checks if there is a winner (checkStatus)
	 */

	private void update() throws IOException 

	{	
		timeWaster = timeWaster + 1;
		if (this.timeWaster == 300)
		{
			this.clock.stepClock();
			timeWaster = 0;
		}

		levels.checkStatus();
		this.repaint();
		this.setVisible(true);
	}
	

}