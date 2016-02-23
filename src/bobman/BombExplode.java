package bobman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.Timer;

public class BombExplode
{
	private TreeMap<Integer,Tiles> tiles,explodeRatio;
	private Tiles bombScanner;
	private Board board;
	private Bomb bomb;
	private Fire fire,fire1,fire2;
	private Timer timer1,timer2;
	private boolean up,down,left,right;
	public BombExplode(TreeMap<Integer, Tiles> tiles, Board board) 
	{
		super();
		this.tiles = tiles;
		this.board = board;
		explodeRatio = new TreeMap<>();
		
	}
	
	public void BombExploded(Tiles k,int status)
	{
		bombScanner = k;
		up=down=left=right=false;
		fireCenter();
		fireUp();
		fireDown();
		fireRight();
		fireLeft();
		
	}

	public void fireCenter() 
	{
		fire = new Fire(1,this,bombScanner.getxPos(),bombScanner.getyPos());
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
					fire = new Fire(1,this,bombScanner.getxPos(),bombScanner.getyPos());
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
					fire = new Fire(1,this,bombScanner.getxPos(),bombScanner.getyPos());
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
					fire = new Fire(1,this,bombScanner.getxPos(),bombScanner.getyPos());
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
					fire = new Fire(1,this,bombScanner.getxPos(),bombScanner.getyPos());
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

	public void resetfire(int player,int xPos,int yPos,Fire fire)
	{
			
			Tiles a;
			bombScanner = tiles.get(xPos + yPos*13);
			bombScanner.removeAll();
			
			
			
			if(right)
			{
				a = tiles.get(xPos + yPos*13 +1);
				a.removeAll();
				right = false;
			}
			
			if(left)
			{
				a = tiles.get(xPos + yPos*13 -1);
				a.removeAll();
				left = false;
			}
			
			if(up)
			{
				a = tiles.get(xPos + yPos*13 -13);
				a.removeAll();
				up = false;
			}
			
			if(down)
			{
				a = tiles.get(xPos + yPos*13 +13);
				a.removeAll();
				down = false;
				
			}
			fire.turnOffTimer();
			
			
		}

	
		
		
}
