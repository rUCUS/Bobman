package bobman;

import javax.swing.JLabel;

public class Bomb extends JLabel
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
