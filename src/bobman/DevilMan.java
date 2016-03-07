package bobman;

import java.util.TreeMap;

import javax.swing.ImageIcon;

/**
 * this class creates a player and this class also extends Player
 * 
 * @author Mehdi Adelzadeh
 * @version 2016-03-01
 */

public class DevilMan extends Player
{
	
	private static final long serialVersionUID = -7314698319741768805L;

	public DevilMan(TreeMap<Integer,Tiles> tiles,Board board,
			int status ,int xPos, int yPos, int side) 
	{
		super(tiles,board,status, xPos, yPos,side);
		this.setRange(1);
		this.setHp(3);
	}
	
	/**
	 * this method generates our player at a specific position
	 */

	@Override
	public void initPos() 
	{
		// TODO Auto-generated method stub
		super.initPos();
		setRight(new ImageIcon("src/sprite/rightDemon.gif"));
		setLeft(new ImageIcon("src/sprite/leftDemon.gif"));
		setUp(new ImageIcon("src/sprite/upDemon.gif"));
		setDown(new ImageIcon("src/sprite/downDemon.gif"));
	}
	
	/**
	 * this method creates our player with a certain health and bomb-range
	 */
	
	@Override
	public void initPlayer() 
	{
		this.setRange(1);
		this.setHp(3);
	}
	
}
