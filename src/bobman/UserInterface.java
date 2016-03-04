package bobman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * this class checks for which keys are used on the keyboard and acts accordingly
 * its also implements Keylistener
 * 
 * @author Danny Lam, Mehdi Adelzadeh
 * @version 2016-03-02
 */

public class UserInterface implements KeyListener
{
	private Player player1,player2;
	
	
	
	public UserInterface(Player player1, Player player2)
	{
		this.player1 = player1;
		this.player2 = player2;
	}
	
	/*
	 * checks if the key thats we have assigned have been used or not
	 * and acts accordingly
	 */

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			player1.moveLeft();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			player1.moveDown();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			player1.moveUp();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			player1.moveRight();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			player1.throwBomb(1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			player2.moveLeft();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			player2.moveDown();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			player2.moveUp();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			player2.moveRight();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_CONTROL)
		{
			player2.throwBomb(2);
		}
		
	}
	
	/*
	 * checks whether the keys has been released
	 */

	@Override
	public void keyReleased(KeyEvent e) 
	{
		
		
	}

	/*
	 * if the keys other than those we have assigned has been pressed
	 * do nothing
	 */
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		
	}
}

