import java.util.*;

public class TicTacToeGame {

	public static char[] board;
	public static char userLetter;
	public static char computerLetter;
	public static int inPut;
	public static char turn;
	public static String winner;

	public static void createBoard() {

		board = new char[9];

		for (int i = 0; i < board.length; i++) {

			board[i] = (char) (i + '1');

		}

	}

	public static char chooseUserLetter(Scanner userInput) {

		System.out.println("Choose your letter 'x' or 'o': ");

		while (true) {

			char userChoice = userInput.next().toUpperCase().charAt(0);

			if (userChoice == 'X' || userChoice == 'O')

				return userChoice;

			else

				System.out.println("Enter a valid letter 'x' or 'o': ");

		}

	}

	public static void showBoard() {

		System.out.println("|---|---|---|");

		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");

		System.out.println("|-----------|");

		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");

		System.out.println("|-----------|");

		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");

		System.out.println("|---|---|---|");

	}

	public static void makeMove(Scanner userInput, char turn) {

		System.out.println("Enter a index number to place " + turn + " in: ");

		while (winner == null) {

			try {

				if (turn == computerLetter) {

					inPut = computerTurn(userInput); // calling computerTurn

				}

				else {

					inPut = userInput.nextInt();

				}

				if (!(inPut > 0 && inPut <= 9)) {

					System.out.println("Invalid input");

					continue;

				}

			}

			catch (InputMismatchException e) {

				System.out.println("Invalid input");

				continue;

			}

			if (String.valueOf(board[inPut - 1]).equals(String.valueOf(inPut))) {

				board[inPut - 1] = turn;

				showBoard();

				if (turn == userLetter) {

					System.out.println("Computer's turn; enter a slot number to place " + computerLetter + " in:");

					turn = computerLetter;

				}

				else {

					System.out.println("User's turn; enter a slot number to place " + userLetter + " in:");

					turn = userLetter;

				}

				winner = checkWinner();

			}

			else {

				System.out.println("Slot already taken; re-enter slot number:");

			}

		}

		if (winner.equalsIgnoreCase("draw")) {

			System.out.println("It's a draw! Thanks for playing.");

		}

		else {

			if (winner == String.valueOf(userLetter)) {

				System.out.println("\nCongratulations! User's have won! Thanks for playing.");

			} else {

				System.out.println("\nCongratulations! Computer's have won! Thanks for playing.");

			}
		}

	}

	public static char toss() {

		double toss = Math.floor(Math.random() * 10) % 2;

		if (toss == 0) {

			System.out.println("User got the chance first");
			return userLetter;
		} else

			System.out.println("Computer got the chance first");
		return computerLetter;

	}

	static String checkPosition(int a) {

		String line = null;

		switch (a) {
		case 0:
			line = String.valueOf(board[0]) + String.valueOf(board[1]) + String.valueOf(board[2]);
			break;
		case 1:
			line = String.valueOf(board[3]) + String.valueOf(board[4]) + String.valueOf(board[5]);
			break;
		case 2:
			line = String.valueOf(board[6]) + String.valueOf(board[7]) + String.valueOf(board[8]);
			break;
		case 3:
			line = String.valueOf(board[0]) + String.valueOf(board[3]) + String.valueOf(board[6]);
			break;
		case 4:
			line = String.valueOf(board[1]) + String.valueOf(board[4]) + String.valueOf(board[7]);
			break;
		case 5:
			line = String.valueOf(board[2]) + String.valueOf(board[5]) + String.valueOf(board[8]);
			break;
		case 6:
			line = String.valueOf(board[0]) + String.valueOf(board[4]) + String.valueOf(board[8]);
			break;
		case 7:
			line = String.valueOf(board[2]) + String.valueOf(board[4]) + String.valueOf(board[6]);
			break;
		}

		return line;

	}

