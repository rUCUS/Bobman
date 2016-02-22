package bobman;

import java.util.TreeMap;

public class HanSolo extends Player 
{
	private Board board;
	public HanSolo(TreeMap<Integer,Tiles> tiles,Board board, int hp, int xPos, int yPos, Bomb bomb, int speed, int side) 
	{
		super(tiles,board,hp, xPos, yPos, bomb,speed,side);
		
	}

}
