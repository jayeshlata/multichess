import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class EndGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel winnerLabel;
	
	public EndGUI(Game game){
		super("The game is done!");
		setLayout(new FlowLayout());
		setSize(500,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("Game finished");
		
		winnerLabel = new JLabel("We have a winner: "+game.winner.name);
		add(winnerLabel);
	}
}
