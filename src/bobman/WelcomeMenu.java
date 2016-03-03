package bobman;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WelcomeMenu extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -8237781397498731775L;
	
	private JLabel background;
	private JButton startRandomGame,chooseGame,info,quit;
	private GameEngine gameEngine;
	
	
	
	public WelcomeMenu(GameEngine gameEngine)
	{
		super();
		this.gameEngine = gameEngine;
		initMenu();
		this.setDefaultCloseOperation(Board.EXIT_ON_CLOSE);
	}
	
	
	public void initMenu() 
	{
		initButtons();
		background = new JLabel();
		background.setIcon(new ImageIcon("src/sprite/background.jpg"));
		background.setLayout(new BoxLayout(background, EXIT_ON_CLOSE));
		background.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		background.add(chooseGame);
		background.add(startRandomGame);
		background.add(info);
		background.add(quit);
		this.add(background);
		this.setSize(800, 500);
		this.setVisible(true);
	}


	public void initButtons() 
	{
		startRandomGame = new JButton("Start a random game");
		startRandomGame.addActionListener(this);
		startRandomGame.setAlignmentX(CENTER_ALIGNMENT);
		chooseGame = new JButton("New game");
		chooseGame.addActionListener(this);
		chooseGame.setAlignmentX(CENTER_ALIGNMENT);
		info = new JButton("Info and help how to play the game");
		info.addActionListener(this);
		info.setAlignmentX(CENTER_ALIGNMENT);
		quit = new JButton("Quit");
		quit.addActionListener(this);
		quit.setAlignmentX(CENTER_ALIGNMENT);
	}


	@Override
public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == startRandomGame)
		{
			gameEngine.startrandomGame();;
		}
		if (e.getSource() == chooseGame)
		{
			gameEngine.startTheGame();
		}
		if (e.getSource() == quit)
		{
			System.exit(0);
		}
		
		if (e.getSource() == info)
		{
			String s = "Spelare1: A, S, D, W  används för att leda spelaren vänster, ner, höger och uppåt.\n" +
"Mellanslag-tangent gör att spelaren kasta en bomb\n" +
"Spelare2: " + "utnyttjar sig av piltangenterna för att röra sig åt respektive håll.\n" +
"Ctrl-knappen används för att kasta en bomb.\n\n" + 
"I spelet finns tre olika banor: \n\n" +
"Sonic = mest kraft minst liv\n Devilman = minst kraft mest liv \n Rey = lagom kraft och lagom liv \n\n" +
"level one: detta är en bana där man spelar efter karaktärenas förmågor som till exempel sonic har större bomb längd medans devil har mer liv. \n" +
"level two: denna banan innehåller power-ups som finns gömda inuti väggarna, spelarna börjar med ett liv och inga powerups. \n" +
"level three: spelarna börjar med 3 liv, har alla power-ups och det finns inga förstörbara väggar.";
			JOptionPane.showMessageDialog(null, s);
		}
		
		
		
	}
	
}