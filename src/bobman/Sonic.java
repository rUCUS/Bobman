package bobman;

import java.util.TreeMap;

import javax.swing.Timer;

public class Sonic extends Player 
{
	private Board board;
	public Sonic(TreeMap<Integer,Tiles> tiles,Board board,Timer timer1,Timer timer2,
			int status, int hp, int xPos, int yPos, int speed, int side) 
	{
		super(tiles,board,timer1,timer2,status,hp, xPos, yPos,speed,side);
		
	}

}
