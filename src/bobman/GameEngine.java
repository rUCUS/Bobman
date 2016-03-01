package bobman;

import java.io.IOException;

public class GameEngine 
{
	
	private Board board;
	private WelcomeMenu menu;
	public GameEngine() throws IOException
	{
		menu = new WelcomeMenu(this);
		//board = new Board();
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException
	{
		GameEngine engine = new GameEngine();
	}
	
	public void startrandomGame()
	{
		try {
			board = new Board();
			board.getGameMenu().randomGame();
			menu.setVisible(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startTheGame()
	{
		try {
			board = new Board();
			board.getGameMenu().newGame();
			menu.setVisible(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
