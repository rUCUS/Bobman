package bobman;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TreeMap;

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
	private Bomb bomb;
	private Graphics g;
	private JPanel startMenu,gameBoard;
	private JSplitPane split;
	private JButton button1,button2,button3,button4;
	private TreeMap<Integer,Tiles> tiles;
	private Levels levels;
	private Timer timer = new Timer(1000,this);
	Random rand = new Random();
	int r,currentLevel;
	public Board()
	{ 	
		super();
		this.setDefaultCloseOperation(Board.EXIT_ON_CLOSE);
		bomb = new Bomb(1);
		tiles = new TreeMap<>();
		levels = new Levels(this,tiles);

		gameMenu = new GameMenu(this,levels);
		
		
		initStartmenu();
		initBoard();
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, startMenu,gameBoard);
		this.getContentPane().add(split);
		this.setVisible(true);
		this.setSize(800, 800);
		timer.start();
		
		
		
		
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
	
	public void initBoard() 
	{
		gameBoard = new JPanel();
		gameBoard.setLayout(new GridLayout(13,13));
		Tiles k;
		for( int i=0; i<169; i++)
		{
			gameBoard.add(k =new Tiles(i%13,i/13,i));
			k.setBackground(Color.white);
			tiles.put(i, k);
			if (k.getxPos() == 0 || k.getyPos() == 0
				|| k.getxPos() == 12 || k.getyPos()==12)
			{
				k.setBackground(Color.black);
				k.add(new Wall(k.getxPos(),k.getY(),
				k.getOrder()));
				
			}
			else if (k.getxPos() % 2 == 0 && k.getyPos()% 2 == 0)
			{
				k.setBackground(Color.black);
				k.add(new Wall(k.getxPos(),k.getY(),
				k.getOrder()));
			}
			
		}
		/*skapar en metod till som gör samma sak förutom att den ej får skapa om väggarna,tiles och allt annat
		 * för det gör så att jag överbelastar i onöden med att lägga en jpanel över en jpanel varje gång jag kör
		 * en ny spel. La allt i en ny klassmetod Levels så att det ser finare ut och mer orginiserat samt så har
		 * jag försökt gruppera om till mindre metoder. 
		 */
		
		levels.initBaseLevel();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		update();
		if (e.getSource() == button1)
			
		{
			gameMenu.newGame();
			
		}
		
		if (e.getSource() == button2)
		{
			gameMenu.restart();
			
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
		
		/* ANVÄNDS FÖR ATT TESTA OM MINA KNAPPAR I STARTMENU FUNGEAR
		 * TILLS JAG HAR IMPLEMENTERAT SPELET.
		 */
		r = rand.nextInt(8) + 100;
		Tiles k = tiles.get(r);
		k.setBackground(Color.blue);
		this.repaint();
		
	}
	
	public void skapaSpelare1(){
		ImageIcon player = new ImageIcon("Desktop/Firefox_wallpaper.png");
		Image player1 = player.getImage();
	}
	
	public void pauseTheGame()
	{
		timer.stop();
		JOptionPane.showMessageDialog(null, "you have paused the game");
		button4.setText("resume");
		
	}

	public void startTheGame() 
	{
		timer.start();
		button4.setText("Pause");
		
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	
	


}