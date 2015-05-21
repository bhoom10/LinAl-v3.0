package math;
import java.util.*;
public class siedel {

     /*Gauss Siedel method*/ 
    public double[] gaussSiedel(double a[][], double b[], double x[],int n,int m){
        double sum = 0;
        int i,j;
        for (int l = 0; l < n; l++)
        x[l] = 0;
        while(m>0)
        {
            for(i = 0; i <n ; i++)
            {
                sum = b[i];
                for(j = 0; j <n; j++)
                {
                    if( i != j )
                    {
                        sum = sum - (a[i][j] * x[j]);
                    }
                }
                x[i] = sum/a[i][i];
            }
            m--;
        }
         for(i = 0; i <n ; i++)
            {
                System.out.println(x[i]);
            }
    return x;
        
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
        
        siedel trial=new siedel();
        x=trial.gaussSiedel(a,b,x,n,m);
       
     //for(i=0;i<n;i++){
       //       System.out.println(x[i]);   
      //}
    }
}   
    

