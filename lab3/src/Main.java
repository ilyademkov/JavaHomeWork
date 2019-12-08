import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{

  public static void main(String[] args)
  {
    Sportsman sportsman = new Sportsman();
    Person person = new Person();
    Scanner in = new Scanner(System.in);
    int switcher;
    String requiredCountry;
    String requiredSport;
    String removeSportsman;
    while (true)
    {
      System.out.println("Выберите действие: ");
      System.out.println("1 - Добавление спортсмена");
      System.out.println("2 - Выдача информации об участниках заданной страны");
      System.out.println("3 - Выдача информации об участниках по заданному виду спорта");
      System.out.println("4 - Дисквалификация спортмена по просьбе комиссии");
      System.out.println("5 - Перечень медалей полученных каждой из стран");
      System.out.println("6 - Список всех спортсменов");
      System.out.println("0 - Завершить");
      switcher = in.nextInt();
      switch (switcher)
      {
        case 1:
          try
          {
            System.out.println("Введите Регистрационный номер, ФИО, Страну, Вид спорта и медаль полученную спортсменом: ");
            System.out.println("Фио: ");
            do
            {
            }
            while (!sportsman.setFIO(in.next()));
            System.out.println("Регистрационный номер: ");
            do
            {
            }
            while (!sportsman.setRegistNumber(in.nextLong()));
            System.out.println("Занятое место: ");
            do
            {
            }
            while (!sportsman.setMedal(in.next()));
            System.out.println("Страна: ");
            do
            {
            }
            while (!sportsman.setCountry(in.next()));
            System.out.println("Вид спорта: ");
            do
            {
            }
            while (!sportsman.setSport(in.next()));
            person.sportsmen.add(new Sportsman(sportsman.getFIO(), sportsman.getRegistNumber(), sportsman.getMedal(), sportsman.getCountry(), sportsman.getSport()));
          }
          catch (InputMismatchException e)
          {
            System.out.println("Проверте правильность введенных данных");
          }
          break;
        case 2:
          if (person.sportsmen.size() > 0)
          {
            System.out.println("Введите желаемую страну: ");
            requiredCountry = in.next();
            System.out.println("Для выбранной страны - " + requiredCountry + " - представленны следующие призеры: ");
            int k = 0;
            for (int i = 0; i < person.sportsmen.size(); i++)
            {
              if (person.sportsmen.get(i).getCountry().equalsIgnoreCase(requiredCountry))
              {
                System.out.println("Спортсмен №" + (i + 1) + ":" + person.sportsmen.get(i).toString());
                k++;
              }
            }
            if (k == 0)
            {
              System.out.println("Совпадений не найдено");
            }
          }
          else
          {
            System.out.println("База данных пуста");
          }
          break;
        case 3:
          if (person.sportsmen.size() > 0)
          {
            System.out.println("Введите желаемый вид спорта: ");
            requiredSport = in.next();
            System.out.println("По выбранному виду спорта - " + requiredSport + " - представленны следующие призеры: ");
            int k = 0;
            for (int i = 0; i < person.sportsmen.size(); i++)
            {
              if (person.sportsmen.get(i).getSport().equalsIgnoreCase(requiredSport))
              {
                System.out.println("Спортсмен №" + (i + 1) + ":" + person.sportsmen.get(i).toString());
                k++;
              }
            }
            if (k == 0)
            {
              System.out.println("Совпадений не найдено");
            }
          }
          else
          {
            System.out.println("База данных пуста");
          }
          break;
        case 4:
          if (person.sportsmen.size() > 0)
          {
            System.out.println("Введите ФИО спрорстмена для дисквалификации: ");
            removeSportsman = in.next();
            boolean k = false;
            for (int i = 0; i < person.sportsmen.size(); i++)
            {
              if (person.sportsmen.get(i).getFIO().equalsIgnoreCase(removeSportsman))
              {
                person.sportsmen.remove(i);
                System.out.println("Спортсмен " + removeSportsman + " был успешно дисквалифицирован");
                k = true;
              }
            }
            if (!k)
            {
              System.out.println("Совпадений не найдено");
            }
          }
          else
          {
            System.out.println("База данных пуста");
          }
          break;
        case 6:
          if (person.sportsmen.size() > 0)
          {
            for (int i = 0; i < person.sportsmen.size(); i++)
            {
              System.out.println("Спортсмен №" + (i + 1) + ":" + person.sportsmen.get(i).toString());
            }
          }
          break;
        case 5:
          if (person.sportsmen.size() > 0)
          {
            int k = 0;
            for (int i = 0; i < person.sportsmen.size(); i++)
            {

              System.out.println(person.sportsmen.get(i).getCountry() + " - " + person.sportsmen.get(i).getMedal());
              k++;
            }
            if (k == 0)
            {
              System.out.println("Совпадений не найдено");
            }
          }
          else
          {
            System.out.println("База данных пуста");
          }
          break;
        case 0:
          System.exit(0);
      }
    }
  }
}