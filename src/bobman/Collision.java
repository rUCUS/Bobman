package bobman;

public class Collision 
{
	private Player player1,player2;
	private BombExplode bombExplode;
	private Levels levels;
	
	public Collision(Levels levels) {
		super();
		this.bombExplode = bombExplode;
		this.levels = levels;
		this.player1 = levels.getPlayer1();
		this.player2 = levels.getPlayer2();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////Player colliding
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
				collider.setIcon(collider.getLeftRight());
				collided.setIcon(collider.getLeftRight());
				k.setHasPlayer(true);
				break;
		
		case 1: collider.setxPos(collided.getxPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getLeftRight());
				collided.setIcon(collider.getLeftRight());
				k.setHasPlayer(true);
				break;
				
		case 2: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getUpRight());
				collided.setIcon(collider.getUpRight());
				k.setHasPlayer(true);
				break;
		
		case 3: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getDownRight());
				collided.setIcon(collider.getDownRight());
				k.setHasPlayer(true);
				break;
		
		}
		
	}
	
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
				break;
		
		case 1: collider.setxPos(collided.getxPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getUpLeft());
				collided.setIcon(collider.getUpLeft());
				k.setHasPlayer(true);
				break;
				
		case 2: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getUp());
				collided.setIcon(collider.getUp());
				k.setHasPlayer(true);
				break;
		
		case 3: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getUpDown());
				collided.setIcon(collider.getUpDown());
				k.setHasPlayer(true);
				break;
		
		}
		
	}
	
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
				break;
		
		case 1: collider.setxPos(collided.getxPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getDownRight());
				collided.setIcon(collider.getDownRight());
				k.setHasPlayer(true);
				break;
				
		case 2: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getUpDown());
				collided.setIcon(collider.getUpDown());
				k.setHasPlayer(true);
				break;
		
		case 3: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getDown());
				collided.setIcon(collider.getDown());
				k.setHasPlayer(true);
				break;
		
		}
		
	}
	
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
				collider.setIcon(collider.getLeft());
				collided.setIcon(collider.getLeft());
				k.setHasPlayer(true);
				break;
		
		case 1: collider.setxPos(collided.getxPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getLeftRight());
				collided.setIcon(collider.getLeftRight());
				k.setHasPlayer(true);
				break;
				
		case 2: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getUpLeft());
				collided.setIcon(collider.getUpLeft());
				k.setHasPlayer(true);
				break;
		
		case 3: collider.setyPos(collided.getyPos());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getDownLeft());
				collided.setIcon(collider.getDownLeft());
				k.setHasPlayer(true);
				break;
		
		}
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	
	public void FireCollision(Player victim, Fire fire)
	{
		
	}
	
	public void Respawn(Player dead)
	{
		
	}
	
}
