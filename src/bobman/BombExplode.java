package bobman;

import java.awt.Color;
import java.util.TreeMap;

/*
 * 
 */

public class BombExplode
{
	private TreeMap <Integer,Fire> fires;
	private TreeMap<Integer,Tiles> tiles;
	private Tiles bombScanner,bombScanner1;
	private Fire fire,fire1;
	private Board board;
	public BombExplode(Board board,TreeMap<Integer, Tiles> tiles) 
	{
		super();
		this.board = board;
		this.tiles = tiles;
		initFires();
		
	}
	
	/*
	 * this method initialize our fire for player1's and
	 * player2's bombs
	 */
	
	public void initFires() 
	{
		fires = new TreeMap<>();
		for (int i = 0; i<26; i++)
		{
			if (i<13)
			{
				fires.put(i, new Fire(1,this));
			}
			else
			{
				fires.put(i, new Fire(2,this));
			}
			
			
		}
		
	}
	
	/*
	 * this method is used when the bomb is exploded and it transfers
	 * the fire to a certain area for both player1's and player2's bombs
	 */

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
	
	/*
	 * this method directs our fire towards the left for 
	 * player1's bombs
	 */

	public void fireLeft1() 
	{
		Tiles a = tiles.get(bombScanner1.getOrder()-1);
		
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				
				fire1 =  fires.get(15);
				a.add(fire1);
				fire1.setLocate(a);
				a.setHasFire(true);
				
				if(board.getLevels().getPlayer2().getRange() >1)
				{
					if(tiles.get(a.getOrder()-1).isDestroyable())
				{
					if (tiles.get(a.getOrder()-1).isWalkable())
					{
						fire1 =fires.get(19);
						tiles.get(a.getOrder()-1).add(fire1);
						fire1.setLocate(tiles.get(a.getOrder()-1));
						tiles.get(a.getOrder()-1).setHasFire(true);
						if(board.getLevels().getPlayer2().getHandler().isHasLight())
						{
							board.getLevels().getPlayer2().getHandler().lighting(a,23,fires);
						}
					}
					
					else if (!tiles.get(a.getOrder()-1).isWalkable())
					{
						
						tiles.get(a.getOrder()-1).removeAll();
						tiles.get(a.getOrder()-1).makeWalkable();
						tiles.get(a.getOrder()-1).setBackground(Color.white);
					}
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
					if(a.isHasHp())
					{
						a.add(new Powerup(1));
					}
					else
					{
						a.add(new Powerup(2));

					}
				}
			}
		}
			
	}
	
	/*
	 * this method directs our fire towards the right for 
	 * player1's bombs
	 */


	public void fireRight1() 
	{
		Tiles a = tiles.get(bombScanner1.getOrder()+1);
		
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				
				fire1 =  fires.get(14);
				a.add(fire1);
				fire1.setLocate(a);
				a.setHasFire(true);
				if(board.getLevels().getPlayer2().getRange() >1)
				{
					if(tiles.get(a.getOrder()+1).isDestroyable())
				{
					if (tiles.get(a.getOrder()+1).isWalkable())
					{
						fire1 =fires.get(18);
						tiles.get(a.getOrder()+1).add(fire1);
						fire1.setLocate(tiles.get(a.getOrder()+1));
						tiles.get(a.getOrder()+1).setHasFire(true);
						
						if(board.getLevels().getPlayer2().getHandler().isHasLight())
						{
							board.getLevels().getPlayer2().getHandler().lighting(a,22,fires);
						}
					}
					else if (!tiles.get(a.getOrder()+1).isWalkable())
					{
						
						tiles.get(a.getOrder()+1).removeAll();
						tiles.get(a.getOrder()+1).makeWalkable();
						tiles.get(a.getOrder()+1).setBackground(Color.white);
					}
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
					if(a.isHasHp())
					{
						a.add(new Powerup(1));
					}
					else
					{
						a.add(new Powerup(2));

					}
				}
			}
		}
		
	}
	
	/*
	 * this method direct our fire downwards for 
	 * player1's bombs
	 */

	public void fireDown1() 
	{
		Tiles a = tiles.get(bombScanner1.getOrder()+13);
		
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				
				fire1 =  fires.get(17);
				a.add(fire1);
				fire1.setLocate(a);
				a.setHasFire(true);
				if(board.getLevels().getPlayer2().getRange() >1)
				{
					if(tiles.get(a.getOrder()+13).isDestroyable())
				{
					if (tiles.get(a.getOrder()+13).isWalkable())
					{
						fire1 =fires.get(21);
						tiles.get(a.getOrder()+13).add(fire1);
						fire1.setLocate(tiles.get(a.getOrder()+13));
						tiles.get(a.getOrder()+13).setHasFire(true);
						if(board.getLevels().getPlayer2().getHandler().isHasLight())
						{
							board.getLevels().getPlayer2().getHandler().lighting(a,25,fires);
						}
					}
					else if (!tiles.get(a.getOrder()+13).isWalkable())
					{
						
						tiles.get(a.getOrder()+13).removeAll();
						tiles.get(a.getOrder()+13).makeWalkable();
						tiles.get(a.getOrder()+13).setBackground(Color.white);
					}
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
					if(a.isHasHp())
					{
						a.add(new Powerup(1));
					}
					else
					{
						a.add(new Powerup(2));

					}
				}
			}
		}
		
	}
	
	/*
	 * this method direct our fire upwards for 
	 * player1's bombs
	 */


	public void fireUp1() 
	{
		Tiles a = tiles.get(bombScanner1.getOrder()-13);
		
		
		
		if(a.isDestroyable())
		{
			if(a.isWalkable())
			{
				fire1 = fires.get(16);
				a.add(fire1);
				fire1.setLocate(a);
				a.setHasFire(true);
				if(board.getLevels().getPlayer2().getRange() >1)
				{
					if(tiles.get(a.getOrder()-13).isDestroyable())
				{
					if (tiles.get(a.getOrder()-13).isWalkable())
					{
						fire1 =fires.get(20);
						tiles.get(a.getOrder()-13).add(fire1);
						fire1.setLocate(tiles.get(a.getOrder()-13));
						tiles.get(a.getOrder()-13).setHasFire(true);
						if(board.getLevels().getPlayer2().getHandler().isHasLight())
						{
							board.getLevels().getPlayer2().getHandler().lighting(a,24,fires);
						}
					}
					else if (!tiles.get(a.getOrder()-13).isWalkable())
					{
						
						tiles.get(a.getOrder()-13).removeAll();
						tiles.get(a.getOrder()-13).makeWalkable();
						tiles.get(a.getOrder()-13).setBackground(Color.white);
					}
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
					if(a.isHasHp())
					{
						a.add(new Powerup(1));
					}
					else
					{
						a.add(new Powerup(2));

					}
				}
			}
		}		
	}

	public void fireCenter1() 
	{
		fire1 = fires.get(13);
		bombScanner1.add(fire1);
		fire1.setLocate(bombScanner1);
		bombScanner1.setHasFire(true);
		
	}

	public void fireCenter() 
	{
		fire = fires.get(0);
		bombScanner.add(fire);
		fire.setLocate(bombScanner);
		bombScanner.setHasFire(true);
		
	}
	
	/*
	 * this method directs our fire towards the left for 
	 * player2's bombs
	 */


	private void fireLeft() 
	{
		Tiles a = tiles.get(bombScanner.getOrder()-1);
		
			if(a.isDestroyable())
			{
				if(a.isWalkable())
				{
					fire = fires.get(2);
					a.add(fire);
					fire.setLocate(a);
					a.setHasFire(true);
					if(board.getLevels().getPlayer1().getRange() >1)
					{
						if(tiles.get(a.getOrder()-1).isDestroyable())
					{
						if (tiles.get(a.getOrder()-1).isWalkable())
						{
							fire =fires.get(6);
							tiles.get(a.getOrder()-1).add(fire);
							fire.setLocate(tiles.get(a.getOrder()-1));
							tiles.get(a.getOrder()-1).setHasFire(true);
							if(board.getLevels().getPlayer1().getHandler().isHasLight())
							{
								board.getLevels().getPlayer1().getHandler().lighting(a,10,fires);
							}
						}
						else if (!tiles.get(a.getOrder()-1).isWalkable())
						{
							
							tiles.get(a.getOrder()-1).removeAll();
							tiles.get(a.getOrder()-1).makeWalkable();
							tiles.get(a.getOrder()-1).setBackground(Color.white);
						}
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
						if(a.isHasHp())
						{
							a.add(new Powerup(1));
						}
						else
						{
							a.add(new Powerup(2));

						}
					}
				}
			}
		
	}
	
	/*
	 * this method directs our fire towards the right for 
	 * player2's bombs
	 */


	private void fireRight() 
	{
		Tiles a = tiles.get(bombScanner.getOrder()+1);
	
			if(a.isDestroyable())
			{
				if(a.isWalkable())
				{
					fire = fires.get(1);
					a.add(fire);
					fire.setLocate(a);
					a.setHasFire(true);
					
					if(board.getLevels().getPlayer1().getRange() >1)
					{
						if(tiles.get(a.getOrder()+1).isDestroyable())
						{
						if (tiles.get(a.getOrder()+1).isWalkable())
							{
							fire =fires.get(5);
							tiles.get(a.getOrder()+1).add(fire);
							fire.setLocate(tiles.get(a.getOrder()+1));
							tiles.get(a.getOrder()+1).setHasFire(true);
							if(board.getLevels().getPlayer1().getHandler().isHasLight())
							{
								board.getLevels().getPlayer1().getHandler().lighting(a,9,fires);
							}
							}
						else if (!tiles.get(a.getOrder()+1).isWalkable())
							{
							
							tiles.get(a.getOrder()+1).removeAll();
							tiles.get(a.getOrder()+1).makeWalkable();
							tiles.get(a.getOrder()+1).setBackground(Color.white);
							}
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
						if(a.isHasHp())
						{
							a.add(new Powerup(1));
						}
						else
						{
							a.add(new Powerup(2));

						}
					}
				}
			}
		
	}
	
	/*
	 * this method direct our fire downwards for 
	 * player2's bombs
	 */

	private void fireDown() 
	{
		Tiles a = tiles.get(bombScanner.getOrder()+13);
		
			if(a.isDestroyable())
			{
				if(a.isWalkable())
				{
					fire = fires.get(4);
					a.add(fire);
					fire.setLocate(a);
					a.setHasFire(true);
					
					if(board.getLevels().getPlayer1().getRange() >1)
					{
						if(tiles.get(a.getOrder()+13).isDestroyable())
					{
						if (tiles.get(a.getOrder()+13).isWalkable())
						{
							fire =fires.get(8);
							tiles.get(a.getOrder()+13).add(fire);
							fire.setLocate(tiles.get(a.getOrder()+13));
							tiles.get(a.getOrder()+13).setHasFire(true);
							if(board.getLevels().getPlayer1().getHandler().isHasLight())
							{
								board.getLevels().getPlayer1().getHandler().lighting(a,12,fires);
							}
						}
						else if (!tiles.get(a.getOrder()+13).isWalkable())
						{
							
							tiles.get(a.getOrder()+13).removeAll();
							tiles.get(a.getOrder()+13).makeWalkable();
							tiles.get(a.getOrder()+13).setBackground(Color.white);
						}
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
						if(a.isHasHp())
						{
							a.add(new Powerup(1));
						}
						else
						{
							a.add(new Powerup(2));

						}
						
					}
				}
			}
		
	}
	
	/*
	 * this method direct our fire upwards for 
	 * player1's bombs
	 */

	private void fireUp() 
	{
		Tiles a = tiles.get(bombScanner.getOrder()-13);
		
		
		
			if(a.isDestroyable())
			{
				if(a.isWalkable())
				{
					fire = fires.get(3);
					a.add(fire);
					fire.setLocate(a);
					a.setHasFire(true);
					if(board.getLevels().getPlayer1().getRange() >1)
					{
						if(tiles.get(a.getOrder()-13).isDestroyable())
					{
						if (tiles.get(a.getOrder()-13).isWalkable())
						{
							fire =fires.get(7);
							fire.setLocate(tiles.get(a.getOrder()-13));
							tiles.get(a.getOrder()-13).add(fire);
							tiles.get(a.getOrder()-13).setHasFire(true);
							if(board.getLevels().getPlayer1().getHandler().isHasLight())
							{
								board.getLevels().getPlayer1().getHandler().lighting(a,11,fires);
							}
						}
						else if (!tiles.get(a.getOrder()-13).isWalkable())
						{
							
							tiles.get(a.getOrder()-13).removeAll();
							tiles.get(a.getOrder()-13).makeWalkable();
							tiles.get(a.getOrder()-13).setBackground(Color.white);
						}
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
						if(a.isHasHp())
						{
							a.add(new Powerup(1));
						}
						else
						{
							a.add(new Powerup(2));

						}
					}
				}
			}
	}
	
	public void fireReset1()
	{
		Tiles a;
		if(fires.get(0).isactive())
		{
			for (int i= 0; i<13; i++)
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
		if(fires.get(13).isactive())
		{
			for (int i= 13; i<26; i++)
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
