import java.util.Scanner;

public class TicTacToeGame {

	public static char[] board;
	public static String computerTurn;
	public static String playerTurn;

	public static char[] createBoard() {

		char[] board = new char[9];

		for(int i = 0; i < board.length; i++) {

			board[i] =' ';

		}

		return board;

	}

	public static void Turn() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a x or y");

		playerTurn = sc.next();


	if (playerTurn.equals("x")) {

			computerTurn = "O";

		}

		else {

			computerTurn = "X";

		}
	}

	public static void main(String[] args) {

		char[] board = createBoard();

		Turn();

	}

}
