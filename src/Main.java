
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter m and n");
        int m = sc.nextInt();
        int n = sc.nextInt();
        MyMatrix thematrix = new MyMatrix(m, n);
        double[][] array = new double[m][n];
        System.out.println("enter the elements");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextDouble();
            }
        }
        thematrix.setMatrix(array);
        double [][] scalar=thematrix.scalarMultiply(3);
        thematrix.display(scalar);
    }
}
