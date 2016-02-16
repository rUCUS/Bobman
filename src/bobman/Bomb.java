package bobman;

public class Bomb 
{
	int damage;
	int xPos;
	int yPos;
	
	public Bomb(int damage)
	{
		this.damage = damage;
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
	
}
