import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static Scanner read = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.println("/n--------------------------------------/n");
    Sportsman sportsman = new Sportsman(0);
    /*System.out.println("Введите Регистрационный номер, ФИО, Страну, Вид спорта и медальполученную спортсменом: ");
    sportsman.add(new Person(read.nextLong(),read.next(),read.next(),read.next(),read.next()));*/
    System.out.println(Arrays.toString(sportsman.getList()));
    sportsman.add(new Person(88466,"John 1","UKRAINE","bobsleigh", "GOLD"));
    System.out.println(Arrays.toString(sportsman.getList()));
    sportsman.add(new Person(999466,"John 2","USA","skates","SILVER"));
    System.out.println(Arrays.toString(sportsman.getList()));
    sportsman.add(new Person(44446,"John 3","UKRAINE","skates","CUPPER"));
    System.out.println("\nAfter adding:\n"+Arrays.toString(sportsman.getList()));
    sportsman.add(new Person(16743453,"John 4","UKRAINE","bobsleigh","GOLD"));
    sportsman.add(new Person(16743473,"John 5","USA","bobsleigh","SILVER"));
    System.out.println("\nAfter another adding:\n"+Arrays.toString(sportsman.getList()));
    /*System.out.println(sportsman.remove("John 1"));*/
    System.out.println("\nAfter removing:\n"+Arrays.toString(sportsman.getList()));
    sportsman.rewardCountry("UKRAINE");
    sportsman.rewardSport("skates");
    sportsman.medalCount();
  }
}
