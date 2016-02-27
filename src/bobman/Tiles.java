package bobman;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JPanel;

public class Tiles extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4136853509769683971L;
	private int xPos,yPos,order;
	private boolean walkable;
	private boolean destroyable;
	private boolean hasFire;
	private boolean HasPlayer,HasPlayers;
	
	public Tiles(int xPos,int yPos, int order) throws IOException
	{
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.order = order;
		walkable = true;
		destroyable = true;
		HasPlayer = false;
		hasFire = false;
		HasPlayers = false;
		
		this.setBackground(Color.black);
		initTiles();
		
		
	}

	public boolean isHasFire() {
		return hasFire;
	}

	public void setHasFire(boolean hasFire) {
		this.hasFire = hasFire;
	}

	public boolean isHasPlayers() {
		return HasPlayers;
	}

	public void setHasPlayers(boolean hasPlayers) {
		HasPlayers = hasPlayers;
	}

	public boolean isHasPlayer() {
		return HasPlayer;
	}

	public void setHasPlayer(boolean hasPlayer) {
		HasPlayer = hasPlayer;
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
	/*	myPicture = ImageIO.read(new File("src/sprite/floor.png"));
		picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.requestFocusInWindow();
		this.add(picLabel);
		*/
	}

	public void removeFloor() 
	{
	//	this.remove(picLabel);
	}

	public void notWalkable() 
	{
		walkable = false;
	}
	
	public void makeWalkable() 
	{
		walkable = true;
	}
	
	public boolean isWalkable() 
	{
		return walkable;
	}
}
