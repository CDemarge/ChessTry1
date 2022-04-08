package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.LocationPositions;
import com.chess.squares.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class King extends AbstractPiece implements Move{
    public King(PieceColor pieceColor) {
        super(pieceColor);
        this.name = "King";
    }

    public King() { }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        getKingMoves(moveCandidates, squareMap, current, 1,1);
        getKingMoves(moveCandidates, squareMap, current, 1,0);
        getKingMoves(moveCandidates, squareMap, current, 1,-1);
        getKingMoves(moveCandidates, squareMap, current, 0,1);
        getKingMoves(moveCandidates, squareMap, current, 0,-1);
        getKingMoves(moveCandidates, squareMap, current, -1,1);
        getKingMoves(moveCandidates, squareMap, current, -1,0);
        getKingMoves(moveCandidates, squareMap, current, -1,-1);
        return moveCandidates;
    }

    private static List<String> whiteAttackedKing;
    private static List<String> blackAttackedKing;

    public void getKingMoves(List<Location> moveCandidates,
                              Map<Location, Square> squareMap,
                              Location current, int rankOffset, int fileOffset) {
        Location next = LocationPositions.build(current, rankOffset, fileOffset);
        whiteAttackedKing = new ArrayList<>();
        blackAttackedKing = new ArrayList<>();
        while (squareMap.containsKey(next)){
            if (squareMap.get(next).isOccupied()){
                if (squareMap.get(next).getCurrentPiece()
                        .pieceColor.equals(this.pieceColor)){
                    break;
                } else if (squareMap.get(next).getCurrentPiece()
                        .pieceColor != this.pieceColor) {
                    if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(PieceColor.WHITE)){
                        whiteAttackedKing.add(squareMap.get(next).getCurrentPiece().getName() + squareMap.get(next).getLocation());
                    } else if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(PieceColor.BLACK)) {
                        blackAttackedKing.add(squareMap.get(next).getCurrentPiece().getName() + squareMap.get(next).getLocation());
                    }
                    moveCandidates.add(next);
                    break;
                }

            }
            moveCandidates.add(next);
            break;
        }
    }

    public List<String> getBlackKing() {
        return whiteAttackedKing;
    }
    public List<String> getWhiteKing() {
        return blackAttackedKing;
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = square.getLocation();
        getKingMoves(moveCandidates, squareMap, current, 1,1);
        getKingMoves(moveCandidates, squareMap, current, 1,0);
        getKingMoves(moveCandidates, squareMap, current, 1,-1);
        getKingMoves(moveCandidates, squareMap, current, 0,1);
        getKingMoves(moveCandidates, squareMap, current, 0,-1);
        getKingMoves(moveCandidates, squareMap, current, -1,1);
        getKingMoves(moveCandidates, squareMap, current, -1,0);
        getKingMoves(moveCandidates, squareMap, current, -1,-1);
        return moveCandidates;
    }

    @Override
    public void makeMove(Square square) {
        System.out.println(this.getName() + "-> makeMove()");
    }
}
