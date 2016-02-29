package bobman;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Fire extends JLabel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3117597669521741300L;
	private int xPos,yPos;
	private ImageIcon fireIcon,fireIcon2;
	private boolean isActive;

	public Fire(int player,BombExplode bombExplode)
	{
		super(); 
		initFire(player);
	}
	public void initFire(int player) 
	{
		if (player ==1)
		{

			fireIcon = new ImageIcon("src/sprite/fire2.png");
			this.setIcon(fireIcon);
			isActive = false;
		}
		
		if (player ==2)
		{
			fireIcon2 = new ImageIcon("src/sprite/fire1.png");
			this.setIcon(fireIcon2);
			isActive = false;
		}
			
	}
	public boolean isactive() {
		return isActive;
	}

	public void setActive()
	{
		isActive = true;
	}
	
	public void setLocate(Tiles a)
	{
		xPos = a.getxPos();
		yPos = a.getyPos();
		setActive();
				
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
	
	public void notActive()
	{
		isActive = false;
	}
}
