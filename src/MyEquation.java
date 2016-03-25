
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohamed Oun
 */
public class MyEquation {

    int m; //total number of equations
    int c; //current number of equations
    public MyMatrix systemofEquations;
    public float[] RHS;
    float[] result;

    MyEquation(int number) {
        m = number;
        systemofEquations = new MyMatrix(m, m);
        c=0;
        RHS=new float[m];
        result=new float[m];
    }
    public void insertNewEquation ()
    {
        
    if(c!=m-1)
    {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <m; i++) {
            
            if (i<m) {
                System.out.println("enter coefficient on V" + i + " in Equation " + c);
                float temp = sc.nextFloat();
                systemofEquations.setValue(c, i, temp);
            } else {
                System.out.println("enter right hand side of Equation "+c);
                RHS[c]=sc.nextFloat();
            }
        }
        c++;
        
    }
    else System.out.println("System is full");
    
    }

float [] solveSystem (){
    MyMatrix mat=new MyMatrix(m, m);
 float temp[][] = new float[m][m];
float x[] = new float[m];
  for(int i=0;i<m;i++)
  {
      for(int j=0;j<m;j++){
         for(int k=0;k<m;k++){
           if(k == i)
            temp[j][k] = this.RHS[j];
            else
             temp[j][k] = this.systemofEquations.getValue(j, k);      
           }}
      mat.setValues(temp);
       x[i]=this.systemofEquations.det(mat)/this.systemofEquations.det(this.systemofEquations);


    }
 
    System.out.println(x);
  return x;
}

}
