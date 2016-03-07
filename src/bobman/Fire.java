package bobman;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * this class creates our fire for a certain position depending on 
 * which of the player is planting the bomb 
 * 
 * @author Hamza Kadric
 * @version 2016-03-01
 */

public class Fire extends JLabel
{
	
	private static final long serialVersionUID = 3117597669521741300L;
	/**
	 * @uml.property  name="xPos"
	 */
	private int xPos;
	/**
	 * @uml.property  name="yPos"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer bobman.Tiles"
	 */
	private int yPos;
	/**
	 * @uml.property  name="fireIcon"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon fireIcon;
	/**
	 * @uml.property  name="fireIcon2"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon fireIcon2;
	/**
	 * @uml.property  name="isActive"
	 */
	private boolean isActive;

	public Fire(int player,BombExplode bombExplode)
	{
		super(); 
		initFire(player);
	}
	
	/**
	 * this method creates a fire-icon for both of the players bomb
	 * @param player
	 */
	
	public void initFire(int player) 
	{
		if (player ==1)
		{

			fireIcon = new ImageIcon("src/sprite/fire2.png");
			this.setIcon(fireIcon);
			isActive = false;
		}
		
		if (player ==2)
		{
			fireIcon2 = new ImageIcon("src/sprite/fire2.png");
			this.setIcon(fireIcon2);
			isActive = false;
		}
			
	}
	
	/**
	 * returns if it is active
	 * @return isActive
	 */
	
	public boolean isactive() {
		return isActive;
	}

	/**
	 * this method makes the variable isActive true
	 */
	
	public void setActive()
	{
		isActive = true;
	}
	

	/**
	 * this method activates fire for the specific tiles
	 * @param a
	 */
	
	public void setLocate(Tiles a)
	{
		xPos = a.getxPos();
		yPos = a.getyPos();
		setActive();
				
	}
	
	/**
	 * get the x-position for the fire
	 * @return  xPos
	 * @uml.property  name="xPos"
	 */
	
	public int getxPos() {
		return xPos;
	}
	
	/**
	 * sets the x-position for the fire
	 * @param  xPos
	 * @uml.property  name="xPos"
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	/**
	 * get the y-position for the fire
	 * @return  yPos
	 * @uml.property  name="yPos"
	 */
	
	public int getyPos() {
		return yPos;
	}
	
	/**
	 * sets the y-position for the fire
	 * @param  yPos
	 * @uml.property  name="yPos"
	 */
	
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	/**
	 * this method makes the variable isActive false
	 */
	
	public void notActive()
	{
		isActive = false;
	}
}
