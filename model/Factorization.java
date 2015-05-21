/*LU decomposition*/

package model;

public class Factorization {
    private double[][] mat1;
    private double[][] mat2;
    
     public double[][] getMat1() {
        return mat1;
    }

    public void setMat1(double[][] mat1) {
        this.mat1 = mat1;
    }
    
   
    public double[][] getMat2() {
        return mat2;
    }
    
    public void setMat2(double[][] mat2) {
        this.mat2 = mat2;
    }


    public static void luDecom(double matrix[][],int n){
            
            Factorization f=new Factorization();
            
            int i,j,k;
            double u[][]=new double[n][n];
            double l[][]=new double[n][n];
            double b[][]=new double[n][n];
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    u[i][j]=matrix[i][j];
                }
            }
            
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    if(i==j) l[i][j]=1;
                    else l[i][j]=0;
                }
            }
            for(k=0;k<n-1;k++){
                for(j=k+1;j<n;j++){
                    l[j][k]=u[j][k]/u[k][k];
                     if (Double.isNaN(l[j][k])) {
                       l[j][k] = 0;
                        }
                    for(i=k;i<n;i++){
                        u[j][i]=u[j][i]- l[j][k]*u[k][i];
                      }
                }
            }
            
             System.out.println("Upper triangular");
             for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    System.out.println(u[i][j]);
                }}
                
                 System.out.println("Lower triangular");
             for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    System.out.println(l[i][j]);
                }}
                
               
        f.setMat1(l);
       f.setMat2(u);
            
    }    

}
