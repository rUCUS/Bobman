package bobman;

import java.awt.Color;
import java.util.TreeMap;

public class PowerUpHandler 
{
	TreeMap<Integer, Tiles> tiles;
	private boolean hasLight;
	private Player player;
	
	public PowerUpHandler(Player player, TreeMap<Integer, Tiles> tiles)
	{
		super();
		this.player = player;
		this.tiles = tiles;
		
	}
	
	public void lighting(Tiles a,int b,TreeMap <Integer,Fire> fires)
	{
		Fire fire =fires.get(b);
		if (b == 9 || b ==22 )
		{
			Tiles c = tiles.get(a.getOrder()+2);
			if(c.isDestroyable())
			{
				if(c.isWalkable())
				{
					c.add(fire);
					fire.setLocate(c);
					c.setHasFire(true);
				}
				else if (!c.isWalkable())
				{
					
					c.removeAll();
					c.makeWalkable();
					c.setBackground(Color.white);
					if (c.isHasPowerUp())
					{
						if(c.isHasHp())
						{
							c.add(new Powerup(1));
						}
						else
						{
							c.add(new Powerup(2));

						}
					}
				}
			}
		}
		
		if (b == 10 || b ==23 )
		{
			Tiles c = tiles.get(a.getOrder()-2);
			if(c.isDestroyable())
			{
				if(c.isWalkable())
				{
					c.add(fire);
					fire.setLocate(c);
					c.setHasFire(true);
				}
				else if (!c.isWalkable())
				{
					
					c.removeAll();
					c.makeWalkable();
					c.setBackground(Color.white);
					if (c.isHasPowerUp())
					{
						if(c.isHasHp())
						{
							c.add(new Powerup(1));
						}
						else
						{
							c.add(new Powerup(2));

						}
					}
				}
			}
		}
		
		if (b == 11 || b ==24 )
		{
			Tiles c = tiles.get(a.getOrder()-26);
			if(c.isDestroyable())
			{
				if(c.isWalkable())
				{
					c.add(fire);
					fire.setLocate(c);
					c.setHasFire(true);
				}
				else if (!c.isWalkable())
				{
					
					c.removeAll();
					c.makeWalkable();
					c.setBackground(Color.white);
					if (c.isHasPowerUp())
					{
						if(c.isHasHp())
						{
							c.add(new Powerup(1));
						}
						else
						{
							c.add(new Powerup(2));

						}
					}
				}
			}
		}
		
		if (b == 12 || b ==25 )
		{
			Tiles c = tiles.get(a.getOrder()+26);
			if(c.isDestroyable())
			{
				if(c.isWalkable())
				{
					c.add(fire);
					fire.setLocate(c);
					c.setHasFire(true);
				}
				else if (!c.isWalkable())
				{
					
					c.removeAll();
					c.makeWalkable();
					c.setBackground(Color.white);
					if (c.isHasPowerUp())
					{
						if(c.isHasHp())
						{
							c.add(new Powerup(1));
						}
						else
						{
							c.add(new Powerup(2));

						}
					}
				}
			}
		}
	}
	
	public void giveExtra()
	{
		player.setHp(player.getHp()+1);
		if (player.getStatus() == 1)
		{
			player.getBoard().getPlayer1().setText("P1 life: " + player.getHp());
		}
		
		if (player.getStatus() == 2)
		{
			player.getBoard().getPlayer2().setText("P2 life: " + player.getHp());
		}
		
	
	}

	public boolean isHasLight() {
		return hasLight;
	}

	public void setHasLight(boolean hasLight) {
		this.hasLight = hasLight;
	}
}
