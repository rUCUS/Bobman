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
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("unused")
public class Board  extends JFrame implements ActionListener{

	private static final long serialVersionUID = -2926933215387776929L;
	private Player player;
	private Game game;
	private Bomb bomb;
	private Graphics g;
	private JPanel PGround;
	private Container cunt;
	private JButton button1,button2,button3,button4;
	public Board()
	{ 	
		super();
		bomb = new Bomb(1);
		game = new Game();
		player = new Player(100,10,10,bomb,1);
		this.setDefaultCloseOperation(Board.EXIT_ON_CLOSE);
		JPanel pGround = new JPanel();
		button1 = new JButton("New Game");
		button1.addActionListener(this);
		pGround.add(button1);
		button2 = new JButton("Restart");
		button2.addActionListener(this);
		pGround.add(button2);
		button3 = new JButton("Quit");
		button3.addActionListener(this);
		pGround.add(button3);
		button4 = new JButton("Pause");
		button4.addActionListener(this);
		pGround.add(button4);
		this.add(pGround);
		cunt = this.getContentPane();
		cunt.setLayout(new GridLayout(4,4,1,1));
		cunt.setBackground(Color.yellow);
		this.pack();
		this.setVisible(true);
		Timer timer = new Timer(500,this);
		timer.start();
		
		
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		update();
		this.pack();
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
		System.out.println("ugly mehdi");
		this.repaint();
		
	}
	


}