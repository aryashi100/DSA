class Solution {
    public void setZeroes(int[][] matrix) {

        // Number of rows
        int m = matrix.length;

        // Number of columns
        int n = matrix[0].length;

        // Tells us whether first column needs to be zero
        boolean col0 = false;

        // STEP 1: Find zeroes and create markers
        for (int i = 0; i < m; i++) {

            // Check first column
            if (matrix[i][0] == 0)
                col0 = true;

            // Start from column 1 because column 0 is used as a marker
            for (int j = 1; j < n; j++) {

                if (matrix[i][j] == 0) {

                    // Mark this row
                    matrix[i][0] = 0;

                    // Mark this column
                    matrix[0][j] = 0;
                }
            }
        }

        // STEP 2: Use the markers to set cells to zero
        // Go backwards to protect the markers
        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 1; j--) {

                // If row OR column is marked
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            // STEP 3: Handle first column
            if (col0)
                matrix[i][0] = 0;
        }
    }
}