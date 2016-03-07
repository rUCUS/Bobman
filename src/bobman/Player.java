package bobman;

import java.util.TreeMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * this class creates our player
 * has information about its position, bomb, hp etc
 * 
 * @author Liban Aden 
 * @version 2016-03-01
 */

public class Player extends JLabel
{
	
	
	private static final long serialVersionUID = 6017005901425321171L;
	/**
	 * @uml.property  name="board"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Board board;
	/**
	 * @uml.property  name="hp"
	 */
	private int hp;
	/**
	 * @uml.property  name="xPos"
	 */
	private int xPos;
	/**
	 * @uml.property  name="yPos"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer bobman.Tiles"
	 */
	private int yPos;
	/**
	 * @uml.property  name="range"
	 */
	private int range;
	/**
	 * @uml.property  name="status"
	 */
	private int status;
	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="bomb"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Bomb bomb;
	/**
	 * @uml.property  name="tiles"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer bobman.Tiles"
	 */
	private TreeMap<Integer,Tiles> tiles;
	/**
	 * @uml.property  name="left"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon left;
	/**
	 * @uml.property  name="right"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon right;
	/**
	 * @uml.property  name="up"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon up;
	/**
	 * @uml.property  name="down"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon down;
	/**
	 * @uml.property  name="upDown"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon upDown;
	/**
	 * @uml.property  name="upLeft"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon upLeft;
	/**
	 * @uml.property  name="upRight"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon upRight;
	/**
	 * @uml.property  name="downLeft"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon downLeft;
	/**
	 * @uml.property  name="downRight"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon downRight;
	/**
	 * @uml.property  name="leftRight"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon leftRight;
	/**
	 * @uml.property  name="upUp"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon upUp;
	/**
	 * @uml.property  name="leftLeft"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon leftLeft;
	/**
	 * @uml.property  name="rightRight"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon rightRight;
	/**
	 * @uml.property  name="downDown"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon downDown;
	/**
	 * @uml.property  name="handler"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="player:bobman.PowerUpHandler"
	 */
	private PowerUpHandler handler;
	
	public Player(TreeMap<Integer,Tiles> tiles,Board board,int status , int xPos, int yPos,int side)
	
	{
		this.status = status;
		this.tiles = tiles;
		this.board = board;
		this.xPos = xPos;
		this.yPos = yPos;
		handler = new PowerUpHandler(this,tiles);
		initPos();
		startPos(side);
		initBomb();
	}
	
	/**
	 * initialize the player
	 */
	
	public void initPos() 
	{
		right = new ImageIcon("src/sprite/rightWalk.gif");
		left = new ImageIcon("src/sprite/leftwalk.gif");
		up = new ImageIcon("src/sprite/upWalk.gif");
		down = new ImageIcon("src/sprite/downWalk.gif");
		upDown = new ImageIcon("src/sprite/upDown.gif");
		upLeft = new ImageIcon("src/sprite/upLeft.gif");
		upRight = new ImageIcon("src/sprite/upRight.gif");
		downLeft = new ImageIcon("src/sprite/downleft.gif");
		downRight = new ImageIcon("src/sprite/downRight.gif");
		leftRight = new ImageIcon("src/sprite/leftRight.gif");
		upUp = new ImageIcon("src/sprite/upUp.gif");
		downDown = new ImageIcon("src/sprite/downDown.gif");
		rightRight = new ImageIcon("src/sprite/rightRight.gif");
		leftLeft = new ImageIcon("src/sprite/leftLeft.gif");
		initPlayer();
	}
	
	/**
	 * sets the players attributes
	 */
	
	
	public void initPlayer() 
	{
		this.setRange(2);
		this.setHp(2);
	}
	
	/**
	 * initialize the player bomb with position
	 */
	
	public void initBomb()
	{
		bomb = new Bomb(status);
		
		bomb.setxPos(this.getxPos());
		bomb.setyPos(this.getyPos());
	}
	
	/**
	 * which side our players should be facing
	 * @param side
	 */
	
	public void startPos(int side)
	{
		switch(side)
		{
		case 0: this.setIcon(right);
		break;
		
		case 1: this.setIcon(left);
		break;
		}
		
	}
	
