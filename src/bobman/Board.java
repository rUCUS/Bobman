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
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("unused")
public class Board  extends JFrame implements ActionListener{

	private static final long serialVersionUID = -2926933215387776929L;
	private Player player;
	private GameMenu gameMenu;
	private Graphics g;
	private JPanel startMenu,gameBoard;
	private JSplitPane split;
	private JButton button1,button2,button3,button4;
	private TreeMap<Integer,Tiles> tiles;
	private Levels levels;
	private Timer timer1,timer2,timer3,timer4;
	private float wastetime1,wastetime2,wastetime3;
	private Tiles resetTile1,resetTile2;
	private BombExplode bombExplode;
	

	Random rand = new Random();	
	public Board() throws IOException
	{ 	
		super();
		this.setDefaultCloseOperation(Board.EXIT_ON_CLOSE);
		timer1= new Timer(20,this);
		timer2 = new Timer(1000,this);
		timer3 = new Timer(1000,this); 
		timer4 = new Timer(1000,this);
		tiles = new TreeMap<>();
		levels = new Levels(this,tiles);
		gameMenu = new GameMenu(this,levels);
		bombExplode = new BombExplode(tiles,this,timer4);
		
		
		initStartmenu();
		initBoard();
		
		
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, startMenu,gameBoard);
		this.getContentPane().add(split);
		this.pack();
		this.setVisible(true);
		timer1.start();
		setLocationRelativeTo(null);
		//setResizable(false);
		
		
		
	}
	


	public void initStartmenu() 
	{
		startMenu = new JPanel();
		button1 = new JButton("New Game");
		button1.addActionListener(this);
		startMenu.add(button1);
		button2 = new JButton("Restart");
		button2.addActionListener(this);
		startMenu.add(button2);
		button3 = new JButton("Quit");
		button3.addActionListener(this);
		startMenu.add(button3);
		button4 = new JButton("Pause");
		button4.addActionListener(this);
		startMenu.add(button4);
		
	}
	
	public void initBoard() throws IOException 
	{
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


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		update();
		
		if(timer2.isRunning())
		{
			wastetime1 = wastetime1 +0.2f;
			if (wastetime1 >= 21.0f)
			{
				resetWalkable3();
				timer2.stop();
			}
		}
		
		if(timer3.isRunning())
		{
			wastetime2 = wastetime2 +0.2f;
			if (wastetime2 >= 21.0f)
			{
				resetWalkable4();
				timer3.stop();
			}
		}
		
		if(timer4.isRunning())
		{
			wastetime3 = wastetime3 +0.2f;
			if (wastetime3 >= 21.0f)
			{
				bombExplode.resetfire();
				timer4.stop();
				wastetime3 = 0;
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
				// TODO Auto-generated catch block
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

	public void resetWalkable(Tiles k, int id)
	
	{
		if (id == 1)
		{
			resetWalkable1(k);
		}
		else if (id == 2)
		{
			resetWalkable2(k);
		}
	}

	public void resetWalkable1(Tiles k) 
	{
		timer2.start();
		resetTile1 = k; 
		wastetime1 = 0f;
		
	}
	
	public void resetWalkable2(Tiles k) 
	{
		timer3.start();
		resetTile2 = k; 
		wastetime2 = 0f;
		
	}
	
	private void resetWalkable3() 
	{
		resetTile1.makeWalkable();
		resetTile1.removeAll();
		bombExplode.BombExploded(resetTile1);
		
	}
	
	private void resetWalkable4() 
	{
		resetTile2.makeWalkable();
		resetTile2.removeAll();
		bombExplode.BombExploded(resetTile2);
		
	}



	private void update() 
	{	
		
		this.repaint();
		this.setVisible(true);
	}
	
	public void test()
	{
		int r = rand.nextInt(169);
		Tiles k = tiles.get(r);
		k.removeFloor();
		this.setVisible(true);
	}
	
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

}