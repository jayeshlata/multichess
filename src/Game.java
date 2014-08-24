public class Game {

	Board board;
	boolean gameProgress;
	Player winner;
	
	public Game(Board board) {
		this.board = board;
	}

	public void begin(){
		if(board.boardSet){
			System.out.println("The game has begun between "+board.p1.name+" and "+board.p2.name);
			gameProgress = true;
		}
	}
	
	public void process(){
		//whole logic goes here.
		while(board.boardSet == true){
			if(board.nextTurn == true){
				playNextTurn();
			}
			board.nextTurn = false;
		}
	}
	
	public void end(Player winner){
		if(!board.boardSet){
			System.out.println("The game is done with the victory of "+winner.name);
			gameProgress = false;
			this.winner = winner;
		}
	}
	
	public void playNextTurn(){
		/*while(1){
			
		}*/
	}
}
