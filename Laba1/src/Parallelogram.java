import java.util.*;
public class Parallelogram extends Quadrangle
{
  private double hight = 0;
  public Parallelogram(Point a, Point b, Point c, Point d, double hight) {
    super(a, b, c, d);
    this.hight = hight;
  }

  public boolean checkCorrectFigure() {
    boolean correct = true;
    if (getLengthAB() != getLengthCD()&& getLengthBC() != getLengthAD())
    {
      correct = false;
      System.out.println("Данная фигура не является параллелограмом!!!");
    }
    return correct;
  }
  @Override
  public double getArea() {
    double area = 0;
    if (checkCorrectFigure()) {
      double a;
      a = getLengthBC();
      area = a*hight;
      }
    return area;
  }
  @Override
  public double getPerimeter()
  {
    double a;
    double b;
    double perimeter = 0;
    if (checkCorrectFigure()) {
      a = getLengthAB();
      b = getLengthBC();
      perimeter = 2*(a+b);
      }

    return perimeter;
  }

}

