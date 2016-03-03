package bobman;

import java.util.TreeMap;

import javax.swing.ImageIcon;

public class Sonic extends Player 
{
	/*
	 * this class creates a player
	 * it also extends Player 
	 */
	
	private static final long serialVersionUID = -8839858857139384364L;
	public Sonic(TreeMap<Integer,Tiles> tiles,Board board,
			int status, int xPos, int yPos, int side) 
	{
		super(tiles,board,status, xPos, yPos,side);	
	}
	
	/*
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

	@Override
	public void initPlayer() 
	{
		this.setRange(2);
		this.setHp(1);
		this.getHandler().setHasLight(true);
	}
	

}
