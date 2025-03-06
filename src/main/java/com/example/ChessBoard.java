package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChessBoard {
    public enum Color {
        WHITE, BLACK
    }
    public enum Peices { 
        ROOK, PAWN, KNIGHT, BISHOP, KING, QUEEN
    }

    public class Chess {
        private final Color color;
        private final Peices peices;
    
        public Chess(Color color, Peices peices) {
            this.color = color;
            this.peices = peices;
        } 

        public Color getColor() {
            return color;
        }

        public Peices getPeices() {
            return peices;
        }  
        
        @Override
        public String toString() {
            return color + " " + peices;
        }
    };

    public List<Chess> generatePieces() {
        List<Chess> allPeices = new ArrayList<>();
        for (Color c : Color.values()) { 
            allPeices.add(new Chess(c, Peices.KING));
            allPeices.add(new Chess(c, Peices.QUEEN));

            for (int i = 0; i < 2; i++) {
                allPeices.add(new Chess(c, Peices.ROOK));
                allPeices.add(new Chess(c, Peices.KNIGHT));
                allPeices.add(new Chess(c, Peices.BISHOP));
            }
            for (int i = 0; i < 8; i++) {
                allPeices.add(new Chess(c, Peices.PAWN));
            }
        }
        return allPeices;
    }

    public Chess[][] generateBoard() {
        Chess[][] board = new Chess[8][8];
        List<Chess> shuffledList = generatePieces();
        Collections.shuffle(shuffledList);

        int index = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (index < shuffledList.size()) {
                    board[row][col] = shuffledList.get(index++);
                }
            }
        }
        return board;
    }

    public void printChessBoard() {
        Chess[][] chessBoard = generateBoard();
    
        for (int row = 0; row < chessBoard.length; row++) {
            System.out.print((8 - row) + "  ");
            for (int col = 0; col < chessBoard[row].length; col++) {
                if (chessBoard[row][col] == null) {
                    System.out.print("EMPTY\t");
                } else {
                    System.out.print(chessBoard[row][col] + "\t");
                }
            }
            System.out.println();
        }
    }
}
