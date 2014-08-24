import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WelcomeGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel q1;
	private JTextField noOfPlayers;
	private JLabel q2;
	private JTextField p1_name;
	private JLabel q3;
	private JTextField p2_name;
	private JLabel q4;
	private JTextField color1;
	private JLabel q5;
	private JTextField color2;
	private JButton createGameButton;
	private Player p1;
	private Player p2;
	
	public WelcomeGUI(Player p1, Player p2){
	
		super("Welcome! Choose the game variables.");
		setLayout(new FlowLayout());
		setSize(180,320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.p1 = p1;
		this.p2 = p2;
		
		q1 = new JLabel("Enter the number of players: ");
		add(q1);
		noOfPlayers = new JTextField("2");
		noOfPlayers.setEditable(false);
		add(noOfPlayers);
		
		q2 = new JLabel("Enter the name of Player1: ");
		add(q2);
		p1_name = new JTextField(10);
		add(p1_name);
		
		q3 = new JLabel("Enter the name of Player2: ");
		add(q3);
		p2_name = new JTextField(10);
		add(p2_name);
		
		q4 = new JLabel("What color will Player1 take?");
		add(q4);
		color1 = new JTextField(10);
		add(color1);
		
		q5 = new JLabel("What color will Player2 take?");
		add(q5);
		color2 = new JTextField(10);
		add(color2);
		
		createGameButton = new JButton("Create Game Now!");
		add(createGameButton);
		
		createGameButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				submitActionPerformed(e);
			}
		});
		
	}
	private void submitActionPerformed(ActionEvent event){
		String disp = "";
		if(event.getSource() == createGameButton){
			p1.name = p1_name.getText();
			p1.color = color1.getText();
			p2.name = p2_name.getText();
			p2.color = color2.getText();
			disp = (p1.name + " takes " + p1.color +" color. \n"+p2.name + " takes " + p2.color + " color.");
		}
		JOptionPane.showMessageDialog(null, disp);
	}
}
