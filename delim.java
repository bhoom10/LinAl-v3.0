import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
public class delim
{
    
public static void main(String args[]) {
    String tok[]=new String[5], comp;
    int n,i;
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the real num:");
                     comp=(s.next());
    StringTokenizer st = new StringTokenizer(comp,"i");                    
    n=st.countTokens();
    
    System.out.println("The tokens are:");
   for(i=0; i<n; i++)
   {
        while (st.hasMoreTokens()) {
       tok[i] =st.nextToken();
        System.out.println(tok[i]);
    }}
}}