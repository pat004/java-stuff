import java.util.Scanner;

class TicTacToe{
    public static void main(String[] args){
        System.out.println("Instructions: Empty slots on the board below are ordered\nleft to right, top to bottom, in numerical order (1 to 9).");
        int turn = 0; // initialize variables
        boolean on = true;
        String player = " ";
        String[] board = {" "," "," "," "," "," "," "," "," "};
        String[] moves = {"1","2","3","4","5","6","7","8","9"};
        while (on){
            writeBoard(board);
            if (turn == 0){
                player = "X";
                turn++;
                getMove(player, moves, board);
                writeBoard(board);
                if (winCheck(board, player) == true){
                    System.out.println(player + " Wins!");
                    on = restart(board, moves);
                }
            } else {
                player = "O";
                turn--;
                getMove(player, moves, board);
                writeBoard(board);
                if (winCheck(board, player) == true){
                    System.out.println(player + " Wins!");
                    on = restart(board, moves);
                }
            }
        }
        System.out.println("\nThanks for playing!");
    }

    public static void writeBoard(String[] board){
        System.out.println("\n" + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]+ "\n");
    }

    public static final Scanner USER_IN = new Scanner(System.in); // for user input
    
    public static void getMove(String playerCurrent, String[] movesList, String[] board){
        boolean validMove = false;
        String input = "";
        if (
            !board[0].equals(" ") && !board[1].equals(" ") && !board[2].equals(" ") &&
            !board[3].equals(" ") && !board[4].equals(" ") && !board[5].equals(" ") &&
            !board[6].equals(" ") && !board[7].equals(" ") && !board[8].equals(" ")
            ){
                validMove = true;
            }
        while (validMove == false) {
            System.out.print(playerCurrent + ", choose an empty slot (1-9): ");
            input = USER_IN.nextLine();
            for (int i = 0; i < movesList.length; i++){
                if ((input.equals(movesList[i])) && (board[i] == " ") && (movesList[i] != "0")){
                    movesList[i] = "0";
                    board[i] = playerCurrent;
                    validMove = true;
                }
            }
        }
    }  
    public static boolean winCheck (String[] board, String playerCurrent){
        if (playerCurrent.equals(board[0]) && playerCurrent.equals(board[1]) && playerCurrent.equals(board[2])){
            return true;
        } else if (playerCurrent.equals(board[3]) && playerCurrent.equals(board[4]) && playerCurrent.equals(board[5])){
            return true;
        } else if (playerCurrent.equals(board[7]) && playerCurrent.equals(board[8]) && playerCurrent.equals(board[9])){
            return true; // ^ all rows
        } else if (playerCurrent.equals(board[0]) && playerCurrent.equals(board[3]) && playerCurrent.equals(board[6])){
            return true;
        } else if (playerCurrent.equals(board[1]) && playerCurrent.equals(board[4]) && playerCurrent.equals(board[7])){
            return true;
        } else if (playerCurrent.equals(board[2]) && playerCurrent.equals(board[5]) && playerCurrent.equals(board[8])){
            return true; // ^ all collumns
        } else if (playerCurrent.equals(board[0]) && playerCurrent.equals(board[4]) && playerCurrent.equals(board[8])){
            return true;
        } else if (playerCurrent.equals(board[2]) && playerCurrent.equals(board[4]) && playerCurrent.equals(board[6])){
            return true; // ^ all diagonals
        } else {
            return false;
        }
    }
    public static boolean restart(String[] board, String[] moves){
        for (int i = 0; i < board.length; i++){
            board[i] = " ";
        } // refresh game board
        moves[0] = "1";
        moves[1] = "2";
        moves[2] = "3";
        moves[3] = "4";
        moves[4] = "5";
        moves[5] = "6";
        moves[6] = "7";
        moves[7] = "8";
        moves[8] = "9"; // refresh available moves
        String input = " ";
        boolean looping = true;
        while (looping){
            System.out.print("\nReplay? yes or no: ");
            input = USER_IN.nextLine();
            if (input.equals("yes")){
                return true;
            }
            if (input.equals("no")){
                looping = false;
            }
        } return false;
    }
}