package com.sdet;

import java.util.*;
public class Nqueen 
{
	public static void main(String[] args) {
		nQueens(4);
}
    public static ArrayList<ArrayList<Integer>> nQueens(int n)
    {
        // Write Your Code Here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
    }
        solve(0,ans,board,n);
            return ans;
    }
    
    public static void solve(int col,ArrayList<ArrayList<Integer>> ans, int[][] board, int n){
        if(col>=n){
            addSolution(ans,board,n);
        }
        
        //solve 1 case and rest recursion will take care
        //solving for 1st column
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col]=1;
                solve(col+1,ans,board,n);
                //backtrack
                board[row][col]=0;
            }
        }
    }
    
    public static void addSolution(ArrayList<ArrayList<Integer>> ans, int[][] board, int n){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp.add(board[i][j]);
            }
        }
        ans.add(temp);
    }
    
    public static Boolean isSafe(int row, int col, int[][] board, int n){
        int x=row;
        int y=col;
        
        //check for same row
        while(y>=0){
            if(board[x][y]==1)
                return false;
            y--;
        }
        x=row;
        y=col;
        //check diagonal -1
        while(x>=0 && y>=0){
            if(board[x][y]==1)
                return false;
            y--;
            x--;
        }
        x=row;
        y=col;
        //check diagonal -2
        while(x<n && y>=0){
            if(board[x][y]==1)
                return false;
            y--;
            x++;
        }
        return true;
    } 
        
} 

