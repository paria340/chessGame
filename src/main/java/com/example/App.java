package com.example;

import com.example.ChessBoard.Chess;

public class App {
    public static void initializeChessPieces() {
        ChessBoard chessBoard = new ChessBoard();
        Chess[][] standardBoard = chessBoard.initializeStandardBoard();
        chessBoard.printChessBoard(standardBoard);

        System.out.println();
        System.out.println("******************************************************");
        System.out.println("******************************************************");
        System.out.println();

        Chess[][] randomBoard = chessBoard.generateRandomBoard();
        chessBoard.printChessBoard(randomBoard);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Hello World!");
        System.out.println("Let's play some chess together");
        System.out.println();
        initializeChessPieces();
    }
}
