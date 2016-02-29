package bobman;

import java.awt.Color;
import java.util.Random;
import java.util.TreeMap;

public class BombExplode
{
	private TreeMap <Integer,Fire> fires;
	private TreeMap<Integer,Tiles> tiles;
	private Tiles bombScanner,bombScanner1;
	private Fire fire,fire1;
	private Board board;
	Random rand = new Random();
	private int whichPower;
	public BombExplode(Board board,TreeMap<Integer, Tiles> tiles) 
	{
		super();
		this.board = board;
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
		bombScanner = null;
		bombScanner1 = null;
		
		if(status ==1)
		{
			board.setRucus(1);
			bombScanner = k;
			fireCenter();
			fireUp();
			fireDown();
			fireRight();
			fireLeft();
		}
		if(status ==2)
		{
			board.setRucus1(1);
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
		System.out.println("player2left");
		Tiles a = tiles.get(bombScanner1.getOrder()-1);
		
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				
				fire1 =  fires.get(11);
				a.add(fire1);
				fire1.setLocate(a);
				a.setHasFire(true);
				if(tiles.get(a.getOrder()-1).isDestroyable())
				{
					if (tiles.get(a.getOrder()-1).isWalkable())
					{
						fire1 =fires.get(15);
						tiles.get(a.getOrder()-1).add(fire1);
						fire1.setLocate(tiles.get(a.getOrder()-1));
						tiles.get(a.getOrder()-1).setHasFire(true);
					}
					
					else if (!tiles.get(a.getOrder()-1).isWalkable())
					{
						
						tiles.get(a.getOrder()-1).removeAll();
						tiles.get(a.getOrder()-1).makeWalkable();
						tiles.get(a.getOrder()-1).setBackground(Color.white);
					}
				}
			
			}
			else if (!a.isWalkable())
			{
				
				a.removeAll();
				a.makeWalkable();
				a.setBackground(Color.white);
				if (a.isHasPowerUp())
				{
					whichPower = rand.nextInt(2) + 1;
					a.add(new Powerup(whichPower));
				}
			}
		}
			
	}

	public void fireRight1() 
	{
		System.out.println("player2left");
		Tiles a = tiles.get(bombScanner1.getOrder()+1);
		
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				
				fire1 =  fires.get(10);
				a.add(fire1);
				fire1.setLocate(a);
				a.setHasFire(true);
				if(tiles.get(a.getOrder()+1).isDestroyable())
				{
					if (tiles.get(a.getOrder()+1).isWalkable())
					{
						fire1 =fires.get(14);
						tiles.get(a.getOrder()+1).add(fire1);
						fire1.setLocate(tiles.get(a.getOrder()+1));
						tiles.get(a.getOrder()+1).setHasFire(true);
					}
					else if (!tiles.get(a.getOrder()+1).isWalkable())
					{
						
						tiles.get(a.getOrder()+1).removeAll();
						tiles.get(a.getOrder()+1).makeWalkable();
						tiles.get(a.getOrder()+1).setBackground(Color.white);
					}
				}
			
			}
			else if (!a.isWalkable())
			{
				
				a.removeAll();
				a.makeWalkable();
				a.setBackground(Color.white);
				if (a.isHasPowerUp())
				{
					whichPower = rand.nextInt(2) + 1;
					a.add(new Powerup(whichPower));
				}
			}
		}
		
	}

	public void fireDown1() 
	{
		System.out.println("player2left");
		Tiles a = tiles.get(bombScanner1.getOrder()+13);
		
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				
				fire1 =  fires.get(13);
				a.add(fire1);
				fire1.setLocate(a);
				a.setHasFire(true);
				if(tiles.get(a.getOrder()+13).isDestroyable())
				{
					if (tiles.get(a.getOrder()+13).isWalkable())
					{
						fire1 =fires.get(17);
						tiles.get(a.getOrder()+13).add(fire1);
						fire1.setLocate(tiles.get(a.getOrder()+13));
						tiles.get(a.getOrder()+13).setHasFire(true);
					}
					else if (!tiles.get(a.getOrder()+13).isWalkable())
					{
						
						tiles.get(a.getOrder()+13).removeAll();
						tiles.get(a.getOrder()+13).makeWalkable();
						tiles.get(a.getOrder()+13).setBackground(Color.white);
					}
				}
			
			}
			else if (!a.isWalkable())
			{
				
				a.removeAll();
				a.makeWalkable();
				a.setBackground(Color.white);
				if (a.isHasPowerUp())
				{
					whichPower = rand.nextInt(2) + 1;
					a.add(new Powerup(whichPower));
				}
			}
		}
		
	}

	public void fireUp1() 
	{
		System.out.println("player2left");
		Tiles a = tiles.get(bombScanner1.getOrder()-13);
		
		
		
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				fire1 = fires.get(12);
				a.add(fire1);
				fire1.setLocate(a);
				a.setHasFire(true);
				if(tiles.get(a.getOrder()-13).isDestroyable())
				{
					if (tiles.get(a.getOrder()-13).isWalkable())
					{
						fire1 =fires.get(16);
						tiles.get(a.getOrder()-13).add(fire1);
						fire1.setLocate(tiles.get(a.getOrder()-13));
						tiles.get(a.getOrder()-13).setHasFire(true);
					}
					else if (!tiles.get(a.getOrder()-13).isWalkable())
					{
						
						tiles.get(a.getOrder()-13).removeAll();
						tiles.get(a.getOrder()-13).makeWalkable();
						tiles.get(a.getOrder()-13).setBackground(Color.white);
					}
				}
			
			}
			else if (!a.isWalkable())
			{
				a.removeAll();
				a.makeWalkable();
				a.setBackground(Color.white);
				if (a.isHasPowerUp())
				{
					whichPower = rand.nextInt(2) + 1;
					a.add(new Powerup(whichPower));
				}
			}
		}		
	}

	public void fireCenter1() 
	{
		System.out.println("player2left");
		fire1 = fires.get(9);
		bombScanner1.add(fire1);
		fire1.setLocate(bombScanner1);
		bombScanner1.setHasFire(true);
		
	}

	public void fireCenter() 
	{
		System.out.println("player1left");
		fire = fires.get(0);
		bombScanner.add(fire);
		fire.setLocate(bombScanner);
		bombScanner.setHasFire(true);
		
	}

	private void fireLeft() 
	{
		System.out.println("player1left");
		Tiles a = tiles.get(bombScanner.getOrder()-1);
		
			if(a.isDestroyable())
			{
				if(a.isWalkable())
				{
					fire = fires.get(2);
					a.add(fire);
					fire.setLocate(a);
					a.setHasFire(true);
					if(tiles.get(a.getOrder()-1).isDestroyable())
					{
						if (tiles.get(a.getOrder()-1).isWalkable())
						{
							fire =fires.get(6);
							tiles.get(a.getOrder()-1).add(fire);
							fire.setLocate(tiles.get(a.getOrder()-1));
							tiles.get(a.getOrder()-1).setHasFire(true);
						}
						else if (!tiles.get(a.getOrder()-1).isWalkable())
						{
							
							tiles.get(a.getOrder()-1).removeAll();
							tiles.get(a.getOrder()-1).makeWalkable();
							tiles.get(a.getOrder()-1).setBackground(Color.white);
						}
					}
					
				
				}
				else if (!a.isWalkable())
				{
					a.removeAll();
					a.makeWalkable();
					a.setBackground(Color.white);
					if (a.isHasPowerUp())
					{
						whichPower = rand.nextInt(2) + 1;
						a.add(new Powerup(whichPower));
					}
				}
			}
		
	}

	private void fireRight() 
	{
		System.out.println("player1left");
		Tiles a = tiles.get(bombScanner.getOrder()+1);
	
			if(a.isDestroyable())
			{
				if(a.isWalkable())
				{
					fire = fires.get(1);
					a.add(fire);
					fire.setLocate(a);
					a.setHasFire(true);
					if(tiles.get(a.getOrder()+1).isDestroyable())
					{
						if (tiles.get(a.getOrder()+1).isWalkable())
						{
							fire =fires.get(5);
							tiles.get(a.getOrder()+1).add(fire);
							fire.setLocate(tiles.get(a.getOrder()+1));
							tiles.get(a.getOrder()+1).setHasFire(true);
						}
						else if (!tiles.get(a.getOrder()+1).isWalkable())
						{
							
							tiles.get(a.getOrder()+1).removeAll();
							tiles.get(a.getOrder()+1).makeWalkable();
							tiles.get(a.getOrder()+1).setBackground(Color.white);
						}
					}
					
				
				}
				else if (!a.isWalkable())
				{
					a.removeAll();
					a.makeWalkable();
					a.setBackground(Color.white);
					if (a.isHasPowerUp())
					{
						whichPower = rand.nextInt(2) + 1;
						a.add(new Powerup(whichPower));
					}
				}
			}
		
	}

	private void fireDown() 
	{
		System.out.println("player1left");
		Tiles a = tiles.get(bombScanner.getOrder()+13);
		
			if(a.isDestroyable())
			{
				if(a.isWalkable())
				{
					fire = fires.get(4);
					a.add(fire);
					fire.setLocate(a);
					a.setHasFire(true);
					if(tiles.get(a.getOrder()+13).isDestroyable())
					{
						if (tiles.get(a.getOrder()+13).isWalkable())
						{
							fire =fires.get(8);
							tiles.get(a.getOrder()+13).add(fire);
							fire.setLocate(tiles.get(a.getOrder()+13));
							tiles.get(a.getOrder()+13).setHasFire(true);
						}
						else if (!tiles.get(a.getOrder()+13).isWalkable())
						{
							
							tiles.get(a.getOrder()+13).removeAll();
							tiles.get(a.getOrder()+13).makeWalkable();
							tiles.get(a.getOrder()+13).setBackground(Color.white);
						}
					}
					
				
				}
				else if (!a.isWalkable())
				{
					a.removeAll();
					a.makeWalkable();
					a.setBackground(Color.white);
					if (a.isHasPowerUp())
					{
						whichPower = rand.nextInt(2) + 1;
						a.add(new Powerup(whichPower));
					}
				}
			}
		
	}

	private void fireUp() 
	{
		System.out.println("player1left");
		Tiles a = tiles.get(bombScanner.getOrder()-13);
		
		
		
			if(a.isDestroyable())
			{
				if(a.isWalkable())
				{
					fire = fires.get(3);
					a.add(fire);
					fire.setLocate(a);
					a.setHasFire(true);
					if(tiles.get(a.getOrder()-13).isDestroyable())
					{
						if (tiles.get(a.getOrder()-13).isWalkable())
						{
							fire =fires.get(7);
							fire.setLocate(tiles.get(a.getOrder()-13));
							tiles.get(a.getOrder()-13).add(fire);
							tiles.get(a.getOrder()-13).setHasFire(true);
						}
						else if (!tiles.get(a.getOrder()-13).isWalkable())
						{
							
							tiles.get(a.getOrder()-13).removeAll();
							tiles.get(a.getOrder()-13).makeWalkable();
							tiles.get(a.getOrder()-13).setBackground(Color.white);
						}
					}
				
				}
				else if (!a.isWalkable())
				{
					
					a.removeAll();
					a.makeWalkable();
					a.setBackground(Color.white);
					if (a.isHasPowerUp())
					{
						whichPower = rand.nextInt(2) + 1;
						a.add(new Powerup(whichPower));
					}
				}
			}
	}
	
	public void fireReset1()
	{
		Tiles a;
		if(fires.get(0).isactive())
		{
			for (int i= 0; i<9; i++)
			{
				Fire k = fires.get(i);
				if (k.isactive())
				{
					a = tiles.get(k.getxPos() + k.getyPos()*13);
					a.setHasFire(false);
					a.removeAll();
					k.notActive();
				}
			}
		}
	}
	
	public void fireReset2()
	{
		Tiles a;
		if(fires.get(9).isactive())
		{
			for (int i= 9; i<18; i++)
			{
				Fire k = fires.get(i);
				if (k.isactive())
				{
					a = tiles.get(k.getxPos() + k.getyPos()*13);
					a.setHasFire(false);
					a.removeAll();
					k.notActive();
				}
			}
		}
	}

	
		
		
}
