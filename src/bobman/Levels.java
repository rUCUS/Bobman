package bobman;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JOptionPane;

/**
 * this class creates our three levels
 * each has different attributes to them
 * 
 * @author Liban Mukthar Aden
 * @version 2016-02-29
 */

public class Levels 
{
	/**
	 * @uml.property  name="player1"
	 * @uml.associationEnd  
	 */
	private Player player1;
	/**
	 * @uml.property  name="player2"
	 * @uml.associationEnd  
	 */
	private Player player2;
	/**
	 * @uml.property  name="board"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="levels:bobman.Board"
	 */
	private Board board;
	/**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  
	 */
	private UserInterface Ui;
	/**
	 * @uml.property  name="tiles"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer bobman.Tiles"
	 */
	private TreeMap<Integer,Tiles> tiles;
	private static final Set<Integer> playerSpace = new HashSet<Integer>(Arrays.asList(14,15,16,27,40,128,141,152,153,154));
	/**
	 * @uml.property  name="currentLevel"
	 */
	private int currentLevel;
	/**
	 * @uml.property  name="powers"
	 */
	private int powers;
	/**
	 * @uml.property  name="rand"
	 */
	Random rand = new Random();
	/**
	 * @uml.property  name="collision"
	 * @uml.associationEnd  
	 */
	private Collision collision;
	
	
	public Levels(Board board, TreeMap<Integer,Tiles> tiles)
	{
		this.board = board;
		this.tiles = tiles;
	}
	
	/**
	 * returns our collision control
	 * @return  collision
	 * @uml.property  name="collision"
	 */
	
	public Collision getCollision() {
		return collision;
	}
	
	/**
	 * sets our collision
	 * @param  collision
	 * @uml.property  name="collision"
	 */

	public void setCollision(Collision collision) {
		this.collision = collision;
	}
	
	/**
	 * returns our player1
	 * @return  player1
	 * @uml.property  name="player1"
	 */

	public Player getPlayer1() {
		return player1;
	}
	
	/**
	 * sets our player1
	 * @param  player1
	 * @uml.property  name="player1"
	 */

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	

	/**
	 * returns our player2
	 * @return  player2
	 * @uml.property  name="player2"
	 */

	public Player getPlayer2() {
		return player2;
	}
	
	/**
	 * sets our player2
	 * @param  player2
	 * @uml.property  name="player2"
	 */

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	/**
	 * the method creates/initialize our basic level 
	 * @throws IOException
	 */
	
