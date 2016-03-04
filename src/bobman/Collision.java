package bobman;

/*
 * this class handles, what happens when player1 
 * and player2 collide 
 * 
 * @author Liban Aden
 * @version 2016-02-29
 */

public class Collision 
{
	private Player player1,player2;
	
	public Collision(Levels levels) {
		super();
		this.player1 = levels.getPlayer1();
		this.player2 = levels.getPlayer2();
	}
	
	/*
	 * this method paints the picture when the players collide
	 */
	public void playerCollision(Player collider,int side)
	{
		if (collider.getStatus() == 1)
		{
			
			if(player2.getIcon() == player2.getUp())
			{
				firstPlayerLooksUp(player1,player2,side);
			}
						
			if(player2.getIcon() == player2.getDown())
			{
				firstPlayerLooksDown(player1,player2,side);
			}
								
			if(player2.getIcon() == player2.getRight())
			{
				firstPlayerLooksRight(player1,player2,side);
			}
			
			if(player2.getIcon() == player2.getLeft())
			{
				firstPlayerLooksLeft(player1,player2,side);
			}
			
		}
		
		if (collider.getStatus() == 2)
		{
			if(player1.getIcon() == player1.getUp())
			{
				firstPlayerLooksUp(player2,player1,side);
			}
						
			if(player1.getIcon() == player1.getDown())
			{
				firstPlayerLooksDown(player2,player1,side);
			}
								
			if(player1.getIcon() == player1.getRight())
			{
				firstPlayerLooksRight(player2,player1,side);
			}
			
			if(player1.getIcon() == player1.getLeft())
			{
				firstPlayerLooksLeft(player2,player1,side);
			}
		}
	}
	
	/*
	 * this method tells us what should happen when our first player is looking
	 * right and collides with the other player from different directions
	 */
	
	public void firstPlayerLooksRight(Player collider,Player collided,int side)
	{
		Tiles a = collider.getTiles().get(collider.getxPos() + collider.getyPos()*13);
		Tiles k = collider.getTiles().get(collided.getxPos() + collided.getyPos()*13);
		switch(side)
		{
		
		case 0: collider.setxPos(collided.getxPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getrightRight());
				collided.setIcon(collider.getrightRight());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
		
		case 1: collider.setxPos(collided.getxPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getLeftRight());
				collided.setIcon(collider.getLeftRight());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
				
		case 2: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getUpRight());
				collided.setIcon(collider.getUpRight());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
		
		case 3: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getDownRight());
				collided.setIcon(collider.getDownRight());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
		
		}
		
	}
	
	/*
	 * this method tells us what should happen when our first player is looking
	 * up and collides with the other player from different directions
	 */
	
	public void firstPlayerLooksUp(Player collider,Player collided,int side)
	{
		Tiles a = collider.getTiles().get(collider.getxPos() + collider.getyPos()*13);
		Tiles k = collider.getTiles().get(collided.getxPos() + collided.getyPos()*13);
		switch(side)
		{
		
		case 0: collider.setxPos(collided.getxPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getUpRight());
				collided.setIcon(collider.getUpRight());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
		
		case 1: collider.setxPos(collided.getxPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getUpLeft());
				collided.setIcon(collider.getUpLeft());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
				
		case 2: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getupUp());
				collided.setIcon(collider.getupUp());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
		
		case 3: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getUpDown());
				collided.setIcon(collider.getUpDown());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
		
		}
		
	}
	
	/*
	 * this method tells us what should happen when our first player is looking
	 * down and collides with the other player from different directions
	 */
	
	public void firstPlayerLooksDown(Player collider,Player collided,int side)
	{
		Tiles a = collider.getTiles().get(collider.getxPos() + collider.getyPos()*13);
		Tiles k = collider.getTiles().get(collided.getxPos() + collided.getyPos()*13);
		switch(side)
		{
		
		case 0: collider.setxPos(collided.getxPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getDownLeft());
				collided.setIcon(collider.getDownLeft());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
		
		case 1: collider.setxPos(collided.getxPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getDownRight());
				collided.setIcon(collider.getDownRight());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
				
		case 2: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getUpDown());
				collided.setIcon(collider.getUpDown());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
		
		case 3: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getdownDown());
				collided.setIcon(collider.getdownDown());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
		
		}
		
	}
	
	/*
	 * this method tells us what should happen when our first player is looking
	 * left and collides with the other player from different directions
	 */
	
	public void firstPlayerLooksLeft(Player collider,Player collided,int side)
	{
		Tiles a = collider.getTiles().get(collider.getxPos() + collider.getyPos()*13);
		Tiles k = collider.getTiles().get(collided.getxPos() + collided.getyPos()*13);
		switch(side)
		{
		
		case 0: collider.setxPos(collided.getxPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getLeftRight());
				collided.setIcon(collider.getLeftRight());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
		
		case 1: collider.setxPos(collided.getxPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getleftLeft());
				collided.setIcon(collider.getleftLeft());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
				
		case 2: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getUpLeft());
				collided.setIcon(collider.getUpLeft());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
		
		case 3: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getDownLeft());
				collided.setIcon(collider.getDownLeft());
				k.setHasPlayer(true);
				k.setHasPlayers(true);
				break;
		
		}
		
	}
	
	
	
	public void LeaveCollision(Player collider,int side)
	{
		Tiles a;
		if (collider.getStatus() == 1)
		{
			a = player2.getTiles().get(player2.getxPos() + player2.getyPos()*13);
			a.add(player2);
			switch(side)
			{
			case 0: player2.setIcon(player2.getLeft());
					a.setHasPlayers(false);
					break;
			case 1: player2.setIcon(player2.getRight());
					a.setHasPlayers(false);
					break;
			case 2: player2.setIcon(player2.getDown());
					a.setHasPlayers(false);
					break;
			case 3: player2.setIcon(player2.getUp());
					a.setHasPlayers(false);
					break;
			}
		}
		
		if (collider.getStatus() == 2)
		{
			a = player1.getTiles().get(player1.getxPos() + player1.getyPos()*13);
			a.add(player1);
			switch(side)
			{
			case 0: player1.setIcon(player1.getLeft());
					a.setHasPlayers(false);
					break;
			case 1: player1.setIcon(player1.getRight());
					a.setHasPlayers(false);
					break;
			case 2: player1.setIcon(player1.getDown());
					a.setHasPlayers(false);
					break;
			case 3: player1.setIcon(player1.getUp());
					a.setHasPlayers(false);
					break;
			}
		}
	}
	
	

	/*
	 * this method is called upon if the fire and player collide
	 * @param victim
	 */
	
	public void FireCollision(Player victim)
	{
		Tiles a = victim.getTiles().get(victim.getxPos()+victim.getyPos()*13);
		a.removeAll();
		a.setHasPlayer(false);
		respawn(victim);
	}

	/*
	 * this method respawns our player to their original position 
	 * @param victim
	 */
	
	public void respawn(Player victim)
	{
		Tiles a;
		if (victim.getStatus() == 1)
		{
			a = victim.getTiles().get(14);
			a.add(player1);
			player1.setxPos(1);
			player1.setyPos(1);
		}
		
		if (victim.getStatus() == 2)
		{
			a = victim.getTiles().get(154);
			a.add(player2);
			player2.setxPos(11);
			player2.setyPos(11);
		}
	}
	
	
}
