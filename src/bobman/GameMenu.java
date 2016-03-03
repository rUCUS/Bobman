package bobman;

import java.io.IOException;
import java.util.Random;

/*
 * this class creates our game menu above the game
 * 
 * @author 
 * @version 
 */

public class GameMenu
{
	private boolean status = false;
	private Board board;
	private Levels levels;
	Random rand = new Random();
	
	public GameMenu(Board board, Levels levels) {
		super();
		this.board = board;
		this.levels = levels;
	}

	/*
	 * used when newGame is chosen from the alternative in the game menu
	 * starts a new game, can choose from 3 different levels/maps
	 */
	
	public void newGame() throws IOException
	{
		levels.chooseLevel();
		levels.initBaseLevel();
		levels.removeListener();
		levels.sameLevel();
		board.startTheGame();
		board.getClock().reset();
		board.getClock().clockStarter();
		status = false;
		
	}
	
	/*
	 * used when restart is chosen from the game menu
	 * restarts the same level that was chosen before
	 */
	
	public void restart() throws IOException
	{
		levels.initBaseLevel();
		levels.removeListener();
		levels.sameLevel();
		board.startTheGame();
		board.getClock().reset();
		board.getClock().clockStarter();
		status = false;
	}
	
	/*
	 * used when quit is chosen from the game menu
	 * exits the game
	 */
	
	public void Quit()
	{
		System.exit(0);
	}
	
	/*
	 * used when pause is chosen from the game menu
	 * pauses the game and also resumes the game when chosen	 
	 */
	
	public void Pause()
	{
		
		if (!status)
		{
			board.getClock().clockStop();
			board.pauseTheGame();
			status = true;
		}
		else
		{	
			
			board.startTheGame();
			board.getClock().clockStarter();
			board.setFocusable(true);
			board.requestFocus();
			status = false;
		}
		
	}
	
	/*
	 * starts one of the 3 level
	 * is chosen by random by this method
	 */
	
	public void randomGame()
	{
		levels.setCurrentLevel(rand.nextInt(3));
		try {
			restart();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}	
}
