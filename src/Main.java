
import java.util.Scanner;

public class Main {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter m and n");
        int m = sc.nextInt();
        int n = sc.nextInt();
        MyMatrix thematrix = new MyMatrix(m, n);
        float[][] array = new float[m][n];
        System.out.println("enter the elements");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("write value of row " + (i + 1) + " column " + (j + 1));
                array[i][j] = sc.nextFloat();
            }
        }
        thematrix.setValues(array);
//       MyMatrix inv= thematrix.inverse();
//       inv.display();
//        System.out.println("---------------------------------------");
//        thematrix.multiply(inv).display();
        System.out.println("det= "+thematrix.det(thematrix));

    }
}
