package bobman;

import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel
{
	private Board board;
	private int hp,xPos,yPos,speed;
	private Bomb bomb;
	private UserInterface Ui;
	private boolean isPlayerAlive;
	private TreeMap<Integer,Tiles> tiles;
	private ImageIcon left,right,up,down;
	
	public Player(TreeMap<Integer,Tiles> tiles,Board board,int hp, int xPos, int yPos, Bomb bomb, int speed,int side)
	{
		this.Ui = new UserInterface(this);
		this.tiles = tiles;
		this.board = board;
		this.hp = hp;
		this.bomb = bomb;
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
		isPlayerAlive = true;
		this.board.addKeyListener(Ui);
		this.board.setFocusable(true);
		this.board.requestFocus();
		initPos();
		startPos(side);
		initBomb();
	}
	
	public void initPos() 
	{
		right = new ImageIcon("src/sprite/rightWalk.gif");
		left = new ImageIcon("src/sprite/leftwalk.gif");
		up = new ImageIcon("src/sprite/upWalk.gif");
		down = new ImageIcon("src/sprite/downWalk.gif");
	}

	public boolean isPlayerAlive() {
		return isPlayerAlive;
	}

	public void setPlayerAlive(boolean isPlayerAlive) {
		this.isPlayerAlive = isPlayerAlive;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	
	
	public void throwBomb()
	{
		
	}
	
	public void hit(int bXPos, int bYPos, int pXPos, int pYPos)
	{
		
	}
	
	public void moveLeft()
	{
		Tiles a;
		Tiles k = tiles.get(this.getxPos() + this.getyPos()*13 - 1);
		if (k.isWalkable())
		{
			this.setxPos(this.getxPos()-1);
			a = tiles.get(k.getOrder()+1);
			a.removeAll();
			k.add(this);
			this.setIcon(left);
		}
		else
		{
			this.setIcon(left);
		}
		// om det ej fanns vägg rita om jlabel spelaren till tiles(-1)
	}
	
	public void moveRight()
	{
		Tiles a;
		Tiles k = tiles.get(this.getxPos() + this.getyPos()*13 + 1);
		if (k.isWalkable())
		{
			this.setxPos(this.getxPos()+1);
			a = tiles.get(k.getOrder()-1);
			a.removeAll();
			k.add(this);
			this.setIcon(right);
		}
		else
		{
			this.setIcon(right);
		}
		// om det ej fanns vägg rita om jlabel spelaren till tiles(+1)
	}
	
	public void moveUp()
	{
		Tiles a;
		Tiles k = tiles.get(this.getxPos() + this.getyPos()*13 -13);
		if (k.isWalkable())
		{
			this.setyPos(this.getyPos()-1);
			a = tiles.get(k.getOrder()+13);
			a.removeAll();
			k.add(this);
			this.setIcon(up);
		}
		else
		{
			this.setIcon(up);
		}
		// om det ej fanns vägg rita om jlabel spelaren till tiles(-13)
	}
	
	public void moveDown()
	{
		Tiles a;
		Tiles k = tiles.get(this.getxPos() + this.getyPos()*13 +13);
		if (k.isWalkable())
		{
			this.setyPos(this.getyPos()+1);
			a = tiles.get(k.getOrder()-13);
			a.removeAll();
			k.add(this);
			this.setIcon(down);
		}
		else
		{
			this.setIcon(down);
		}
		// om det ej fanns vägg rita om jlabel spelaren till tiles(+13)
	}
	
	public void initBomb()
	{
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
	
	

}
