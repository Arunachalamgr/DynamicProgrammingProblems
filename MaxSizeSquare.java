package DSA;

import java.util.Arrays;

public class MaxSizeSquare {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,0,1},
                          {1,1,0,1,0},
                          {0,1,1,1,0},
                          {1,1,1,1,0},
                          {1,1,1,1,1},
                          {0,0,0,0,0}};
        int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i=0;i<cache.length;i++){
            Arrays.fill(cache[i],-1);
        }
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=matrix[0].length-1;j>=0;j--){
                boolean[] flag = {false};
                int[] maxSquare = {Integer.MIN_VALUE};
                findMaxSquare(matrix,i,j,maxSquare,cache,flag);
                if(maxSquare[0] != 0 && matrix[i][j] != 0 && !flag[0]){
                    cache[i][j] = maxSquare[0] + 1;
                }else {
                    if(matrix[i][j] == 0)
                        cache[i][j] = 0;
                    else cache[i][j] = matrix[i][j];
                }
            }

        }
        int res = 0;
        for(int[] arr : cache){
            for(int num : arr){
                res = Math.max(res,num);
            }
        }
        System.out.println(res);
    }
    public static void findMaxSquare(int[][] matrix,int row,int col,int[] maxSquare,int[][] cache,boolean[] flag){
        if(row < 0 || col < 0 || row > matrix.length-1 || col > matrix[0].length-1 || maxSquare[0] == 0 || flag[0]){
            return;
        }
        if(matrix[row][col] == 0){
            flag[0] = true;
            return;
        }
        maxSquare[0] = Math.max(maxSquare[0],matrix[row][col]);
        findMaxSquare(matrix,row+1,col,maxSquare,cache,flag);
        findMaxSquare(matrix,row,col+1,maxSquare,cache,flag);
        findMaxSquare(matrix,row+1,col+1,maxSquare,cache,flag);

    }
}
