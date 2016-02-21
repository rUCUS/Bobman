package bobman;

import java.awt.Color;

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

	public void newGame()
	{
		levels.chooseLevel();
		levels.initBaseLevel();
		levels.sameLevel();
		board.startTheGame();
		status = false;
	}
	
	public void restart()
	{
		
		levels.initBaseLevel();
		levels.sameLevel();
		board.startTheGame();
		status = false;	}
	
	public void Quit()
	{
		System.exit(0);
	}
	
	public void Pause()
	{
		if (!status)
		{
			board.pauseTheGame();
			status = true;
		}
		else
		{
			board.startTheGame();
			status = false;
		}
	}
	
}
