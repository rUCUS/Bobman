package bobman;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * generate a Game menu when the game starts
 * with different options
 * 
 * @author Mehdi Adelzadeh, Danny Lam
 * @version 2016-03-01
 */

public class WelcomeMenu extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -8237781397498731775L;
	
	/**
	 * @uml.property  name="background"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel background;
	/**
	 * @uml.property  name="startRandomGame"
	 * @uml.associationEnd  
	 */
	private JButton startRandomGame;

	/**
	 * @uml.property  name="chooseGame"
	 * @uml.associationEnd  
	 */
	private JButton chooseGame;

	/**
	 * @uml.property  name="info"
	 * @uml.associationEnd  
	 */
	private JButton info;

	/**
	 * @uml.property  name="quit"
	 * @uml.associationEnd  
	 */
	private JButton quit;
	/**
	 * @uml.property  name="gameEngine"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="menu:bobman.GameEngine"
	 */
	private GameEngine gameEngine;
	
	
	
	public WelcomeMenu(GameEngine gameEngine)
	{
		super();
		this.gameEngine = gameEngine;
		initMenu();
		this.setDefaultCloseOperation(Board.EXIT_ON_CLOSE);
	}
	
	/**
	 * initialize our menu
	 */
	
	
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
	
	/**
	 * adds buttons to our menu
	 */


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
	
	/**
	 * performs different actions depending on which options has been chosen
	 */


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
			String s = "Spelare1: A, S, D, W  anv�nds f�r att leda spelaren v�nster, ner, h�ger och upp�t.\n" +
"Shift-tangent g�r att spelaren kasta en bomb\n" +
"Spelare2: " + "utnyttjar sig av piltangenterna f�r att r�ra sig �t respektive h�ll.\n" +
"Ctrl-knappen anv�nds f�r att kasta en bomb.\n\n" + 
"I spelet finns tre olika banor: \n\n" +
"Sonic = mest kraft minst liv\n Devilman = minst kraft mest liv \n Rey = lagom kraft och lagom liv \n\n" +
"level one: detta �r en bana d�r man spelar efter karakt�renas f�rm�gor som till exempel sonic har st�rre bomb l�ngd medans devil har mer liv. \n" +
"level two: denna banan inneh�ller power-ups som finns g�mda inuti v�ggarna, spelarna b�rjar med ett liv och inga powerups. \n" +
"level three: spelarna b�rjar med 3 liv, har alla power-ups och det finns inga f�rst�rbara v�ggar.";
			JOptionPane.showMessageDialog(null, s);
		}
		
		
		
	}
	
}