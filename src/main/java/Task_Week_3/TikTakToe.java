package Task_Week_3;

import java.util.Scanner;

public class TikTakToe {
    public static void main(String[] args) {
        System.out.println("*********TIC-TAC-TOE*********");
        Scanner input = new Scanner(System.in);
        Board board = new Board();
        Board.instructionalBoard();

        // Make enter the position by the user
        System.out.println("Enter the position: ");
        int position = input.nextInt();
        board.piecePlaced(position, "O");


        boolean isGameInProgress = true; // Base value. Further based on the conditions it will change
        while(isGameInProgress && !board.isMatrixFull()){
            board.piecePlacedRandomly("X");
            board.printBoard();
            isGameInProgress = GameResolver.winnerDeclaration(board.getBoard()) == GameResolver.Game_State.IN_PROGRESS;

            if(!isGameInProgress){
                System.out.println("GAME OVER!");
                break;
            }
            else{
                System.out.println("Enter another  position: ");
                position = input.nextInt();
                board.piecePlaced(position, "O");
            }
        }
    }
}
