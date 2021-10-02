package tictactoe;

import java.util.*;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static char[][] input  = new char[3][3];
    static String inputLump = "0";
    static boolean isNotValidated = false;
    static boolean xOrO = false;
    static boolean isCalledOnce = false;

    public static void main(String[] args) {
        populateArray();
    }


    public static void populateArray() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 2; j++) {
                input[i][j] = ' ';
            }
        }

        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j <= 2; j++) {
                
                System.out.print(input[i][j] + " ");

            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
        askUser();
    }

    public static void askUser() {


        int inputRow = 0,inputColumn = 0 ;

        do {
            System.out.println("Enter the coordinates: ");

            if (!scanner.hasNextInt()) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            } else {
                inputRow = scanner.nextInt();
                inputColumn = scanner.nextInt();
                if (inputRow < 1 || inputRow > 3 || inputColumn < 1 || inputColumn > 3 ) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if ( input[inputRow - 1][inputColumn - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else if (!xOrO) {
                    input[inputRow - 1][inputColumn - 1] = 'X';
                    isNotValidated = false;
                    xOrO = true;

                } else if (xOrO){
                    input[inputRow - 1][inputColumn - 1] = 'O';
                    isNotValidated = false;
                    xOrO = false;
                }
            }

        } while (isNotValidated);

        print();


    }

    public static void print(){

        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j <= 2; j++) {
                System.out.print(input[i][j] + " ");

            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");

        win();

    }

    public static void win(){

        int xCount = 0;
        int oCount = 0;

        boolean xWin = false;
        boolean oWin = false;

        // Counting Xs and Os
        for (int i = 0; i < 3; i++) {
            int row = 0;
            int column = 0;
            int mDiag = 0;
            int aDiag =0;

            for (int j = 0; j < 3; j++) {

                row += input[i][j];
                column += input[j][i];
                mDiag += input[j][j];
                aDiag += input[j][2 - j];


                if (input[i][j] == 'X') {
                    xCount++;

                } else if (input[i][j] == 'O') {
                    oCount++;
                }
            }

            xWin = xWin || row == 264 || column == 264 || aDiag == 264 || mDiag == 264;
            oWin = oWin || row == 237 || column == 237 || aDiag == 237 || mDiag == 237;
        }

        String result = " ";
        if (Math.abs(xCount - oCount) > 1 || xWin && oWin) {
            result = "Impossible";
        } else {

            if (xWin) {
                result = "X wins";

            } else {
                if (oWin) {
                    result = "O wins";

                } else {
                    if (xCount + oCount == 9) {
                        result = "Draw";
                    }
                    else  askUser();
                }
            }
            System.out.println(result);
        }
//                        : "Game not finished";

    }

}
