import java.util.Comparator;

public class Person
{
  private long RegistNumber;
  private String FIO;
  private String country;
  private String sport;
  private String medal;
  public Person()
  {
  }

  public Person(long registNumber, String FIO, String country, String sport, String medal)
  {
    this.RegistNumber = registNumber;
    this.FIO = FIO;
    this.country = country;
    this.sport = sport;
    this.medal = medal;
  }
  @Override
  public String toString()
  {
    return "Sportsman{" +
        "RegistNumber=" + RegistNumber +
        ", FIO='" + FIO + '\'' +
        ", country='" + country + '\'' +
        ", sport='" + sport + '\'' +
        ", position=" + medal +
        '}';
  }

  public long getRegistNumber()
  {
    return RegistNumber;
  }

  public String getFIO()
  {
    return FIO;
  }

  public String getCountry()
  {
    return country;
  }

  public String getSport()
  {
    return sport;
  }

  public String getMedal()
  {
    return medal;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public void setMedal(String medal)
  {
    this.medal = medal;
  }
  public static Comparator<Person> ByCountry() {return (o1, o2) -> o1.getCountry().compareTo(o2.getCountry()); }
}
