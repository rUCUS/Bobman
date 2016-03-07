package bobman;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JPanel;

/**
 * this class creates our tiles
 * has information about tile 
 * is destroyable, walkable
 * this class extends JPanel
 * 
 * @author Liban Aden
 * @version 2016-03-01
 */

public class Tiles extends JPanel 
{
	
	
	private static final long serialVersionUID = -4136853509769683971L;
	/**
	 * @uml.property  name="xPos"
	 */
	private int xPos;
	/**
	 * @uml.property  name="yPos"
	 */
	private int yPos;
	/**
	 * @uml.property  name="order"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer bobman.Tiles"
	 */
	private int order;
	/**
	 * @uml.property  name="walkable"
	 */
	private boolean walkable;
	/**
	 * @uml.property  name="destroyable"
	 */
	private boolean destroyable;
	/**
	 * @uml.property  name="hasFire"
	 */
	private boolean hasFire;
	/**
	 * @uml.property  name="hasPlayer"
	 */
	private boolean HasPlayer;
	/**
	 * @uml.property  name="hasPlayers"
	 */
	private boolean HasPlayers;
	/**
	 * @uml.property  name="hasPowerUp"
	 */
	private boolean hasPowerUp;
	/**
	 * @uml.property  name="hasHp"
	 */
	private boolean hasHp;
	/**
	 * @uml.property  name="hasLight"
	 */
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
	
	/**
	 * returns whether there is life/hp or not
	 * @return  hasHp
	 * @uml.property  name="hasHp"
	 */

	public boolean isHasHp() {
		return hasHp;
	}
	
	/**
	 * sets the hp
	 * @param  hasHp
	 * @uml.property  name="hasHp"
	 */

	public void setHasHp(boolean hasHp) {
		this.hasHp = hasHp;
	}
	
	/**
	 * Returns if the tile has the powerup lighting
	 * @return  hasLight
	 * @uml.property  name="hasLight"
	 */

	public boolean isHasLight() {
		return hasLight;
	}
	
	/**
	 * sets so that that the tile will have the powerup lighting or not
	 * @param  hasLight
	 * @uml.property  name="hasLight"
	 */

	public void setHasLight(boolean hasLight) {
		this.hasLight = hasLight;
	}
	
	/**
	 * returns whether the tile has a power-up or not
	 * @return  hasPowerUp
	 * @uml.property  name="hasPowerUp"
	 */

	public boolean isHasPowerUp() {
		return hasPowerUp;
	}
	
	/**
	 * sets the tile whether the tile has a power-up or not
	 * @param  hasPowerUp
	 * @uml.property  name="hasPowerUp"
	 */

	public void setHasPowerUp(boolean hasPowerUp) {
		this.hasPowerUp = hasPowerUp;
	}
	
	/**
	 * returns whether the tile has fire or not 
	 * @return  hasFire
	 * @uml.property  name="hasFire"
	 */

	public boolean isHasFire() {
		return hasFire;
	}
	
	/**
	 * sets whether the tile has fire or not
	 * @param  hasFire
	 * @uml.property  name="hasFire"
	 */

	public void setHasFire(boolean hasFire) {
		this.hasFire = hasFire;
	}
	
	/**
	 * returns whether the tile has players on it or not
	 * @return  hasPlayers
	 * @uml.property  name="hasPlayers"
	 */

	public boolean isHasPlayers() {
		return HasPlayers;
	}
	
	/**
	 * sets whether the tile has players or not
	 * @param  hasPlayers
	 * @uml.property  name="hasPlayers"
	 */

	public void setHasPlayers(boolean hasPlayers) {
		HasPlayers = hasPlayers;
	}
	
	/**
	 * returns whether the tile has a player on it or not
	 * @return  hasPLayer
	 * @uml.property  name="hasPlayer"
	 */

	public boolean isHasPlayer() {
		return HasPlayer;
	}
	
	/**
	 * sets whether the tile has a player or not
	 * @param  hasPlayer
	 * @uml.property  name="hasPlayer"
	 */

	public void setHasPlayer(boolean hasPlayer) {
		HasPlayer = hasPlayer;
	}
	
	/**
	 * returns the x-position for the tile
	 * @return  xPos
	 * @uml.property  name="xPos"
	 */

	public int getxPos() {
		return xPos;
	}
	
	/**
	 * sets the x-positions for the tile
	 * @param  xPos
	 * @uml.property  name="xPos"
	 */

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	/**
	 * returns the y-position for the tile
	 * @return  yPos
	 * @uml.property  name="yPos"
	 */

	public int getyPos() {
		return yPos;
	}
	
	/**
	 * sets the y-position for the tile
	 * @param  yPos
	 * @uml.property  name="yPos"
	 */

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	/**
	 * returns the order of the tile
	 * @return  order
	 * @uml.property  name="order"
	 */

	public int getOrder() {
		return order;
	}
	
	/**
	 * sets the order of the tile
	 * @param  order
	 * @uml.property  name="order"
	 */
	

	public void setOrder(int order) {
		this.order = order;
	}
	
	/**
	 * sets the tile to not destroyable
	 */
	
	public void notDestroyable()
	{
		destroyable = false;
	}
	
	/**
	 * returns whether the tile is destroyable or not
	 * @return  destroyable
	 * @uml.property  name="destroyable"
	 */
	
	public boolean isDestroyable()
	{
		return destroyable;
	}
	
	/**
	 * A non abstract Kind of abstract function for the subclasses
	 * @throws IOException
	 */
	
	
	public void initTiles() throws IOException 
	{
	
	}


	/**
	 * sets the tile to not walkable 
	 */

	public void notWalkable() 
	{
		walkable = false;
	}
	
	/**
	 * sets the tile to walkable
	 */
	
	public void makeWalkable() 
	{
		walkable = true;
	}
	
	/**
	 * @uml.property  name="walkable"
	 */
	
	public boolean isWalkable() 
	{
		return walkable;
	}
}
