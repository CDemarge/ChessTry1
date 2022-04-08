package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.LocationPositions;
import com.chess.squares.Square;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Queen extends AbstractPiece implements Move{
    public Queen(PieceColor pieceColor) {
        super(pieceColor);
        this.name = "Queen";
    }

    public Queen() { }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        getQueenMoves(moveCandidates, squareMap, current, 1, 1);
        getQueenMoves(moveCandidates, squareMap, current, 1, -1);
        getQueenMoves(moveCandidates, squareMap, current, -1, 1);
        getQueenMoves(moveCandidates, squareMap, current, -1, -1);
        getQueenMoves(moveCandidates, squareMap, current, 0, 1);
        getQueenMoves(moveCandidates, squareMap, current, 0, -1);
        getQueenMoves(moveCandidates, squareMap, current, 1, 0);
        getQueenMoves(moveCandidates, squareMap, current, -1, 0);
        return moveCandidates;
    }

    private List<String> whiteAttackedQueen;
    private List<String> blackAttackedQueen;

    public void getQueenMoves(List<Location> moveCandidates,
                                Map<Location, Square> squareMap,
                                Location current,
                                int rankOffset,
                                int fileOffset) {
        Location next = LocationPositions.build(current, rankOffset, fileOffset);
        whiteAttackedQueen = new ArrayList<>();
        blackAttackedQueen = new ArrayList<>();

        while (squareMap.containsKey(next)) {
            if (squareMap.get(next).isOccupied()) {
                if (squareMap.get(next).getCurrentPiece()
                        .pieceColor.equals(this.pieceColor)) {
                    break;
                } else if (squareMap.get(next).getCurrentPiece()
                        .pieceColor != this.pieceColor) {
                    System.out.println("Piece here.");
                    if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(PieceColor.WHITE)) {
                        whiteAttackedQueen.add(squareMap.get(next).getCurrentPiece().getName() + squareMap.get(next).getLocation());
                    } else if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(PieceColor.BLACK)) {
                        blackAttackedQueen.add(squareMap.get(next).getCurrentPiece().getName() + squareMap.get(next).getLocation());
                    }
                    moveCandidates.add(next);
                    break;
                }

            }
            moveCandidates.add(next);
        }
        System.out.print(whiteAttackedQueen);74
    }

    public final List<String> getBlackQueen() {
        return whiteAttackedQueen;
    }
    public final List<String> getWhiteQueen() {
        return blackAttackedQueen;
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        getQueenMoves(moveCandidates, squareMap, current, 1, 1);
        getQueenMoves(moveCandidates, squareMap, current, 1, -1);
        getQueenMoves(moveCandidates, squareMap, current, -1, 1);
        getQueenMoves(moveCandidates, squareMap, current, -1, -1);
        getQueenMoves(moveCandidates, squareMap, current, 0, 1);
        getQueenMoves(moveCandidates, squareMap, current, 0, -1);
        getQueenMoves(moveCandidates, squareMap, current, 1, 0);
        getQueenMoves(moveCandidates, squareMap, current, -1, 0);
        return moveCandidates;
    }

    @Override
    public void makeMove(Square square) {
        Square current = this.getCurrentSquare();
        this.setCurrentSquare(square);
        current.reset();
    }
}
