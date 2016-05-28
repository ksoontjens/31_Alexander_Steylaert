import java.lang.*;
import java.util.Arrays;

/**
 * @author Alexander Steyaert
 * @version v0.1
 */

public class oef7 {
  
  /**
   * Hoofdmethode
   * @param
   */
  public static void main (String args[])
  { 
    int[] a = { 12, 34, 56, 78, 123, 234, 99, 88};
    int[] b = new int[a.length];
    int max=0, plaats=0;
    
    for(int j=0; j<b.length;j++)      // B vullen
    {
      max=0;
      
     for(int i=0; i < a.length; i++)  // grootste zoeke in A
     {
       if(a[i] > max)
       {max = a[i]; plaats = i;}
     }
     a[plaats] = 0;
     b[j] = max;
    }
    
    //print array
    for(int i=0;i<b.length; i++)
    {
      System.out.println("- " + b[i]);
    }
    
  }
}