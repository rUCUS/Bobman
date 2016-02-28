package bobman;

import java.awt.Color;
import java.util.TreeMap;

public class BombExplode
{
	private TreeMap <Integer,Fire> fires;
	private TreeMap<Integer,Tiles> tiles;
	private Tiles bombScanner,bombScanner1;
	private Fire fire,fire1;
	private boolean up,down,left,right;
	private boolean right1,up1,left1,down1;
	public BombExplode(TreeMap<Integer, Tiles> tiles) 
	{
		super();
		this.tiles = tiles;
		initFires();
		
	}
	
	public void initFires() 
	{
		fires = new TreeMap<>();
		for (int i = 0; i<18; i++)
		{
			if (i<9)
			{
				fires.put(i, new Fire(1,this));
			}
			else
			{
				fires.put(i, new Fire(2,this));
			}
			
			
		}
		
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
				fire1 =  fires.get(11);
				a.add(fire1);
				a.setHasFire(true);
				if(tiles.get(a.getOrder()-1).isDestroyable())
				{
					if (tiles.get(a.getOrder()-1).isWalkable())
					{
						fire1 =fires.get(15);
						tiles.get(a.getOrder()-1).add(fire1);
						tiles.get(a.getOrder()-1).setHasFire(true);
					}
				}
			
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
				fire1 =  fires.get(10);
				a.add(fire1);
				a.setHasFire(true);
				if(tiles.get(a.getOrder()+1).isDestroyable())
				{
					if (tiles.get(a.getOrder()+1).isWalkable())
					{
						fire1 =fires.get(14);
						tiles.get(a.getOrder()+1).add(fire1);
						tiles.get(a.getOrder()+1).setHasFire(true);
					}
				}
			
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
				fire1 =  fires.get(13);
				a.add(fire1);
				a.setHasFire(true);
				if(tiles.get(a.getOrder()+13).isDestroyable())
				{
					if (tiles.get(a.getOrder()+13).isWalkable())
					{
						fire1 =fires.get(17);
						tiles.get(a.getOrder()+13).add(fire1);
						tiles.get(a.getOrder()+13).setHasFire(true);
					}
				}
			
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
				fire1 = fires.get(12);
				a.add(fire1);
				a.setHasFire(true);
				if(tiles.get(a.getOrder()-13).isDestroyable())
				{
					if (tiles.get(a.getOrder()-13).isWalkable())
					{
						fire1 =fires.get(16);
						tiles.get(a.getOrder()-13).add(fire1);
						tiles.get(a.getOrder()-13).setHasFire(true);
					}
				}
			
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
		fire1 = fires.get(8);
		bombScanner1.add(fire1);
		bombScanner1.setHasFire(true);
		
	}

	public void fireCenter() 
	{
		fire = fires.get(0);
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
					fire = fires.get(2);
					a.add(fire);
					a.setHasFire(true);
					if(tiles.get(a.getOrder()-1).isDestroyable())
					{
						if (tiles.get(a.getOrder()-1).isWalkable())
						{
							fire =fires.get(6);
							tiles.get(a.getOrder()-1).add(fire);
							tiles.get(a.getOrder()-1).setHasFire(true);
						}
					}
					
				
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
					fire = fires.get(1);
					a.add(fire);
					a.setHasFire(true);
					if(tiles.get(a.getOrder()+1).isDestroyable())
					{
						if (tiles.get(a.getOrder()+1).isWalkable())
						{
							fire =fires.get(5);
							tiles.get(a.getOrder()+1).add(fire);
							tiles.get(a.getOrder()+1).setHasFire(true);
						}
					}
					
				
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
					fire = fires.get(4);
					a.add(fire);
					a.setHasFire(true);
					if(tiles.get(a.getOrder()+13).isDestroyable())
					{
						if (tiles.get(a.getOrder()+13).isWalkable())
						{
							fire =fires.get(8);
							tiles.get(a.getOrder()+13).add(fire);
							tiles.get(a.getOrder()+13).setHasFire(true);
						}
					}
					
				
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
					fire = fires.get(3);
					a.add(fire);
					a.setHasFire(true);
					if(tiles.get(a.getOrder()-13).isDestroyable())
					{
						if (tiles.get(a.getOrder()-13).isWalkable())
						{
							fire =fires.get(7);
							tiles.get(a.getOrder()-13).add(fire);
							tiles.get(a.getOrder()-13).setHasFire(true);
						}
					}
				
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

	
		
		
}
