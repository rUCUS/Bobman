package bobman;

import java.awt.Color;
import java.util.TreeMap;

public class Levels 
{
	private Board board;
	private TreeMap<Integer,Tiles> tiles;
	
	public Levels(Board board, TreeMap<Integer,Tiles> tiles)
	{
		this.board = board;
		this.tiles = tiles;
		
	}
	
	public void initBaseLevel() 
	{
		Tiles l;
		
		for( int i=0; i<169; i++)
		{
			l = tiles.get(i);
			l.setBackground(Color.white);
			if (l.getxPos() == 0 || l.getyPos() == 0
				|| l.getxPos() == 12 || l.getyPos()==12)
			{
				l.setBackground(Color.black);
				
			}
			else if (l.getxPos() % 2 == 0 && l.getyPos()% 2 == 0)
			{
				l.setBackground(Color.black);
			}
			
		}
		
		
	}
	
	public void levelOne()
	{
		
	}
	
	public void levelTwo()
	{
		
	}
	
	public void levelThree()
	{
		
	}

}
