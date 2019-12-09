import java.io.*;
import java.util.ArrayList;

public class File extends Person {
  private static final String Filename = "C:\\Users\\User\\IdeaProjects\\JavaHomeWork\\Lab4\\lab4.txt";
  public void Load(Person person){
    try {
      FileInputStream fin = new FileInputStream(Filename);
      ObjectInputStream ois = new ObjectInputStream(fin);
      person.sportsmen = (ArrayList<Sportsman>) ois.readObject();
      ois.close();
      fin.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  public void Save(Person person){
    try{
      FileOutputStream fileOut = new FileOutputStream(Filename);
      ObjectOutputStream oos = new ObjectOutputStream(fileOut);
      oos.writeObject(person.sportsmen);
      oos.close();
      fileOut.close();
     
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
