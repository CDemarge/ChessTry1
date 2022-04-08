package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.LocationPositions;
import com.chess.squares.Square;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pawn extends AbstractPiece implements Move{


    //Need to create a super class.
    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
        this.name = "Pawn";
    }

    public Pawn() { }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();

        // I am not using any other move because other moves do not have
        // capture movement on the board.

        // I need 2 sets of pawn moves based on the color because they move
        // opposite direction.

        // White Pieces Capture Moves
        getWhitePawnMoves(moveCandidates, squareMap, current, 1,1);
        getWhitePawnMoves(moveCandidates, squareMap, current, 1,-1);

        // Black Pieces Capture Moves
        getBlackPawnMoves(moveCandidates, squareMap, current, -1,1);
        getBlackPawnMoves(moveCandidates, squareMap, current, -1,-1);

        return moveCandidates;
    }

    private List<String> whiteAttackedPawn;
    private List<String> blackAttackedPawn;

    public void getWhitePawnMoves(List<Location> moveCandidates,
                              Map<Location, Square> squareMap,
                              Location current, int rankOffset, int fileOffset) {
        Location next = LocationPositions.build(current, rankOffset, fileOffset);
        blackAttackedPawn = new ArrayList<>();
        if (this.pieceColor.equals(PieceColor.WHITE)) {
            while (squareMap.containsKey(next)) {
                if (squareMap.get(next).isOccupied()) {
                    if (squareMap.get(next).getCurrentPiece()
                            .pieceColor.equals(this.pieceColor)) {
                        break;
                    }
                    if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(PieceColor.BLACK)) {
                        blackAttackedPawn.add(currentSquare.getCurrentPiece().getName() + squareMap.get(next).getLocation());
                    }
                    moveCandidates.add(next);
                    break;
                }
            }
        }
    }

    public void getBlackPawnMoves(List<Location> moveCandidates,
                              Map<Location, Square> squareMap,
                              Location current, int rankOffset, int fileOffset) {
        Location next = LocationPositions.build(current, rankOffset, fileOffset);
        whiteAttackedPawn = new ArrayList<>();
        if (this.pieceColor.equals(PieceColor.BLACK)) {
            while (squareMap.containsKey(next)) {
                if (squareMap.get(next).isOccupied()) {
                    if (squareMap.get(next).getCurrentPiece()
                        .pieceColor.equals(this.pieceColor)) {
                        break;
                    }
                    if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(PieceColor.WHITE)) {
                        whiteAttackedPawn.add(squareMap.get(next).getCurrentPiece().getName() + squareMap.get(next).getLocation());
                    }
                    moveCandidates.add(next);
                    break;
                }
            }
        }
    }

    public List<String> getBlackPawn() {
        return whiteAttackedPawn;
    }
    public List<String> getWhitePawn() {
        return blackAttackedPawn;
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        getWhitePawnMoves(moveCandidates, squareMap, current, 1,1);
        getWhitePawnMoves(moveCandidates, squareMap, current, 1,-1);
        getBlackPawnMoves(moveCandidates, squareMap, current, -1,1);
        getBlackPawnMoves(moveCandidates, squareMap, current, -1,-1);
        return moveCandidates;
    }

    @Override
    public void makeMove(Square square) {

    }
}
