package interview.questions.array.medium;

import interview.questions.ArrayUtils;

public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int [][] resultMatrix = new int[n][n];
        int cnt = 1;
        for(int i = 0 ; i  < n ; i++){
            for (int j = i ; j < n-i ; j++){
                resultMatrix[i][j] = cnt++;
            }
            for (int k = i + 1 ; k < n-i ; k++){
                resultMatrix[k][n-i-1] = cnt++;
            }
            for(int l = n-i-2;l >= i;l--){
                resultMatrix[n-i-1][l] = cnt++;
            }
            for(int m = n-i-2;m > i;m--){
                resultMatrix[m][i] = cnt++;
            }
        }
        return resultMatrix;
    }

    public static void main(String [] args){
        SpiralMatrix obj = new SpiralMatrix();
        int [][] result = obj.generateMatrix(1);
        ArrayUtils.printMatrix(result,1);
    }
}
