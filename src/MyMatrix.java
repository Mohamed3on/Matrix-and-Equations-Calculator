
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

    MyMatrix scalarMultiply(int k) {
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
