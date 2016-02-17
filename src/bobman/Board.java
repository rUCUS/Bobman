package bobman;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.shape.Circle;

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
	public Board()
	{ 	
		super();
		bomb = new Bomb(1);
		game = new Game();
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
		gameBoard.setLayout(new GridLayout(13,13,1,1));
		gameBoard.setBackground(Color.black);
		Tiles onlyForTheLoop;
		for( int i=0; i<169; i++)
		{
			gameBoard.add(onlyForTheLoop =new Tiles(i%13,i/13,i));
			if (onlyForTheLoop.getxPos() == 0 || onlyForTheLoop.getyPos() == 0 
					|| onlyForTheLoop.getxPos() == 12 || onlyForTheLoop.getyPos()==12)
			{
				onlyForTheLoop.setBackground(Color.black);
			}
			else if(onlyForTheLoop.getxPos() % 2 == 0 && onlyForTheLoop.getyPos()% 2 == 0)
			{
				onlyForTheLoop.setBackground(Color.black);
			}
			
		
		}
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, startMenu,gameBoard);
		this.getContentPane().add(split);
		this.setVisible(true);
		
		Timer timer = new Timer(1000,this);
		timer.start();
		this.pack();
		
		
		
		
		
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
	


}