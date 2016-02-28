package bobman;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Fire extends JLabel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3117597669521741300L;
	private int xPos,yPos,player;
	private ImageIcon fireIcon,fireIcon2;
	private BombExplode bombExplode;

	public Fire(int player,BombExplode bombExplode)
	{
		super(); 
		this.player = player;
		this.bombExplode = bombExplode;
		initFire(player);
	}
	public void initFire(int player) 
	{
		if (player ==1)
		{

			fireIcon = new ImageIcon("src/sprite/fire_.png");
			this.setIcon(fireIcon);
		}
		
		if (player ==2)
		{
			fireIcon2 = new ImageIcon("src/sprite/fire_.png");
			this.setIcon(fireIcon2);
		}
			
	}

}
