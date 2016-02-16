package bobman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class UserInterface implements KeyListener
{
	private ArrayList<Integer> keysDown;
	
	
	
	public UserInterface()
	{
		keysDown = new ArrayList<>();
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(!(keysDown.contains(e.getKeyCode()))) 
		{
			keysDown.add(e.getKeyCode());
		}
		
	/*	if(keysDown.contains(KeyEvent.VK_A) )
		{
			((Object) e.getSource()).MoveRight();
			
		}
		
		if(keysDown.contains(KeyEvent.VK_S))
		{
			((Object) e.getSource()).MoveDown();
			
		}
		
		if(keysDown.contains(KeyEvent.VK_W))
		{
			((Object) e.getSource()).MoveUp();
			
		}
		
		if(keysDown.contains(KeyEvent.VK_D))
		{
			((Object) e.getSource()).MoveLeft();
			
		}*/
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		keysDown.remove(e.getKeyCode());
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		
	}
}

