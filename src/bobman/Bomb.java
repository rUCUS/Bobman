package bobman;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class creates bombs on a given position.
 * @author Danny Lam
 * @version 2016-02-26
 */

public class Bomb extends JLabel
{
	
	private static final long serialVersionUID = 2578658456631174653L;
	/**
	 * @uml.property  name="xPos"
	 */
	private int xPos;
	/**
	 * @uml.property  name="yPos"
	 */
	private int yPos;
	/**
	 * @uml.property  name="bombicon1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon bombicon1;
	/**
	 * @uml.property  name="bombicon2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon bombicon2;
	

	public Bomb(int player)
	{
		this.setSize(48, 48);
		whoseBomb(player);
	}
	
	/**
	 * this method generates a bomb for a given player 
	 * @param player
	 */

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
	
	/**
	 * returns the x-position of the bomb
	 * @return  xPos
	 * @uml.property  name="xPos"
	 */

	public int getxPos()
	{
		return xPos;
	}
	
	/**
	 * sets the x-position of the bomb
	 * @param  xPos
	 * @uml.property  name="xPos"
	 */

	public void setxPos(int xPos) 
	{
		this.xPos = xPos;
	}
	
	/**
	 * returns the y-position of bomb
	 * @return  yPos
	 * @uml.property  name="yPos"
	 */

	public int getyPos() 
	{
		return yPos;
	}
	
	/**
	 * sets the y-position of the bomb
	 * @param  yPos
	 * @uml.property  name="yPos"
	 */

	public void setyPos(int yPos) 
	{ 
		this.yPos = yPos;
	}
	
	/**
	 * this method resets the animation for the bomb
	 * @param bombicon
	 */
	
	public void resetAnimation(ImageIcon bombicon)
	{
		bombicon.getImage().flush();
		this.setIcon(bombicon);
	}
	
	/**
	 * returns the bomb for the given player 
	 * @param status
	 * @return bombicon1
	 * @return bombicon2
	 */
	
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
