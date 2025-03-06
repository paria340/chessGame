package com.example;

import java.util.Scanner;

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

        // Chess[][] randomBoard = chessBoard.generateRandomBoard();
        // chessBoard.printChessBoard(randomBoard);
        movePiece(standardBoard, chessBoard);
    }

    public static void movePiece(Chess[][] board, ChessBoard chessBoard) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the position of the piece you want to move (e.g., e2): ");
            String currentPos = scanner.nextLine().toLowerCase();

            System.out.println("Enter the destination position (e.g., e4): ");
            String newPos = scanner.nextLine().toLowerCase();

            // Convert the positions from algebraic notation to array indices
            int[] currentPosition = convertPositionToIndices(currentPos);
            int[] newPosition = convertPositionToIndices(newPos);

            if (currentPosition == null || newPosition == null || board[currentPosition[0]][currentPosition[1]] == null) {
                System.out.println("Invalid position or no piece found at that position.");
                return;
            }

            // Get the piece that will be moved
            Chess piece = board[currentPosition[0]][currentPosition[1]];

            // Move the piece to the new position
            board[newPosition[0]][newPosition[1]] = piece;
            board[currentPosition[0]][currentPosition[1]] = null;

            System.out.println("Moved " + piece.getColor() + " " + piece.getPeices() + " from " + currentPos + " to " + newPos);
        }

        chessBoard.printChessBoard(board);
    }

    // Method to convert the position from chess notation (e.g., "e2") to array indices
    public static int[] convertPositionToIndices(String position) {
        if (position.length() != 2) {
            return null;
        }

        char col = position.charAt(0);
        char row = position.charAt(1);

        int colIndex = col - 'a';
        int rowIndex = 8 - (row - '0');
        if (colIndex < 0 || colIndex > 7 || rowIndex < 0 || rowIndex > 7) {
            return null;
        }
        return new int[]{rowIndex, colIndex};
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Hello World!");
        System.out.println("Let's play some chess together");
        System.out.println();
        initializeChessPieces();
    }
}
