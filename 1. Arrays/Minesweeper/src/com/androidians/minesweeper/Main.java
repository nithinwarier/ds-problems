package com.androidians.minesweeper;

public class Main {

    public static void main(String[] args) {
        boolean[][] matrix = new boolean[][]{
                {true,false,false,false},
                {false,true,false,true},
                {false,false,false,false},
                {false,false,true,false},
        };
        int[][] result = minesweeper(matrix);
        for(int i=0;i<result.length;i++) {
            for(int j=0;j<result[0].length;j++) {
                System.out.print(result[i][j]+"    ");
            }
            System.out.println();
        }
    }

    static int[][] minesweeper(boolean[][] matrix) {
        int[][] res = new int[matrix.length][];
        for(int i=0; i<matrix.length; i++)
            res[i] = new int [matrix[i].length];

        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[0].length; j++)
                for(int k=i-1; k<i+2; k++)
                    for(int l=j-1; l<j+2; l++)
                        if(k>=0 && k<matrix.length && l>=0 && l<matrix[i].length &&
                                !(k==i && j==l) && matrix[k][l])
                            res[i][j]++;


        return res;
    }
}
