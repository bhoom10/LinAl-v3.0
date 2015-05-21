package model;

import viewController.ToolkitView;


//jacobi
//
public class LinearAlgebra {
    
    /* Simple Addition of two matrices */
    public static double[][] addMatrix(double mat1[][],double mat2[][], int m, int n){
        int i,j;
        double result[][]=new double[m][n];
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                result[i][j]=mat1[i][j]+mat2[i][j];
            }
        }
        return result;
    }
    /* Simple subtraction of two matrices */
    public static double[][] subtractMatrix(double mat1[][],double mat2[][], int m, int n){
        int i,j;
        double result[][]=new double[m][n];
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                result[i][j]=mat1[i][j]-mat2[i][j];
            }
        }
        return result;
    }
    
    /*Finding the determinant of a matrix*/
    public static double determinant(double mat[][], int norder){
        int d;
        double result = 0;
        if (norder == 1) {
            result = mat[0][0];
            return result;
        }
        if (norder == 2) {
            result = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
            return result;
        }
        for (int i = 0; i < norder; i++) {
            double temp[][] = new double[norder - 1][norder - 1];

        for (int j = 1; j < norder; j++) {
                for (int k = 0; k < norder; k++) {

                        if (k < i) {
                                temp[j - 1][k] = mat[j][k];
                        } else if (k > i) {
                                temp[j - 1][k - 1] = mat[j][k];
                        }
                }
            }
            result += mat[0][i] * Math.pow(-1, (int) i) * determinant(temp,(norder-1));
        }

        return result;
    
    }

    /*Returns a sign based on whether the number is odd or even
     *  -1 if odd, 0 if even
     * Used in cofactor*/
    public static int sign(int n){
        int m=n%2;
        if(m==0){
            return 1;
        }
        else 
            return -1;
    }
    
    /*Returns the cofactor matrix of a matrix
     * Used in inverse
     */
    public static double[][] cofactor(double[][] matrix,int norder){
        double mat[][] = new double[norder][norder];
        double temp[][] = new double[norder][norder];
        for (int i=0;i<norder;i++) {
            for (int j=0; j<norder;j++) {
                temp=createSubMatrix(matrix, i, j);
                int n=i+j;
                mat[i][j]= sign(i) *sign(j)* determinant(createSubMatrix(matrix, i, j),temp.length);
            }
        }
        return mat;
    } 
    
    /*Creates a matrix out of the values that are not a part of the row or column that a particular number belongs to
     * used in determinant*/
    public static double[][] createSubMatrix(double[][] matrix, int excluding_row, int excluding_col) {
        double[][] mat = new double[matrix.length-1][matrix[0].length-1];
        int r = -1;
            for (int i=0;i<matrix.length;i++) {
                if (i==excluding_row)
                    continue;
                r++;
                int c = -1;
            for (int j=0;j<matrix[0].length;j++) {
                if (j==excluding_col)
                    continue;
                mat[r][++c]= matrix[i][j];
            }
            }
        return mat;
    }
    
    /*Finds the inverse of a matrix*/
    
    public static double[][] inverse(double[][] matrix, int norder){
        double co[][]=new double[norder][norder];
        double tr[][]=new double[norder][norder];
        double mu[][]=new double[norder][norder];
        double det;
        co=cofactor(matrix,norder);
        det=determinant(matrix,norder);
       
        for(int i=0;i<norder;i++){
            for(int j=0;j<norder;j++){
                mu[i][j]= co[i][j]/det;
                System.out.println(""+mu[i][j]);
            }
        }
       
        return (mu);
       
    }
    
    /*Finds the transpose of a matrix*/
    public static double[][] transpose(double[][] matrix,int mrow,int mcol){
        double trans[][]=new double[mcol][mrow];
        for(int i=0;i<mcol;i++){
           for(int j=0;j<mrow;j++){
               trans[i][j]=matrix[j][i];
           }
       }
       return trans;
    }
    
    
    /*public static double[] eigenval(double a[][],int n){
        Jama.Matrix M=new Jama.Matrix(a);
        int i;
        EigenvalueDecomposition E = new EigenvalueDecomposition(M);
        double[] d = new double[n];
        d=E.getRealEigenvalues();
        return d;
        }
    public static double[][] eigenvect(double a[][],int n){
        Jama.Matrix M=new Jama.Matrix(a);
        int i;
        EigenvalueDecomposition E = new EigenvalueDecomposition(M);
        EigenvalueDecomposition v= M.eig();
        Matrix v1=E.getV();
        Matrix v2=E.getD();
        double[][] evect=v1.getArray();
        return evect;
        }
    static void vector(int order, double matr[][]){
        double x0[][]= new double[order][1];
        double xi[][]= new double[order][1];
        double x2[][]= new double[order][1];
        int i,flag=1,j;
        
        double min;
        
        for(i=0;i<order;i++){
            xi[i][0]=1;
            x0[i][0]=1;
        }
        for(i=0;i<order;i++){
            System.out.print(xi[i][0]);
        }
        
        for(j=0;;j++){
            flag=0;
            
            xi=multiply(matr,xi,order,order,1);

            min=Math.abs(xi[0][0]);
            for (i=0;i<order;i++){
                System.out.println(" "+xi[i][0]);
                if(Math.abs(min)>Math.abs(xi[i][0])){
                    min=xi[i][0];                   
                }
            }
            System.out.println("boo1 "+min);
            for(i=0;i<order;i++){
                
                x2[i][0]=xi[i][0]/min;
                System.out.println(" "+x2[i][0]);
            }
            System.out.println("boo");
            for(i=0;i<order;i++){
                if(x2[i][0]-x0[i][0]<=0.02){
                    flag++;
                }
            }
            if(flag==order){
                value=min;
                vec=x2;
                break;
            }
            for(i=0;i<order;i++){
                x0[i][0]=x2[i][0];
            }
            
            
        }
        
        System.out.println("eigenvalue:"+value);
        System.out.println("eigenvector:");
        for(i=0;i<order;i++){
            for(j=0;j<1;j++){
                 System.out.print(vec[i][j]+" ");
            }
            System.out.print("\n");
        }
        
    }*/
    
    /* Multiplication of two matrices */
    public static double[][] multiply (double matrix1[][],double matrix2[][],int row1,int row2,int col2){
        double temp;
        double result[][]=new double[row1][col2];
        
        for ( int c = 0 ; c < row1 ; c++ ){
            for (int  d = 0 ; d < col2 ; d++ ){  
               temp= 0;
               for ( int k = 0 ; k < row2 ; k++ ){
                  temp = temp + (matrix1[c][k]* matrix2[k][d]);
               }
               
               result[c][d]=temp;
               
            }
         }
        return result;
    }
    
    /*Rank of a matrix*/
    public static int rank(double matrix[][],int n){
        int r=0;
        int i,j;
        int flag=0;
        double a[][]=new double[n][n];
        a=gaussElimin(matrix,n);
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                flag=0;
                if(a[i][j]==0){
                    continue;
                }
                flag++;
                
            }
            if(flag!=0) r++;
        }
        return r;
    }
    
    /*Trace of a matrix*/
    public static double trace(double matrix[][], int n){
        double tr=0;
        int i,j;
      
        for(i=0;i<n;i++){
               tr+=matrix[i][i];
        }
        return tr;
    }
    
    /*Checks if a matrix is a Hessenberg matrix*/
       public static boolean isHessen(double matrix[][], int n){
        int i,j;
        boolean flag=true;
      
        for(i=2;i<n;i++){
            for(j=0; j<=(i-2); j++)
              {
                  if(matrix[i][j]!=0)
                    flag=false;
        }}
        if(flag)   
                return true;
        else
                return false; 
            
    }
    
    /*Finds if a matrix is a lower triangular matrix
     * return false if not a lower triangular matrix
     * returns true if it is a lower triangular matrix*/
    public static boolean islowerTriangle(double[][] matrix, int norder){
        for(int i=0;i<norder;i++){
            for(int j=0;j<norder;j++){
                if(i<j && matrix[i][j]!=0){
                    return false;
                }
            }
        }
        return true;
        
    }
    
    /*Finds if a matrix is a upper triangular matrix
     * return false if not a upper triangular matrix
     * returns true if it is a upper triangular matrix*/
    public static boolean isupperTriangle(double[][] matrix, int norder){
        for(int i=0;i<norder;i++){
            for(int j=0;j<norder;j++){
                if(j<i && matrix[i][j]!=0){
                    return false;
                }
            }
        }
        return true;
        
    }
    
    /*Gaussian elimination method on a matrix*/
     public static double[][] gaussElimin(double a[][],int n){
         int i,j,k;
         double temp,r;
         for(i=0;i<n;i++){
             if(a[i][i]==0){
                 for(j=i+1;j<n;j++){
                     if(a[j][i]!=0){
                         for(k=0;k<n;k++){
                             temp=a[i][k];
                             a[i][k]=a[j][k];
                             a[j][k]=temp;
                         }
                         break;
                     }
                 }
                 if(j==n){
                     System.out.print("singular");
                 }
             }
             for(k=i+1;k<n;k++){
                 r=a[k][i]/a[i][i];
                 for(j=0;j<n;j++){
                     a[k][j]-=r*a[i][j];
                 }
             }
         }
          for(i=0;i<n;i++)
          {     
              for(j=0;j<n;j++){
          if (Double.isNaN(a[i][j])) {
         a[i][j]= 0;
    }
}} return a;
     }
    /*Checks if a given matrix is singular*/
     public static boolean isSingular(double a[][],int n){
         double res;
         res=determinant(a,n);  
         if(res==0){
                     return true;
                 }
             else
             return false;
            }
    /*Checks if a given matrix is invertible*/
      public static boolean isInv(double a[][],int n){
         double res[][]=new double[n][n] ;
         res= inverse(a,n);
         int i,j, flag=0;
         for(i=0;i<n;i++){
             for(j=0;j<n;j++){
                 if(a[i][j]!=res[i][j])
                    flag=1;
                }}
         if(flag==0){
                     return true;
                 }
             else
             return false;
            }
    
      /*Checks if a given matrix is symmetric*/
      public static boolean isSym(double a[][],int n){
         double res[][]=new double[n][n], res1[][]= new double[n][n] ;
         res= inverse(a,n);
         res1=multiply(a,res, n, n, n);
         int i,j, flag=0;
         for(i=0;i<n;i++){
             for(j=0;j<n;j++){
                 if(i==j && res1[i][j]!=1)
                    flag=1;
                else if(i!=j && res1[i][j]!=0)
                                    flag=1;
               else
                                flag=0;
            }}
         if(flag==0){
                     return true;
                 }
             else
             return false;
            }
       
        
    /*Gauss Siedel method
    public static double[] gaussSiedel(double a[][],double b[], double x[],int n,int m){
        double sum = 0;
        int i,j;
        for (int l = 0; l < n; l++)
        x[l] = 0;
        while(m>0)
        {
            for(i = 0; i <n-1 ; i++)
            {
                sum = b[i];
                for(j = 0; j <n-1; j++)
                {
                    if( i != j )
                    {
                        sum = sum - (a[i+1][j+1] * x[j]);
                    }
                }
                x[i] = sum/a[i+1][i+1];
            }
        }
         for(i = 0; i <n ; i++)
            {
                System.out.println(x[i]);
            }
    return x;
        
    }
    */
       
     
    /* To find 1-norm of a matrix*/
    public static double norm1(double[][] a,int n){
        int i, j;
        double b[]=new double[n];
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                b[j]+=a[i][j];
            }
        }
        double max=b[0];
        for(i=1;i<n;i++){
            if(b[i]>max){
                max=b[i];
            }
        }
        return max;
        
    }
    
    /*Gram schmidt orthonormalization method*/
    public static double[][] gso1(double a[][],int m, int n){
        double u[][]=new double[n][m];
        double v[][]=new double[n][m];
        double w[]=new double[m];
        
        int i,j,k;
        double sum=0;
        v=transpose(a,m,n);
        u[0]=normalise(v[0],m);
        /*for(j=0;j<m;j++){
                System.out.println(u[0][j]);
            } */
            
            for(j=1;j<n;j++){
                sum=0;
                double x[]=new double[m];
                for(k=0;k<j;k++){
                    sum+=dotProduct(u[k],v[j],m);
              //  System.out.println(sum);
                    for(i=0;i<m;i++){
                        x[i]=sum*u[j][i];
                    }
                    
                    
                }
                w=subArray(v[j],x,m);
                u[j]=normalise(w,m);
                
                
            }
        return transpose(u,n,m); 
    }
    
    public static double[][] retCol(double a[][],int m, int col)
    {
     double res[][]= new double[m][1];
            for(int i=0; i<m; i++)
                res[i][0]=a[i][col];
                
            return res;
    }
    
    /*QR decomposition method to return the eigen values of a matrix*/
    public static double[] QRdecomp(double a[][],int m) {
        double q[][]=new double[m][m];
        double r[][]=new double[m][m];
        double m1[][]=new double[m][m];
        double m2[][]=new double[m][m];
        double subt;
        double prod[][]= new double[1][1];
        double res[]=new double[m];
        boolean flag;
        int k=50;
        
        m1=a;
        while(k!=0)
        {
            q=gso1(m1,m,m);     //Compute Q using Gram Schmidt orthonormalization method
             /*
              System.out.print("Q:");
             for(int i=0; i<m; i++)
             {
                for(int j=0; j<m; j++)
                {
                       System.out.print(q[i][j]+"\t");
                }
                System.out.println("");
            }
            System.out.println("");
            */
                       
            //Compute R
            for(int i=0; i<m; i++)
                for(int j=0; j<m; j++)
                {
                    prod = multiply( transpose( retCol(m1,m,j), m, 1), retCol(q,m,i), 1,m,1);
                    r[i][j]= prod[0][0];
                }
           /* System.out.print("R:");
              for(int i=0; i<m; i++)
             {
                for(int j=0; j<m; j++)
                {
                       System.out.print(r[i][j]+"\t");
                }
                System.out.println("");
            }
            System.out.println("");
            */
                           
            m2= multiply(r,q,m,m,m);
            /* for(int i=0; i<m; i++)
             {
                for(int j=0; j<m; j++)
                {
                       System.out.print(m2[i][j]+"\t");
                }
                System.out.println("");
            }
            System.out.println("");
            */
           
            //Check for convergence
           /* flag= true;
            for(int i=0; i<m; i++)
            {
                subt=m1[i][i] - m2[i][i];
                if(subt != 0.0)
                {   flag= false;
                    break;
                }
           }
           if(flag) //Matrices have converged
           break;
           */
          
           m1=m2; //Re-assign for next iteration
        
        }
        
        //Assign eigen values to matrix res and return
        for(int i=0; i<m; i++)
                res[i]=m2[i][i];
        return res; 
    }
    
    
    /*To find the subarray of the matrix*/
    
    public static double[] subArray(double a[],double b[], int m){
        double c[]=new double[m];
        int i;
        for(i=0;i<m;i++){
            c[i]=a[i]-b[i];
        }
        return c;
    }
    
    /*To find the dot product of the two matrices*/
    public static double dotProduct(double a[],double b[],int m){
        double d=0,sum=0;
        int i=0;
        for(i=0;i<m;i++){
            sum+=a[i]*b[i];
        }
       // d=Math.sqrt(sum);
        //return d;
        return sum;
    }
    
    public static double[] normalise(double a[],int n){
        
        double[] nor= new double[n];
        double sum=0,po;
        int j;
        for(j=0;j<n;j++){
            po=Math.pow(a[j],2);
            sum+=po;
        }
        sum=Math.sqrt(sum);
        for(j=0;j<n;j++){
            nor[j]=a[j]/sum;
        }
        
        return nor;
    }
    
    /*Cholesky factorization*/
    public static double[][] cholesky(double[][] a){
        int m = a.length;
        double sum;
        double[][] l = new double[m][m]; //automatically initialzed to 0's
        for(int i = 0; i< m;i++){
            for(int k = 0; k < (i+1); k++){
                 sum = 0;
                for(int j = 0; j < k; j++){
                    sum += l[i][j] * l[k][j];
                }
                l[i][k] = (i == k)?Math.sqrt(a[i][i] - sum):(1.0 / l[k][k] * (a[i][k] - sum));
            }
        }
       /* for(int i = 0; i< m;i++){
            for(int k = 0; k < m; k++){
                System.out.println(l[i][k]);
            }}
            */
           
        return l;
    }


}
