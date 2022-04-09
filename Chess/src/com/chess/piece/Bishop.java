package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.LocationPositions;
import com.chess.squares.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bishop extends AbstractPiece implements Move {



    public Bishop(PieceColor pieceColor) {
        super(pieceColor);
        this.name = "Bishop";
    }

    public Bishop() { }


    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        getBishopMoves(moveCandidates, squareMap, current, 1, 1);
        getBishopMoves(moveCandidates, squareMap, current, 1, -1);
        getBishopMoves(moveCandidates, squareMap, current, -1, 1);
        getBishopMoves(moveCandidates, squareMap, current, -1, -1);
        return moveCandidates;
    }


    private static List<String> whiteAttackedBishop  = new ArrayList<>();
    private static List<String> blackAttackedBishop  = new ArrayList<>();

    public void getBishopMoves(List<Location> moveCandidates,
                                Map<Location, Square> squareMap,
                                Location current,
                                int rankOffset,
                                int fileOffset) {
        Location next = LocationPositions.build(current, rankOffset, fileOffset);
        while (squareMap.containsKey(next)) {
            if (squareMap.get(next).isOccupied()) {
                if (squareMap.get(next).getCurrentPiece()
                        .pieceColor.equals(this.pieceColor)) {
                    break;
                } else if (squareMap.get(next).getCurrentPiece()
                            .pieceColor != this.pieceColor) {
                    
                    // I wanted to create listing based on the color of the pieces on attacked square.
                    
                    if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(PieceColor.WHITE)) {
                        whiteAttackedBishop.add(squareMap.get(next).getCurrentPiece().getName()
                                + squareMap.get(next).getLocation());
                        System.out.println("Piece here.");
                    } else if (squareMap.get(next).getCurrentPiece().getPieceColor()
                            .equals(PieceColor.BLACK)) {
                        blackAttackedBishop.add(squareMap.get(next).getCurrentPiece().getName()
                                + squareMap.get(next).getLocation());
                    }
                    moveCandidates.add(next);
                    break;
                }
            }
            moveCandidates.add(next);
        }
    }



    public List<String> getBlackBishop() {
        return whiteAttackedBishop;
    }
    public List<String> getWhiteBishop() {
        return blackAttackedBishop;
    }


    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = square.getLocation();
        getBishopMoves(moveCandidates, squareMap, current, 1, 1);
        getBishopMoves(moveCandidates, squareMap, current, 1, -1);
        getBishopMoves(moveCandidates, squareMap, current, -1, 1);
        getBishopMoves(moveCandidates, squareMap, current, -1, -1);
        return moveCandidates;
    }

    @Override
    public void makeMove(Square square) {
        System.out.println(this.getName() + "-> makeMove()");
    }
}
