package bobman;

public class Bomb 
{
	int damage;
	double xPos;
	double yPos;
	
	public Bomb(int damage)
	{
		this.damage = damage;
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
	
}
