import java.util.*;

public class Main{

  public static Scanner read = new Scanner(System.in);

  public static void main(String[] args) {
    //вводим кол-во четырёхугольников и трапеций
    int n = getCountShape("Введите кол-во четырёхугольников");
    int m = getCountShape("Введите кол-во параллелограмов");

    //создаём массивы размеров, введённых с консоли
    Quadrangle[] quadr = new Quadrangle[n];
    Parallelogram[] parallel = new Parallelogram[m];

    //заполняем фигурами со случайными координатами
    fillArrayQuadrangular(quadr);
    fillArrayParallel(parallel);

    //печатаем всю информацию о всех фигурах
    printShapes(quadr, "quadrangular");
    printShapes(parallel, "parallel");

    //получаем максимальную площадь четырёхугольников и по ней кол-во фигур с такой площадью
    double midArea = getMidArea(quadr);
    System.out.printf("Средняя площадь четырёхугольников = %.3f;%s", midArea, System.lineSeparator());

    //ищем минимальную площадь в массиве параллелограмов и выводим о этой фигуре все данные
    double min = getMinDiagonal(parallel);
    System.out.printf("Минимальная площадь = %.3f;%s", min, System.lineSeparator());
    printParallelWithMinArea(parallel, min);

    double max = getMaxDiagonal(parallel);
    System.out.printf("Максимальная площадь = %.3f;%s", min, System.lineSeparator());
    printParallelWithMaxArea(parallel, min);
  }

  public static void printShapes(Quadrangle[] array, String nameShape) {
    for (int i = 0; i < array.length; i++) {
      System.out.println(nameShape + " " + (i + 1) + ":");
      array[i].infoFigure();
      System.out.println();
    }
  }

  public static double getMidArea(Quadrangle[] array) {
    double max = 0;
    double mid = 0;
    for (Quadrangle shape : array) {
      if (shape.getArea() > max) {
        mid += shape.getArea();
      }
    }
    return mid/array.length;
  }

  public static double getMinDiagonal(Parallelogram[] array) {
    double min = array[0].getArea();
    for (int i = 1; i < array.length; i++) {
      if (min > array[i].getArea()) {
        min = array[i].getArea();
      }
    }
    return min;
  }

  public static void printParallelWithMinArea(Parallelogram[] array, double min) {
    for (Parallelogram par : array) {
      if (par.getArea() == min) {
        par.infoFigure();
        break;
      }
    }
  }

  public static double getMaxDiagonal(Parallelogram[] array) {
    double max = array[0].getArea();
    for (int i = 1; i < array.length; i++) {
      if (max < array[i].getArea()) {
        max = array[i].getArea();
      }
    }
    return max;
  }

  public static void printParallelWithMaxArea(Parallelogram[] array, double max) {
    for (Parallelogram par : array) {
      if (par.getArea() == max) {
        par.infoFigure();
        break;
      }
    }
  }


  public static void fillArrayQuadrangular(Quadrangle[] array) {
    for (int i = 0; i < array.length; i++) {
      array[i] = Quadrangular();
    }
  }

  public static void fillArrayParallel(Quadrangle[] array) {
    for (int i = 0; i < array.length; i++) {
      array[i] = Parallel();
    }
  }

  public static int getCountShape(String text) {
    System.out.print(text + ": ");
    return read.nextInt();
  }


  public static Quadrangle Quadrangular() {
    System.out.println("Введите координаты четырех точек четырехугольника в формате (x y): ");
    System.out.print("Введите координаты точки А: ");
    double x = read.nextDouble(), y = read.nextDouble();
    Point a = new Point(x,y);
    System.out.print("Введите координаты точки B: ");
    x = read.nextDouble();
    y = read.nextDouble();
    Point b = new Point(x,y);
    System.out.print("Введите координаты точки C: ");
    x = read.nextDouble();
    y = read.nextDouble();
    Point c = new Point(x,y);
    System.out.print("Введите координаты точки D: ");
    x = read.nextDouble();
    y = read.nextDouble();
    Point d = new Point(x,y);
    return new Quadrangle(a, b, c, d);
  }

  public static Parallelogram Parallel() {
    System.out.println("Введите координаты четырех точек параллелограма в формате (x y): ");
    System.out.print("Введите координаты точки А: ");
    double x = read.nextDouble(), y = read.nextDouble();
    Point a = new Point(x,y);
    System.out.print("Введите координаты точки B: ");
    x = read.nextDouble();
    y = read.nextDouble();
    Point b = new Point(x,y);
    System.out.print("Введите координаты точки C: ");
    x = read.nextDouble();
    y = read.nextDouble();
    Point c = new Point(x,y);
    System.out.print("Введите координаты точки D: ");
    x = read.nextDouble();
    y = read.nextDouble();
    Point d = new Point(x,y);
    System.out.print("Введите высоту паралеллограма: ");
    double hight = read.nextDouble();
    return new Parallelogram(a, b, c, d,hight);
  }

}