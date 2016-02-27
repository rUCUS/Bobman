package bobman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.Timer;

public class BombExplode
{
	private TreeMap<Integer,Tiles> tiles,explodeRatio;
	private Tiles bombScanner,bombScanner1;
	private Board board;
	private Bomb bomb;
	private Fire fire,fire1;
	private Timer timer1,timer2;
	private boolean up,down,left,right;
	private boolean right1,up1,left1,down1;
	public BombExplode(TreeMap<Integer, Tiles> tiles, Board board) 
	{
		super();
		this.tiles = tiles;
		this.board = board;
		explodeRatio = new TreeMap<>();
		
	}
	
	public void BombExploded(Tiles k,int status)
	{
		
		up=down=left=right=false;
		up1=down1=left1=right1=false;
		if(status ==1)
		{
			bombScanner = k;
			fireCenter();
			fireUp();
			fireDown();
			fireRight();
			fireLeft();
		}
		if(status ==2)
		{
			bombScanner1 = k;
			fireCenter1();
			fireUp1();
			fireDown1();
			fireRight1();
			fireUp1();
			fireLeft1();
		}
		
	}

	public void fireLeft1() 
	{
		Tiles a = tiles.get(bombScanner1.getOrder()-1);
		
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				left1 = true;
				fire1 = new Fire(2,this,bombScanner1.getxPos(),bombScanner1.getyPos());
				a.add(fire1);
				a.setHasFire(true);
			
			}
			else if (!a.isWalkable())
			{
				left1 = false;
				a.removeAll();
				a.makeWalkable();
				a.setBackground(Color.white);
			}
		}
			
	}

	public void fireRight1() 
	{
		Tiles a = tiles.get(bombScanner1.getOrder()+1);
		
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				right1 = true;
				fire1 = new Fire(2,this,bombScanner1.getxPos(),bombScanner1.getyPos());
				a.add(fire1);
				a.setHasFire(true);
			
			}
			else if (!a.isWalkable())
			{
				right1 = false;
				a.removeAll();
				a.makeWalkable();
				a.setBackground(Color.white);
			}
		}
		
	}

	public void fireDown1() 
	{
		Tiles a = tiles.get(bombScanner1.getOrder()+13);
		
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				down1 = true;
				fire1 = new Fire(2,this,bombScanner1.getxPos(),bombScanner1.getyPos());
				a.add(fire1);
				a.setHasFire(true);
			
			}
			else if (!a.isWalkable())
			{
				down1 = false;
				a.removeAll();
				a.makeWalkable();
				a.setBackground(Color.white);
			}
		}
		
	}

	public void fireUp1() 
	{
		Tiles a = tiles.get(bombScanner1.getOrder()-13);
		
		
		
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				up1 = true;
				fire1 = new Fire(2,this,bombScanner1.getxPos(),bombScanner1.getyPos());
				a.add(fire1);
				a.setHasFire(true);
				
			
			}
			else if (!a.isWalkable())
			{
				up1 = false;
				a.removeAll();
				a.makeWalkable();
				a.setBackground(Color.white);
			}
		}		
	}

	public void fireCenter1() 
	{
		fire1 = new Fire(2,this,bombScanner1.getxPos(),bombScanner1.getyPos());
		bombScanner1.add(fire1);
		bombScanner1.setHasFire(true);
		
	}

	public void fireCenter() 
	{
		fire = new Fire(1,this,bombScanner.getxPos(),bombScanner.getyPos());
		bombScanner.add(fire);
		bombScanner.setHasFire(true);
		
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
					a.setHasFire(true);
					
				
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
					a.setHasFire(true);
					
				
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
					a.setHasFire(true);
					
				
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
					a.setHasFire(true);
					
				
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

	public void resetfire(int xPos,int yPos,Fire fire)
	{
		

		if (fire.getPlayer() == 1)
		{
			
			Tiles a;
			bombScanner = tiles.get(xPos + yPos*13);
			bombScanner.removeAll();
			bombScanner.setHasFire(false);
			
			
			
			if(right)
			{
				a = tiles.get(xPos + yPos*13 +1);
				a.removeAll();
				a.setHasFire(false);
				right = false;
			}
			
			if(left)
			{
				a = tiles.get(xPos + yPos*13 -1);
				a.removeAll();
				a.setHasFire(false);
				left = false;
			}
			
			if(up)
			{
				a = tiles.get(xPos + yPos*13 -13);
				a.removeAll();
				a.setHasFire(false);
				up = false;
			}
			
			if(down)
			{
				a = tiles.get(xPos + yPos*13 +13);
				a.removeAll();
				a.setHasFire(false);
				down = false;
				
			}
			fire.turnOffTimer();
		}
			
		if (fire.getPlayer() == 2)
		{
			

			Tiles a;
			bombScanner1 = tiles.get(xPos + yPos*13);
			bombScanner1.removeAll();
			bombScanner1.setHasFire(false);
			
			
			
			if(right1)
			{
				a = tiles.get(xPos + yPos*13 +1);
				a.removeAll();
				a.setHasFire(false);
				right = false;
			}
			
			if(left1)
			{
				a = tiles.get(xPos + yPos*13 -1);
				a.removeAll();
				a.setHasFire(false);
				left = false;
			}
			
			if(up1)
			{
				a = tiles.get(xPos + yPos*13 -13);
				a.removeAll();
				a.setHasFire(false);
				up = false;
			}
			
			if(down1)
			{
				a = tiles.get(xPos + yPos*13 +13);
				a.removeAll();
				a.setHasFire(false);
				down = false;
				
			}
			fire.turnOffTimer1();
		}
			
		}

	
		
		
}
