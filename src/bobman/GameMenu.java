package bobman;

import java.io.IOException;
import java.util.Random;

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
	
	public void Quit()
	{
		System.exit(0);
	}
	
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
