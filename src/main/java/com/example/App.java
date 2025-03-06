package com.example;

public class App {
    public int EMAI_INDEX = 1;

    public static void initializeChessPieces() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.printChessBoard();
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        initializeChessPieces();
    }
}
