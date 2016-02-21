package bobman;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class Levels 
{
	
	private Board board;
	private TreeMap<Integer,Tiles> tiles;
	private static final Set<Integer> playerSpace = new HashSet<Integer>(Arrays.asList(14,15,16,27,40,128,141,152,153,154));
	private int currentLevel;
	Random rand = new Random();	
	
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
			l.removeAll();
		}
		
		for( int i=0; i<169; i++)
		{
			l=tiles.get(i);
			if (l.getxPos() == 0 || l.getyPos() == 0
					|| l.getxPos() == 12 || l.getyPos()==12)
				{
					l.setBackground(Color.black);
					l.add(new Wall(l.getxPos(),l.getY(),
					l.getOrder()));
					l.notDestroyable();
					
				}
				else if (l.getxPos() % 2 == 0 && l.getyPos()% 2 == 0)
				{
					l.setBackground(Color.black);
					l.add(new Wall(l.getxPos(),l.getY(),
					l.getOrder()));
					l.notDestroyable();
				}
			
		}		
		
	}
	
	public void chooseLevel() 
	{
		String[] options = new String[] {"Level one", "Level two", "Level three", "Quit"};
		currentLevel =  JOptionPane.showOptionDialog(null, "To start the game", "choose level",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[0]);
		sameLevel();
		
	}
	
	public void sameLevel()
	{
		switch(currentLevel)
		{
		case 0: levelOne();
		break;
		
		case 1: levelTwo();
		break;
		
		case 2: levelThree();
		break;
		
		case 3: System.exit(0);
		}
	}

	public void levelOne()
	{
		int randomnumber;
		int enoughDWalls = 0;
		Tiles p;
		while(enoughDWalls < 84)
		{
			randomnumber = rand.nextInt(169);
			if (playerSpace.contains(randomnumber))
			{
				continue;
			}
			
			p = tiles.get(randomnumber);
			if (p.isDestroyable())
			{
				p.add(new Dwall(p.getxPos(),p.getY(),p.getOrder()));
				p.setBackground(Color.red);
				enoughDWalls++;
			}

		}		
	}
	
	public void levelTwo()
	{
		System.out.println("level2");
	}
	
	public void levelThree()
	{
		System.out.println("level3");
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

}
