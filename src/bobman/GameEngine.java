package bobman;

import java.io.IOException;

public class GameEngine 
{
	@SuppressWarnings("unused")
	private Board board;
	
	public GameEngine() throws IOException
	{
		
		board = new Board();
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException
	{
		GameEngine engine = new GameEngine();
	}
	
}
