package bobman;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class Levels 
{
	private Player player1,player2;
	private Board board;
	private UserInterface Ui;
	private TreeMap<Integer,Tiles> tiles;
	private static final Set<Integer> playerSpace = new HashSet<Integer>(Arrays.asList(14,15,16,27,40,128,141,152,153,154));
	private int currentLevel;
	Random rand = new Random();
	private Collision collision;	
	
	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Levels(Board board, TreeMap<Integer,Tiles> tiles)
	{
		this.board = board;
		this.tiles = tiles;
	}
	
	public void initBaseLevel() throws IOException 
	{
		Tiles l;
		
		for( int i=0; i<169; i++)
		{
			l = tiles.get(i);
			l.setBackground(Color.white);
			l.removeAll();
			l.makeWalkable();
		}
		
		for( int i=0; i<169; i++)
		{
			l=tiles.get(i);
			if (l.getxPos() == 0 || l.getyPos() == 0
					|| l.getxPos() == 12 || l.getyPos()==12)
				{
					l.setBackground(Color.black);
					l.add(new Wall(l.getxPos(),l.getY(),
					l.getOrder()));
					l.notDestroyable();
					l.notWalkable();
					l.removeFloor();
					
				}
				else if (l.getxPos() % 2 == 0 && l.getyPos()% 2 == 0)
				{
					l.setBackground(Color.black);
					l.add(new Wall(l.getxPos(),l.getY(),
					l.getOrder()));
					l.notDestroyable();
					l.notWalkable();
					l.removeFloor();
				}
			
		}		
		
	}
	
	public void chooseLevel() throws IOException 
	{
		String[] options = new String[] {"Level one", "Level two", "Level three", "Quit"};
		currentLevel =  JOptionPane.showOptionDialog(board, "To start the game", "Please Choose level!",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[0]);
		sameLevel();
		
	}
	
	public void sameLevel() throws IOException
	{
		resetHp();
		switch(currentLevel)
		{
		case 0: levelOne();
		break;
		
		case 1: levelTwo();
		break;
		
		case 2: levelThree();
		break;
		
		case 3: System.exit(0);
		}
	}

	public void levelOne() throws IOException
	{
		player1 = new Player(tiles,board,board.getTimer2(),board.getTimer3(),1 ,3, 1, 1,  1, 0);
		player2 = new Player(tiles,board,board.getTimer2() ,board.getTimer3(),2 ,3, 11, 11, 1, 1);
		this.Ui = new UserInterface(player1,player2);
		this.board.addKeyListener(Ui);
		this.board.setFocusable(true);
		this.board.requestFocus();
		this.board.getPlayer1().setText(this.board.getPlayer1().getText() + player1.getHp());
		this.board.getPlayer2().setText(this.board.getPlayer2().getText() + player2.getHp());
		Set<Integer> used = new HashSet<Integer>();
		int randomnumber;
		int enoughDWalls = 0;
		Tiles p;
		while(enoughDWalls < 60)
		{
			randomnumber = rand.nextInt(169);
			if (playerSpace.contains(randomnumber))
			{
				continue;
			}
			
			p = tiles.get(randomnumber);
			if (p.isDestroyable())
			{
				if(!(used.contains(p.getOrder())))
				{
					used.add(p.getOrder());
					p.removeFloor();
					p.add(new Dwall(p.getxPos(),p.getY(),p.getOrder()));
					p.setBackground(Color.black);
					p.notWalkable();
					enoughDWalls++;
				}
				
			}

		}	
		p = tiles.get(14);
		p.add(player1);
		p = tiles.get(154);
		p.add(player2);
		collision = new Collision(this);
		board.repaint();
		board.setVisible(true);
	}
	
	public Collision getCollision() {
		return collision;
	}

	public void setCollision(Collision collision) {
		this.collision = collision;
	}

	public void levelTwo()
	{
		System.out.println("level2");
		//Teleport
	}
	
	public void levelThree()
	{
		Tiles p;
		player1 = new Player(tiles,board,board.getTimer2(),board.getTimer3(),1 ,3, 1, 1,  1, 0);
		player2 = new Player(tiles,board,board.getTimer2() ,board.getTimer3(),2 ,3, 11, 11, 1, 1);;
		this.Ui = new UserInterface(player1,player2);
		this.board.addKeyListener(Ui);
		this.board.setFocusable(true);
		this.board.requestFocus();
		this.board.getPlayer1().setText(this.board.getPlayer1().getText() + player1.getHp());
		this.board.getPlayer2().setText(this.board.getPlayer2().getText() + player2.getHp());
		
		p = tiles.get(14);
		p.add(player1);
		p = tiles.get(154);
		p.add(player2);
		collision = new Collision(this);
		board.repaint();
		board.setVisible(true);
		/*
		 * tom map spelare ska ha full kraft oavsett karaktär
		 */
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public void removeListener()
	{
		board.removeKeyListener(Ui);
	}
	
	public void resetHp ()
	{
		this.board.getPlayer1().setText("P1 life: ");
		this.board.getPlayer2().setText("P2 life: ");
	}
}