	public void initBaseLevel() throws IOException 
	{
		Tiles l;
		
		for( int i=0; i<169; i++)
		{
			l = tiles.get(i);
			l.setBackground(Color.white);
			l.removeAll();
			l.makeWalkable();
			l.setHasPlayers(false);
			l.setHasFire(false);
			l.setHasPlayer(false);
			l.setHasPowerUp(false);
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
					
				}
				else if (l.getxPos() % 2 == 0 && l.getyPos()% 2 == 0)
				{
					l.setBackground(Color.black);
					l.add(new Wall(l.getxPos(),l.getY(),
					l.getOrder()));
					l.notDestroyable();
					l.notWalkable();
				}
			
		}		
		
	}
	
	/**
	 * the method creates 4 options for our players to choose from
	 * @throws IOException
	 */
	
	public void chooseLevel() throws IOException 
	{
		String[] options = new String[] {"Level one", "Level two", "Level three", "Quit"};
		currentLevel =  JOptionPane.showOptionDialog(board, "To start the game", "Please Choose level!",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[0]);
		
	}
	
	/**
	 * this method tells what should happen depending on which option has been chosen
	 * from the method chooseLevel
	 * @throws IOException
	 */
	
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
	
	/**
	 * which player-character that should be assigned to each player depending
	 * on chosen option
	 * @param player
	 * @return i
	 * @return 0
	 */
	
	public int choosePlayer(int player)
	{
		if (player == 1)
		{
			String[] options = new String[] {"Rey", "Sonic", "Devilman"};
		int i =  JOptionPane.showOptionDialog(board, "To start the game", "Please Choose character for Player1!",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[0]);
		return i;
		}
		
		if (player == 2)
		{
			String[] options = new String[] {"Rey", "Sonic", "Devilman"};
		int i =  JOptionPane.showOptionDialog(board, "To start the game", "Please Choose character for Player2!",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[0]);
		return i;
		}
		return 0;
		
		
	}
	
	/**
	 * here we pick our player-character
	 */
	
	
	public void choosenPlayer ()
	{
			int pick1 = choosePlayer(1);
			int pick2 = choosePlayer(2);
			
			if (pick1 == 0)
			{
				player1 = new Player(tiles,board,1 , 1, 1, 0);
			}
			
			if (pick1 == 1)
			{
				player1 = new Sonic(tiles,board,1 , 1, 1, 0);
			}
			
			if (pick1 == 2)
			{
				player1 = new DevilMan(tiles,board,1 ,1,1,0);
			}
			
			if (pick2 == 0)
			{
				
				player2 = new Player(tiles,board,2, 11, 11, 1);
			}
			
			
			if (pick2 == 1)
			{
				player2 = new Sonic(tiles,board,2, 11, 11, 1);

			}
			
			if (pick2 == 2)
			{
				player2 = new DevilMan(tiles,board,2, 11, 11, 1);
				
			}
			
			this.Ui = new UserInterface(player1,player2);
	}
	
	/**
	 * we create our level 1 and here we acknowledge our different player attributes 
	 * @throws IOException
	 */

	public void levelOne() throws IOException
	{
		if (player1 == null)
		{
			this.choosenPlayer();
		}
		this.board.addKeyListener(Ui);
		this.board.setFocusable(true);
		this.board.requestFocus();
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
					p.add(new Dwall(p.getxPos(),p.getY(),p.getOrder()));
					p.setBackground(Color.black);
					p.notWalkable();
					enoughDWalls++;
				}
				
			}

		}	
		p = tiles.get(14);
		p.add(player1);
		player1.setxPos(1);
		player1.setyPos(1);
		p = tiles.get(154);
		p.add(player2);
		player2.setxPos(11);
		player2.setyPos(11);
		if (collision == null)
		{
			collision = new Collision(this);
		}
		player1.initPlayer();
		player2.initPlayer();
		this.board.getPlayer1().setText("P1 life: " + player1.getHp() + " |");
		this.board.getPlayer2().setText("P2 life: " + player2.getHp());
		board.repaint();
		board.setVisible(true);
	}
	
	/**
	 * we create our level 2 and here we set default value for our players
	 * @throws IOException
	 */
	
	public void levelTwo() throws IOException
	{
		if (player1 == null)
		{
			this.choosenPlayer();
		}
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
					powers = rand.nextInt(15);
					used.add(p.getOrder());
					p.add(new Dwall(p.getxPos(),p.getY(),p.getOrder()));
					p.setBackground(Color.black);
					p.notWalkable();
					if (powers<=1)
					{
						p.setHasPowerUp(true);
						if (powers == 0)
						{
							p.setHasHp(true);
						}
						else
						{
							p.setHasLight(true);
						}
					}
					enoughDWalls++;
				}
				
			}

		}	
		p = tiles.get(14);
		p.add(player1);
		player1.setxPos(1);
		player1.setyPos(1);
		p = tiles.get(154);
		p.add(player2);
		player2.setxPos(11);
		player2.setyPos(11);
		player1.setRange(1);
		player2.setRange(1);
		collision = new Collision(this);
		this.board.getPlayer1().setText("P1 life: " + player1.getHp() + " |");
		this.board.getPlayer2().setText("P2 life: " + player2.getHp());
		board.repaint();
		board.setVisible(true);
	}
	
	/**
	 * we create our level 3 and we give our players all the power-ups
	 */
	
	public void levelThree()
	{
		Tiles p;
		if (player1 == null)
		{
			this.choosenPlayer();
		}
		
		
		this.board.addKeyListener(Ui);
		this.board.setFocusable(true);
		this.board.requestFocus();
		this.board.getPlayer1().setText(this.board.getPlayer1().getText() + player1.getHp());
		this.board.getPlayer2().setText(this.board.getPlayer2().getText() + player2.getHp());
		
		p = tiles.get(14);
		p.add(player1);
		player1.setxPos(1);
		player1.setyPos(1);
		player1.setHp(3);
		p = tiles.get(154);
		p.add(player2);
		player2.setxPos(11);
		player2.setyPos(11);
		player2.setHp(3);
		player1.setRange(2);
		player2.setRange(2);
		player1.getHandler().setHasLight(true);
		player2.getHandler().setHasLight(true);
		this.board.getPlayer1().setText("P1 life: " + player1.getHp() + " |");
		this.board.getPlayer2().setText("P2 life: " + player2.getHp());
		
		
		if (collision == null)
		{
			collision = new Collision(this);
		}
		
		board.repaint();
		board.setVisible(true);
	}
	
	/**
	 * the level we are playing 
	 * @return  currentLevel
	 * @uml.property  name="currentLevel"
	 */
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	/**
	 * the class board
	 * @return  board
	 * @uml.property  name="board"
	 */

	public Board getBoard() {
		return board;
	}
	
	/**
	 * sets our board
	 * @param  board
	 * @uml.property  name="board"
	 */

	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * sets the current level
	 * @param  currentLevel
	 * @uml.property  name="currentLevel"
	 */

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	/**
	 * removes our key listening
	 */
	
	public void removeListener()
	{
		board.removeKeyListener(Ui);
	}
	
	/**
	 * sets our players life to 1
	 */
	
	public void resetHp ()
	{
		if (player1 != null)
		{
			player1.setHp(1);
			player2.setHp(1);
		}
		this.board.getPlayer1().setText("P1 life: ");
		this.board.getPlayer2().setText("P2 life: ");
	}

	/**
	 * checks if our players get caught be the fire
	 * @throws IOException
	 */
	
	public void checkStatus() throws IOException 
	{
		if(player1!=null)
		{
			Tiles a = tiles.get(player1.getxPos()+player1.getyPos()*13);
			Tiles b = tiles.get(player2.getxPos()+player2.getyPos()*13);
			
			if (a.isHasFire())
			{
				collision.FireCollision(player1);
				LoseHp(1);
				
			}
			
			if (b.isHasFire())
			{
				collision.FireCollision(player2);
				LoseHp(2);
			}
		}
		
	}
	
	/**
	 * announces a winner
	 * @param a
	 * @throws IOException
	 */
	
	public void LoseHp(int a) throws IOException
	{
		if (a == 1)
		{
			if(player1.getHp() == 1)
			{
				JOptionPane.showMessageDialog(null, "Player 2 has won the game");
				board.getBombExplode().fireReset1();
				board.getBombExplode().fireReset2();
				board.getGameMenu().restart();
				
			}
			
			else 
			{
				player1.setHp(player1.getHp()-1);
				board.getPlayer1().setText("P1 life: ");
				board.getPlayer1().setText(board.getPlayer1().getText() + player1.getHp() + " |");
			}
		}
		
		if (a == 2)
		{
			if(player2.getHp() == 1)
			{
				JOptionPane.showMessageDialog(null, "Player 1 has won the game");
				board.getBombExplode().fireReset1();
				board.getBombExplode().fireReset2();
				board.getGameMenu().restart();
			}
			
			else 
			
				player2.setHp(player2.getHp()-1);
				board.getPlayer2().setText("P2 life: ");
				board.getPlayer2().setText(board.getPlayer2().getText() + player2.getHp());
			}
		}
}
