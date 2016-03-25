
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static MyMatrix setMatrix() {
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
        System.out.println("this is the matrix:");
        thematrix.display();
        return thematrix;
    }

    public static void matrixOps() {

        char input = 'w';
        while (input != 'e') {
            System.out.println("To Transpose a matrix enter 1");
            System.out.println("To multiply a matrix by a number enter 2");
            System.out.println("To sum a matrix with another enter 3");
            System.out.println("To multiply a matrix by another enter 4");
            System.out.println("to find if a matrix is symmetric press 5");
            System.out.println("to find if two matrices are equal press 6");
            System.out.println("to get the zeroMatrix of certain size press 7");
            System.out.println("to get an identity matrix press 8");
            System.out.println("to find the inverse of a matrix press 9");
            System.out.println("to exit press e");
            input = sc.next(".").charAt(0);
            switch (input) {
                case '1':
                    MyMatrix m = setMatrix();
                    System.out.println("Transposed matrix:");
                    m.transpose().display();
                    break;
                case '2':
                    MyMatrix m1 = setMatrix();
                    System.out.println("please enter a number to multiply by");
                    int n = sc.nextInt();
                    System.out.println("multiplied matrix:");
                    m1.scalarMultiply(n).display();
                    break;
                case '3':
                    System.out.println("first matrix");
                    MyMatrix m2 = setMatrix();
                    System.out.println("second matrix");
                    MyMatrix m3 = setMatrix();
                    System.out.println("sum of them");
                    m2.sum(m3).display();
                    break;
                case '4':
                    System.out.println("first matrix");
                    MyMatrix m4 = setMatrix();
                    System.out.println("second matrix");
                    MyMatrix m5 = setMatrix();
                    System.out.println("multiplication of them");
                    m4.multiply(m5).display();
                    break;
                case '5':
                    MyMatrix m6 = setMatrix();
                    System.out.println(m6.isSymmetric());
                    break;
                case '6':
                    System.out.println("first matrix");
                    MyMatrix m7 = setMatrix();
                    System.out.println("second matrix");
                    MyMatrix m8 = setMatrix();
                    System.out.println(m7.equals(m8));
                    break;
                case '7':
                    System.out.println("enter size");
                    int s1 = sc.nextInt();
                    int s2 = sc.nextInt();
                    MyMatrix.zeroMatrix(s1, s2).display();
                    break;
                case '8':
                    System.out.println("enter size");
                    int s = sc.nextInt();
                    MyMatrix.identityMatrix(s).display();
                    break;
                case '9':
                    MyMatrix m9 = setMatrix();
                    System.out.println("inversed matrix:");
                    m9.inverse().display();
                    break;
                case 'e':
                    break;
                default:
                    break;

            }

        }

    }

    public static void EquationOps() {
        char input = 'w';
        System.out.println("please enter number of equations");
        int m = sc.nextInt();
        MyEquation x = new MyEquation(m);
        for (int i = 0; i < m; i++) {
            x.insertNewEquation();
        }
        System.out.println("system now:");
        x.getSystemofEquations().display();
        System.out.println("RHS: ");
        x.displayRHS();
        while (input != 'e') {
            System.out.println("to swap equations enter 1 \n to solve the system enter 2 \n to exit enter e");
            input = sc.next(".").charAt(0);
            switch (input) {
                case '1':
                    System.out.println("enter the the order of the 2 equations");
                    int e1 = sc.nextInt();
                    int e2 = sc.nextInt();
                    x.swapEquations(e1, e2);
                    System.out.println("system now:");
                    x.getSystemofEquations().display();
                    System.out.println("RHS: ");
                    x.displayRHS();
                    break;
                case '2':
                    x.solveSystem();
                    System.out.println("Solution is:");
                    System.out.println(Arrays.toString(x.getResult()));
                    input = 'e';
                    break;
                default:
                    break;

            }
        }
    }

    public static void main(String[] args) {
        char input = 'w';
        while (input != 'e') {
            System.out.println("For Matrix press 1, For Equations press 2, to exit press e");
            input = sc.next(".").charAt(0);
            switch (input) {
                case '1':
                    matrixOps();
                    break;
                case '2':
                    EquationOps();
                    break;
                case 'e':
                    break;
                default:
                    break;

            }
        }

//       MyMatrix inv= thematrix.inverse();
//       inv.display();
//        System.out.println("---------------------------------------");
//        thematrix.multiply(inv).display();
//        System.out.println("please enter m");
//        int m = sc.nextInt();
//        MyEquation x = new MyEquation(m);
//        for (int i = 0; i < m; i++) {
//            x.insertNewEquation();
//        }
//        System.out.println("now enter RHS");
//        for (int i = 0; i < m; i++) {
//            x.RHS[i]=sc.nextFloat();
//        }
//        x.solveSystem();
//        System.out.println("Solution is:");
//        System.out.println(Arrays.toString(x.getResult()));
    }
}
