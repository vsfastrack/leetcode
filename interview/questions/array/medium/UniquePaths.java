package interview.questions.array.medium;

import java.util.Arrays;

public class UniquePaths {
    int m , n;
    int [][] visited  = new int[101][101];
    public int moveInGrid(int[][] grid , int i , int j){
        if((i == m || j == n) || grid[i][j] == 1)
            return 0;
        if(visited[i][j] != -1)
            return visited[i][j];
        if(i == m- 1 && j == n-1)
            return 1;
        int right = moveInGrid(grid,i,j+1);
        int down =  moveInGrid(grid,i+1,j);
        visited[i][j] = right + down;
        return right + down;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        for(int i = 0 ; i < m ; i++){
            Arrays.fill(visited[i],-1);
        }
        return moveInGrid(obstacleGrid,0,0);
    }

    public static void main(String [] args){
        UniquePaths obj = new UniquePaths();
        int [][] matrix = new int[][]{{0,0,0,},{0,1,0},{0,0,0}};
        int uniquePathsCount = obj.uniquePathsWithObstacles(matrix);
        System.out.println("Unique Paths count"+uniquePathsCount);
    }

}
