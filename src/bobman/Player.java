package bobman;

import java.util.TreeMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * this class creates our player
 * has information about its position, bomb, hp etc
 * 
 * @author Liban Aden 
 * @version 2016-03-01
 */

public class Player extends JLabel
{
	
	
	private static final long serialVersionUID = 6017005901425321171L;
	private Board board;
	private int hp,xPos,yPos,range,status,id;
	private Bomb bomb;
	private TreeMap<Integer,Tiles> tiles;
	private ImageIcon left,right,up,down,upDown,upLeft,upRight,downLeft,downRight,leftRight,upUp,leftLeft,rightRight,downDown;
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
	
	/*
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
	
	/*
	 * sets the players attributes
	 */
	
	
	public void initPlayer() 
	{
		this.setRange(2);
		this.setHp(2);
	}
	
	/*
	 * initialize the player bomb with position
	 */
	
	public void initBomb()
	{
		bomb = new Bomb(status);
		
		bomb.setxPos(this.getxPos());
		bomb.setyPos(this.getyPos());
	}
	
	/*
	 * which side our players should be facing
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
	
	/*
	 * resets our tile that has a bomb on it 
	 * to a walkable tile
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


	/*
	 * sets the tile to walkable for player1
	 */

	public void resetWalkable1(Tiles k) 
	{
		board.setResetTile1(k); 
		board.setWastetime1(10f);
		

	}
	
	/*
	 * sets the tile to walkable for player2
	 */
	
	public void resetWalkable2(Tiles k) 
	{
		board.setResetTile2(k); 
		board.setWastetime2(10f);
		
	}
	
	/*
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
	
	/*
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
	
	/*
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
			;
		}
		else
		{
			this.setIcon(up);
		}
		
	}
	
	/*
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
	
	/*
	 * throws the bomb in different directions
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
	
	/*
	 * throw the bombs to the right
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
	
	/*
	 * throw the bomb to the left
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
	
	/*
	 * throw the bomb upwards
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
	
	/*
	 * throw the bomb downwards
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
	
	/*
	 * returns the image icon for left-movement
	 * @returns left
	 */
	
	public ImageIcon getLeft() 
	{
		return left;
	}
	
	/*
	 * sets the image icon for left-movement
	 * @param left
	 */

	public void setLeft(ImageIcon left) 
	{
		this.left = left;
	}
	
	/*
	 * returns the image icon for right-movement
	 * @returns right
	 */

	public ImageIcon getRight() 
	{
		return right;
	}
	
	/*
	 * sets the image icon for right-movement
	 * @param right
	 */

	public void setRight(ImageIcon right) 
	{
		this.right = right;
	}
	
	/*
	 * returns the image icon for up-movement
	 * @returns up
	 */

	public ImageIcon getUp() 
	{
		return up;
	}
	
	/*
	 * sets the image icon for up-movement
	 * @param up
	 */

	public void setUp(ImageIcon up) 
	{
		this.up = up;
	}
	
	/*
	 * returns the image icon for down-movement
	 * @returns down
	 */

	public ImageIcon getDown() 
	{
		return down;
	}
	
	/*
	 * sets the image icon for down-movement
	 * @param down
	 */

	public void setDown(ImageIcon down) 
	{
		this.down = down;
	}
	
	/*
	 * returns which player it is
	 * @return status
	 */

	public int getStatus() 
	{
		return status;
	}
	
	/*
	 * sets which player it is
	 * @param status
	 */

	public void setStatus(int status) 
	{
		this.status = status;
		
	}
	
	/*
	 * returns the range for the player
	 * @returns range
	 */

	public double getRange() 
	{
		return range;
	}
	
	/*
	 * sets the range for player
	 * @param range
	 */

	public void setRange(int range) 
	{
		this.range = range;
	}

	/*
	 * returns the health for player
	 * @return hp
	 */
	
	public int getHp() 
	{
		return hp;
	}
	
	/*
	 * sets the health for player
	 * @param hp
	 */

	public void setHp(int hp) 
	{
		this.hp = hp;
	}
	
	/*
	 * returns the x-position for the player
	 * @return xPos
	 */

	public int getxPos() 
	{
		return xPos;
	}
	
	/*
	 * sets the x-position for the player
	 * @param xPos
	 */

	public void setxPos(int xPos) 
	{
		this.xPos = xPos;
	}
	
	/*
	 * returns the y-position for the player
	 * @return yPos
	 */

	public int getyPos() 
	{
		return yPos;
	}
	
	/*
	 * sets the y-position for the player
	 * @param yPos
	 */

	public void setyPos(int yPos) 
	{
		this.yPos = yPos;
	}
	
	/*
	 * returns the image icon for the players facing up and down
	 * @returns upDown
	 */
	
	public ImageIcon getUpDown() 
	{
		return upDown;
	}
	
	/*
	 * returns the image icon for the players facing up and left
	 * @returns upLeftt
	 */

	public ImageIcon getUpLeft()
	{
		return upLeft;
	}

	/*
	 * returns the image icon for the players facing up and right
	 * @returns upRight
	 */

	public ImageIcon getUpRight() 
	{
		return upRight;
	}
	
	/*
	 * returns the image icon for the players facing down and left
	 * @returns downLeft
	 */


	public ImageIcon getDownLeft() {
		return downLeft;
	}

	/*
	 * returns the image icon for the players facing down and right
	 * @returns downRight
	 */


	public ImageIcon getDownRight() 
	{
		return downRight;
	}

	/*
	 * returns the image icon for the players facing left and right
	 * @returns leftRight
	 */

	public ImageIcon getLeftRight() 
	{
		return leftRight;
	}

	
	public TreeMap<Integer, Tiles> getTiles() {
		return tiles;
	}

	public void setTiles(TreeMap<Integer, Tiles> tiles) {
		this.tiles = tiles;
	}
	
	/*
	 * returns the image icon for both player facing right
	 * @returns rightRight
	 */


	public Icon getrightRight() {
		
		return rightRight;
	}
	
	/*
	 * returns the image icon for both player facing left
	 * @returns leftLeft
	 */


	public Icon getleftLeft() {
		
		return leftLeft;
	}
	
	/*
	 * returns the image icon for both player facing down
	 * @returns downDown
	 */


	public Icon getdownDown() {
		
		return downDown;
	}
	
	/*
	 * returns the image icon for both player facing up
	 * @returns up
	 */

	public Icon getupUp() {
		
		return upUp;
	}

	/*
	 * returns the players power-up-handlers
	 */
	
	public PowerUpHandler getHandler() {
		return handler;
	}
	
	/*
	 * sets the players power-up handler
	 */

	public void setHandler(PowerUpHandler handler) {
		this.handler = handler;
	}

	/*
	 * returns the main-board class
	 */
	
	public Board getBoard() {
		return board;
	}
	
	/*
	 * sets the board
	 */

	public void setBoard(Board board) {
		this.board = board;
	}

	
	

}
