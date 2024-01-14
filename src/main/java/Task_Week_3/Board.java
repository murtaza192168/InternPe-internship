package Task_Week_3;

import java.util.Random;

public class Board {
    // instance variables
//    int nrows;
//    int ncols;
    public int[][] board_arr = new int[3][3];
    // to initialize number of rows and columns, you need to create a constrctor of a class
//    public Board(int nrows, int ncols){ // we will pass this constructor in main method of main class to actually pass values for number of rows and cols of the board
//
//        this.nrows = nrows;
//        this.ncols = ncols;
//    }

    // Displaying the board with formatting including identifiers. (So that users can choose at which position I want to insert my move ("X" / "O"))
    public static void instructionalBoard(){
        System.out.println("| - | - | - |"); // This GAME BOARD will be printed first the moment we run the program
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("| - | - | - |");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("| - | - | - |");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("| - | - | - |");
    }
    // Display the board and write a code to actaully make the compiler understand that with the help of:
      // 0 , 1, 2 -->> " ", "X", "O"
    // Print rows in the board and by visiting each cell give indication: if cell contains "X" then cell value is 1
    //                                                                    if cell is empty, then cell value is 0
    //                                                                    if cell conttains "O" then cell value is 2
    public  void printBoard(){
        System.out.println("| - | - | - |");
        System.out.println(printRow(0));
        System.out.println("| - | - | - |");
        System.out.println(printRow(1));
        System.out.println("| - | - | - |");
        System.out.println(printRow(2));
        System.out.println("| - | - | - |");
    }
    public  String printRow(int row){
        StringBuilder rowDisplay =  new StringBuilder("| ");

        for(int i=0; i<board_arr[0].length; i++){
            if(board_arr[row][i] == 0){
                rowDisplay.append(" ");
            }
            if(board_arr[row][i] == 1){
                rowDisplay.append("X");
            }
            if(board_arr[row][i] == 2){
                rowDisplay.append("O");
            }
            rowDisplay.append(" | ");
        }
        rowDisplay.deleteCharAt(rowDisplay.lastIndexOf(" "));
        return rowDisplay.toString(); // One by one row will be executed. One row will return then again for next row, printRow(1) will be called and so on...

    }

    // Plan the player moves. The position entered, and the Piece type ("X", "O"). What actions will be performed on rows and cols. Calculatiing the rows and cols
    public boolean piecePlaced(int pos, String pieceType){
        // Calculate row and column positions using mathematical general formula
        int row = (pos-1) / 3;
        int col = (pos - (row*3))- 1;
        if(board_arr[row][col] == 0){ // if particular cell is empty

            if(pieceType.equals("X")){ board_arr[row][col] = 1; }
            if(pieceType.equals("O")){ board_arr[row][col] = 2; }
            return true; // tells that the piece X / O was chosed
        }
        return false;
    }
    public boolean piecePlacedRandomly(String pieceType){ // piece chosed by the computer : (opponent)
        int row = new Random().nextInt(3);
        int col = new Random().nextInt(3);
        boolean isPiecePlaced = false;
        // run the while loop untill piece is not placed and matrix(board) is not full
        while(!isPiecePlaced && (!isMatrixFull())){
            if(board_arr[row][col] == 0){

                if(pieceType.equals("X")){ board_arr[row][col] = 1; }
                if(pieceType.equals("O")){ board_arr[row][col] = 2; }
                return true; // tells that the piece X / O was placed in the cell
            }
            else{ // search for other new cells randomly that are empty
                 row = new Random().nextInt(3);
                 col = new Random().nextInt(3);
            }

        }
        return isPiecePlaced;
    }
    public boolean isMatrixFull(){
        for(int row=0; row< board_arr.length;row++){
            for(int col=0; col<board_arr[0].length; col++){
                if(board_arr[row][col] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public int[][] getBoard(){
        return board_arr;
    }
    //IMPORTANT NEW// constructing a class inside a class
    public static class Cell{
        // instances
        int row;
        int col;
        public Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }


}

