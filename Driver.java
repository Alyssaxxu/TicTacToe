
/**
 * @alyssa Xu
 */
import java.util.Scanner;

public class Driver
{
    static int round = 1;
    static String [][] board = new String[3][3];
    static String currentPlayer = "X";
    static boolean playing = false;
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        while (true){
            boardCreate();
            play(input);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = input.next().toLowerCase();
            round = 1;
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }

        }
    }

    public static void boardCreate(){
        for(int i = 0; i< 3; i ++){
            for(int j = 0; j< 3; j++){
                board[i][j] = "[ ]";
            }
        }
    }

    public static void printBoard(){
        System.out.println( "Round " + round );
        for(int i = 0; i<3; i ++){
            for(int j = 0; j< 3; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void play (Scanner x){
        while(true){
            printBoard();
            move(x);
            System.out.println(checkWin());
            if (checkWin() == true) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins! Congratulations!");
                round++;
                break;
            } else if (fullBoard()) {
                printBoard();
                System.out.println("It's a tie! The game is a draw.");
                round++;
                break;
            } else {
                switchPlayer();
                round++;
            }
        }
    }

    public static void move(Scanner x){
        int row, col;
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter your move (row,column): ");
            String response = x.next();
            row = Integer.parseInt(response.substring(1,2));
            col = Integer.parseInt(response.substring(3,4));

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == "[ ]") {
                board[row][col] = "[" + currentPlayer +"]";
                break;
            } else {
                System.out.println("Invalid move. Try again.");
                System.out.println(row);
                System.out.print(col);
            }
        }
    }

    public static boolean checkWin(){
        for (int i = 0; i < 3; i++) {
            if ((board[i][0].equals("["+ currentPlayer +"]") && board[i][1].equals("["+ currentPlayer +"]") && board[i][2].equals("["+ currentPlayer +"]")) || 
            (board[0][i].equals("["+ currentPlayer +"]") && board[1][i].equals("["+ currentPlayer +"]") && board[2][i].equals("["+ currentPlayer +"]"))) {
                return true;
            }
        }
        return ((board[0][0].equals("["+ currentPlayer +"]") && board[1][1].equals("["+ currentPlayer +"]") && board[2][2].equals("["+ currentPlayer +"]")) ||
            (board[0][2].equals("["+ currentPlayer +"]") && board[1][1].equals("["+ currentPlayer +"]") && board[2][0].equals("["+ currentPlayer +"]")));

    }

    public static boolean fullBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == "[ ]") {
                    return false;
                }
            }
        }
        return true;
    }

    public static void switchPlayer(){
        if (currentPlayer == "X") {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }
}

