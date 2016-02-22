package bobman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class UserInterface implements KeyListener
{
	private Player player;
	
	
	
	public UserInterface(Player player)
	{
		this.player = player;
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			player.moveLeft();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			player.moveDown();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			player.moveUp();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			player.moveRight();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		
	}
}

