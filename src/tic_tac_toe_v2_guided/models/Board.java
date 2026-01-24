package tic_tac_toe_v2_guided.models;

import tic_tac_toe_v2_guided.enums.Symbol;
import tic_tac_toe_v2_guided.exceptions.InvalidMoveException;

public class Board {

    private int size;
    private Cell [][] board;
    private int numMoves;

    public Board(int size) {
        this.size = size;
        board = new Cell[size][size];
        numMoves=0;
        initialiseBoard();
    }
    void initialiseBoard(){

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j] = new Cell(Symbol.EMPTY);
            }
        }
    }

    public boolean placeSymbol(Symbol symbol, int row, int col)
    {
        if(row<0 || row>=size || col<0 || col>=size)
            throw  new InvalidMoveException("Invalid move played");

        if (board[row][col].getSymbol()!=Symbol.EMPTY) {
            throw new InvalidMoveException("Symbol already placed at this box");
        }
        board[row][col].setSymbol(symbol);
        numMoves++;
        return true;
    }

    public Cell getCell(int row, int col)
    {
        if(row<0 || row>=size || col<0 || col>=size)
            throw  new InvalidMoveException("Invalid move played");
        return board[row][col];
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j].getSymbol() + "  ");
            }
            System.out.println();
        }
    }

    public boolean movesLeft(){
        return numMoves < size * size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public int getNumMoves() {
        return numMoves;
    }

    public void setNumMoves(int numMoves) {
        this.numMoves = numMoves;
    }
}
