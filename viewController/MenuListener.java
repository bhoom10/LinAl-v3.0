/*Menu listener and methods*/


package viewController;

import javax.swing.*;    
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import model.Factorization;
import model.LinearAlgebra;


public class MenuListener implements ActionListener {
    private ToolkitView menuFrame;
    public MainPanel mainpanel;
    JScrollPane scroll;
    LinearAlgebra l=new LinearAlgebra();
    
    private double matrix1[][]=new double[10][10];
    private double matrix2[][]=new double[10][10];
    private double result[][]=new double[10][10];
    private double dir[]=new double[10];
    private JTextField[][] sum;
    private int row1,row2;
    private int col1,col2;
    double temp;
    int i,j;
    
    public int choice=0;
    
    private JDialog dialog;
    public int mrow=0 ;
    public int mcolumns=0;
    JPanel m= new JPanel();  
    
    private JTextField row;
    private JTextField columns;
    private JTextField[][] di=new JTextField[10][10];
    private JPanel addMatrix;
    
  /* private JTextField row;
    private JTextField columns;
    private JTextField[][] di=new JTextField[10][1];
    private JPanel addMatrix;
    
    
    private JTextField row;
    private JTextField columns;
    private JTextField[][] di=new JTextField[10][1];
    private JPanel addMatrix;
    
    
    private JTextField row;
    private JTextField columns;
    private JTextField[][] di=new JTextField[10][1];
    private JPanel addMatrix;
    
    
    private JTextField row;
    private JTextField columns;
    private JTextField[][] di=new JTextField[10][1];
    private JPanel addMatrix;
   
    
    private JTextField row;
    private JTextField columns;
    private JTextField[][] di=new JTextField[10][1];
    private JPanel addMatrix;
    */
   
    
    /* public MenuListener (ToolkitView mf,JScrollPane scrollp){
        menuFrame= mf;
        scroll=scrollp;     
    
    public MenuListener (ToolkitView mf,JScrollPane scrollp){
        menuFrame= mf; 
        scroll=scrollp;     
        addMatrix=new JPanel();
    
     public MenuListener (ToolkitView mf,JScrollPane scrollp){
        menuFrame= mf;
        scroll=scrollp;     
        addMatrix=new JPanel();
    
    public MenuListener (ToolkitView mf,JScrollPane scrollp){
        menuFrame= mf;
        scroll=scrollp;     
        addMatrix=new JPanel();
    
    public MenuListener (ToolkitView mf,JScrollPane scrollp){
        menuFrame= mf;
        scroll=scrollp;     
        addMatrix=new JPanel();
    
    public MenuListener (ToolkitView mf,JScrollPane scrollp){
        menuFrame= mf;
        scroll=scrollp;     
        addMatrix=new JPanel();
    
    public MenuListener (ToolkitView mf,JScrollPane scrollp){
        menuFrame= mf;
        scroll=scrollp;     
        addMatrix=new JPanel();
    
    public MenuListener (ToolkitView mf,JScrollPane scrollp){
        menuFrame= mf;
        scroll=scrollp;     
        addMatrix=new JPanel();
    
    public MenuListener (ToolkitView mf,JScrollPane scrollp){
        menuFrame= mf;
        scroll=scrollp;     
        addMatrix=new JPanel();
    
    public MenuListener (ToolkitView mf,JScrollPane scrollp){
        menuFrame= mf;
        scroll=scrollp;     
        addMatrix=new JPanel();
        
    
    public MenuListener (ToolkitView mf,JScrollPane scrollp){
        menuFrame= mf;      scroll=scrollp;     
        addMatrix=new JPanel();
        */
    
        
    
