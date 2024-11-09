class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1;

        for(int i=0; i < matrix.length; i++) { // traverse and mark zeroes
            for(int j = 0; j < matrix[0].length; j++) {
                int val = matrix[i][j];
                if(val == 0) {
                    if(j == 0) { // j is 0 means all the column will be 0 hence, in future set 0 to whole column
                        col0 = 0; // col0 means 0th row is empty.
                    }
                    else {
                        matrix[0][j] = 0;
                    }
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1; i < matrix.length; i++) { // setting 0 for 1 to n
            for(int j = 1; j < matrix[0].length; j++) {

                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
            }
        }

        if(matrix[0][0] == 0) { // row is calculated, this is 0 means any column in 0th row is 0
            for(int j = 1; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) { // The 0th row is zero, hence put everything col0 empty
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
