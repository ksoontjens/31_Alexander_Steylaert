import java.lang.*;

/**
 * Getal PI
 * @author Alexander Steyaert
 * @version v0.1
 */

public class oef3 {
  
  /**
   * Hoofdmethode
   * @param
   */
  public static void main (String args[])
  {
    double pi=0.0;
    int i = 0;
    int x = 1;
    int y;
    while(i <= 10000)
    {
      y = x + 2;
      
      pi += 1.0/x - 1.0/y;
      
      x = y + 2;
      i++;
    }
    pi = 4*pi;
    
    System.out.print(pi);
  }
}