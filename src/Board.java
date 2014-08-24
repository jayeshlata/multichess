

public class Board {

	boolean boardSet = false;
	boolean nextTurn = false;

	int nextTurnPiece;
	Player p1;
	Player p2;
	String pieceGrid[] = new String[64];
	
	/*Bishop bishops[][] = new Bishop[2][2];
	King kings[] = new King[2];
	Knight knights[][] = new Knight[2][2];
	Pawn pawns[][] = new Pawn[2][8];
	Queen queens[] = new Queen[2];
	Rook rooks[][] = new Rook[2][2];
	*///make a label grid/or simulate one in gui....but only store a grid! not pieces
	
	/*
	 * Default sets first player as white
	 */
	public Board(Player p1, Player p2){
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/*
	public void setPiecesPosition(){
		bishops[0][0].position = "a2";
		bishops[0][1].position = "a5";
		bishops[1][0].position = "h2";
		bishops[1][1].position = "h5";
			
		knights[0][0].position = "a1";
		knights[0][1].position = "a6";
		knights[1][0].position = "h1";
		knights[1][1].position = "h6";
			
		rooks[0][0].position = "a0";
		rooks[0][1].position = "a7";
		rooks[1][0].position = "h0";
		rooks[1][1].position = "h7";
			
		kings[0].position = "a4";
		kings[1].position = "h4";
		
		queens[0].position = "a5";
		queens[1].position = "h5";
		
		for(int i=0;i<2;i++){
			for(int j=0;j<8;j++){
				if(i==0)
					pawns[i][j].position = "a"+(char)(48+j);
				else
					pawns[i][j].position = "h"+(char)(48+j);
			}
		}
		
	}
*/
	
	public void setPieceGrid(){
		pieceGrid[0] = "rook_black";
		pieceGrid[1] = "knight_black";
		pieceGrid[2] = "bishop_black";
		pieceGrid[3] = "queen_black";
		pieceGrid[4] = "king_black";
		pieceGrid[5] = "bishop_black";
		pieceGrid[6] = "knight_black";
		pieceGrid[7] = "rook_black";
		
		for(int i=8;i<16;i++)
			pieceGrid[i] = "pawn_black";
		
		for(int i=16;i<48;i++)
			pieceGrid[i] = "NIL";
		
		for(int i=48;i<56;i++)
			pieceGrid[i] = "pawn_white";
		
		pieceGrid[56] = "rook_white";
		pieceGrid[57] = "knight_white";
		pieceGrid[58] = "bishop_white";
		pieceGrid[59] = "queen_white";
		pieceGrid[60] = "king_white";
		pieceGrid[61] = "bishop_white";
		pieceGrid[62] = "knight_white";
		pieceGrid[63] = "rook_white";
	}
	
	public void load(){
		setPieceGrid();
		this.boardSet = true;
		System.out.println("A board has been created!");
	}
}
