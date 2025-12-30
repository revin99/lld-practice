package tic_tac_toe.entity;

import tic_tac_toe.constants.PieceEnum;

public class Board {

    private int size;
    private PlayingPiece board[][];

    public Board(int size)
    {
        this.size=size;
        board = new PlayingPiece[size][size];
    }

    public void printBoard(){

        for(int i=0;i<this.size;i++)
        {
            for(int j=0;j<this.size;j++)
            {
                if(board[i][j]==null)
                    System.out.print(board[i][j]+ " ");
                else
                    System.out.print(board[i][j].getpieceEnum() + " ");
            }
            System.out.println("");
        }

    }

    public void setPiece(Integer x, Integer y, PlayingPiece playingPiece)
    {
        board[x][y]=playingPiece;
        printBoard();
    }
    public Boolean checkHelper(PlayingPiece piece)
    {
        Boolean ans = true;
        for(int i=0;i<size;i++)
        {
            ans = true;
            for(int j=0;j<size;j++)
            {
                if(board[i][j]!=piece) ans = false;
            }
            if(ans) return ans;
        }

        for(int i=0;i<size;i++)
        {
            ans = true;
            for(int j=0;j<size;j++)
            {
                if(board[j][i]!=piece) ans = false;
            }
            if(ans) return ans;
        }
        ans = true;
        for(int i=0;i<size;i++)
        {
            if(board[i][i]!=piece) ans=false;
        }
        if(ans) return true;

        ans=true;
        for (int i=size-1,j=0;i>=0;i--,j++)
        {
            if(board[i][j]!=piece) ans=false;
        }
        if(ans) return true;

        return false;
    }
    public Boolean nullLeft(){
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++){
                if(board[i][j]==null) return true;
            }
        }
        return false;
    }
    public int checkWinner()
    {
        PlayingPiece xpiece = new PlayingPiece(PieceEnum.X);
        PlayingPiece ypiece = new PlayingPiece(PieceEnum.O);
        if(checkHelper(xpiece)) return 1;
        else if(checkHelper(ypiece)) return 2;

        if(!nullLeft()) return 3;

        return 0;
    }
}
