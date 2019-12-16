import java.io.Serializable;

public class Sportsman implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String FIO;
  private long RegistNumber;
  private String medal;
  private String country;
  private String sport;
Person person = new Person();
  FileLoader fileOperator = new FileLoader();

  public Sportsman(String FIO, long RegistNumber, String medal, String country, String sport) {
    this.FIO = FIO;
    this.RegistNumber = RegistNumber;
    this.medal = medal;
    this.country = country;
    this.sport = sport;
  }

  public Sportsman() { }
  public void toDelete()
  {

  }

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
    return FIO;
  }
}