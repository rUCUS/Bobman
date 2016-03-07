package bobman;

import java.util.TreeMap;

import javax.swing.ImageIcon;

/**
 * this class creates a player
 * it also extends Player 
 * 
 * @author Danny Lam
 * @version 2016-03-03
 */

public class Sonic extends Player 
{
	
	
	private static final long serialVersionUID = -8839858857139384364L;
	public Sonic(TreeMap<Integer,Tiles> tiles,Board board,
			int status, int xPos, int yPos, int side) 
	{
		super(tiles,board,status, xPos, yPos,side);	
	}
	
	/**
	 * initialize our player,Sonic
	 */
	
	@Override
	public void initPos() {
		// TODO Auto-generated method stub
		super.initPos();
		setRight(new ImageIcon("src/sprite/rightSonic.gif"));
		setLeft(new ImageIcon("src/sprite/leftSonic.gif"));
		setUp(new ImageIcon("src/sprite/upSonic.gif"));
		setDown(new ImageIcon("src/sprite/downSonic.gif"));
	}

	/**
	 * * Initialize our player with certain bomb-range and life
	 */
	
	@Override
	
	public void initPlayer() 
	{
		this.setRange(2);
		this.setHp(1);
		this.getHandler().setHasLight(true);
	}
	

}
