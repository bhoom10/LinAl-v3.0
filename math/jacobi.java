
//Jacobi requires a few extra parameters that has to be taken from the users
//helps in solving a system of linear equations
package math;
import java.util.*;
public class jacobi {
    static void copy(double b[],double c[],int n)
    {
        int i=0;
        for(i=0;i<n;i++)
        {
            b[i]=c[i];
            
         }
    }
    public void jacobian(int m,int n, double a[][], double b[] , double y[], double x[]){
        int i,j;
        while(m>0){
            for(i=0;i<n;i++){
                     y[i]=(b[i]/a[i][i]);
             for(j=0;j<n;j++){
                 if(i==j) continue;
                 y[i]=y[i]-((a[i][j]/a[i][i])*x[j]);
             }
            }copy(x,y,n);
       
        m--;
        }
    }
    public static void main(String args[]){
        Scanner s= new Scanner(System.in);
        int m,n,i,j;
        
        System.out.println("Enter n");
        n=s.nextInt();
        double a[][]=new double[n][n];
        double b[]=new double[n];
        double y[]=new double[n];
        double x[]=new double[n];
        System.out.println("Enter Matrix");
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                a[i][j]=s.nextFloat();
            }
        }
        System.out.println("Enter constants");
        for(j=0;j<n;j++){
            b[j]=s.nextFloat();
        }
        System.out.println("Enter initial values");
        for(j=0;j<n;j++){
            x[j]=s.nextFloat();
        }
        System.out.println("Enter number of iteration");
        m=s.nextInt();
        
        jacobi trial=new jacobi();
        trial.jacobian(m,n,a,b,y,x);
       
      for(i=0;i<n;i++){
              System.out.println(x[i]);   
      }
    }
}   
    

