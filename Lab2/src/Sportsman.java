
import java.util.Arrays;
  public class Sportsman extends Person
  {
    public Person[] getList() {
      return list;
    }

    private Person[] list;

    public Sportsman(int length) {
      this.list = new Person[length];
    }

    public void resize(int newLength)
    {
      Person[] tempList;
      tempList = Arrays.copyOf(this.list, newLength);

      this.list = tempList;
    }

    public void add(Person person)
    {
      int i = list.length-1;
      for (; i >= 0 && list[i] != null; i--);

      if (i == -1) {
        resize(list.length + 1);
        list[list.length-1] = person;
      }
      else
        list[i] = person;
    }

    public Person remove(String Name)
    {
      int temp = 0;
      for (int i = 0; i < list.length - 1; i++)
      {
        if (list[i].getFIO().equals(Name))
        {
          temp = i;
          Person person = list[temp];
          for (int j = temp; j < list.length - 1; j++)
          {
            list[j] = list[j + 1];
          }
          resize(list.length - 1);
          return person;
        }
      }
        return null;
      }
     public void rewardCountry(String country)
     {
       System.out.println("Для выбранной страны - "+ country+ " - представленны следующие призеры: ");
       for (int i = 0; i < list.length ; i++)
       {
         if (list[i].getCountry().equals(country))
         {
           System.out.println(list[i]);
         }
       }
     }
    public void rewardSport(String sport)
    {
      System.out.println("Пр выбранному виду спорта - "+sport+ " - представленны следующие призеры: ");
      for (int i = 0; i < list.length ; i++)
      {
        if (list[i].getSport().equals(sport))
        {
          System.out.println(list[i]);
        }
      }
    }
    public void medalCount()
    {
      int count = 0;
      Person newperson = list[10];
      System.out.println("Пр выбранному виду спорта - - представленны следующие призеры: ");
      for (int i = 0; i < list.length ; i++)
      {
          if(list[i].getCountry().equals(list[i+1].getCountry()))
          newperson.setCountry(list[i].getCountry());
        }
        {

        }
        count++;
      }
    public void clear()
    {
      resize(0);
    }
  }

