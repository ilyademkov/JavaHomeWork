import java.io.File;
import java.io.*;
import java.util.ArrayList;

public class FileLoader extends Person {
  File myFile = new File("C:\\Users\\User\\IdeaProjects\\JavaHomeWork\\Lab5\\lab5.txt");
  {
    boolean created = false;
    try
    {
      created = myFile.createNewFile();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    if (created)
      System.out.println("File has been created");
  }

  public void Load(Person person){
    try {
      String Filename = "C:\\Users\\User\\IdeaProjects\\JavaHomeWork\\Lab5\\lab5.txt";
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
      String Filename = "C:\\Users\\User\\IdeaProjects\\JavaHomeWork\\Lab5\\lab5.txt";
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
