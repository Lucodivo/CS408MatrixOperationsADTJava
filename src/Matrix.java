/**
 * Holds a two dimensional array and provides matrix operations between two matrices
 * @author Connor Haskins
 */
public class Matrix {

    private int num_rows;
    private int num_cols;
    private double[][] mat;

    /**
     * Constructor that uses the two dimensional array as matrix values
     * @param mat
     */
    public Matrix(double[][] mat) {
        this.num_rows = mat.length;
        this.num_cols = mat[0].length;
        this.mat = new double[this.num_rows][this.num_cols];
        for (int i = 0; i < this.num_rows; i++) {
            this.mat[i] = mat[i].clone();
        }
    }

    /**
     * Adds two matrices of the same size
     * @param matrix addend Matrix
     * @return summation Matrix
     */
    public Matrix addMat(Matrix matrix) {
        // Ensure that matrices are the same size
        if (isSameSize(matrix)) {
            double newMat[][] = new double[this.num_rows][this.num_cols];
            for (int i = 0; i < num_rows; i++) {
                for (int j = 0; j < num_cols; j++) {
                    newMat[i][j] = this.mat[i][j] + matrix.mat[i][j];
                }
            }
            return new Matrix(newMat);
        }
        return null;
    }

    /**
     * Subtract the parameter matrix from this instance's matrix
     * @param matrix subtrahend matrix
     * @return difference Matrix
     */
    public Matrix subMat(Matrix matrix) {
        // Ensure that matrices are the same size
        if (isSameSize(matrix)) {
            double newMat[][] = new double[this.num_rows][this.num_cols];
            for (int i = 0; i < num_rows; i++) {
                for (int j = 0; j < num_cols; j++) {
                    newMat[i][j] = this.mat[i][j] - matrix.mat[i][j];
                }
            }
            return new Matrix(newMat);
        }
        return null;
    }

    /**
     * Multiply two Matrix instances using matrix multiplication
     * (DOES NOT SIMPLY MULTIPLY CORRESPONDING INDEXES)
     * @param matrix multiplier Matrix
     * @return product Matrix
     */
    public Matrix multMat(Matrix matrix) {
        // Ensure that matrices are the same size
        if (hasSameInnerSize(matrix)) {
            double newMat[][] = new double[this.num_rows][this.num_cols];
            for (int i = 0; i < num_rows; i++) {
                for (int j = 0; j < num_cols; j++) {
                    newMat[i][j] = 0;
                    for (int k = 0; k < this.num_rows; k++) {
                        newMat[i][j] += this.mat[i][k] * matrix.mat[k][j];
                    }
                }
            }
            return new Matrix(newMat);
        }
        return null;
    }

    /**
     * Static function that prints the parameter Matrix object
     * @param m
     */
    public static void printMatrix(Matrix m) {
        for (int i = 0; i < m.num_cols; i++) {
            for (int j = 0; j < m.mat[i].length; j++) {
                System.out.format("%7.2f", m.mat[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Check if this matrix and the parameter matrix have the same dimensions
     * @param m
     * @return true if dimensions are the same
     */
    private boolean isSameSize(Matrix m) {
        return (m.num_rows == this.num_rows && m.num_cols == this.num_cols);
    }

    /**
     * Check if this matrix and the parameter matrix have the same inner dimensions
     * @param m
     * @return true if inner dimensions are the same
     */
    private boolean hasSameInnerSize(Matrix m) {
        return (this.num_cols == m.num_rows);
    }
}
