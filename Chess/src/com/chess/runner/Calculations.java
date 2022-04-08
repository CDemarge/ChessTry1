package com.chess.runner;

import com.chess.piece.*;

import javax.swing.text.html.HTMLDocument;
import java.io.Console;
import java.util.*;


public class Calculations {

    static double K = 100;
    static double Q = 9;
    static double R = 5;
    static double B = 3;
    static double A = 3;
    static double P = 1;


    public static Bishop bishop = new Bishop();
    public static Knight knight = new Knight();
    public static Rook rook = new Rook();
    public static Queen queen = new Queen();
    public static King king = new King();
    public static Pawn pawn = new Pawn();
    public double[] penalties = new double[] {0 , 0};
    public double mw;
    public double mb;




    public void Calculations() {

        List<String> whiteKing = king.getWhiteKing();
        List<String> whiteQueen = queen.getWhiteQueen();
        List<String> whiteRook = rook.getWhiteRook();
        List<String> whiteBishop = bishop.getWhiteBishop();
        List<String> whiteKnight = knight.getWhiteKnight();
        List<String> whitePawn = pawn.getWhitePawn();


        List<String> negativeBlack = new ArrayList<>(whiteBishop);
        //negativeBlack.addAll(whiteKing);
        if(whiteKing != null)
            negativeBlack.addAll(whiteKing);

        /* if(whiteKing == null)
            System.out.println("no such piece exists");
        else
            negativeBlack.addAll(whiteKing);

        */
        //negativeBlack.addAll(whiteQueen);
        if(whiteQueen != null) {
            System.out.println("no such piece exists");
            negativeBlack.addAll(whiteQueen);
        }
        // negativeBlack.addAll(whiteKnight);
        if(whiteKnight != null)
            negativeBlack.addAll(whiteKnight);
        // negativeBlack.addAll(whiteRook);
        if(whiteRook != null)
            negativeBlack.addAll(whiteRook);
        // negativeBlack.addAll(whitePawn);
        if(whitePawn != null)
            negativeBlack.addAll(whitePawn);

        Set<String> minusBlack = new HashSet<>(negativeBlack);

        // I need to use this because they could not think I might want to use
        // get method on a Set<string>. By using iterator I might be able to use
        // the get method for each part.

        Iterator<String> bminus = minusBlack.iterator();

        mb = 0;

        while (bminus.hasNext()) {
            String element = bminus.next();
            if (element.contains("Rook")) {
                mb = mb + R / 2;
            } else if (element.contains("AKnight")) {
                mb = mb + A / 2;
            } else if (element.contains("Queen")) {
                mb = mb + Q / 2;
            } else if (element.contains("King")) {
                mb = mb + K / 2;
            } else if (element.contains("Bishop")) {
                mb = mb + B / 2;
            } else if (element.contains("Pawn")) {
                mb = mb + P / 2;
            }
        }


        List<String> blackKing = king.getBlackKing();
        List<String> blackQueen = queen.getBlackQueen();
        List<String> blackRook = rook.getBlackRook();
        List<String> blackBishop = bishop.getBlackBishop();
        List<String> blackKnight = knight.getBlackKnight();
        List<String> blackPawn = pawn.getBlackPawn();

        List<String> negativeWhite = new ArrayList<>(blackBishop);
        //negativeWhite.addAll(blackKing);
        if(blackKing != null)
            negativeWhite.addAll(blackKing);
        //negativeWhite.addAll(blackQueen);
        if(blackQueen != null)
            negativeWhite.addAll(blackQueen);
        //negativeWhite.addAll(blackRook);
        if(blackRook != null)
            negativeWhite.addAll(blackRook);
        //negativeWhite.addAll(blackKnight);
        if(blackKnight != null)
            negativeWhite.addAll(blackKnight);
        //negativeWhite.addAll(blackPawn);
        if(blackPawn != null)
            negativeWhite.addAll(blackPawn);

        Set<String> minusWhite = new HashSet<>(negativeWhite);

        Iterator<String> wminus = minusWhite.iterator();

        mw = 0;

        while (wminus.hasNext()) {
            String element = wminus.next();
            if (element.contains("Rook")) {
                mw = mw + R / 2;
            } else if (element.contains("AKnight")) {
                mw = mw + A / 2;
            } else if (element.contains("Queen")) {
                mw = mw + Q / 2;
            } else if (element.contains("King")) {
                mw = mw + K / 2;
            } else if (element.contains("Bishop")) {
                mw = mw + B / 2;
            } else if (element.contains("Pawn")) {
                mw = mw + P / 2;
            }
        }
        if(mb==0 || mw==0) {
            System.out.println("calculation broken");
        }
        if (mb!= 0){
            System.out.println("wat");
        }
        if (mw!= 0){
            System.out.println("bat");
        }

        penalties[0] = mb;
        penalties[1] = mw;
        // return penalties;

    }



//    Make list for each take position.
//    Based on the taken piece.

//    Merge the lists for each chess pieces in another part. Can make this list based
//    on color of the piece.

//    public Calculations(){
//        List<Float> MinusWhites = new ArrayList<Float>();
//    }
//  EXAMPLE:
//--------------------------------------------------------------
//    List<String> newList = new ArrayList<String>(listOne);
//      newList.addAll(listTwo);
//      newList.addAll(listThree); 		//newList is the list name.
//...

//    listSize = newList.size();

//--------------------------------------------------------------

//    Take the unique pieces from the merged list.

//  EXAMPLE:
//--------------------------------------------------------------
//      List<String> gasList = // create list with duplicates...
//      Set<String> uniqueGas = new HashSet<String>(gasList);
//      System.out.println("Unique gas count: " + uniqueGas.size());
//--------------------------------------------------------------

//  Generate a negative summation:

//    double K = 100;
//    double Q = 9;
//    double B = 3;
//    double A = 3;
//    double P = 1;



//    double blackAttacked = 0 ;
//    int i = 0;

//while (i < listSize){
//        if (newList.get(i).getName().equals("Rook")){
//            blackAttacked = blackAttacked - R/2;
//        }
//        else if (newList.get(i).getName().equals("Bishop")){
//           blackAttacked = blackAttacked - B/2;
//        }
//        else if (newList.get(i).getName().equals("Knight")){
//            blackAttacked = blackAttacked - Kn/2;
//        }
//        else if (newList.get(i).getName().equals("Pawn")){
//            blackAttacked = blackAttacked - P/2;
//        }
//        else if (newList.get(i).getName().equals("Queen")){
//            blackAttacked = blackAttacked - Q/2;
//        }
//        else if (newList.get(i).getName().equals("King")){
//            blackAttacked = blackAttacked - Ki/2;
//        }
//        i++;
//    }
}
