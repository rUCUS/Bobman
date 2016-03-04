package bobman;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JPanel;

/*
 * this class creates our tiles
 * has information about tile 
 * is destroyable, walkable
 * 
 * @author Liban Aden
 * @version 2016-03-01
 */

public class Tiles extends JPanel 
{
	
	
	private static final long serialVersionUID = -4136853509769683971L;
	private int xPos,yPos,order;
	private boolean walkable;
	private boolean destroyable;
	private boolean hasFire;
	private boolean HasPlayer,HasPlayers;
	private boolean hasPowerUp;
	private boolean hasHp;
	private boolean hasLight;
	
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
		hasPowerUp= false;
		hasHp = false;
		hasLight = false;
		
		this.setBackground(Color.black);
		initTiles();
		
		
	}
	
	/*
	 * returns whether there is life/hp or not
	 * @returns false
	 */

	public boolean isHasHp() {
		return hasHp;
	}
	
	/*
	 * sets the hp
	 * @param hasHp
	 */

	public void setHasHp(boolean hasHp) {
		this.hasHp = hasHp;
	}
	
	/*
	 *  Returns if the tile has the powerup lighting
	 */

	public boolean isHasLight() {
		return hasLight;
	}
	
	/*
	 *  sets so that that the tile will have the powerup lighting or not
	 *  @param hasLight
	 */

	public void setHasLight(boolean hasLight) {
		this.hasLight = hasLight;
	}
	
	/*
	 * returns whether the tile has a power-up or not
	 * @returns false 
	 */

	public boolean isHasPowerUp() {
		return hasPowerUp;
	}
	
	/*
	 * sets the tile whether the tile has a power-up or not
	 * @param hasPowerUp
	 */

	public void setHasPowerUp(boolean hasPowerUp) {
		this.hasPowerUp = hasPowerUp;
	}
	
	/*
	 * returns whether the tile has fire or not 
	 * @returns false
	 */

	public boolean isHasFire() {
		return hasFire;
	}
	
	/*
	 * sets whether the tile has fire or not
	 * @param hasFire
	 */

	public void setHasFire(boolean hasFire) {
		this.hasFire = hasFire;
	}
	
	/*
	 * returns whether the tile has players on it or not
	 * @returns false
	 */

	public boolean isHasPlayers() {
		return HasPlayers;
	}
	
	/*
	 * sets whether the tile has players or not
	 * @param hasPlayers
	 */

	public void setHasPlayers(boolean hasPlayers) {
		HasPlayers = hasPlayers;
	}
	
	/*
	 * returns whether the tile has a player on it or not
	 * @returns false
	 */

	public boolean isHasPlayer() {
		return HasPlayer;
	}
	
	/*
	 * sets whether the tile has a player or not
	 * @param hasPlayer
	 */

	public void setHasPlayer(boolean hasPlayer) {
		HasPlayer = hasPlayer;
	}
	
	/*
	 * returns the x-position for the tile
	 * @returns x-position
	 */

	public int getxPos() {
		return xPos;
	}
	
	/*
	 * sets the x-positions for the tile
	 * @param xPos
	 */

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	/*
	 * returns the y-position for the tile
	 * @returns y-position
	 */

	public int getyPos() {
		return yPos;
	}
	
	/*
	 * sets the y-position for the tile
	 * @param yPos
	 */

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	/*
	 * returns the order of the tile
	 * @returns order
	 */

	public int getOrder() {
		return order;
	}
	
	/*
	 * sets the order of the tile
	 * @param order
	 */

	public void setOrder(int order) {
		this.order = order;
	}
	
	/*
	 * sets the tile to not destroyable
	 */
	
	public void notDestroyable()
	{
		destroyable = false;
	}
	
	/*
	 * returns whether the tile is destroyable or not
	 * @returns false
	 */
	
	public boolean isDestroyable()
	{
		return destroyable;
	}
	
	
	
	public void initTiles() throws IOException ///????????????
	{
	/*	myPicture = ImageIO.read(new File("src/sprite/floor.png"));
		picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.requestFocusInWindow();
		this.add(picLabel);
		*/
	}

	public void removeFloor() //???????????????????
	{
	//	this.remove(picLabel);
	}
	
	/*
	 * sets the tile to not walkable 
	 */

	public void notWalkable() 
	{
		walkable = false;
	}
	
	/*
	 * sets the tile to walkable
	 */
	
	public void makeWalkable() 
	{
		walkable = true;
	}
	
	/*
	 * returns whether the tile walkable		??????????????????
	 * @returns true/false
	 */
	
	public boolean isWalkable() 
	{
		return walkable;
	}
}
