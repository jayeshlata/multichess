import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class BoardGUI extends JFrame implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel p1;
	private JLabel p2;
	private JLabel white;
	private JLabel black;
	private JLabel separator;
	private JLabel checks[] = new JLabel[64];
	private JLabel temp;
	private JButton finish;
	private Board board;
	
	//TODO take a label grid formed in board...so as to arrange the piece pictures on the checks
	public BoardGUI(Board board){
		super("The chessboard");
		setLayout(new FlowLayout());
		setSize(540,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.board = board;
		p1 = new JLabel(board.p1.name);
		add(p1);
		white = new JLabel(new ImageIcon("white.jpg"));
		black = new JLabel(new ImageIcon("black.jpg"));
		finish = new JButton("Finish Game!");
		
		if(board.p1.color.equals("white")){
			add(white);
			add(finish);
			add(black);
		}else{
			add(black);
			add(finish);
			add(white);
		}
		p2 = new JLabel(board.p2.name);
		add(p2);
		
		separator = new JLabel(new ImageIcon("separator.jpg"));
		add(separator);

		for(int i=0,arrangement = -1;i<64;i++){
			if((i>0) && ((i % 8)==0)){
				arrangement *= -1;				
			}
			if(arrangement == 1){
				
				checks[i] = new JLabel(new ImageIcon("white.jpg"),JLabel.CENTER);
				add(checks[i]);
				temp = new JLabel(new ImageIcon(board.pieceGrid[i]+".png"),JLabel.CENTER);
				temp.setForeground(Color.WHITE);
				temp.setSize(60,60);
				checks[i].add(temp);
				
				i++;
				
				checks[i] = new JLabel(new ImageIcon("black.jpg"),JLabel.CENTER);
				add(checks[i]);
				temp = new JLabel(new ImageIcon(board.pieceGrid[i]+".png"),JLabel.CENTER);
				temp.setForeground(Color.WHITE);
				temp.setSize(60,60);
				checks[i].add(temp);
				
			}else if(arrangement == -1){
				
				checks[i] = new JLabel(new ImageIcon("black.jpg"),JLabel.CENTER);
				add(checks[i]);
				temp = new JLabel(new ImageIcon(board.pieceGrid[i]+".png"),JLabel.CENTER);
				temp.setForeground(Color.WHITE);
				temp.setSize(60,60);
				checks[i].add(temp);
				
				i++;
				
				checks[i] = new JLabel(new ImageIcon("white.jpg"),JLabel.CENTER);
				add(checks[i]);
				temp = new JLabel(new ImageIcon(board.pieceGrid[i]+".png"),JLabel.CENTER);
				temp.setForeground(Color.WHITE);
				temp.setSize(60,60);
				checks[i].add(temp);
				
			}
		}
		System.out.println("Board loaded :D");
		board.boardSet = true;
		
		finish.addActionListener(this);
		for(int i=0;i<64;i++)
			checks[i].addMouseListener(this);
		
	}
	public void actionPerformed(ActionEvent e){
		String disp = "";
		if(e.getSource() == finish){
			board.boardSet = false;
			disp = ("The game is finished it seems :) See the result?");
		}
		JOptionPane.showMessageDialog(null, disp);
	}
	public void mouseClicked(MouseEvent me){
		for(int i=0;i<64;i++){
			if(me.getSource() == checks[i]){
				board.nextTurnPiece = i;
				board.nextTurn = true;
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
