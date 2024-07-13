package DSA;

public class RateMaze {
    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0},{0,0,0,0},{0,0,1,1}};
        int startRow = 0;
        int startCol = 0;
        boolean[] flag = {false};
        getCheezeOrNot(maze,startRow,startCol,flag);

    }
    public static void getCheezeOrNot(int[][] maze,int startRow,int startCol,boolean[] flag){
        if(startRow > maze.length-1 || startCol > maze.length-1 || maze[startRow][startCol] == 0 || flag[0]){
            return;
        }
        if(startRow == maze.length-1 && startCol == maze.length-1){
            System.out.println("Target Obtained");
            flag[0] = true;
            return;
        }
        if(maze[startRow][startCol] == 1){
            getCheezeOrNot(maze,startRow+1,startCol,flag);
            getCheezeOrNot(maze,startRow,startCol+1,flag);
        }
    }
}
