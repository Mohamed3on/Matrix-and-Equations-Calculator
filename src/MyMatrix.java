
import java.util.Arrays;

/**
 * Created by Mohamed Oun on 19-Mar-16.
 */
public class MyMatrix {

    private int rows = 0;
    private int cols = 0;
    float[][] matrix;

    MyMatrix(int num1, int num2) {
        rows = num1;
        cols = num2;
        matrix = new float[rows][cols];

    }

    public MyMatrix transpose() {
        MyMatrix modifiedMatrix = new MyMatrix(getCols(), getRows());
        for (int i = 0; i < getCols(); i++) {
            for (int j = 0; j < getRows(); j++) {
                modifiedMatrix.matrix[i][j] = this.matrix[j][i];
            }
        }
        return modifiedMatrix;
    }

    MyMatrix scalarMultiply(float k) {
        MyMatrix modifiedMatrix = new MyMatrix(getRows(), getCols());
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                modifiedMatrix.matrix[i][j] = k * matrix[i][j];
            }
        }
        return modifiedMatrix;
    }

    boolean validForSum(MyMatrix mat) {
        return (this.rows == mat.getRows() && this.cols == mat.getCols());
    }

    MyMatrix sum(MyMatrix mat) {
        if (validForSum(mat)) {
            MyMatrix modifiedMatrix = new MyMatrix(getRows(), getCols());
            for (int i = 0; i < getRows(); i++) {
                for (int j = 0; j < getCols(); j++) {
                    modifiedMatrix.matrix[i][j] = this.matrix[i][j] + mat.matrix[i][j];
                }
            }
            return modifiedMatrix;
        } else {
            System.out.println("the matrices were not of equal size, summation failed");
            return this;
        }
    }

    boolean equals(MyMatrix mat) {
        return Arrays.deepEquals(this.matrix, mat.matrix);
    }

    static MyMatrix identityMatrix(int x) {
        MyMatrix mat = new MyMatrix(x, x);
        for (int i = 0; i < x; i++) {
            mat.matrix[i][i] = 1;
        }
        return mat;
    }

    boolean isSymmetric() {
        return Arrays.deepEquals(this.matrix, this.transpose().matrix);
    }

    boolean validForMultiplication(MyMatrix mat) {
        return this.cols == mat.getRows();
    }

    public void setValues(float[][] x) {
        matrix = x;

    }

    MyMatrix multiply(MyMatrix mat) {
        if (this.validForMultiplication(mat)) {
            MyMatrix modifiedMatrix = new MyMatrix(this.rows, mat.getCols());
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < mat.getCols(); j++) {
                    for (int k = 0; k < this.cols; k++) {
                        modifiedMatrix.matrix[i][j] += this.matrix[i][k] * mat.matrix[k][j];
                    }
                }
            }
            return modifiedMatrix;
        } else {
            return this;
        }
    }

    static MyMatrix zeroMatrix(int x, int y) {

        MyMatrix mat = new MyMatrix(x, y); //new arrays of float are automatically initialized with zeroes, so no need for looping again.
        return mat;
    }

    public void setValue(int row, int col, float x) {
        this.matrix[row][col] = x;
    }

    public float getValue(int row, int col) {
        return this.matrix[row][col];
    }

    public int getSign(int x) {
        //get correct sign to use with value (input is row or column index)
        if (x%2==0) {
            return 1;
        } else {
            return -1;
        }
    }

    public float det(MyMatrix mat) {
        if (mat.getCols() != mat.getRows()) {
            System.out.println("Matrix is not square");
            return 0;
        }

        if (mat.matrix.length == 1) {
            return mat.getValue(0, 0);
        }
        if (mat.matrix.length == 2) {
            return (mat.getValue(0, 0) * mat.getValue(1, 1)) - (mat.getValue(0, 1) * mat.getValue(1, 0));
        }
        float sum = 0;
        for (int i = 0; i < mat.getCols(); i++) {
            sum += getSign(i) * mat.getValue(0, i) * det(SubMatrix(mat, 0, i));
        }
        return sum;
    }

    public MyMatrix SubMatrix(MyMatrix OriginalMatrix, int row, int col) {
        MyMatrix mat = new MyMatrix(OriginalMatrix.getRows() - 1, OriginalMatrix.getCols() - 1);
        int r = -1;
        for (int i = 0; i < OriginalMatrix.getRows(); i++) {
            if (i == row) {
                continue;
            }
            r++;
            int c = -1;
            for (int j = 0; j < OriginalMatrix.getCols(); j++) {
                if (j == col) {
                    continue;
                }
                mat.setValue(r, ++c, OriginalMatrix.getValue(i, j));
            }
        }
        return mat;
    }

    public MyMatrix cofactor(MyMatrix OriginalMatrix) {
        MyMatrix mat = new MyMatrix(OriginalMatrix.getRows(), OriginalMatrix.getCols());
        for (int i = 0; i < OriginalMatrix.getRows(); i++) {
            for (int j = 0; j < OriginalMatrix.getCols(); j++) {
                mat.setValue(i, j, getSign(i) * getSign(j) * det(SubMatrix(OriginalMatrix, i, j)));
            }
        }

        return mat;
    }

    public MyMatrix inverse() {
        
        if (det(this)!=0) return (cofactor(this).transpose().scalarMultiply(1/det(this)));
        else {
            System.out.println("Matrix couldn't be inverted");
            return zeroMatrix(getRows(), getCols());
        }
      
    }

    public void display() {
        for (float[] matrix1 : matrix) {
            System.out.print("{ ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print((float)Math.round(matrix1[j] * 1000d) / 1000d + " ");
            }
            System.out.println("}");
           
        }
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * sets number of rows 
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the number of columns
     */
    public int getCols() {
        return cols;
    }

    /**
     * sets number of columns
     */
    public void setCols(int cols) {
        this.cols = cols;
    }

}
