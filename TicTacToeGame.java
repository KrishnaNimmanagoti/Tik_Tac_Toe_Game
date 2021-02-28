import java.util.*;

public class TicTacToeGame {

   public static char[] board;
   public static char userLetter;
   public static char computerLetter;
   public static int inPut = 0;

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

      while(true) {

      try {

         inPut = userInput.nextInt();

         if (!(inPut > 0 && inPut <= 9)) {

            System.out.println("Invalid input");

         }

      }

      catch (InputMismatchException e) {

         System.out.println("Invalid input");

      }

      if(String.valueOf(board[inPut - 1]).equals(String.valueOf(inPut))) {

      board[inPut - 1] = turn;

      if (turn == userLetter )

          turn = computerLetter;

      else

          turn = userLetter;

      showBoard();

      }

      else {

    	  System.out.println( "Slot already taken; re-enter slot number:");

      }

      }

   }

   public static char toss() {

	   double toss = Math.floor(Math.random() * 10) % 2;

	   if(toss == 0) {

		   System.out.println("User got the chance first");
		   return userLetter;
	   }
	   else

		   System.out.println("Computer got the chance first");
		   return computerLetter;

   }

   public static void main(String[] args) {

      Scanner userInput = new Scanner(System.in);

      createBoard();

      userLetter = chooseUserLetter(userInput);

      computerLetter = (userLetter == 'X') ? 'O' : 'X';

      showBoard();

      char turn = toss();

      makeMove(userInput, turn);

   }

}
