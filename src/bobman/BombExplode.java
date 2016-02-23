package bobman;

import java.awt.Color;
import java.util.TreeMap;

import javax.swing.Timer;

public class BombExplode 
{
	private TreeMap<Integer,Tiles> tiles,explodeRatio;
	private Tiles bombScanner;
	private Board board;
	private Bomb bomb;
	private Fire fire;
	private Timer timer;
	private boolean up,down,left,right;
	public BombExplode(TreeMap<Integer, Tiles> tiles, Board board,Timer timer) 
	{
		super();
		this.tiles = tiles;
		this.board = board;
		this.timer = timer;
		explodeRatio = new TreeMap<>();
		
	}
	
	public void BombExploded(Tiles k)
	{
		bombScanner = k;
		up=down=left=right=false;
		fireCenter();
		fireUp();
		fireDown();
		fireRight();
		fireLeft();
		timer.start();
	}

	public void fireCenter() 
	{
		fire = new Fire(1);
		bombScanner.add(fire);
		
	}

	private void fireLeft() 
	{
		Tiles a = tiles.get(bombScanner.getOrder()-1);
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				left = true;
				fire = new Fire(1);
				a.add(fire);
			
			}
			else if (!a.isWalkable())
			{
				left = false;
				a.removeAll();
				a.makeWalkable();
				a.setBackground(Color.white);
			}
		}
	}

	private void fireRight() 
	{
		Tiles a = tiles.get(bombScanner.getOrder()+1);
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				right = true;
				fire = new Fire(1);
				a.add(fire);
			
			}
			else if (!a.isWalkable())
			{
				right = false;
				a.removeAll();
				a.makeWalkable();
				a.setBackground(Color.white);
			}
		}
	}

	private void fireDown() 
	{
		Tiles a = tiles.get(bombScanner.getOrder()+13);
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				down = true;
				fire = new Fire(1);
				a.add(fire);
			
			}
			else if (!a.isWalkable())
			{
				down = false;
				a.removeAll();
				a.makeWalkable();
				a.setBackground(Color.white);
			}
		}
		
	}

	private void fireUp() 
	{
		Tiles a = tiles.get(bombScanner.getOrder()-13);
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				up = true;
				fire = new Fire(1);
				a.add(fire);
			
			}
			else if (!a.isWalkable())
			{
				up = false;
				a.removeAll();
				a.makeWalkable();
				a.setBackground(Color.white);
			}
		}
	}

	public void resetfire()
	{
		Tiles a;
		bombScanner.removeAll();
		if(right)
		{
			a = tiles.get(bombScanner.getOrder()+1);
			a.removeAll();
		}
		
		if(left)
		{
			a = tiles.get(bombScanner.getOrder()-1);
			a.removeAll();
		}
		
		if(up)
		{
			a = tiles.get(bombScanner.getOrder()-13);
			a.removeAll();
		}
		
		if(down)
		{
			a = tiles.get(bombScanner.getOrder()+13);
			a.removeAll();
		}
		
		
		
	}
	
	
	
}
