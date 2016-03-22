

/**
 * Created by Mohamed Oun on 19-Mar-16.
 */
public class MyMatrix {
    int m = 0, n = 0;
    double[][] matrix;
    double [][] modifiedMatrix;

    MyMatrix(int num1, int num2) {
        m = num1;
        n = num2;
        matrix = new double[m][n];
       
    }

    public double[][] transpose() {
         modifiedMatrix=new double[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                modifiedMatrix[i][j] =matrix[j][i];
            }
        }
        return modifiedMatrix;
    }
    double [][] scalarMultiply (int k){
         modifiedMatrix=new double[m][n];
          for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                modifiedMatrix[i][j] =k*matrix[i][j];
            }
        }
          return modifiedMatrix;
    }
    public void setMatrix(double[][] mat){
        matrix=mat;
        
    }
    public void display(){
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("}");
            System.out.print("\n");
        }
    }
        public void display(double[][] newmatrix){
        for (int i = 0; i < newmatrix.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < newmatrix[0].length; j++) {
                System.out.print(newmatrix[i][j] + " ");
            }
            System.out.print("}");
            System.out.print("\n");
        }
    }
}
