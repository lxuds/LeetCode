// time complexity: O(1) per query, O(mn) time pre-computation. 
   The pre-computation in the constructor takes O(nm) time. 
// Space complexity: O(mn). The algorithm uses O(mn) to store the cumulative region sum.
 
class NumMatrix {

    private int[][] preSum;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length ==0) return;
        
        preSum = new int[matrix.length + 1][matrix[0].length + 1]; 
        // array[m][n] m is row, n is column. Element default value is 0. 
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++){
                preSum[row + 1][col + 1] = preSum[row + 1][col] + preSum[row][col+1] + matrix[row][col] - preSum[row][col];              
            }
        }
        
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2+1][col1] - preSum[row1][col2+1] + preSum[row1][col1];
        //inclusive - exclusive 
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
