package bobman;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Fire extends JLabel implements ActionListener
{
	private Timer fireTimer1,fireTimer2;
	private int xPos,yPos,player,fireTime1,fireTime2;
	private ImageIcon fireIcon,fireIcon2;
	private BombExplode bombExplode;

	public Fire(int player,BombExplode bombExplode,int xPos, int yPos)
	{
		super(); 
		this.player = player;
		this.xPos = xPos;
		this.yPos = yPos;
		this.bombExplode = bombExplode;
		initFire(player);
	}
	public void initFire(int player) 
	{
		if (player ==1)
		{

			fireTimer1= new Timer(500,this);
			fireTimer1.start();
			fireIcon = new ImageIcon("src/sprite/fire_.png");
			this.setIcon(fireIcon);
			
			
			
		}
		
		if (player ==2)
		{
			fireTimer2= new Timer(500,this);
			fireTimer2.start();
			fireIcon2 = new ImageIcon("src/sprite/fire_.png");
			this.setIcon(fireIcon2);
		}
			
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(fireTimer1 != null && fireTimer1.isRunning())
		{
			bombExplode.resetfire(xPos, yPos,this);
		}
		if(fireTimer2 != null && fireTimer2.isRunning())
		{
			bombExplode.resetfire(xPos, yPos,this);
		}

		
		
	}
	
	public void turnOffTimer()
	{
		fireTimer1.stop();
	}
	
	public void turnOffTimer1()
	{
		fireTimer2.stop();
	}
	
	public int getPlayer() {
		return player;
	}
	public void setPlayer(int player) {
		this.player = player;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	
	
	
	
	
	
}
