package com.chess.piece;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.LocationPositions;
import com.chess.squares.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Rook extends AbstractPiece implements Move{
    public Rook(PieceColor pieceColor) {
        super(pieceColor);
        this.name = "Rook";
    }

    public Rook() { }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        getFileCandidates(moveCandidates, squareMap, current, 1);
        getFileCandidates(moveCandidates, squareMap, current, -1);
        getRankCandidates(moveCandidates, squareMap, current, 1);
        getRankCandidates(moveCandidates, squareMap, current, -1);
        return moveCandidates;
    }

    private List<String> whiteAttackedRook;
    private List<String> blackAttackedRook;

    public void getRankCandidates(List<Location> moveCandidates,
            Map<Location,Square> squareMap, Location current, int offset) {
        Location next = LocationPositions.build(current, current.getFile().ordinal(), offset);
        while (squareMap.containsKey(next)){
            if (squareMap.get(next).isOccupied()){
                if (squareMap.get(next).getCurrentPiece()
                        .pieceColor.equals(this.pieceColor)){
                    break;
                } else if (squareMap.get(next).getCurrentPiece()
                        .pieceColor != this.pieceColor) {
                    if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(PieceColor.WHITE)) {
                        whiteAttackedRook.add(squareMap.get(next).getCurrentPiece().getName()+ squareMap.get(next).getLocation());
                    } else if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(PieceColor.BLACK)) {
                        blackAttackedRook.add(squareMap.get(next).getCurrentPiece().getName()+ squareMap.get(next).getLocation());
                    }
                    moveCandidates.add(next);
                    break;
                }
            }
            moveCandidates.add(next);
        }
    }



    public void getFileCandidates(List<Location> moveCandidates,
                                   Map<Location,Square> squareMap,
                                   Location current, int offset) {
        Location next = LocationPositions.build(current, offset, 0);
        whiteAttackedRook = new ArrayList<>();
        blackAttackedRook = new ArrayList<>();
        while (squareMap.containsKey(next)){
            if (squareMap.get(next).isOccupied()){
                if (squareMap.get(next).getCurrentPiece()
                        .pieceColor.equals(this.pieceColor)){
                    break;
                } else if (squareMap.get(next).getCurrentPiece()
                        .pieceColor != this.pieceColor) {
                    if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(PieceColor.WHITE)) {
                        whiteAttackedRook.add(squareMap.get(next).getCurrentPiece().getName()+ squareMap.get(next).getLocation());
                    } else if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(PieceColor.BLACK)) {
                        blackAttackedRook.add(squareMap.get(next).getCurrentPiece().getName()+ squareMap.get(next).getLocation());
                    }
                    moveCandidates.add(next);
                    break;
                }
            }
            moveCandidates.add(next);
        }
    }

    public List<String> getBlackRook() {
        return whiteAttackedRook;
    }
    public List<String> getWhiteRook() {
        return blackAttackedRook;
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = square.getLocation();
        getFileCandidates(moveCandidates, squareMap, current, -1);
        getFileCandidates(moveCandidates, squareMap, current, 1);
        getRankCandidates(moveCandidates, squareMap, current, -1);
        getRankCandidates(moveCandidates, squareMap, current, 1);
        return moveCandidates;
    }

    @Override
    public void makeMove(Square square) {
        Square current = this.getCurrentSquare();
        this.setCurrentSquare(square);
        current.reset();
    }
}