	/**
	 * resets our tile that has a bomb on it 
	 * to a walkable tile
	 * @param k
	 * @param id
	 */
	
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


	/**
	 * sets the tile to walkable for player1
	 * @param k
	 */

	public void resetWalkable1(Tiles k) 
	{
		board.setResetTile1(k); 
		board.setWastetime1(10f);
		

	}
	
	/**
	 * sets the tile to walkable for player2
	 * @param k
	 */
	
	public void resetWalkable2(Tiles k) 
	{
		board.setResetTile2(k); 
		board.setWastetime2(10f);
		
	}
	
	/**
	 * moves the player towards the left
	 */
	
	public void moveLeft()
	{
		Tiles a;
		Tiles k = tiles.get(this.getxPos() + this.getyPos()*13 - 1);		
		if (k.isWalkable())
		{
			if(k.isHasPlayer())
			{
				board.getLevels().getCollision().playerCollision(this,1);
			}
			else
			{
				if (k.isHasPowerUp())
				{
					if(k.isHasHp())
					{
						handler.giveExtra();
						k.setHasHp(false);
						k.setHasPowerUp(false);
					}
					else
					{
						if (this.getRange() == 1)
						{
							this.setRange(2);
							k.setHasPowerUp(false);
						}
						else
						{
							handler.setHasLight(true);
							k.setHasPowerUp(false);
						}
						
					}
				}
			this.setxPos(this.getxPos()-1);
			a = tiles.get(k.getOrder()+1);
			if(a.isHasPlayers()== false)
			{
			a.removeAll();
			a.setHasPlayer(false);
			}
			
			else
			{
				a.removeAll();
				board.getLevels().getCollision().LeaveCollision(this, 1);
			}
			k.add(this);
			this.setIcon(left);
			k.setHasPlayer(true);
			}
			
		}
		
		else
		{
			this.setIcon(left);
		}
		
	}
	
	/**
	 * moves the player towards the right
	 */

	public void moveRight()
	{
		Tiles a;
		Tiles k = tiles.get(this.getxPos() + this.getyPos()*13 + 1);
		if (k.isWalkable())
		{
			if(k.isHasPlayer())
			{
				board.getLevels().getCollision().playerCollision(this,0);
			}
			
			 
			
			else 
			{
				if (k.isHasPowerUp())
				{
					if(k.isHasHp())
					{
						handler.giveExtra();
						k.setHasHp(false);
						k.setHasPowerUp(false);
					}
					else
					{
						if (this.getRange() == 1)
						{
							this.setRange(2);
							k.setHasPowerUp(false);
						}
						else
						{
							handler.setHasLight(true);
							k.setHasPowerUp(false);
						}
					}
				}
				this.setxPos(this.getxPos()+1);
				a = tiles.get(k.getOrder()-1);
				if(a.isHasPlayers()== false)
				{
				a.removeAll();
				a.setHasPlayer(false);
				}
				
				else
				{
					a.removeAll();
					board.getLevels().getCollision().LeaveCollision(this, 0);
				}
				
				k.add(this);
				this.setIcon(right);
				k.setHasPlayer(true);
			}
			
			
		}
		else
		{
			this.setIcon(right);
		}
		
	}
	
	/**
	 * moves the player upwards
	 */
	
	public void moveUp()
	{
		Tiles a;
		Tiles k = tiles.get(this.getxPos() + this.getyPos()*13 -13);
		if (k.isWalkable())
		{
			
			if(k.isHasPlayer())
			{
				board.getLevels().getCollision().playerCollision(this,2);
			}
			else
			{
				if (k.isHasPowerUp())
				{
					if(k.isHasHp())
					{
						handler.giveExtra();
						k.setHasHp(false);
						k.setHasPowerUp(false);
					}
					else
					{
						if (this.getRange() == 1)
						{
							this.setRange(2);
							k.setHasPowerUp(false);
						}
						else
						{
							handler.setHasLight(true);
							k.setHasPowerUp(false);
						}
					}
				}
				this.setyPos(this.getyPos()-1);
				a = tiles.get(k.getOrder()+13);
				if(a.isHasPlayers()== false)
				{
				a.removeAll();
				a.setHasPlayer(false);
				}
				
				else
				{
					a.removeAll();
					board.getLevels().getCollision().LeaveCollision(this, 2);
				}
				k.add(this);
				this.setIcon(up);
				k.setHasPlayer(true);
			}
		}
		else
		{
			this.setIcon(up);
		}
		
	}
	
