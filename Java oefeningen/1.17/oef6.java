import java.lang.*;

/**
 * @author Alexander Steyaert
 * @version v0.1
 */

public class oef6 {
  
  /**
   * Hoofdmethode
   * @param
   */
  public static void main (String args[])
  { 
    int a[] = { 12, 34, 56, 78, 123, 234, 99, 88};
    int result = 0;
    
    for(int i=0; i < a.length; i++)
    {
      if(a[i] > result)
        result = a[i];
      
    }
    
    System.out.println("'t Grootste getalleke is " + result + ".");
  }
}