	static String checkWinner() {

		for (int a = 0; a < 8; a++) {

			String line = checkPosition(a);

			// For X winner
			if (line.equals("XXX")) {

				return "X";
			}

			// For O winner
			else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {

			boolean check = (String.valueOf(board)).contains(String.valueOf(a + 1));

			if (check) {

				break;

			}

			else if (a == 8) {

				return "draw";

			}
		}

		return null;
	}

	public static int computerTurnIfX(Scanner userInput) {

		boolean flag = false;

		System.out.println("Computer method executed");

		for (int a = 0; a < 8; a++) {

			String line = checkPosition(a);

			switch (line) {

			// Line-1 if X
			case "1XX":
				inPut = 1;
				flag = false;
				a = 9;
				break;
			case "X2X":
				inPut = 2;
				flag = false;
				a = 9;
				break;
			case "XX3":
				inPut = 3;
				flag = false;
				a = 9;
				break;

			// Line-2 if X
			case "4XX":
				inPut = 4;
				flag = false;
				a = 9;
				break;
			case "X5X":
				inPut = 5;
				flag = false;
				a = 9;
				break;
			case "XX6":
				inPut = 6;
				flag = false;
				a = 9;
				break;

			// Line-3 if X
			case "7XX":
				inPut = 7;
				flag = false;
				a = 9;
				break;
			case "X8X":
				inPut = 8;
				flag = false;
				a = 9;
				break;
			case "XX9":
				inPut = 9;
				flag = false;
				a = 9;
				break;

			case "X4X":
				inPut = 4;
				flag = false;
				a = 9;
				break; // vertical Left column middle
			case "2XX":
				inPut = 2;
				flag = false;
				a = 9;
				break; // vertical middle column middle
			case "XX8":
				inPut = 8;
				flag = false;
				a = 9;
				break; // vertical middle column third
			case "X6X":
				inPut = 6;
				flag = false;
				a = 9;
				break; // Vertical right column middle
			case "3XX":
				inPut = 3;
				flag = false;
				a = 9;
				break; // Vertical right column first

			case "XX7":
				inPut = 7;
				flag = false;
				a = 9;
				break; // Right to left diagonal third element

			default:
				System.out.println("No match found");
				flag = true;

			}

		}

		if (flag == true) {

			if (computerLetter == 'X') {

				inPut = computerTurnIfO(userInput);

			}

			System.out.println("Do you want to enter press y");
			String check = userInput.next();
			if (check.equals("y")) {

				System.out.println("Enter a number for computerer");
				inPut = userInput.nextInt();

			}
		}

		return inPut;

	}

	public static int computerTurnIfO(Scanner userInput) {

		boolean flag = false;

		System.out.println("Computer method executed");

		for (int a = 0; a < 8; a++) {

			String line = checkPosition(a);

			switch (line) {

			// Line-1 if O
			case "1OO":
				inPut = 1;
				flag = false;
				a = 9;
				break;
			case "O2O":
				inPut = 2;
				flag = false;
				a = 9;
				break;
			case "OO3":
				inPut = 3;
				flag = false;
				a = 9;
				break;

			// Line-2 if O
			case "4OO":
				inPut = 4;
				flag = false;
				a = 9;
				break;
			case "O5O":
				inPut = 5;
				flag = false;
				a = 9;
				break;
			case "OO6":
				inPut = 6;
				flag = false;
				a = 9;
				break;

			// Line-3 if O
			case "7OO":
				inPut = 7;
				flag = false;
				a = 9;
				break;
			case "O8O":
				inPut = 8;
				flag = false;
				a = 9;
				break;
			case "OO9":
				inPut = 9;
				flag = false;
				a = 9;
				break;

			case "O4O":
				inPut = 4;
				flag = false;
				a = 9;
				break; // vertical Left column middle
			case "2OO":
				inPut = 2;
				flag = false;
				a = 9;
				break; // vertical middle column middle
			case "OO8":
				inPut = 8;
				flag = false;
				a = 9;
				break; // vertical middle column third
			case "O6O":
				inPut = 6;
				flag = false;
				a = 9;
				break; // Vertical right column middle
			case "3OO":
				inPut = 3;
				flag = false;
				a = 9;
				break; // Vertical right column first

			case "OO7":
				inPut = 7;
				flag = false;
				a = 9;
				break; // Right to left diagonal third element

			default:
				System.out.println("No match found");
				flag = true;

			}

		}

		if (flag == true) {

			if (computerLetter == 'O') {

				inPut = computerTurnIfX(userInput);

			}

			System.out.println("Do you want to enter press y");
			String check = userInput.next();
			if (check.equals("y")) {

				System.out.println("Enter a number for computerer");
				inPut = userInput.nextInt();

			}
		}

		return inPut;

	}

	public static int computerTurn(Scanner userInput) {

		if (computerLetter == 'X') {

			return computerTurnIfX(userInput);

		}

		else {

			return computerTurnIfO(userInput);

		}

	}

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		createBoard();

		userLetter = chooseUserLetter(userInput);

		computerLetter = (userLetter == 'X') ? 'O' : 'X';

		showBoard();

		turn = toss();

		makeMove(userInput, turn);

	}

}
