package interview.questions.array.medium;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int [][] sumMatrix =  new int[m][n];
        sumMatrix[0][0] = grid[0][0];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if(i > 0 && j > 0){
                    sumMatrix[i][j] = grid[i][j] + Math.min(sumMatrix[i][j-1],sumMatrix[i-1][j]);
                }else if(i > 0){
                    sumMatrix[i][j] = grid[i][j] +  sumMatrix[i-1][j];
                }else if(j > 0){
                    sumMatrix[i][j] = grid[i][j] + sumMatrix[i][j-1];
                }
            }
        }
        return sumMatrix[m-1][n-1];
    }

    public static void main(String [] args){
        MinimumPathSum obj = new MinimumPathSum();
//        int [][] matrix = new int[][]{{1,3,1,},{1,5,1},{4,2,1}};
        int [][] matrix = new int[][]{{1,2,3,},{4,5,6}};
        int minimumSumPath = obj.minPathSum(matrix);
        System.out.println("Minimum Sum = "+minimumSumPath);
    }

}
