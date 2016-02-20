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
		/*
		 * SER IDENTISK UT MED RESTART FAST SKA G�RA FLERA BANOR SOM MAN F�R V�LJA
		 * EFTER�T N�R MAN STARTAR SPELET SAMT KARAKT�RER S� DENNA KOMMER UTVECKLAS.....
		 */
		levels.initBaseLevel();
		board.startTheGame();
		status = false;
	}
	
	public void restart()
	{
		
		levels.initBaseLevel();
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

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	
	
}
