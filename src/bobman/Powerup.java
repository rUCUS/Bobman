package bobman;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Powerup extends JLabel
{
	private static final long serialVersionUID = 6129936604059073855L;
	private ImageIcon extraHp,lighting;
	
	public ImageIcon getExtraHp() {
		return extraHp;
	}

	public void setExtraHp(ImageIcon extraHp) {
		this.extraHp = extraHp;
	}

	public ImageIcon getLighting() {
		return lighting;
	}

	public void setLighting(ImageIcon lighting) {
		this.lighting = lighting;
	}

	public Powerup(int k) 
	{
		super();
		initPowerUps();
		pickPowerUps(k);
	}

	private void initPowerUps() 
	{
		extraHp = new ImageIcon("src/sprite/extrahp.gif");
		lighting = new ImageIcon("src/sprite/lighting.png");
		
	}

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
