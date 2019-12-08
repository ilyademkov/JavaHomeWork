

public class Sportsman
{







  private String FIO;
  private long RegistNumber;
  private String medal;
  private String country;
  private String sport;
  Person person = new Person();


  public Sportsman(String FIO, long RegistNumber, String medal, String country, String sport) {
    this.FIO = FIO;
    this.RegistNumber = RegistNumber;
    this.medal = medal;
    this.country = country;
    this.sport = sport;
  }

  public Sportsman() { }

  public String getFIO() {
    return FIO;
  }

  public boolean setFIO(String FIO) {
    if(!FIO.isEmpty()) {
      this.FIO = FIO;
      return true;
    } else {
      System.out.println("Try again");
      return false;
    }
  }

  public long getRegistNumber() {
    return RegistNumber;
  }

  public boolean setRegistNumber(long RegistNumber) {
    if(RegistNumber > 0) {
      this.RegistNumber = RegistNumber;
      return true;
    }
    else{
      System.out.println("Try again");
      return false;
    }
  }

  public String getMedal() {
    return medal;
  }

  public boolean setMedal(String medal) {
    if(!medal.isEmpty()){
      this.medal = medal;
      return true;
    }
    else{
      System.out.println("Try again");
      return false;
    }
  }

  public String getCountry() {
    return country;
  }

  public boolean setCountry(String country) {
    if(!country.isEmpty()) {
      this.country = country;
      return true;
    } else {
      System.out.println("Try again");
      return false;
    }
  }

  public String getSport() {
    return sport;
  }

  public boolean setSport(String sport) {
    if(!sport.isEmpty()) {
      this.sport = sport;
      return true;
    } else {
      System.out.println("Try again");
      return false;
    }
  }

  @Override
  public String toString() {
    return "{" +
        " FIO='" + getFIO() + '\'' +
        ", Registration number=" + getRegistNumber() +
        ", Medal=" + getMedal() +
        ", Country='" + getCountry() + '\'' +
        ", Sport='" + getSport() + '\'' +
        '}';
  }
}