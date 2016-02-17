package bobman;

import javax.swing.JPanel;

public class Tiles extends JPanel 
{
	private int xPos,yPos,order;
	
	public Tiles(int xPos,int yPos, int order)
	{
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.order = order;
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

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
