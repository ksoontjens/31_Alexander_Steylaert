import java.lang.*;

/**
 * Vermenigvuldingen
 * @author Alexander Steyaert
 * @version v0.1
 */

public class oef1 {
  
  /**
   * Hoofdmethode
   * @param
   */
  public static void main (String args[])
  {
    int x,y;
    
    y = 9;
    
    System.out.println( "TAFEL VAN " + y );
    
    for( x=0; x<10; x++ )
    {
      System.out.println( x + " x " + y + " = " + x*y );
      
    }
  }
}