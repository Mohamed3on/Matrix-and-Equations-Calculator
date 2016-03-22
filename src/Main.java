
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // write your code here
//        Scanner sc = new Scanner(System.in);
//        System.out.println("please enter m and n");
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        MyMatrix thematrix = new MyMatrix(m, n);
//        float[][] array = new float[m][n];
//        System.out.println("enter the elements");
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                array[i][j] = sc.nextDouble();
//            }
//        }
//        thematrix.setValues(array);
//        MyMatrix thematrix2 = new MyMatrix(3, 2);
//        float[][] array2 =new float[3][2];
//        array2[0][0]=7;
//        array2[0][1]=8;
//        array2[1][0]=9;
//        array2[1][1]=10;
//        array2[2][0]=11;
//        array2[2][1]=12;
//        thematrix2.setValues(array2);
//        
//        thematrix.multiply(thematrix2).display();
          MyMatrix mat=MyMatrix.identityMatrix(5);
          mat.display();
    }
}
