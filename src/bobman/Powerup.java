package bobman;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * Handles what picture will spawn when a powerup appears
 * 
 * @author Liban Aden
 * @version 2016-03-01
 */

public class Powerup extends JLabel
{
	private static final long serialVersionUID = 6129936604059073855L;
	/**
	 * @uml.property  name="extraHp"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon extraHp;
	/**
	 * @uml.property  name="lighting"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ImageIcon lighting;
	
	public Powerup(int k) 
	{
		super();
		initPowerUps();
		pickPowerUps(k);
	}
	
	/**
	 * returns the image icon for extra health
	 * @return  extraHp
	 * @uml.property  name="extraHp"
	 */
	
	public ImageIcon getExtraHp() {
		return extraHp;
	}
	
	/**
	 * sets the image icon for extra health
	 * @param  extraHp
	 * @uml.property  name="extraHp"
	 */

	public void setExtraHp(ImageIcon extraHp) {
		this.extraHp = extraHp;
	}
	
	 /**
	 * returns the image icon for extra range for the bomb
	 * @return  lighting
	 * @uml.property  name="lighting"
	 */

	public ImageIcon getLighting() {
		return lighting;
	}
	
	/**
	 * sets the image icon for extra range for the bomb
	 * @param  lighting
	 * @uml.property  name="lighting"
	 */

	public void setLighting(ImageIcon lighting) {
		this.lighting = lighting;
	}

	/**
	 * initialize the power-ups
	 */
	
	private void initPowerUps() 
	{
		extraHp = new ImageIcon("src/sprite/extrahp.gif");
		lighting = new ImageIcon("src/sprite/lighting.png");
		
	}
	
	/**
	 * which power-up is picked up
	 * @param k
	 */

	private void pickPowerUps(int k) 
	{
		switch(k)
		{
		case 1: this.setIcon(extraHp);
		break;
		case 2: this.setIcon(lighting);
		break;
				
		}
	}
	
	
	
}
