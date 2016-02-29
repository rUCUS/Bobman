package bobman;

public class PowerUpHandler 
{
	private boolean hasLight;
	private Player player;
	public PowerUpHandler(Player player)
	{
		super();
		this.player = player;
		
	}
	
	public void lighting(Tiles a, int k)
	{
		
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
