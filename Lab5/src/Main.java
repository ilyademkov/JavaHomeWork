
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application
{

  public void start(Stage primaryStage) throws Exception
  {
    Sportsman sportsman = new Sportsman();
    Person person = new Person();
    FileLoader fileOperator = new FileLoader();
    fileOperator.Load(person);
    Scanner in = new Scanner(System.in);
    int menu;
    String requiredCountry;
    String requiredSport;
    String removeSportsman;
    for (int i = 0; i < person.sportsmen.size(); i++)
    {
      System.out.println(person.sportsmen.get(i).toString());
    }
      System.out.println("Выберите действие: ");
      System.out.println("1 - Добавление спортсмена");
      System.out.println("2 - Выдача информации об участниках заданной страны");
      System.out.println("3 - Выдача информации об участниках по заданному виду спорта");
      System.out.println("4 - Дисквалификация спортмена по просьбе комиссии");
      System.out.println("5 - Перечень медалей полученных каждой из стран");
      System.out.println("6 - Список всех спортсменов");
      System.out.println("7 - Сохранить список спортсменов");
      System.out.println("0 - Завершить");
     int var = in.nextInt();
      menu = var;
      if (menu == 1)
      {
        try
        {
          System.out.println("Введите Регистрационный номер, ФИО, Страну, Вид спорта и медаль полученную спортсменом: ");
          System.out.println("Фио: ");
          sportsman.setFIO(in.next());
          System.out.println("Регистрационный номер: ");
          sportsman.setRegistNumber(in.nextLong());
          System.out.println("Занятое место: ");
          sportsman.setMedal(in.next());
          System.out.println("Страна: ");
          sportsman.setCountry(in.next());
          System.out.println("Вид спорта: ");
          sportsman.setSport(in.next());
          person.sportsmen.add(new Sportsman(sportsman.getFIO(), sportsman.getRegistNumber(), sportsman.getMedal(), sportsman.getCountry(), sportsman.getSport()));
          fileOperator.Save(person);
        }
        catch (InputMismatchException e)
        {
          System.out.println("Проверте правильность введенных данных");
        }
      }
        else if (menu == 2)
        {
          if (person.sportsmen.size() > 0)
          {
            System.out.println("Введите желаемую страну: ");
            requiredCountry = in.next();
            System.out.println("Для выбранной страны - " + requiredCountry + " - представленны следующие призеры: ");
            for (int i = 0; i < person.sportsmen.size(); i++)
            {
              if (person.sportsmen.get(i).getCountry().equalsIgnoreCase(requiredCountry))
              {
                System.out.println("Спортсмен №" + (i + 1) + ":" + person.sportsmen.get(i).toString());
              }
            }
          }
        }
        else if(menu == 3)
      {
        if (person.sportsmen.size() > 0)
        {
          System.out.println("Введите желаемый вид спорта: ");
          requiredSport = in.next();
          System.out.println("По выбранному виду спорта - " + requiredSport + " - представленны следующие призеры: ");
          for (int i = 0; i < person.sportsmen.size(); i++)
          {
            if (person.sportsmen.get(i).getSport().equalsIgnoreCase(requiredSport))
            {
              System.out.println("Спортсмен №" + (i + 1) + ":" + person.sportsmen.get(i).toString());
            }
          }
        }
      }
       else if (menu==4)
      {
        if (person.sportsmen.size() > 0)
        {
          System.out.println("Введите ФИО спрорстмена для дисквалификации: ");
          removeSportsman = in.next();
          for (int i = 0; i < person.sportsmen.size(); i++)
          {
            if (person.sportsmen.get(i).getFIO().equalsIgnoreCase(removeSportsman))
            {
              person.sportsmen.remove(i);
              fileOperator.Save(person);
              person.sportsmen.clear();
              System.out.println("Спортсмен " + removeSportsman + " был успешно дисквалифицирован");
            }
          }
        }
      }
        else if (menu == 6)
      {
        fileOperator.Load(person);
        for (int i = 0; i < person.sportsmen.size(); i++)
        {
          System.out.println("Спортсмен №" + (i + 1) + ":" + person.sportsmen.get(i).toString());
        }

      }
        else if (menu==5)
      {
        if (person.sportsmen.size() > 0)
        {
          for (int i = 0; i < person.sportsmen.size(); i++)
          {
            System.out.println(person.sportsmen.get(i).getCountry() + " - " + person.sportsmen.get(i).getMedal());
          }
        }
      }
        else if (menu==7)
      {
        if (person.sportsmen.size() > 0)
        {
          fileOperator.Save(person);
        }
      }
        else if (menu==0){
          System.exit(0);
      }
      sportsmanComboBox.getItems().addAll(person.sportsmen);
      root.getChildren().add(strings);

      strings.setPadding(new Insets(10, 30, 10, 30));
      strings.setSpacing(20);

    strings.getChildren().add(new Text("Select the sportsman"));
    strings.getChildren().add(buttonBox);
    strings.getChildren().add(deleteBox);
    strings.getChildren().add(new Text("Add new Sportsman"));
    strings.getChildren().add(addSportsmanBox);


      buttonBox.setSpacing(10);
      buttonBox.getChildren().add(sportsmanComboBox);
      buttonBox.getChildren().add(buttonGetInfo);
      buttonBox.getChildren().add(textInfo);

    addSportsmanBox.setSpacing(10);
    addSportsmanBox.getChildren().add(new Text("Name: "));
    addSportsmanBox.getChildren().add(FIO);
    addSportsmanBox.getChildren().add(new Text("RegNum: "));
    addSportsmanBox.getChildren().add(RegistNumber);
    addSportsmanBox.getChildren().add(new Text("Position: "));
    addSportsmanBox.getChildren().add(medal);
    addSportsmanBox.getChildren().add(new Text("Country: "));
    addSportsmanBox.getChildren().add(country);
    addSportsmanBox.getChildren().add(new Text("Sport: "));
    addSportsmanBox.getChildren().add(sport);
    addSportsmanBox.getChildren().add(buttonAddSportsman);

    deleteBox.getChildren().add(buttonDelete);


    buttonGetInfo.setOnAction(e -> {
      Sportsman sp = sportsmanComboBox.getSelectionModel().getSelectedItem();
      if (sp != null) {
        textInfo.setText("RegNum: " + sp.getRegistNumber() + ", " + "Position: " + sp.getMedal() + ", " + "Country: " + sp.getCountry() + "," + "Sport: " + sp.getSport());
      } else {
        textInfo.setText("User not selected");
      }
    });
  buttonAddSportsman.setOnAction(e -> {
    Sportsman sp = new Sportsman (FIO.getText(), Long.parseLong(RegistNumber.getText()), medal.getText(),country.getText(),sport.getText());
    person.sportsmen.add(sp);
    sportsmanComboBox.getItems().addAll(sp);
    FIO.clear();
    RegistNumber.clear();
    medal.clear();
    country.clear();
    sport.clear();
    fileOperator.Save(person);
  });

    buttonDelete.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {

          int selectedIndex = sportsmanComboBox.getSelectionModel().getSelectedIndex();
          sportsmanComboBox.getItems().remove(selectedIndex);
          fileOperator.Load(person);
        fileOperator.Save(person);



        }
    });

    Scene scene = new Scene(root, WIDTH, HEIGHT);
      primaryStage.setTitle("Sportsmen");
      primaryStage.setScene(scene);
      primaryStage.show();


    }
  public static void main(String[] args)
  {
    launch(args);
  }

  Group root = new Group();
  VBox strings = new VBox();

  HBox buttonBox = new HBox();

  ComboBox<Sportsman> sportsmanComboBox = new ComboBox<>();
  Button buttonGetInfo = new Button("Info");
  Text textInfo = new Text();

  HBox addSportsmanBox = new HBox();
  Button buttonAddSportsman = new Button("Add User");
  TextField FIO = new TextField();
  TextField RegistNumber = new TextField();
  TextField medal = new TextField();
  TextField country = new TextField();
  TextField sport = new TextField();

  HBox deleteBox = new HBox();
  Button buttonDelete = new Button("Delete Sportsman");
  TextField toDelete = new TextField();
  final private int WIDTH = 1200;
  final private int HEIGHT = 300;
}