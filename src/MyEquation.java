
import java.util.Scanner;

/**
 *
 * @author Mohamed Oun
 */
public class MyEquation {

    private int m; //total number of equations
    int c; //current number of equations
    private MyMatrix systemofEquations;
    private float[] RHS;
    private final float[] result;

    MyEquation(int number) {
        m = number;
        systemofEquations = new MyMatrix(m, m);
        c = 0;
        RHS = new float[m];
        result = new float[m];
    }

    public void insertNewEquation() {

        if (c != getM()) {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i <= getM(); i++) {

                if (i < getM()) {
                    System.out.println("enter coefficient on V" + (i + 1) + " in Equation " + (c + 1));
                    float temp = sc.nextFloat();
                    getSystemofEquations().setValue(c, i, temp);
                } else {
                    System.out.println("enter right hand side of Equation " + (c + 1));
                    RHS[c] = sc.nextFloat();
                }
            }
            c++;

        } else {
            System.out.println("System is full");
        }

    }

    public void swapEquations(int i, int j) {
        float temp[] = this.getSystemofEquations().matrix[i - 1];
        systemofEquations.matrix[i - 1] = getSystemofEquations().matrix[j - 1];
        systemofEquations.matrix[j - 1] = temp;
         float temporary= RHS[i-1];
         RHS[i-1]=RHS[j-1];
         RHS[j-1]=temporary;
       
    }

    public void displayRHS() {
        System.out.println("{");
        for (int j = 0; j < RHS.length; j++) {
            System.out.println((float) Math.round(RHS[j] * 1000d) / 1000d);
        }
        System.out.println("}");

    }

    float[] solveSystem() {
        if (c == this.m) {
            MyMatrix mat = new MyMatrix(getM(), getM());
            float temp[][] = new float[getM()][getM()];
            for (int i = 0; i < getM(); i++) {
                for (int j = 0; j < getM(); j++) {
                    for (int k = 0; k < getM(); k++) {
                        if (k == i) {
                            temp[j][k] = this.getRHS()[j];
                        } else {
                            temp[j][k] = this.getSystemofEquations().getValue(j, k);
                        }
                    }
                }
                mat.setValues(temp);
                // if det equals zero, system has unique solution
                if (this.getSystemofEquations().det(this.getSystemofEquations()) != 0) {
                    result[i] = this.getSystemofEquations().det(mat) / this.getSystemofEquations().det(this.getSystemofEquations());
                } else {
                    System.out.println("System has no unique solution");
                    return getResult();
                }

            }

            return getResult();
        } else {
            System.out.println("Enter all equations first");
            return getResult();
        }
    }

    /**
     * @return the m
     */
    public int getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(int m) {
        this.m = m;
    }

    /**
     * @param systemofEquations the systemofEquations to set
     */
    public void setSystemofEquations(MyMatrix systemofEquations) {
        this.systemofEquations = systemofEquations;
    }

    /**
     * @return the RHS
     */
    public float[] getRHS() {
        return RHS;
    }

    /**
     * @param RHS the RHS to set
     */
    public void setRHS(float[] RHS) {
        this.RHS = RHS;
    }

    /**
     * @return the result
     */
    public float[] getResult() {
        return result;
    }

    /**
     * @return the systemofEquations
     */
    public MyMatrix getSystemofEquations() {
        return systemofEquations;
    }

}
