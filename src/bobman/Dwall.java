package bobman;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dwall extends Tiles 
{

	private JLabel picLabel;

	public Dwall(int xPos, int yPos, int order) throws IOException 
	{
		super(xPos, yPos, order);
		
	}

	public void initTiles() throws IOException
	{
		BufferedImage myPicture = ImageIO.read(new File("src/sprite/wall.png"));
		picLabel = new JLabel(new ImageIcon(myPicture));
		this.add(picLabel);
	}

}