    public MenuListener (ToolkitView mf,JScrollPane scrollp){
        menuFrame= mf;
        scroll=scrollp;     
        addMatrix=new JPanel();
        addMatrix.setLayout(new GridLayout());
        scroll.setViewportView(addMatrix);
    }
    
    
    @SuppressWarnings({ "static-access" })
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        
        String actionCommand= evt.getActionCommand();
        if(actionCommand.equals("new")){
            
        }
        if(actionCommand.equals("close")){
            System.exit(0);
        }
        if(actionCommand.equals("open")){
            
        }
        if(actionCommand.equals("Addition")){
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
            int y;
            if(row1!=row2 || col1!=col2){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);

            }
            else{
                result= LinearAlgebra.addMatrix(matrix1, matrix2, row1, col1);
                
            }
                Display(result,row1,col1);
                menuFrame.setTitle("addition selected");
        }
        if(actionCommand.equals("Subtraction")){
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
            int y;
            if(row1!=row2 || col1!=col2){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);

            }
            else{
                result=LinearAlgebra.subtractMatrix(matrix1, matrix2, row1, col1);
                
            }
            Display(result,row1,col1);
            menuFrame.setTitle("subtraction selected");
        }
        if(actionCommand.equals("Multiplication")){
            JPanel table = new JPanel(new GridLayout(row1,col1));
            if(row1!=col2){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);

            }
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
            int y;
            result=LinearAlgebra.multiply(matrix1,matrix2,row1,col1,col2);                      
             Display(result,row1,col2);
            menuFrame.setTitle("multiplication selected");
        }
        
        if(actionCommand.equals("Determinant")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);

            }
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
            int y;
            double res;
            res= LinearAlgebra.determinant(matrix1,row1);
            Displayval(res,"Determinant");
            menuFrame.setTitle("determinant selected");
        }
        
        if(actionCommand.equals("Inverse")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);

            }
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
            int y;
            double det;
            det= LinearAlgebra.determinant(matrix1,row1);
            if(det==0){
                JOptionPane.showMessageDialog(menuFrame,"determinant should not be equal to zero.Can not be inversed","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
           result=LinearAlgebra.inverse(matrix1,row1);
           Display(result,row1,row1);
            menuFrame.setTitle("inverse selected");
        }
        
        if(actionCommand.equals("Norm")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);

            }
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
            int y;
            double det;
            double norm;
            det=LinearAlgebra.determinant(matrix1,row1);
            if(det==0){
                JOptionPane.showMessageDialog(menuFrame,"determinant should not be equal to zero.","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
           norm=LinearAlgebra.norm1(matrix1,row1);
           Displayval(norm,"Normal");
            menuFrame.setTitle("norm1 selected");
        }
        if(actionCommand.equals("Transpose")){
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
           /* int y;
            
            for (int i = 0; i < mcolumns; i++) {
                for (int j = 0; j < mrow; j++) {
                    result[i][j] = matrix1[j][i];
                }
            }*/
            double res[][]=new double[col1][row1];
            res=LinearAlgebra.transpose(matrix1, row1, col1);
            Display(res,col1,row1);
            menuFrame.setTitle("transpose selected");
        }
        if(actionCommand.equals("Rank")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);

            }
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
            int y;
            double res;
            res= LinearAlgebra.rank(matrix1,row1);
            Displayval(res,"rank");
            menuFrame.setTitle("rank");
        }
        
        if(actionCommand.equals("Trace")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
            int y;
            double res;
            res= LinearAlgebra.trace(matrix1,row1);
            Displayval(res,"Trace");
            menuFrame.setTitle("Trace");
        }
        
        /*if(actionCommand.equals("eigen")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);

            }
            int i,j;
            double eigenv[]=new double[row1];
            double res[][]=new double[1][row1];
            eigenv=l.eigenval(matrix1,row1);
            for(i=0;i<row1;i++){
                System.out.println(eigenv[i]);
                res[0][i]=eigenv[i];
                System.out.println(res[0][i]);
            }
            Display(res,1,row1);
            result=l.eigenvect(matrix1,row1);
            Display(result,row1,row1);
            menuFrame.setTitle("Eigen value/vector selected");
        }
    */
        if(actionCommand.equals("Gram schmidt orthonormalization")){
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
             result=LinearAlgebra.gso1(matrix1,row1,col1);
             Display(result,row1,col1);
                menuFrame.setTitle("Gram schmidt orthonormalization selected");
            
        }
        /*if(actionCommand.equals("smith normal form")){
            
        }
        if(actionCommand.equals("singular value decomposition")){
            
        }*/
        if(actionCommand.equals("Gaussian Elimination")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
             result=LinearAlgebra.gaussElimin(matrix1,row1);
             Display(result,row1,col1);
                menuFrame.setTitle("gauss elimination selected");
                          
        }
        
        /*if(actionCommand.equals("Gaussian Seidel")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
             dir=LinearAlgebra.gaussSeidel(matrix1,row1);
             Display(result,row1,col1);
                menuFrame.setTitle("gauss seidel selected");
            }
            */
           
            
        if(actionCommand.equals("LU decomposition")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
             double res1[][]=new double[row1][row1], res2[][]= new double[row1][row1];
            Factorization f1=new Factorization();
            f1.luDecom(matrix1, row1);
            res1=f1.getMat1();
            res2=f1.getMat2();
            Display(res1,row1,row1);
            Display(res2,row1,row1);
            
        }
        
        if(actionCommand.equals("Cholesky Factorization")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
             result=LinearAlgebra.cholesky(matrix1);
             Display(result,row1,col1);
                menuFrame.setTitle("Cholesky factorization selected"); 
        }
        
       if(actionCommand.equals("QR decomposition")){
             if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            double result1[][]=new double[1][row1];
            JPanel table = new JPanel(new GridLayout(row1,col1));
            sum= new JTextField[row1][col1];
             table.setPreferredSize(new Dimension (4,1));
             result1[0]=LinearAlgebra.QRdecomp(matrix1,row1);
             Display(result1,1,row1);
                menuFrame.setTitle("QR factorization selected"); 
        }
        
       
        if(actionCommand.equals("Lower triangular matrix")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

            boolean check= LinearAlgebra.islowerTriangle(matrix1,row1);
            if(check==true){
                JOptionPane.showMessageDialog(menuFrame,"This matrix is a lower triangular matrix","True",JOptionPane.PLAIN_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(menuFrame,"This matrix is not a lower triangular matrix","True",JOptionPane.PLAIN_MESSAGE);
            
        }
        
        if(actionCommand.equals("Upper triangular matrix")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            boolean check= LinearAlgebra.isupperTriangle(matrix1,row1);
            if(check==true){
                JOptionPane.showMessageDialog(menuFrame,"This matrix is an upper triangular matrix","True",JOptionPane.PLAIN_MESSAGE);

            }
            else
                JOptionPane.showMessageDialog(menuFrame,"This matrix is a not an upper triangular matrix","True",JOptionPane.PLAIN_MESSAGE);
            
        }
         if(actionCommand.equals("Singular matrix")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

            boolean check= LinearAlgebra.isSingular(matrix1,row1);
            if(check==true){
                JOptionPane.showMessageDialog(menuFrame,"This matrix is a singular matrix","True",JOptionPane.PLAIN_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(menuFrame,"This matrix is not a singular matrix","True",JOptionPane.PLAIN_MESSAGE);
            
        }
       
        if(actionCommand.equals("Invertible matrix")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

            boolean check= LinearAlgebra.isInv(matrix1,row1);
            if(check==true){
                JOptionPane.showMessageDialog(menuFrame,"This matrix is an invertible matrix","True",JOptionPane.PLAIN_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(menuFrame,"This matrix is not an invertible matrix","True",JOptionPane.PLAIN_MESSAGE);
            
        }
       
        if(actionCommand.equals("Symmetric matrix")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

            boolean check= LinearAlgebra.isSym(matrix1,row1);
            if(check==true){
                JOptionPane.showMessageDialog(menuFrame,"This matrix is a symmetric matrix","True",JOptionPane.PLAIN_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(menuFrame,"This matrix is not a symmetric matrix","True",JOptionPane.PLAIN_MESSAGE);
            
        }
        
         if(actionCommand.equals("Hessenberg matrix")){
            if(row1!=col1){
                JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

            boolean check= LinearAlgebra.isHessen(matrix1,row1);
            if(check==true){
                JOptionPane.showMessageDialog(menuFrame,"This matrix is a Hessenberg matrix","True",JOptionPane.PLAIN_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(menuFrame,"This matrix is not a Hessenberg matrix","True",JOptionPane.PLAIN_MESSAGE);
            
        }
       
        if(actionCommand.equals("Matrix")){
             
            MatrixInsert();
            menuFrame.setTitle("new matrix adding");
            
        }
        
        /*if(actionCommand.equals("LU decomposition")){
            chDimensions(row1,col1);
            LinearAlgebra.luDecom(matrix1,row1);
            
        }*/
        
    }
    void chDimensions(int row,int col){
        if(row!=col){
            JOptionPane.showMessageDialog(menuFrame,"rows and columns should be equal","error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    void MatrixInsert(){
        
            String  r="1";
            String c="1";
            row = new JTextField(r);
            columns = new JTextField(c);
            row.setEditable(true);
            row.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    row.selectAll();
                }
            });
            columns.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                columns.selectAll();
                }
            });
            columns.setEditable(true);
            final JComponent[] inputs = new JComponent[]{
                    new JLabel("Row"),
                    row,
                    new JLabel("Columns"),
                    columns
        };
            
            
        //do{
             JOptionPane.showMessageDialog(null, inputs, "Provide row and columns less 10", JOptionPane.PLAIN_MESSAGE);
             r=row.getText();
            c=columns.getText();
            if(r==null||c==null){
                JOptionPane.showMessageDialog(menuFrame,"invalid entry","error",JOptionPane.ERROR_MESSAGE);
                MatrixInsert();
            }
            else {
            mrow = Integer.parseInt(r);
            mcolumns = Integer.parseInt(c);
        
            if(mrow<1||mrow>10||mcolumns<1||mcolumns>10){
                JOptionPane.showMessageDialog(menuFrame,"Please enter valid values in the range 1 to 10","error",JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
            
        //}while(r==null ||c==null ||mrow<1||mcolumns<1||mcolumns>10||mrow<0);
        JTextField[][] matrix_1= new JTextField[mrow][mcolumns];
        JPanel matPane= new JPanel(new GridLayout(mrow, mcolumns));
        JTable table = new JTable(mrow,mcolumns);
       
        matrix_1 = CreateMatrix(mrow, mcolumns, "Fill Matrix");
        System.out.println("matPane");
        for (int i = 0; i < mrow; i++) {
            for (int j = 0; j < mcolumns; j++) {
                table.add(matrix_1[i][j]);          
                //matPane.add(matrix_1[i][j]);
                matrix_1[i][j].setEditable(false);
            }
         }  
        
        if(row1==0){
            matrix1=saveMatrix(matrix_1,mrow,mcolumns);
            row1=mrow;
            col1=mcolumns;
        }
        
        else {
            matrix2=saveMatrix(matrix_1,mrow,mcolumns);
            row2=mrow;
            col2=mcolumns;
        }
        System.out.println(row1+"    "+row2);
        
        addMatrix.add(table);
        scroll.setViewportView(addMatrix);
        }
    }
   
    public static void displayMatrix(double[][] matrix,int row,int col){
        int i,j;
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
    }
   
    double[][] saveMatrix(JTextField[][] matrix,int row, int col){
        double mat[][]=new double[row][col];
        for (int i = 0; i < mrow; i++) {
            for (int j = 0; j < mcolumns; j++) {
               mat[i][j]=Double.parseDouble(matrix[i][j].getText());
             
            }
        }
        return mat;
    }
    private JTextField[][] CreateMatrix(int mrow, int mcolumns, String title) {
        Object[] obj = createMatrixPanel(mrow, mcolumns);
        JTextField[][] matrix = (JTextField[][]) obj[1];
        JOptionPane.showMessageDialog(null, obj[0], title, JOptionPane.PLAIN_MESSAGE);
        return matrix;
    }

    private Object[] createMatrixPanel(int rows, int cols) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));
        JTextField matrix[][] = new JTextField[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = new JTextField("", 5);
                panel.add(matrix[i][j]);
            }
        }
        return new Object[]{panel, matrix};
    }
    
    //Display a 2D matrix
    public static void Display(double[][] mat,int mrow,int mcol){
        Object[] obj = displayMatrixPanel(mat,mrow,mcol);
        JTextField[][] matrix = (JTextField[][]) obj[1];
        String title="RESULT";
        JOptionPane.showMessageDialog(null, obj[0], title, JOptionPane.PLAIN_MESSAGE);
            
    }
    
       
    //Display a single value
    public static void Displayval(double res,String s){
        JLabel text=new JLabel(s+": "+res);
        String title="RESULT";
        JOptionPane.showMessageDialog(null, text, title, JOptionPane.PLAIN_MESSAGE);
            
    }
    
    public void DisplayE(double[][] mat,int mrow,double value2){
        JLabel ei=new JLabel(""+value2);
        Object[] obj= displayMatrixPanel(mat,mrow,1);
        Object[] obj1= { ei,obj};
        String title="RESULT";
        JOptionPane.showMessageDialog(null, obj1, title, JOptionPane.PLAIN_MESSAGE);
                
        
    }
    private static Object[] displayMatrixPanel(double[][] mat,int rows, int cols) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));
        JTextField matrix[][] = new JTextField[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = new JTextField(""+mat[i][j], 15);
                matrix[i][j].setEditable(false);
                panel.add(matrix[i][j]);
            }
        }
        return new Object[]{panel, matrix};
    }
    
}
class EventQueueProxy extends EventQueue {
     
    protected void dispatchEvent(AWTEvent newEvent) {
        try {
            super.dispatchEvent(newEvent);
        } catch (Throwable t) {
            t.printStackTrace();
            String message = t.getMessage();
 
            if (message == null || message.length() == 0) {
                message = "Fatal: " + t.getCause();
            }
 
            JOptionPane.showMessageDialog(null, "General Error", message, JOptionPane.ERROR_MESSAGE);
        }
    }
}



