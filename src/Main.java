import java.util.Scanner;

public class Main{

public static void main(String args[]) {

    int[] board = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    Board currentBoard = new Board(board);
    Scanner myObj = new Scanner(System.in);
    int turn = 0;
    //The above code initializes an empty board to play with, as well as a scanner for input

    //While there is no win on the board, this code loops
    //ask for the index of where to place the piece, then place the according one to whoever turn it is

    while (!currentBoard.checkWin(board)&&turn<=8){
        if(turn%2==0) {
            //board[currentBoard.botPieceEasy(board)] = 1;
            board[currentBoard.botPieceMedium(board, turn)] = 1;
        }else{
            boolean emptySpace;
            emptySpace = false;
            int index = 99;
            while(!emptySpace){
                index = myObj.nextInt();
                if(currentBoard.getIndexValue(index-1)==0){
                    emptySpace = true;
                }else{
                    System.out.println("Please enter an empty slot!");
                }
            }
            currentBoard.playedLocations.add(index-1);
            board[index - 1] = 8;
        }
        //print out the board
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i]);
            System.out.print(board[i + 1]);
            System.out.print(board[i + 2]);
            System.out.println();
            i = i + 2;
        }
        System.out.println("where would you lke to place your next piece?");
        turn++;
    }
    if(turn%2==1){
        System.out.println("Get owned     -my lovely cpu");
    }else{
        System.out.println("You are smarter than my decision tree :(");
    }
}

}
