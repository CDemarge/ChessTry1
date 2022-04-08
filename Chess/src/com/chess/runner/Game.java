package com.chess.runner;

import com.chess.board.Board;
import com.chess.piece.AbstractPiece;
import com.chess.piece.Bishop;
import com.chess.piece.PieceColor;

public class Game {
    public static void main(String[] args) {

        // Code below is to check for the tile setting of the board.
        // It helps with putting right colors on right squares.
        // -----------------------------
        Board board = new Board();

        board.printBoard();

         ;

        // -----------------------------

        // PieceColor color =PieceColor.BLACK;
        // Pawn pawn = new Pawn(color); // AbstractPiece pawn = new Pawn(color);
        // Game.printPiece(pawn);
    }

    // By using AbstractPiece, so we don't have to call for each piece one by one.
    // P.S. An abstract piece may not have all the functionality of a specific case.
    //      But every specific piece will have the functionality of an abstract piece.

    public static void printPiece(AbstractPiece piece){
       System.out.println(piece.toString());
    }
}
