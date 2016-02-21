package bobman;

import javax.swing.JLabel;

public class Player extends JLabel
{
	private Board board;
	private int hp;
	private double xPos;
	private double yPos;
	private Bomb bomb;
	private double speed;
	private boolean isPlayerAlive;
	
	public Player(Board board,int hp, double xPos, double yPos, Bomb bomb, double speed)
	{
		this.board = board;
		this.hp = hp;
		this.bomb = bomb;
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
		isPlayerAlive = true;
		
		initBomb();
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

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
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
		// om det ej fanns vägg rita om jlabel spelaren till tiles(-1)
	}
	
	public void moveRight()
	{
		// om det ej fanns vägg rita om jlabel spelaren till tiles(+1)
	}
	
	public void moveUp()
	{
		// om det ej fanns vägg rita om jlabel spelaren till tiles(-13)
	}
	
	public void moveDown()
	{
		// om det ej fanns vägg rita om jlabel spelaren till tiles(+13)
	}
	
	public void initBomb()
	{
		bomb.setxPos(this.getxPos());
		bomb.setyPos(this.getyPos());
	}
	
	public void startPos()
	{
		
	}
	

}
