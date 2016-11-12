import java.util.Scanner;

/**
 * Uses a Matrix ADT to perform different matrix operations and display them results to the console
 * @author Connor Haskins
 */
public class main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // The Matrix objects that will be used in operations
        double mat1[][] = {{1.0, 2.0, 3.0, 4.0, 5.0}, {2.0, 2.0, 2.0, 2.0, 2.0}, {3.0, 1.0, 1.0, 1.0, 3.0}, {0.0, 0.0, 2.0, 3.0, 2.0}, {4.0, 4.0, 4.0, 0.0, 0.0}};
        double mat2[][] = {{1.0, 0.0, 0.0, 0.0, 0.0}, {1.0, 2.0, 1.0, 2.0, 1.0}, {0.0, 0.0, 1.0, 0.0, 0.0}, {1.0, 1.0, 1.0, 1.0, 1.0}, {2.0, 2.0, 2.0, 2.0, 2.0}};
        Matrix matrix1 = new Matrix(mat1);
        Matrix matrix2 = new Matrix(mat2);
        // The result Matrix object
        Matrix matrix3;

        // inform user of their options
        printTwoMatrices(matrix1, matrix2);
        printCommands();

        char choice = scanner.next().charAt(0);

        // while the user enters a given command, continue the program
        while (choice > '0' && choice < '4') {
            switch (choice) {
                case '1':
                    matrix3 = matrix1.addMat(matrix2);

                    System.out.println("(1) M4 = M1 + M2");
                    printResults(matrix1, matrix2, matrix3);
                    break;
                case '2':
                    matrix3 = matrix1.subMat(matrix2);

                    System.out.println("(2) M4 = M1 - M2");
                    printResults(matrix1, matrix2, matrix3);
                    break;
                case '3':
                    matrix3 = matrix1.multMat(matrix2);

                    System.out.println("(3) M5 = M1 * M2");
                    printResults(matrix1, matrix2, matrix3);
                    break;
                default:
                    break;
            }
            printCommands();
            choice = scanner.next().charAt(0);
        }
    }

    /**
     * Print two matrices
     * @param m1
     * @param m2
     */
    private static void printTwoMatrices(Matrix m1, Matrix m2) {
        System.out.println("===============Matrix 1===============");
        Matrix.printMatrix(m1);
        System.out.println("===============Matrix 2===============");
        Matrix.printMatrix(m2);
        System.out.println();
    }

    /**
     * Display the user's options
     */
    private static void printCommands() {
        System.out.println("(1) M3 = M1 + M2");
        System.out.println("(2) M4 = M1 - M2");
        System.out.println("(3) M5 = M1 * M2");
        System.out.println("Enter the one of the following commands.");
        System.out.println("Or any other key to terminate.");
        System.out.println();
    }

    /**
     * print two matrices and their result matrix
     * @param m1
     * @param m2
     * @param m3
     */
    private static void printResults(Matrix m1, Matrix m2, Matrix m3) {
        printTwoMatrices(m1, m2);
        System.out.println("================Result================");
        Matrix.printMatrix(m3);
        System.out.println("\n");
    }
}
