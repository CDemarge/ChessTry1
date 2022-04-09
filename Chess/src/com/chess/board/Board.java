package com.chess.board;

import com.chess.common.File;
import com.chess.common.Location;
import com.chess.piece.AbstractPiece;
import com.chess.piece.PieceColor;
import com.chess.piece.PiecesOnBoard;
import com.chess.piece.Rook;
import com.chess.squares.Square;
import com.chess.squares.SquareColor;
import com.chess.runner.Calculations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private static final  Integer BOARD_LENGTH = 8;
    private final Map<Location, Square> locationSquareMap;
    public static Calculations calculations = new Calculations();

    Square[][] boardSquares = new Square[BOARD_LENGTH][BOARD_LENGTH];

    private final List<AbstractPiece> whitePieces = new ArrayList<>();
    private final List<AbstractPiece> blackPieces = new ArrayList<>();


    public Board(){
        locationSquareMap = new HashMap<>();
        Map<Location, AbstractPiece> pieces = PiecesOnBoard.getPieces();
        for(int i = 0; i < boardSquares.length; i++){
            int column = 0;
            SquareColor currentColor = (i % 2 == 0) ? SquareColor.LIGHT : SquareColor.DARK;
            for(File file : File.values()){
                Square newSquare = new Square(currentColor, new Location(file, BOARD_LENGTH-i));
                if (pieces.containsKey(newSquare.getLocation())){
                    AbstractPiece piece = pieces.get(newSquare.getLocation());
                    newSquare.setCurrentPiece(piece);
                    newSquare.setOccupied(true);
                    piece.setCurrentSquare(newSquare);
                    if (piece.getPieceColor().equals(PieceColor.WHITE)) {
                        whitePieces.add(piece);
                    } else {
                        blackPieces.add(piece);
                    }
                }
                locationSquareMap.put(newSquare.getLocation(), newSquare);
                boardSquares[i][column] = newSquare;
                currentColor = (currentColor == SquareColor.DARK) ? SquareColor.LIGHT :SquareColor.DARK;
                column++;
            }
        }
    }

    public Map<Location, Square> getLocationSquareMap(){
        return locationSquareMap;
    }

    public List<AbstractPiece> getWhitePieces() {
        return whitePieces;
    }

    public List<AbstractPiece> getBlackPieces() {
        return blackPieces;
    }

    public void printBoard(){
        double wob = 0;
        double bob = 0;
        for(int i = 0; i < boardSquares.length; i++){
            System.out.print(BOARD_LENGTH - i + "  ");
            for (int j = 0; j < boardSquares[i].length; j++){
                if (boardSquares[i][j].isOccupied()){
                    AbstractPiece piece = boardSquares[i][j].getCurrentPiece();
                    if(piece.getPieceColor().equals(PieceColor.WHITE)) {
                        if(piece.getName().equals("Rook")){
                            wob = wob + calculations.R;
                        } else if(piece.getName().equals("Queen")){
                            wob = wob + calculations.Q;
                        } else if(piece.getName().equals("King")){
                            wob = wob + calculations.K;
                        } else if(piece.getName().equals("AKnight")){
                            wob = wob + calculations.A;
                        } else if(piece.getName().equals("Bishop")){
                            wob = wob + calculations.B;
                        }  else if(piece.getName().equals("Pawn")){
                            wob = wob + calculations.P;
                        }
                        System.out.print("W" + piece.getName().charAt(0) + "  ");
                    } else {
                        if(piece.getName().equals("Rook")){
                            bob = bob + calculations.R;
                        } else if(piece.getName().equals("Queen")){
                            bob = bob + calculations.Q;
                        } else if(piece.getName().equals("King")){
                            bob = bob + calculations.K;
                        } else if(piece.getName().equals("AKnight")){
                            bob = bob + calculations.A;
                        } else if(piece.getName().equals("Bishop")){
                            bob = bob + calculations.B;
                        }  else if(piece.getName().equals("Pawn")){
                            bob = bob + calculations.P;
                        }
                        System.out.print("B" + piece.getName().charAt(0) + "  ");
                    }
                } else {
                    //Empty Square
                    System.out.print("--  ");
                }

            }
            System.out.println();

        }
        System.out.print("   ");
        for(File file : File.values()){
            System.out.print(file.name() + "   ");

        }
        // penalties = calculations.Calculations();
        // double mb = penalties[0];
        // double mw = penalties[1];
        calculations.Calculations();

        double wtotal = wob - calculations.penalties[1];
        double btotal = bob - calculations.mb;
        //System.out.print(calculations.mb);
        //System.out.print(calculations.mw);
        System.out.println();
        System.out.print("White Piece Point: " + wtotal);
        System.out.print("   ");
        System.out.print("Black Piece Point: " + btotal);

    }

}
