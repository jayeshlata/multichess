
public class Main extends Thread {

	public static void main(String[] args) {
		new Main().run();
	}

	public void run() {

		synchronized (this) {
			// Creating players
			// System.out.println("as"+9);
			Player p1 = new Player();
			Player p2 = new Player();

			// Taking parameters for the players from the UI
			WelcomeGUI gui_welcome = new WelcomeGUI(p1, p2);
			gui_welcome.setVisible(true);
			try {
				// keeps checking at a regular interval for the parameters of p1
				// to be set (all set simultaneously though)
				while (p1.name == null) {
					sleep(1000);
				}
				gui_welcome.setVisible(false);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Printing the parameters set
			System.out.println(p1.name + p1.color + p2.name + p2.color);

			Board board = new Board(p1, p2);
			board.load();

			try {
				while (board.boardSet == false) {

					sleep(1000);
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BoardGUI gui_board = new BoardGUI(board);
			gui_board.setVisible(true);

			Game game = new Game(board);
			game.begin();

			System.out.println(game.gameProgress);
			game.process();
			try {
				while (board.boardSet == true) {
					sleep(1000);
				}
				gui_board.setVisible(false);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			game.end(board.p1);

			EndGUI gui_end = new EndGUI(game);
			gui_end.setVisible(true);
		}

	}

}
