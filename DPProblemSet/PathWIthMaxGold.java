package DSA;

public class PathWIthMaxGold {
        public static int getMaximumGold(int[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            int[] maxGold = {0};
            int gold = 0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[i].length;j++){
                    if(grid[i][j] != 0){
                        getMaxGold(grid,i,j,visited,maxGold,gold);
                    }
                }
            }
            return maxGold[0];
        }
        public static void getMaxGold(int[][] grid,int row,int col,boolean[][] visited,int[] maxGold,int gold){
            if(row < 0 || col < 0 || row > grid.length-1 || col > grid[row].length-1 || grid[row][col] == 0 || visited[row][col]){
                if(maxGold[0] < gold){
                    maxGold[0] = gold;
                }
                return;
            }

            gold += grid[row][col];
            visited[row][col] = true;
            getMaxGold(grid,row+1,col,visited,maxGold,gold);
            getMaxGold(grid,row,col+1,visited,maxGold,gold);
            getMaxGold(grid,row,col-1,visited,maxGold,gold);
            getMaxGold(grid,row-1,col,visited,maxGold,gold);
            visited[row][col] = false;
        }

    public static void main(String[] args) {
        int[][] grid = {{1,0,7,0,0,0},{2,0,6,0,1,0},{3,5,6,7,4,2},{4,3,1,0,2,0},{3,0,5,0,20,0}};
        System.out.println(getMaximumGold(grid));
    }
}
