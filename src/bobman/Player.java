package bobman;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Player extends JLabel
{
	private Board board;
	private int hp,xPos,yPos,speed,status,id,damage;
	private Bomb bomb;
	private boolean isPlayerAlive;
	private TreeMap<Integer,Tiles> tiles;
	private ImageIcon left,right,up,down,upDown,upLeft,upRight,downLeft,downRight,leftRight;
	private Timer timer1,timer2;
	
	public Player(TreeMap<Integer,Tiles> tiles,Board board,Timer timer1,Timer timer2,
			int status ,int hp, int xPos, int yPos, int speed,int side)
	
	{
		this.damage = 1;
		this.timer1 = timer1;
		this.timer2 = timer2;
		this.status = status;
		this.tiles = tiles;
		this.board = board;
		this.hp = hp;
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
		isPlayerAlive = true;
		initPos();
		startPos(side);
		initBomb();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////// Initiation
	
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
	}
	
	
	public void initBomb()
	{
		bomb = new Bomb(damage,status);
		
		bomb.setxPos(this.getxPos());
		bomb.setyPos(this.getyPos());
	}
	
	public void startPos(int side)
	{
		switch(side)
		{
		case 0: this.setIcon(right);
		break;
		
		case 1: this.setIcon(left);
		break;
		
		case 2: this.setIcon(up);
		break;
		
		case 3: this.setIcon(down);
		break;
		}
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////// ResetBombThrow
	
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
		timer1.start();
		board.setResetTile1(k); 
		board.setWastetime1(0f);
		

	}
	
	public void resetWalkable2(Tiles k) 
	{
		timer2.start();
		board.setResetTile2(k); 
		board.setWastetime2(0f);
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////// Move Player
	
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
			this.setxPos(this.getxPos()-1);
			a = tiles.get(k.getOrder()+1);
			a.removeAll();
			a.setHasPlayer(false);
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
				this.setxPos(this.getxPos()+1);
				a = tiles.get(k.getOrder()-1);
				a.removeAll();
				a.setHasPlayer(false);
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
				this.setyPos(this.getyPos()-1);
				a = tiles.get(k.getOrder()+13);
				a.removeAll();
				a.setHasPlayer(false);
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
				this.setyPos(this.getyPos()+1);
				a = tiles.get(k.getOrder()-13);
				a.removeAll();
				a.setHasPlayer(false);
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
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////// Throw Bomb
	
	public void throwBomb(int i)
	{
		if ( i ==1)
		{
			if(!timer1.isRunning())
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
			if(!timer2.isRunning())
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
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////// Setters and Getters
	
	public ImageIcon getLeft() 
	{
		return left;
	}

	public void setLeft(ImageIcon left) 
	{
		this.left = left;
	}

	public ImageIcon getRight() 
	{
		return right;
	}

	public void setRight(ImageIcon right) 
	{
		this.right = right;
	}

	public ImageIcon getUp() 
	{
		return up;
	}

	public void setUp(ImageIcon up) 
	{
		this.up = up;
	}

	public ImageIcon getDown() 
	{
		return down;
	}

	public void setDown(ImageIcon down) 
	{
		this.down = down;
	}

	public int getStatus() 
	{
		return status;
	}

	public void setStatus(int status) 
	{
		this.status = status;
		
	}
	
	public boolean isPlayerAlive() 
	{
		return isPlayerAlive;
	}

	public void setPlayerAlive(boolean isPlayerAlive) 
	{
		this.isPlayerAlive = isPlayerAlive;
	}

	public double getSpeed() 
	{
		return speed;
	}

	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}

	public int getHp() 
	{
		return hp;
	}

	public void setHp(int hp) 
	{
		this.hp = hp;
	}

	public int getxPos() 
	{
		return xPos;
	}

	public void setxPos(int xPos) 
	{
		this.xPos = xPos;
	}

	public int getyPos() 
	{
		return yPos;
	}

	public void setyPos(int yPos) 
	{
		this.yPos = yPos;
	}
	
	public ImageIcon getUpDown() 
	{
		return upDown;
	}

	public void setUpDown(ImageIcon upDown) 
	{
		this.upDown = upDown;
	}

	public ImageIcon getUpLeft()
	{
		return upLeft;
	}

	public void setUpLeft(ImageIcon upLeft) 
	{
		this.upLeft = upLeft;
	}

	public ImageIcon getUpRight() 
	{
		return upRight;
	}

	public void setUpRight(ImageIcon upRight) 
	{
		this.upRight = upRight;
	}

	public ImageIcon getDownLeft() {
		return downLeft;
	}

	public void setDownLeft(ImageIcon downLeft) 
	{
		this.downLeft = downLeft;
	}

	public ImageIcon getDownRight() 
	{
		return downRight;
	}

	public void setDownRight(ImageIcon downRight) 
	{
		this.downRight = downRight;
	}

	public ImageIcon getLeftRight() 
	{
		return leftRight;
	}

	public void setLeftRight(ImageIcon leftRight) 
	{
		this.leftRight = leftRight;
	}

	public TreeMap<Integer, Tiles> getTiles() {
		return tiles;
	}

	public void setTiles(TreeMap<Integer, Tiles> tiles) {
		this.tiles = tiles;
	}
	
	

	
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	

}
