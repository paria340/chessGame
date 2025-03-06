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

    public Chess[][] initializeStandardBoard() {
        Chess[][] board = new Chess[8][8];
    
        // Initialize White pieces
        board[0][0] = new Chess(Color.WHITE, Peices.ROOK);
        board[0][1] = new Chess(Color.WHITE, Peices.KNIGHT);
        board[0][2] = new Chess(Color.WHITE, Peices.BISHOP);
        board[0][3] = new Chess(Color.WHITE, Peices.QUEEN);
        board[0][4] = new Chess(Color.WHITE, Peices.KING);
        board[0][5] = new Chess(Color.WHITE, Peices.BISHOP);
        board[0][6] = new Chess(Color.WHITE, Peices.KNIGHT);
        board[0][7] = new Chess(Color.WHITE, Peices.ROOK);
    
        for (int col = 0; col < 8; col++) {
            board[1][col] = new Chess(Color.WHITE, Peices.PAWN);
        }
    
        // Initialize Black pieces
        board[7][0] = new Chess(Color.BLACK, Peices.ROOK);
        board[7][1] = new Chess(Color.BLACK, Peices.KNIGHT);
        board[7][2] = new Chess(Color.BLACK, Peices.BISHOP);
        board[7][3] = new Chess(Color.BLACK, Peices.QUEEN);
        board[7][4] = new Chess(Color.BLACK, Peices.KING);
        board[7][5] = new Chess(Color.BLACK, Peices.BISHOP);
        board[7][6] = new Chess(Color.BLACK, Peices.KNIGHT);
        board[7][7] = new Chess(Color.BLACK, Peices.ROOK);
    
        for (int col = 0; col < 8; col++) {
            board[6][col] = new Chess(Color.BLACK, Peices.PAWN);
        }
    
        return board;
    }

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

    public Chess[][] generateRandomBoard() {
        Chess[][] board = new Chess[8][8];
        List<Chess> shuffledList = generatePieces();
        Collections.shuffle(shuffledList);
    
        // Create a list of all available positions on the board (from (0,0) to (7,7))
        List<int[]> positions = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                positions.add(new int[]{i, j});
            }
        }
    
        // Shuffle the list of positions to randomize where the pieces will go
        Collections.shuffle(positions);
        int index = 0;
        for (int[] position : positions) {
            int row = position[0];
            int col = position[1];
            if (index < shuffledList.size()) {
                board[row][col] = shuffledList.get(index++);
            }
        }
    
        return board;
    }

    public void printChessBoard(Chess[][] chessBoard) {
        System.out.println("    a   b   c   d   e   f   g   h");
        System.out.println("  +---+---+---+---+---+---+---+---+");
    
        for (int row = 0; row < chessBoard.length; row++) {
            System.out.print((8 - row) + " |");
            for (int col = 0; col < chessBoard[row].length; col++) {
                if (chessBoard[row][col] == null) {
                    System.out.print("   |");
                } else {
                    Chess piece = chessBoard[row][col];
                    String emoji;
                    if (piece.getColor() == Color.WHITE) {
                        switch (piece.getPeices()) {
                            case KING:
                                emoji = "♔";
                                break;
                            case QUEEN:
                                emoji = "♕";
                                break;
                            case ROOK:
                                emoji = "♖";
                                break;
                            case KNIGHT:
                                emoji = "♘";
                                break;
                            case BISHOP:
                                emoji = "♗";
                                break;
                            case PAWN:
                                emoji = "♙";
                                break;
                            default:
                                emoji = " ";
                        }
                    } else {
                        switch (piece.getPeices()) {
                            case KING:
                                emoji = "♚";
                                break;
                            case QUEEN:
                                emoji = "♛";
                                break;
                            case ROOK:
                                emoji = "♜";
                                break;
                            case KNIGHT:
                                emoji = "♞";
                                break;
                            case BISHOP:
                                emoji = "♝";
                                break;
                            case PAWN:
                                emoji = "♟";
                                break;
                            default:
                                emoji = " ";
                        }
                    }
    
                    System.out.printf(" %s |", emoji);
                }
            }
            System.out.println(" " + (8 - row));
            System.out.println("  +---+---+---+---+---+---+---+---+");
        }
        System.out.println("    a   b   c   d   e   f   g   h");
    }
}
