package bobman;

import java.io.IOException;

/**
 * this is where all of the building block for the game is located
 * this class creates our game
 * 
 * @author Liban Aden, Danny Lam, Mehdi Adelzadeh, Hamza Kadric
 * @version 2016-03-02
 */

public class GameEngine 
{
	
	/**
	 * @uml.property  name="board"
	 * @uml.associationEnd  
	 */
	private Board board;
	/**
	 * @uml.property  name="menu"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="gameEngine:bobman.WelcomeMenu"
	 */
	private WelcomeMenu menu;
	public GameEngine() throws IOException
	{
		menu = new WelcomeMenu(this);
	}
	
	/**
	 * this method generate a new game engine
	 * @param args
	 * @throws IOException
	 */
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException
	{
		GameEngine engine = new GameEngine();
	}
	
	/**
	 *this method is used when startrandomGame is selected from game menu 
	 */
	
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
	
	/**
	 * this method start our game or creates a new game
	 */
	
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
