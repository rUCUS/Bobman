package bobman;

import java.util.TreeMap;

import javax.swing.Timer;

public class HanSolo extends Player 
{
	private Board board;
	public HanSolo(TreeMap<Integer,Tiles> tiles,Board board,Timer timer1,Timer timer2,int status, int hp, int xPos, int yPos, Bomb bomb, int speed, int side) 
	{
		super(tiles,board,timer1,timer2,status,hp, xPos, yPos, bomb,speed,side);
		
	}

}