	/**
	 * moves the player downwards
	 */
	
	public void moveDown()
	{
		Tiles a;
		Tiles k = tiles.get(this.getxPos() + this.getyPos()*13 +13);
		if (k.isWalkable())
		{
			if(k.isHasPlayer())
			{
				board.getLevels().getCollision().playerCollision(this,3);
			}
			
			else
			{
				if (k.isHasPowerUp())
				{
					if(k.isHasHp())
					{
						handler.giveExtra();
						k.setHasHp(false);
						k.setHasPowerUp(false);
					}
					else
					{
						if (this.getRange() == 1)
						{
							this.setRange(2);
							k.setHasPlayer(false);
						}
						else
						{
							handler.setHasLight(true);
							k.setHasPowerUp(false);
						}
					}
				}
				this.setyPos(this.getyPos()+1);
				a = tiles.get(k.getOrder()-13);
				if(a.isHasPlayers()== false)
				{
				a.removeAll();
				a.setHasPlayer(false);
				}
				
				else
				{
					a.removeAll();
					board.getLevels().getCollision().LeaveCollision(this, 3);
				}
				k.add(this);
				this.setIcon(down);
				k.setHasPlayer(true);
			}
			
			
		}
		else
		{
			this.setIcon(down);
		}
		
	}
	
	/**
	 * throws the bomb in different directions
	 * @param i
	 */
	
	public void throwBomb(int i)
	{
		if ( i ==1)
		{
			if(board.getWastetime1() ==0f)
			{
				id = i;
				Tiles k = tiles.get(this.getxPos() + this.getyPos()*13);
				if (this.getIcon().equals(right))
				{
					throwright(k);
				}
				
				if (this.getIcon().equals(left))
				{
					throwleft(k);
				}
				
				if (this.getIcon().equals(up))
				{
					throwup(k);
				}
				
				if (this.getIcon().equals(down))
				{
					throwdown(k);
				}
				this.initBomb();
			}
			
			
		
		}
		
		if ( i ==2)
		{
			if(board.getWastetime2() ==0f)
			{
				id = i;
				Tiles k = tiles.get(this.getxPos() + this.getyPos()*13);
				if (this.getIcon().equals(right))
				{
					throwright(k);
					id = 0;
				}
				
				if (this.getIcon().equals(left))
				{
					throwleft(k);
					id = 0;
				}
				
				if (this.getIcon().equals(up))
				{
					throwup(k);
					id = 0;
				}
				
				if (this.getIcon().equals(down))
				{
					throwdown(k);
					id = 0;
				}
			}
			this.initBomb();
		
		}
		


	}
	
	/**
	 * throw the bombs to the right
	 * @param k
	 */
	
	public void throwright(Tiles k)
	{
		Tiles a = tiles.get(k.getOrder()+1);
		if(a.isWalkable())
		{
			bomb.resetAnimation(bomb.getBombicon(status));
			bomb.setxPos(a.getxPos());
			bomb.setyPos(a.getyPos());
			a.add(bomb);
			a.notWalkable();
			resetWalkable(a,id);
			
		}
		else
		{
			moveLeft();
			this.setIcon(right);
			bomb.resetAnimation(bomb.getBombicon(status));
			bomb.setxPos(k.getxPos());
			bomb.setyPos(k.getyPos());
			k.add(bomb);
			k.notWalkable();
			resetWalkable(k,id);
			
		}
		
		
	}
	
	/**
	 * throw the bomb to the left
	 * @param k
	 */
	
