package eightQueens;

public class Main {

    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        chessboard.initChessboard(8);
        chessboard.positionQueen(0);
        System.out.println("Possible solutions found: " + chessboard.getCounter());
    }
}
