package bobman;

public class Player 
{
	private int hp;
	private double xPos;
	private double yPos;
	private Bomb bomb;
	private UserInterface Ui;
	private double speed;
	
	public Player(int hp, double xPos, double yPos, Bomb bomb, double speed)
	{
		this.hp = hp;
		this.bomb = bomb;
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
		
		initBomb();
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
		
	}
	
	public void moveRight()
	{
		
	}
	
	public void moveUp()
	{
		
	}
	
	public void moveDown()
	{
		
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
