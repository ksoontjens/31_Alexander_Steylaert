import java.lang.*;

/**
 * Priemgetallen WERKT NIE
 * @author Alexander Steyaert
 * @version v0.1
 */

public class oef5 {
  
  /**
   * Hoofdmethode
   * @param
   */
  public static void main (String args[])
  { 
    for(int getal=3; getal<100; getal++)
    {
      for(int deler = 1+1; deler < getal; deler++)
      {
        if(getal % deler == 0){  }
        else{System.out.println(getal + " is een priemerino");}
      }
    }
  }
}