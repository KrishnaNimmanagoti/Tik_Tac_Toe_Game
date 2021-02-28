import java.util.*;

public class TicTacToeGameUC7 {

   public static char[] board;
   public static char userLetter;
   public static char computerLetter;
   public static int inPut = 0;
   public static char turn;
   public static String winner;

   public static void createBoard() {

		board = new char[9];

 		for(int i = 0; i < board.length; i++) {

		board[i] = (char) (i + '1');

 		}

   }

   public static char chooseUserLetter(Scanner userInput) {

      System.out.println("Choose your letter 'x' or 'o': ");

      while(true) {

         char userChoice = userInput.next().toUpperCase().charAt(0);

         if( userChoice == 'X' || userChoice == 'O' )

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

		System.out.println( "Enter a index number to place " + turn + " in: ");

		while(winner == null) {

			try {

				inPut = userInput.nextInt();

				if (!(inPut > 0 && inPut <= 9)) {

				System.out.println("Invalid input");

				continue;

				}

			}

			catch (InputMismatchException e) {

				System.out.println("Invalid input");

				continue;

			}

			if(String.valueOf(board[inPut - 1]).equals(String.valueOf(inPut))) {

				board[inPut - 1] = turn;

				showBoard();

			if (turn == userLetter ) {

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

				System.out.println( "Slot already taken; re-enter slot number:");

			}

		}

	  if (winner.equalsIgnoreCase("draw")) {

		  System.out.println("It's a draw! Thanks for playing.");

 		}

		else {

			if(winner == String.valueOf(userLetter)) {

            System.out.println( "\nCongratulations! User's have won! Thanks for playing.");

			}

			else {

				System.out.println( "\nCongratulations! Computer's have won! Thanks for playing.");

			}

		}

   }

	public static char toss() {

		double toss = Math.floor(Math.random() * 10) % 2;

		if(toss == 0) {

			System.out.println("User got the chance first");

		}

	   else

			System.out.println("Computer got the chance first");
			return computerLetter;

		}

	}

	static String checkWinner() {

		for (int a = 0; a < 8; a++) {

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

			//For X winner
			if (line.equals("XXX")) {
				return "X";
			}

			//For O winner
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
