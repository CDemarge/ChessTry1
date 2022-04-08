package com.chess.piece;

import com.chess.common.File;
import com.chess.common.Location;

import java.util.HashMap;
import java.util.Map;

public final class PiecesOnBoard {

    private PiecesOnBoard() { }

    public static Map<Location, AbstractPiece> getPieces() {
        Map<Location, AbstractPiece> pieces = new HashMap<>();

        // White Pieces
        pieces.put(new Location(File.A, 1), new Rook(PieceColor.WHITE));
        pieces.put(new Location(File.B, 1), new Knight(PieceColor.WHITE));
        pieces.put(new Location(File.C, 1), new Bishop(PieceColor.WHITE));
        pieces.put(new Location(File.D, 5), new Queen(PieceColor.WHITE));
        pieces.put(new Location(File.E, 1), new King(PieceColor.WHITE));
        pieces.put(new Location(File.F, 1), new Bishop(PieceColor.WHITE));
        pieces.put(new Location(File.G, 1), new Knight(PieceColor.WHITE));
        pieces.put(new Location(File.H, 1), new Rook(PieceColor.WHITE));
        //pieces.put(new Location(File.A, 2), new Pawn(PieceColor.WHITE));
        //pieces.put(new Location(File.B, 2), new Pawn(PieceColor.WHITE));
        //pieces.put(new Location(File.C, 2), new Pawn(PieceColor.WHITE));
        //pieces.put(new Location(File.D, 2), new Pawn(PieceColor.WHITE));
        //pieces.put(new Location(File.E, 2), new Pawn(PieceColor.WHITE));
        //pieces.put(new Location(File.F, 2), new Pawn(PieceColor.WHITE));
        //pieces.put(new Location(File.G, 2), new Pawn(PieceColor.WHITE));
        //pieces.put(new Location(File.H, 2), new Pawn(PieceColor.WHITE));

        //Black Pieces
        pieces.put(new Location(File.A, 8), new Rook(PieceColor.BLACK));
        pieces.put(new Location(File.B, 8), new Knight(PieceColor.BLACK));
        pieces.put(new Location(File.C, 8), new Bishop(PieceColor.BLACK));
        pieces.put(new Location(File.E, 5), new Queen(PieceColor.BLACK));
        pieces.put(new Location(File.E, 8), new King(PieceColor.BLACK));
        pieces.put(new Location(File.F, 8), new Bishop(PieceColor.BLACK));
        pieces.put(new Location(File.G, 8), new Knight(PieceColor.BLACK));
        pieces.put(new Location(File.H, 8), new Rook(PieceColor.BLACK));
        //pieces.put(new Location(File.A, 7), new Pawn(PieceColor.BLACK));
        //pieces.put(new Location(File.B, 7), new Pawn(PieceColor.BLACK));
        //pieces.put(new Location(File.C, 7), new Pawn(PieceColor.BLACK));
        //pieces.put(new Location(File.D, 7), new Pawn(PieceColor.BLACK));
        //pieces.put(new Location(File.E, 7), new Pawn(PieceColor.BLACK));
        //pieces.put(new Location(File.F, 7), new Pawn(PieceColor.BLACK));
        //pieces.put(new Location(File.G, 7), new Pawn(PieceColor.BLACK));
        //pieces.put(new Location(File.H, 7), new Pawn(PieceColor.BLACK));

        return pieces;
    }


}