	public void throwleft(Tiles k)
	{
		Tiles a = tiles.get(k.getOrder()-1);
		if(a.isWalkable())
		{
			bomb.resetAnimation(bomb.getBombicon(status));
			bomb.setxPos(a.getxPos());
			bomb.setyPos(a.getyPos());
			a.add(bomb);
			a.notWalkable();
			resetWalkable(a,id);
		}
		else
		{
			moveRight();
			this.setIcon(left);
			bomb.resetAnimation(bomb.getBombicon(status));
			bomb.setxPos(k.getxPos());
			bomb.setyPos(k.getyPos());
			k.add(bomb);
			k.notWalkable();
			resetWalkable(k,id);
			
		}
	}
	
	/**
	 * throw the bomb upwards
	 * @param k
	 */
	
	public void throwup(Tiles k)
	{
		Tiles a = tiles.get(k.getOrder()-13);
		if(a.isWalkable())
		{
			bomb.resetAnimation(bomb.getBombicon(status));
			bomb.setxPos(a.getxPos());
			bomb.setyPos(a.getyPos());
			a.add(bomb);
			a.notWalkable();
			resetWalkable(a,id);
		}
		else
		{
			moveDown();
			this.setIcon(up);
			bomb.resetAnimation(bomb.getBombicon(status));
			bomb.setxPos(k.getxPos());
			bomb.setyPos(k.getyPos());
			k.add(bomb);
			k.notWalkable();
			resetWalkable(k,id);
		}
	}
	
	/**
	 * throw the bomb downwards
	 * @param k
	 */
	
	public void throwdown(Tiles k)
	{
		Tiles a = tiles.get(k.getOrder()+13);
		if(a.isWalkable())
		{
			bomb.resetAnimation(bomb.getBombicon(status));
			bomb.setxPos(a.getxPos());
			bomb.setyPos(a.getyPos());
			a.add(bomb);
			a.notWalkable();
			resetWalkable(a,id);
		}
		else
		{
			moveUp();
			this.setIcon(down);
			bomb.resetAnimation(bomb.getBombicon(status));
			bomb.setxPos(k.getxPos());
			bomb.setyPos(k.getyPos());
			k.add(bomb);
			k.notWalkable();
			resetWalkable(k,id);
			
		}
	}
	
	/**
	 * returns the image icon for left-movement
	 * @return  left
	 * @uml.property  name="left"
	 */
	
	public ImageIcon getLeft() 
	{
		return left;
	}
	
	/**
	 * sets the image icon for left-movement
	 * @param  left
	 * @uml.property  name="left"
	 */

	public void setLeft(ImageIcon left) 
	{
		this.left = left;
	}
	
	/**
	 * returns the image icon for right-movement
	 * @return  right
	 * @uml.property  name="right"
	 */

	public ImageIcon getRight() 
	{
		return right;
	}
	
	/**
	 * sets the image icon for right-movement
	 * @param  right
	 * @uml.property  name="right"
	 */

	public void setRight(ImageIcon right) 
	{
		this.right = right;
	}
	
	/**
	 * returns the image icon for up-movement
	 * @return  up
	 * @uml.property  name="up"
	 */

	public ImageIcon getUp() 
	{
		return up;
	}
	
	/**
	 * sets the image icon for up-movement
	 * @param  up
	 * @uml.property  name="up"
	 */

	public void setUp(ImageIcon up) 
	{
		this.up = up;
	}
	
	/**
	 * returns the image icon for down-movement
	 * @return
	 * @uml.property  name="down"
	 */

	public ImageIcon getDown() 
	{
		return down;
	}
	
	/**
	 * sets the image icon for down-movement
	 * @param  down
	 * @uml.property  name="down"
	 */

	public void setDown(ImageIcon down) 
	{
		this.down = down;
	}
	
	/**
	 * returns which player it is
	 * @return  status
	 * @uml.property  name="status"
	 */

	public int getStatus() 
	{
		return status;
	}
	
	/**
	 * sets which player it is
	 * @param  status
	 * @uml.property  name="status"
	 */

	public void setStatus(int status) 
	{
		this.status = status;
		
	}
	
	/**
	 * returns the range for the player
	 * @return range
	 */

	public double getRange() 
	{
		return range;
	}
	
