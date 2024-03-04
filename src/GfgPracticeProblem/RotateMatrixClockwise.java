package GfgPracticeProblem;

class RotateMatrixClockwise {

    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Original Matrix:");
        for (int[] row : mat) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        rotateMatrix(3,3,mat);

        System.out.println("Rotated Matrix:");
        for (int[] row : mat) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
     static  int[][] rotateMatrix(int M, int N, int Mat[][]) {
            int row = 0, col = 0;
            int prev, curr;
            int a = M, b = N;

        /*
        row - Staring row index
        M - ending row index
        col - starting column index
        N - ending column index
        i - iterator
        */
            while (row < M && col < N) {

                if (row + 1 == M || col + 1 == N)
                    break;

                // Store the first element of next row, this
                // element will replace first element of current
                // row
                prev = Mat[row + 1][col];

                /* Move elements of first row from the remaining rows */
                for (int i = col; i < N; i++) {
                    curr = Mat[row][i];
                    Mat[row][i] = prev;
                    prev = curr;
                }
                row++;

                /* Move elements of last column from the remaining columns */
                for (int i = row; i < M; i++) {
                    curr = Mat[i][N - 1];
                    Mat[i][N - 1] = prev;
                    prev = curr;
                }
                N--;

                /* Move elements of last row from the remaining rows */
                if (row < M) {
                    for (int i = N - 1; i >= col; i--) {
                        curr = Mat[M - 1][i];
                        Mat[M - 1][i] = prev;
                        prev = curr;
                    }
                }
                M--;

                /* Move elements of first column from the remaining rows */
                if (col < N) {
                    for (int i = M - 1; i >= row; i--) {
                        curr = Mat[i][col];
                        Mat[i][col] = prev;
                        prev = curr;
                    }
                }
                col++;
            }
            // Print rotated matrix
            return Mat;
        }
}
