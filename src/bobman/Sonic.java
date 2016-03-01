package bobman;

import java.util.TreeMap;

import javax.swing.ImageIcon;

public class Sonic extends Player 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8839858857139384364L;
	public Sonic(TreeMap<Integer,Tiles> tiles,Board board,
			int status, int hp, int xPos, int yPos, int range, int side) 
	{
		super(tiles,board,status,hp, xPos, yPos,range,side);
		this.setRange(2);
		
	}
	@Override
	public void initPos() {
		// TODO Auto-generated method stub
		super.initPos();
		setRight(new ImageIcon("src/sprite/leftWalk.gif"));
		setLeft(new ImageIcon("src/sprite/rightwalk.gif"));
		setUp(new ImageIcon("src/sprite/downWalk.gif"));
		setDown(new ImageIcon("src/sprite/upWalk.gif"));
	}
	

}
