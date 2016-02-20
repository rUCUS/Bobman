package bobman;

import javax.swing.JPanel;

public class Tiles extends JPanel 
{
	private int xPos,yPos,order;
	private boolean walkable;
	private boolean destroyable;
	private JPanel content;
	
	public Tiles(int xPos,int yPos, int order)
	{
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.order = order;
		walkable = true;
		destroyable = false;
		
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
	
	public JPanel getContent()
	{
		return content;
	}
	
	public void setContent(JPanel content)
	{
		this.content = content;
	}

}
