
import java.util.Arrays;

/**
 * Created by Mohamed Oun on 19-Mar-16.
 */
public class MyMatrix {

    int m = 0, n = 0;
    float[][] matrix;

    MyMatrix(int num1, int num2) {
        m = num1;
        n = num2;
        matrix = new float[m][n];

    }

    public MyMatrix transpose() {
        MyMatrix modifiedMatrix = new MyMatrix(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                modifiedMatrix.matrix[i][j] = this.matrix[j][i];
            }
        }
        return modifiedMatrix;
    }

    MyMatrix scalarMultiply(float k) {
        MyMatrix modifiedMatrix = new MyMatrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                modifiedMatrix.matrix[i][j] = k * matrix[i][j];
            }
        }
        return modifiedMatrix;
    }

    boolean validForSum(MyMatrix mat) {
        return (this.m == mat.m && this.n == mat.n);
    }

    MyMatrix sum(MyMatrix mat) {
        if (validForSum(mat)) {
            MyMatrix modifiedMatrix = new MyMatrix(m, n);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
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
        return this.n == mat.m;
    }

    public void setValues(float[][] x) {
        matrix = x;

    }

    MyMatrix multiply(MyMatrix mat) {
        if (this.validForMultiplication(mat)) {
            MyMatrix modifiedMatrix = new MyMatrix(this.m, mat.n);
            for (int i = 0; i < this.m; i++) {
                for (int j = 0; j < mat.n; j++) {
                    for (int k = 0; k < this.n; k++) {
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
        if (mat.n != mat.m) {
            System.out.println("MyMatrix is not square");
            return 0;
        }

        if (mat.matrix.length == 1) {
            return mat.getValue(0, 0);
        }
        if (mat.matrix.length == 2) {
            return (mat.getValue(0, 0) * mat.getValue(1, 1)) - (mat.getValue(0, 1) * mat.getValue(1, 0));
        }
        float sum = 0;
        for (int i = 0; i < mat.n; i++) {
            sum += getSign(i) * mat.getValue(0, i) * det(SubMatrix(mat, 0, i));
        }
        return sum;
    }

    public MyMatrix SubMatrix(MyMatrix OriginalMatrix, int row, int col) {
        MyMatrix mat = new MyMatrix(OriginalMatrix.m - 1, OriginalMatrix.n - 1);
        int r = -1;
        for (int i = 0; i < OriginalMatrix.m; i++) {
            if (i == row) {
                continue;
            }
            r++;
            int c = -1;
            for (int j = 0; j < OriginalMatrix.n; j++) {
                if (j == col) {
                    continue;
                }
                mat.setValue(r, ++c, OriginalMatrix.getValue(i, j));
            }
        }
        return mat;
    }

    public MyMatrix cofactor(MyMatrix OriginalMatrix) {
        MyMatrix mat = new MyMatrix(OriginalMatrix.m, OriginalMatrix.n);
        for (int i = 0; i < OriginalMatrix.m; i++) {
            for (int j = 0; j < OriginalMatrix.n; j++) {
                mat.setValue(i, j, getSign(i) * getSign(j) * det(SubMatrix(OriginalMatrix, i, j)));
            }
        }

        return mat;
    }

    public MyMatrix inverse() {
        
        if (det(this)!=0) return (cofactor(this).transpose().scalarMultiply(1/det(this)));
        else {
            System.out.println("Matrix couldn't be inverted");
            return zeroMatrix(m, n);
        }
      
    }

    public void display() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("}");
            System.out.print("\n");
        }
    }

}
