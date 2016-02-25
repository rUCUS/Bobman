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
		Tiles a;
		Tiles k = collider.getTiles().get(collided.getxPos() + collided.getyPos()*13);
		switch(side)
		{
		case 0: System.out.println("hey bae");
		
		case 1: collider.setxPos(collided.getxPos());
				a = collider.getTiles().get(k.getOrder());
				a.removeAll();
				a.setHasPlayer(false);
				k.add(collider);
				collider.setIcon(collider.getLeftRight());
				k.setHasPlayer(true);
		}
		
	}
	
	public void firstPlayerLooksUp(Player collider,Player Collided,int side)
	{
		System.out.println("works");
	}
	
	public void firstPlayerLooksDown(Player collider,Player Collided,int side)
	{
		System.out.println("works");
	}
	
	public void firstPlayerLooksLeft(Player collider,Player Collided,int side)
	{
		System.out.println("works");
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
