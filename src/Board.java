import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Board {

    public int[] board;
    public ArrayList<Integer> playedLocations = new ArrayList<Integer>();

    public Board (int[] boardInput){
         this.board = boardInput;
    }
    //method to check if an index has already been played
    public boolean hasBeenPlayed(int indexPlayed){

        for(int i = 0; i < playedLocations.size(); i++){
            if(playedLocations.get(i)==indexPlayed){
                return true;
            }
        }
        return false;
    }

    // Public method to get the value of a specified index
    public int getIndexValue(int indexRequest){
        return board[indexRequest];
    }

    //Check through the board and look through each direction to see if 3 in a row match each other
    public boolean checkWin(int[] board){
        if((board[0]==board[1]&&board[1]==board[2])&&board[0]!=0){
            return true;
        }else  if((board[3]==board[4]&&board[4]==board[5])&&board[3]!=0){
            return true;
        }else if((board[6]==board[7]&&board[7]==board[8])&&board[6]!=0){
            return true;
        }

        else if ((board[0] == board[3] && board[3]==board[6])&&board[0]!=0){
                return true;
        }else if((board[1]==board[4]&&board[4]==board[7])&&board[1]!=0) {
            return true;
        }else if((board[2]==board[5]&&board[5]==board[8])&&board[2]!=0) {
            return true;
        }
        else if((board[0]==board[4]&&board[4]==board[8])&&board[0]!=0) {
            return true;
        }else if((board[2]==board[4]&&board[4]==board[6])&&board[2]!=0) {
            return true;
        }
        return false;
    }
    //below is the method for the "easy bot" all it does it place a random piece, hence why it is "easy" to play against
    public int botPieceEasy(int [] board){
        boolean emptySpace=false;
        int indexRandom = 0;
        while(!emptySpace){
            indexRandom = ThreadLocalRandom.current().nextInt(0,8);
            if(board[indexRandom]==0){
                emptySpace=true;
            }
        }
        return indexRandom;
    }
    public int botPieceMedium(int [] board, int turn){
        int index;
        //go through and check if there are two in a row in any direction about to make a win, if so, play to block that piece.

        //top left corner checks
        if(board[0]==board[1]&&(board[0]!=0)&&(!hasBeenPlayed(2))){
            playedLocations.add(2);
            return 2;
        }else if((board[0]==board[3])&&(board[0]!=0)&&(!hasBeenPlayed(6))){
            playedLocations.add(6);
            return 6;
        }else if((board[0]==board[4])&&(board[0]!=0)&&(!hasBeenPlayed(8))){
            playedLocations.add(8);
            return 8;
        }else if((board[2]==board[1])&&(board[2]!=0)&&(!hasBeenPlayed(0))){     //top right corner checks
            playedLocations.add(0);
            return 0;
        }else if((board[2]==board[4])&&(board[2]!=0)&&(!hasBeenPlayed(6))){
            playedLocations.add(6);
            return 6;
        }else if((board[2]==board[5])&&(board[2]!=0)&&(!hasBeenPlayed(8))){
            playedLocations.add(8);
            return 8;
        }else if((board[6]==board[3])&&(board[6]!=0)&&(!hasBeenPlayed(0))){        //bottom left corner checks
            playedLocations.add(0);
            return 0;
        }else if((board[6]==board[4])&&(board[6]!=0)&&(!hasBeenPlayed(2))){
            playedLocations.add(2);
            return 2;
        }else if((board[6]==board[7])&&(board[6]!=0)&&(!hasBeenPlayed(8))){
            playedLocations.add(8);
            return 8;
        }else if((board[8]==board[5])&&(board[8]!=0)&&(!hasBeenPlayed(2))){        //bottom right corner checks
            playedLocations.add(2);
            return 2;
        }else if((board[8]==board[4])&&(board[8]!=0)&&(!hasBeenPlayed(0))){
            playedLocations.add(0);
            return 0;
        }else if((board[8]==board[7])&&(board[8]!=0)&&(!hasBeenPlayed(6))){
            playedLocations.add(6);
            return 6;
        }else if((board[0]==board[2])&&(board[0]!=0)&&(!hasBeenPlayed(1))){        //top edge check
            playedLocations.add(1);
            return 1;
        }else if((board[0]==board[6])&&(board[0]!=0)&&(!hasBeenPlayed(3))){        //left edge check
            playedLocations.add(3);
            return 3;
        }else if((board[2]==board[8])&&(board[2]!=0)&&(!hasBeenPlayed(5))){        //right edge check
            playedLocations.add(5);
            return 5;
        }else if((board[6]==board[8])&&(board[6]!=0)&&(!hasBeenPlayed(7))){        //bottom edge check
            playedLocations.add(7);
            return 7;
        }else if((board[0]==board[8])&&(board[0]!=0)&&(!hasBeenPlayed(4))){        //middle check
            playedLocations.add(4);
            return 4;
        }else if((board[1]==board[7])&&(board[1]!=0)&&(!hasBeenPlayed(4))){
            playedLocations.add(4);
            return 4;
        }else if((board[2]==board[6])&&(board[2]!=0)&&(!hasBeenPlayed(4))){
            playedLocations.add(4);
            return 4;
        }else if((board[3]==board[5])&&(board[3]!=0)&&(!hasBeenPlayed(4))){
            playedLocations.add(4);
            return 4;
        }else if((board[4]==board[5])&&(board[4]!=0)&&(!hasBeenPlayed(3))){
            playedLocations.add(3);
            return 3;
        }else{
            boolean emptySpace=false;
            int indexRandom = ThreadLocalRandom.current().nextInt(0,8);
            while(!emptySpace&&hasBeenPlayed(indexRandom)){
                indexRandom = ThreadLocalRandom.current().nextInt(0,8);
                if(board[indexRandom]==0){
                    emptySpace=true;
                }
            }
            playedLocations.add(indexRandom);
            return indexRandom;
        }
    }
}