	/**
	 * sets the range for player
	 * @param  range
	 * @uml.property  name="range"
	 */

	public void setRange(int range) 
	{
		this.range = range;
	}

	/**
	 * returns the health for player
	 * @return  hp
	 * @uml.property  name="hp"
	 */
	
	public int getHp() 
	{
		return hp;
	}
	
	/**
	 * sets the health for player
	 * @param  hp
	 * @uml.property  name="hp"
	 */

	public void setHp(int hp) 
	{
		this.hp = hp;
	}
	
	/**
	 * returns the x-position for the player
	 * @return  xPos
	 * @uml.property  name="xPos"
	 */

	public int getxPos() 
	{
		return xPos;
	}
	
	/**
	 * sets the x-position for the player
	 * @param  xPos
	 * @uml.property  name="xPos"
	 */

	public void setxPos(int xPos) 
	{
		this.xPos = xPos;
	}
	
	/**
	 * returns the y-position for the player
	 * @return  yPos
	 * @uml.property  name="yPos"
	 */

	public int getyPos() 
	{
		return yPos;
	}
	
	/**
	 * sets the y-position for the player
	 * @param  yPos
	 * @uml.property  name="yPos"
	 */
	
	public void setyPos(int yPos) 
	{
		this.yPos = yPos;
	}
	
	/**
	 * returns the image icon for the players facing up and down
	 * @return  upDown
	 * @uml.property  name="upDown"
	 */
	
	public ImageIcon getUpDown() 
	{
		return upDown;
	}
	
	/**
	 * returns the image icon for the players facing up and left
	 * @return  upLeft
	 * @uml.property  name="upLeft"
	 */

	public ImageIcon getUpLeft()
	{
		return upLeft;
	}

	/**
	 * returns the image icon for the players facing up and right
	 * @return  upRight
	 * @uml.property  name="upRight"
	 */

	public ImageIcon getUpRight() 
	{
		return upRight;
	}
	
	/**
	 * returns the image icon for the players facing down and left
	 * @return  downLeft
	 * @uml.property  name="downLeft"
	 */


	public ImageIcon getDownLeft() {
		return downLeft;
	}

	/**
	 * returns the image icon for the players facing down and right
	 * @return  downRight
	 * @uml.property  name="downRight"
	 */


	public ImageIcon getDownRight() 
	{
		return downRight;
	}

	/**
	 * returns the image icon for the players facing left and right
	 * @return
	 * @uml.property  name="leftRight"
	 */

	public ImageIcon getLeftRight() 
	{
		return leftRight;
	}

	/**
	 * Returns the Collective map of all the created Tiles
	 * @return tiles
	 */
	
	public TreeMap<Integer, Tiles> getTiles() {
		return tiles;
	}
	
	/**
	 * returns the image icon for both player facing right
	 * @return rightRight
	 */


	public Icon getrightRight() {
		
		return rightRight;
	}
	
	/**
	 * returns the image icon for both player facing left
	 * @return leftLeft
	 */


	public Icon getleftLeft() {
		
		return leftLeft;
	}
	
	/**
	 * returns the image icon for both player facing down
	 * @return downDown
	 */


	public Icon getdownDown() {
		
		return downDown;
	}
	
	/**
	 * returns the image icon for both player facing up
	 * @return upUp
	 */

	public Icon getupUp() {
		
		return upUp;
	}

	/**
	 * returns the players power-up-handlers
	 * @return  handler
	 * @uml.property  name="handler"
	 */
	
	public PowerUpHandler getHandler() {
		return handler;
	}
	
	/**
	 * sets the players power-up handler
	 * @param  handler
	 * @uml.property  name="handler"
	 */

	public void setHandler(PowerUpHandler handler) {
		this.handler = handler;
	}

	/**
	 * returns the main-board class
	 * @return  board
	 * @uml.property  name="board"
	 */
	
	public Board getBoard() {
		return board;
	}
	
	/**
	 * sets the board
	 * @param  board
	 * @uml.property  name="board"
	 */

	public void setBoard(Board board) {
		this.board = board;
	}

	
	

}
