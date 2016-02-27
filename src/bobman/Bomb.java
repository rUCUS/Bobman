package bobman;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bomb extends JLabel
{
	private int damage,player, xPos ,yPos;
	private ImageIcon bombicon1,bombicon2;
	
	

	public Bomb(int damage,int player)
	{
		this.damage = damage;
		this.setSize(48, 48);
		whoseBomb(player);
	}

	public void whoseBomb(int player) 
	{
		switch(player)
		{
		case 1: bombicon1 = new ImageIcon("src/sprite/bomb2.gif");
		this.setIcon(bombicon1);
		break;
		
		case 2: bombicon2 = new ImageIcon("src/sprite/bomb3.gif");
		this.setIcon(bombicon2);
		break;

		}
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
	
	
	
	public void resetAnimation(ImageIcon bombicon)
	{
		bombicon.getImage().flush();
		this.setIcon(bombicon);
	}

	public ImageIcon getBombicon(int status) 
	{
		switch(status)
		{
		case 1: return bombicon1;
		case 2: return bombicon2;
		}
		return bombicon1;
	}
	
}
