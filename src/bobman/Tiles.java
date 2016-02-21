package bobman;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tiles extends JPanel 
{
	private int xPos,yPos,order;
	private boolean walkable;
	private boolean destroyable;
	private BufferedImage myPicture;
	private JLabel picLabel;
	
	public Tiles(int xPos,int yPos, int order) throws IOException
	{
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.order = order;
		walkable = true;
		destroyable = true;
		initTiles();
		
		
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	public void notDestroyable()
	{
		destroyable = false;
	}
	
	public boolean isDestroyable()
	{
		return destroyable;
	}
	
	public void initTiles() throws IOException
	{
		BufferedImage myPicture = ImageIO.read(new File("src/Bobman/floor.png"));
		picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.requestFocusInWindow();
		this.add(picLabel);
	}

	public void removeFloor() 
	{
		this.remove(picLabel);
	}
}
