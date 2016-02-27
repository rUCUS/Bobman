package bobman;

import java.util.TreeMap;

import javax.swing.Timer;

public class DevilMan extends Player
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7314698319741768805L;

	public DevilMan(TreeMap<Integer,Tiles> tiles,Board board,Timer timer1,Timer timer2,
			int status ,int hp, int xPos, int yPos, int speed, int side) 
	{
		super(tiles,board,status,hp, xPos, yPos,speed,side);
		
	}

}
