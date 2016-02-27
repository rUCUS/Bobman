package bobman;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dwall extends Tiles 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4198542458020593800L;
	private JLabel picLabel;

	public Dwall(int xPos, int yPos, int order) throws IOException 
	{
		super(xPos, yPos, order);
		
	}

	public void initTiles() throws IOException
	{
		ImageIcon myPicture =(new ImageIcon("src/sprite/wall.png"));
		picLabel = new JLabel((myPicture));
		this.add(picLabel);
	}

}
