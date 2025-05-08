import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        };

        int[][] matrix2 = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        };

        // Resultant matrix will have the same number of rows as matrix1
        // and same number of columns as matrix2
        int[][] result = new int[3][3];

        // Matrix multiplication logic
        for (int i = 0; i < 3; i++) {            // rows from matrix1
            for (int j = 0; j < 3; j++) {        // columns from matrix2
                for (int k = 0; k < 3; k++) {    // columns from matrix1 / rows from matrix2
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        // Print the result
        System.out.println("Result of Matrix Multiplication:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}