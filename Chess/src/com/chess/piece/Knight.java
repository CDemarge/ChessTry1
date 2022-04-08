package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.LocationPositions;
import com.chess.squares.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Knight extends AbstractPiece implements Move{
    public Knight(PieceColor pieceColor) {
        super(pieceColor);
        this.name = "AKnight";
    }

    public Knight() { }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        getKnightMoves(moveCandidates, squareMap, current, 1,2);
        getKnightMoves(moveCandidates, squareMap, current, 1,-2);
        getKnightMoves(moveCandidates, squareMap, current, -1,2);
        getKnightMoves(moveCandidates, squareMap, current, -1,-2);
        getKnightMoves(moveCandidates, squareMap, current, 2,1);
        getKnightMoves(moveCandidates, squareMap, current, 2,-1);
        getKnightMoves(moveCandidates, squareMap, current, -2,1);
        getKnightMoves(moveCandidates, squareMap, current, -2,-1);
        return moveCandidates;
    }

    private List<String> whiteAttackedKnight;
    private List<String> blackAttackedKnight;

    public void getKnightMoves(List<Location> moveCandidates,
                              Map<Location, Square> squareMap,
                              Location current, int rankOffset, int fileOffset) {
        Location next = LocationPositions.build(current, rankOffset, fileOffset);
        whiteAttackedKnight = new ArrayList<>();
        blackAttackedKnight = new ArrayList<>();
        while (squareMap.containsKey(next)) {
            if (squareMap.get(next).isOccupied()) {
                if (squareMap.get(next).getCurrentPiece()
                        .pieceColor.equals(this.pieceColor)) {
                    break;
                }  else if (squareMap.get(next).getCurrentPiece()
                        .pieceColor != this.pieceColor) {
                    if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(PieceColor.WHITE)) {
                        whiteAttackedKnight.add(squareMap.get(next).getCurrentPiece().getName() + squareMap.get(next).getLocation());
                    } else if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(PieceColor.BLACK)) {
                        blackAttackedKnight.add(squareMap.get(next).getCurrentPiece().getName() + squareMap.get(next).getLocation());
                    }
                    moveCandidates.add(next);
                    break;
                }
            }
            moveCandidates.add(next);
            break;
        }
    }

    public final List<String> getBlackKnight() {
        return whiteAttackedKnight;
    }
    public final List<String> getWhiteKnight() {
        return blackAttackedKnight;
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        getKnightMoves(moveCandidates, squareMap, current, 1,2);
        getKnightMoves(moveCandidates, squareMap, current, 1,-2);
        getKnightMoves(moveCandidates, squareMap, current, -1,2);
        getKnightMoves(moveCandidates, squareMap, current, -1,-2);
        getKnightMoves(moveCandidates, squareMap, current, 2,1);
        getKnightMoves(moveCandidates, squareMap, current, 2,-1);
        getKnightMoves(moveCandidates, squareMap, current, -2,1);
        getKnightMoves(moveCandidates, squareMap, current, -2,-1);
        return moveCandidates;
    }

    @Override
    public void makeMove(Square square) {
        System.out.println(this.getName() + "-> makeMove()");
    }
}
