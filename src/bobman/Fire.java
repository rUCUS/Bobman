package bobman;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Fire extends JLabel
{

	private int xPos,yPos,player;
	private ImageIcon fireIcon;
	public Fire(int player)
	{
		super(); 
		//Toolkit t = Toolkit.getDefaultToolkit();
		//fireIcon = t.getImage("src/sprite/exploding.gif");
	//	this.xPos = xPos;
	//	this.yPos = yPos;
		initFire(player);
	}
	public void initFire(int player) 
	{
		if(player == 1)
		{
			fireIcon = new ImageIcon("src/sprite/fire_.png");
			resetAnimationfire();
			this.setIcon(fireIcon);
		}

		if(player == 2)
		{
<<<<<<< HEAD
			fireIcon = new ImageIcon("src/sprite/fire_.png");
=======
			fireIcon = new ImageIcon("src/sprite/exploding2.gif");
>>>>>>> origin/master
			resetAnimationfire();
			this.setIcon(fireIcon);
		}
	}
	
	public void resetAnimationfire()
	{
		fireIcon.getImage().flush();
	}
	
	
	
	
	
	
}
