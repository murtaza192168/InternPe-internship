package Task_Week_3;


public class GameResolver {
    public static Game_State calculateGameState(int[][] board,  Board.Cell position){
        /*_Board.Cell position:: _InnerClass object with a reference "position" to access rows and cols of a specific cell*/
        int gamePiece = board[position.row][position.col];
        if(gamePiece == 0){
            return Game_State.IN_PROGRESS;
        }
        // CHECK EVERY POSSIBLE CONSECUTIVE PIECES IN LINE AT EVERY DIRECTION

        // Down direction
        boolean isCellOutOfBoard = (position.row+1 > board.length-1);
        if (!isCellOutOfBoard && board[position.row+1][position.col] == gamePiece) {
            isCellOutOfBoard = (position.row+2 > board.length-1);
            if(!isCellOutOfBoard && board[position.row+2][position.col] == gamePiece){
                return gamePiece == 2 ? Game_State.O_WON: Game_State.X_WON;
            }

        }

        // UP direction
        isCellOutOfBoard = (position.row-1<0);
        if(!isCellOutOfBoard && board[position.row-1][position.col] == gamePiece){
            isCellOutOfBoard = (position.row-2<0);
            if(!isCellOutOfBoard && board[position.row-2][position.col] == gamePiece){
                return gamePiece == 2 ? Game_State.O_WON: Game_State.X_WON;
            }
        }

        // RIGHT direction
        isCellOutOfBoard = (position.col+1 > board[0].length-1);
        if(!isCellOutOfBoard && board[position.row][position.col+1] == gamePiece){
            isCellOutOfBoard = (position.col+2 > board[0].length-1);
            if(!isCellOutOfBoard && board[position.row][position.col+2] == gamePiece){
                return gamePiece == 2 ? Game_State.O_WON: Game_State.X_WON;
            }
        }

        //LEFT direction
        isCellOutOfBoard = (position.col-1 < 0);
        if(!isCellOutOfBoard && board[position.row][position.col-1] == gamePiece){
            isCellOutOfBoard = (position.col-2 < 0);
            if(!isCellOutOfBoard && board[position.row][position.col-2] == gamePiece){
                return gamePiece == 2 ? Game_State.O_WON: Game_State.X_WON;
            }
        }

        // RIGHT DOWN (DIAGNOLY) direction
        isCellOutOfBoard = (position.row+1>board.length-1 || position.col+1>board[0].length-1); // check boundaries
        if(!isCellOutOfBoard && board[position.row+1][position.col+1] == gamePiece){
            isCellOutOfBoard = (position.row+2>board.length-1 || position.col+2>board[0].length-1);
             if(!isCellOutOfBoard && (board[position.row+2][position.col+2] == gamePiece)){
                 return gamePiece == 2 ? Game_State.O_WON: Game_State.X_WON;
             }
        }

        // LEFT UP (DIAGONALLY) direction
        isCellOutOfBoard = (position.row-1 < 0 || position.col-1 < 0);
        if(!isCellOutOfBoard && board[position.row-1][position.col-1] == gamePiece){
            isCellOutOfBoard = (position.row-2 < 0 || position.col-2 < 0);
            if(!isCellOutOfBoard && board[position.row-2][position.col-2] == gamePiece){
                return gamePiece == 2 ? Game_State.O_WON: Game_State.X_WON;
            }
        }

        //RIGHT UP (DIAGONALLY) direction
        isCellOutOfBoard = (position.row-1 < 0 || position.col+1 > board[0].length-1);
        if(!isCellOutOfBoard && board[position.row-1][position.col+1] == gamePiece){
            isCellOutOfBoard = (position.row-2 < 0 || position.col+2 > board[0].length-1);
            if(!isCellOutOfBoard && board[position.row-2][position.col+2] == gamePiece){
                return gamePiece == 2 ? Game_State.O_WON: Game_State.X_WON;
            }
        }
        // LEFT DOWN (DIAGONALLY) direction
        isCellOutOfBoard = (position.row+1 > board.length-1 || position.col-1 < 0);
        if(!isCellOutOfBoard && board[position.row+1][position.col-1] == gamePiece){
            isCellOutOfBoard = (position.row+2 > board.length-1 || position.col-2 < 0);
            if(!isCellOutOfBoard && board[position.row+2][position.col-2] == gamePiece){
                return gamePiece == 2 ? Game_State.O_WON: Game_State.X_WON;
            }
        }
        return Game_State.IN_PROGRESS;
    }


    // We will create a method with a return type of Enum
    // Declaring this method as static as it will not depend on the object, but the enum_type
    public static Game_State winnerDeclaration(int[][] board){

        for(int row=0; row< board.length; row++){
            for(int col=0; col< board[0].length;col++){ // check for every cell
                // check if there are three consecutive cells...
                Game_State gameState = calculateGameState(board, new Board.Cell(row,col));
                if(gameState != Game_State.IN_PROGRESS){
                    return gameState;
                }
            }
        }
        return Game_State.IN_PROGRESS;
    }
    // Now we will create an Enumeration named GameState to store 3 constants: IN_PROGRESS, X_WON, O_WON
    // enum will perfectly fit to work here as the game sate can have three scenarios
    public enum Game_State{
        IN_PROGRESS, X_WON, O_WON;
    }
}
