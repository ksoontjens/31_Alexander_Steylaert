public class Werknemersoef {
  /*
  public StudentWerknemer( String voornaam, String achternaam, 
                            int nr, float sal, int urengw)
  */
  
  public static void main( String arg[] )
  {
   //oef1
    Werknemer jan = new Werknemer( "jan", "janssens", 1, 900.0f );
    Werknemer herman = new Werknemer( "herman", "vermeulen", 2, 700.0f );
    Werknemer jeffrie = new Werknemer( "jeffrie", "poepgelei", 3, 1100.0f );
    Werknemer rob = new Werknemer( "rob", "boerekieke", 4, 100.0f );
    
   //oef2
    jan.salarisVerhogen(10);
    herman.salarisVerhogen(10);
    
    System.out.println(jan.voornaam + " verdient " + jan.getSalaris());
    System.out.println(herman.voornaam + " verdient " + herman.getSalaris());
    System.out.println(jeffrie.voornaam + " verdient " + jeffrie.getSalaris());
    System.out.println(rob.voornaam + " verdient " + rob.getSalaris());
    
   //oef3
    PartTimeWerknemer rachid = new PartTimeWerknemer( "rachid", "vermeire", 101, 100.0f, 3 );
    PartTimeWerknemer john = new PartTimeWerknemer( "john", "dop", 102, 120.0f, 8 );
    
   //oef4
    rachid.salarisVerhogen(10);
    john.salarisVerhogen(4);
    
    System.out.println(rachid.voornaam + " verdient " + rachid.getSalaris());
    System.out.println(john.voornaam + " verdient " + john.getSalaris());
    
    
   //oef5,6
    jan.setRSZ(35.0f);
    System.out.println(jan.voornaam + " heeft een RSZ van " + jan.getRSZ());
    System.out.println(john.voornaam + " heeft een RSZ van " + john.getRSZ());
    
   //oef7
    StudentWerknemer henkie = new StudentWerknemer( "henkie", "slenkie", 201, 1500.0f, 9 );
    System.out.println(henkie.voornaam + " heeft een RSZ van " + henkie.getRSZ());
    
    
    Factuur factuur1=new Factuur();
    
    Betaalbaar[] BetDingen[] = new Betaalbaar[10];
    
    BetDingen[0] = jan;
    BetDingen[1] = factuur1;
    BetDingen[2] = henkie;
    
    for (int i=0; i<3; i++)
      BetDingen[i].betaal();
    
  }
  
  
}