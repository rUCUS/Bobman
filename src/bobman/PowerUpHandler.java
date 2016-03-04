package bobman;

import java.awt.Color;
import java.util.TreeMap;

/*
 * this class handles the power-ups that exist on the map
 * 
 * @author Liban Aden, Mehdi Adelzadeh
 * @version 2016-03-03
 */

public class PowerUpHandler {
	TreeMap<Integer, Tiles> tiles;
	private boolean hasLight;
	private Player player;
	
	public PowerUpHandler(Player player, TreeMap<Integer, Tiles> tiles)
	{
		super();
		this.player = player;
		this.tiles = tiles;
		
	}
	
	/*
	 * if there is a lighting-icon power-up that a player picks up
	 * it gets longer range on its bombs
	 */
	
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
	
	/*
	 * if the life-icon power-up is picked up
	 * give extra health to player
	 */
	
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
	
	/*
	 *  Returns if the tile has the powerup lighting
	 */

	public boolean isHasLight() {
		return hasLight;
	}
	
	/*
	 *  sets so that that the tile will have the powerup lighting or not
	 *  @param hasLight
	 */

	public void setHasLight(boolean hasLight) {
		this.hasLight = hasLight;
	}
}
