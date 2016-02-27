package bobman;

import java.awt.Color;
import java.io.IOException;

public class GameMenu
{
	private boolean status = false;
	private Board board;
	private Levels levels;
	
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
		
		status = false;
		
	}
	
	public void restart() throws IOException
	{
		levels.initBaseLevel();
		levels.removeListener();
		levels.sameLevel();
		board.startTheGame();
		status = false;
		board.getClock().clockStop();
		board.getClock().resetClock();
		board.getClock().clockStarter();
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
	
}
