package bobman;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javafx.scene.shape.Circle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("unused")
public class Board  extends JFrame implements ActionListener{

	private static final long serialVersionUID = -2926933215387776929L;
	private Player player;
	private Game game;
	private Bomb bomb;
	private Graphics g;
	private JPanel startMenu,gameBoard;
	private JSplitPane split;
	private JButton button1,button2,button3,button4;
	private TreeMap<Integer,Tiles> tiles;
	public Board()
	{ 	
		super();
		bomb = new Bomb(1);
		game = new Game();
		tiles = new TreeMap<>();
		player = new Player(100,10,10,bomb,1);
		this.setDefaultCloseOperation(Board.EXIT_ON_CLOSE);
		JPanel startMenu = new JPanel();
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
		gameBoard = new JPanel();
		gameBoard.setLayout(new GridLayout(29,29));
		gameBoard.setBackground(Color.black);
		Tiles k;
		for( int i=0; i<841; i++)
		{
			gameBoard.add(k =new Tiles(i%29,i/29,i));
			tiles.put(i, k);
			if (k.getxPos() == 0 || k.getyPos() == 0 
					|| k.getxPos() == 28 || k.getyPos()==28
					|| k.getxPos() == 27 || k.getyPos()== 27)
			{
				k.setBackground(Color.black);
				k.add(new Wall(k.getxPos(),k.getY(),
				k.getOrder()));
				
			}
			else if (k.getxPos() % 4 == 0 && k.getyPos()% 4 == 0)
			{
				k.setBackground(Color.black);
				k.add(new Wall(k.getxPos(),k.getY(),
				k.getOrder()));
				if(i>1)
				{
					k = tiles.get(i-1);
					k.setBackground(Color.black);
					k.add(new Wall(k.getxPos(),k.getY(),
					k.getOrder()));
				}
				if(i>25)
				{
					
				
					k = tiles.get(i-29);
					k.setBackground(Color.black);
					k.add(new Wall(k.getxPos(),k.getY(),
					k.getOrder()));
				}
				if(i>26)
				{
					k = tiles.get(i-30);
					k.setBackground(Color.black);
					k.add(new Wall(k.getxPos(),k.getY(),
				    k.getOrder()));
				}
			}
			
		}
		
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, startMenu,gameBoard);
		this.getContentPane().add(split);
		this.setVisible(true);
		this.setSize(800, 800);
		
		Timer timer = new Timer(1000,this);
		timer.start();
		
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		update();
		if (e.getSource() == button1)
		{
			game.newGame();
			
		}
		
		if (e.getSource() == button2)
		{
			game.restart();
			
		}
		
		if (e.getSource() == button3)
		{
			game.Quit();
			
		}
		
		if (e.getSource() == button4)
		{
			game.Pause();
			
		}
	}
	private void update() 
	{
		this.repaint();
		
	}
	
	public void skapaSpelare1(){
		ImageIcon player = new ImageIcon("Desktop/Firefox_wallpaper.png");
		Image player1 = player.getImage();
	}
	


}