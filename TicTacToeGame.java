public class TicTacToeGame {

	public static char[] createBoard() {

		char[] board = new char[9];

		for(int i = 0; i < board.length; i++) {

			board[i] =' ';

		}

		System.out.println("|---|---|---|");

		System.out.println("|   |   |   |");

		System.out.println("|-----------|");

		System.out.println("|   |   |   |");

		System.out.println("|-----------|");

		System.out.println("|   |   |   |");

		System.out.println("|---|---|---|");

		return board;

	}

	public static void main(String[] args) {

		char[] board = createBoard();

	}

}
