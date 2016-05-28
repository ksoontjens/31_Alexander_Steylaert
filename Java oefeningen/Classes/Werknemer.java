public class Werknemer implements Betaalbaar {
  
  public String voornaam;
  public String achternaam;
  public int werknemerNummer;
  protected float salaris;
  private float RSZpercentage = 33.0f;
  
  public Werknemer( String voornaam, String achternaam, int wNummer, float sal)
  {
    werknemerNummer=wNummer;
    this.voornaam=voornaam;
    this.achternaam=achternaam;
    salaris=sal;
  }
  
  public void salarisVerhogen(int percentage)
  {
    salaris+=salaris*(percentage/100.0);
  }
  
  public float getSalaris()
  {
    return salaris;
  }
  
  public void setRSZ( float RSZ )
  {
    RSZpercentage = RSZ;
  }
  
  public float getRSZ()
  {
    return RSZpercentage;
  }
  
  public void betaal()
  {
    System.out.println("Betaal "+ salaris + " aan " + voornaam);
  }
  
}