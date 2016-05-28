import java.lang.*;

/**
 * @author Alexander Steyaert
 * @version v0.1
 */

public class TweedeProg {
  
 /**
  * Deze methode roept volgende methode aan
  * @param args Deze parameter kan meegegeven worden met de main methode
  */
  public static void main (String args[])
  {
    drukaf(20);
  }
  
 /**
  * Deze methode drukt getallen af
  * @param m Deze parameter bepaald de lengte van de looperino
  */
  protected static void drukaf (int m)
  {
    
    int a;
    for (a=0; a<m; a++)
    {
      System.out.println( a );
    }
  }
}