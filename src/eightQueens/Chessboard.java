package eightQueens;

import java.util.Arrays;

public class Chessboard {
    private int[] chessboard;
    private int counter;

    public void initChessboard(int size) {
        chessboard = new int[size];
        Arrays.fill(chessboard, -1);
    }

    public void printChessboard() {
        for (int row : chessboard) {
            for (int column = 0; column < chessboard.length; column++) {
                if (column == row) {
                    System.out.print("[Q]");
                } else
                    System.out.print("[_]");
            }
            System.out.println();
        }
        System.out.println();
        counter++;
    }

    public void positionQueen(int row) {
        if (row == chessboard.length)
            printChessboard();
        else {
            for (int column = 0; column < chessboard.length; column++) {
                if (queenIsSave(row, column)) {
                    chessboard[row] = column;
                    positionQueen(row + 1);
                }
                chessboard[row] = -1;
            }
        }
    }

    private boolean queenIsSave(int row, int column) {
        return (checkIfThreatenedByOtherQueen(row, column));
    }

    private boolean checkIfThreatenedByOtherQueen(int newQueenRow, int newQueenColumn) {
        for (int row = 0; row < chessboard.length; row++) {
            if (checkVertical(row, newQueenColumn) || checkDiagonal(row, newQueenRow, newQueenColumn))
                return false;
        }
        return true;
    }

    private boolean checkVertical(int row, int newQueenColumn) {
        return (chessboard[row] == newQueenColumn);
    }

    private boolean checkDiagonal(int row, int newQueenRow, int newQueenColumn) {
        int deltaRow = row - newQueenRow;
        int deltaColumn = chessboard[row] - newQueenColumn;
        return (chessboard[row] != -1 && (Math.abs(deltaRow) == Math.abs(deltaColumn)));
    }

    public int getCounter() {
        return counter;
    }
}
