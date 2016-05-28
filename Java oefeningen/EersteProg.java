import java.lang.*;

      /**
       * @author AUTEUR
       * @version VERSIE
       * 
       * specifieke commentaar voor java
       * JavaDOC commentaar
       */

public class EersteProg {
    public static void main( String args[ ] )
    {
     /**
      * @param args Dit is een parameter die kan worden meegegeven via console
      */
      
      
      
      int a;   // 32 bits signed (2's complement)
      long b;  // 64 bits signed
      byte c;  // 8 bits (-128...127)
      short d; // 16 bits
      
      float f; // 32
      double g = 0; // 64 bits
        
      a = 5;
      a=a+1;
      a++;
      
      f=3.3f;  //float
      g=3.3;
      
      a=512;
      a=0x200; // hex
      a=0345;  //octaal getal, grondtal=8
      long A=123456781234L;
      
      char C;
      C='R';
      C=65;
      
      // commentaar
      /* commentaar
         commentaar */
      
      
      System.out.println( "Dit is mijn eerste Java programma\n" + a + " en " + args[0]);
    }
}