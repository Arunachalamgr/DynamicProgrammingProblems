package DSA;

public class MaxDiamond {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,-1,1,1}
                       ,{1,1,0,1,1,1},
                        {1,0,1,1,0,1},
                        {-1,0,-1,1,0,1}};
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int[] maxDiamond = {0};
        boolean[] flag = {false};

        topDown(grid,visit,maxDiamond,0,0,0,flag);
        visit[0][0] = false;
        bottomUp(grid,visit,maxDiamond,maxDiamond[0], grid.length-1, grid[0].length-1);

        System.out.println(maxDiamond[0]);
    }
    public static void topDown(int[][] grid,boolean[][] visit,int[] maxDiamond,int diamond,int row,int col,boolean[] flag){
        if(row < 0 || col < 0 || row > grid.length-1 || col > grid[0].length-1 || visit[row][col] || grid[row][col] == -1 || flag[0]){
            return;
        }
        visit[row][col] = true;
        diamond += grid[row][col];
        if(row == grid.length-1 && col== grid[0].length-1){
            if(diamond > maxDiamond[0]){
                maxDiamond[0] = diamond;
            }
            flag[0] = true;
            visit[row][col] = false;
            return;
        }
        topDown(grid,visit,maxDiamond,diamond,row+1,col,flag);
        topDown(grid,visit,maxDiamond,diamond,row,col+1,flag);
        visit[row][col] = false;


    }
    public static void bottomUp(int[][] grid,boolean[][] visit,int[] maxDiamond,int diamond,int row,int col){
        if(row < 0 || col < 0 || row > grid.length-1 || col > grid[0].length-1 || visit[row][col] || grid[row][col] == -1 ){
            return;
        }
        visit[row][col] = true;
        diamond += grid[row][col];
        if(row == 0 && col== 0){
            if(diamond > maxDiamond[0]){
                maxDiamond[0] = diamond;
            }
            visit[row][col] = false;
            return;
        }
        bottomUp(grid,visit,maxDiamond,diamond,row-1,col);
        bottomUp(grid,visit,maxDiamond,diamond,row,col-1);
        visit[row][col] = false;


    }

}
