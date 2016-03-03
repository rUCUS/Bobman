package bobman;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Wall extends Tiles
{
	/*
	 * 
	 */
	private static final long serialVersionUID = -3939973631475481853L;
	private JLabel picLabel;

	public Wall(int xPos, int yPos, int order) throws IOException 
	{
		super(xPos, yPos, order);
		this.setBackground(Color.black);
	}

	
	public void initTiles() throws IOException
	{
		BufferedImage myPicture = ImageIO.read(new File("src/sprite/barrel.png"));
		picLabel = new JLabel(new ImageIcon(myPicture));
		this.add(picLabel);
	}

	
	

}
