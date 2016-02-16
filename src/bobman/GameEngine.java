package bobman;

public class GameEngine 
{
	@SuppressWarnings("unused")
	private Board board;
	@SuppressWarnings("unused")
	private UserInterface ui;
	
	public GameEngine()
	{
		board = new Board();
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		GameEngine engine = new GameEngine();
	}
	
}
