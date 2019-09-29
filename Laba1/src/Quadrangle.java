import java.util.*;

public class Quadrangle
{
  private Point a;
  private Point b;
  private Point c;
  private Point d;

  public Quadrangle()
  {
  }

  public Quadrangle(Point a, Point b, Point c, Point d)
  {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
  }

  public double getLengthAB()
  {
    return a.distanceTo(b);
  }

  public double getLengthBC()
  {
    return b.distanceTo(c);
  }

  public double getLengthCD()
  {
    return c.distanceTo(d);
  }

  public double getLengthAD()
  {
    return a.distanceTo(d);
  }


  public double getPerimeter()
  {
    return getLengthAB() + getLengthAD() + getLengthBC() + getLengthCD();
  }

  public double getDiagonalAC()
  {
    return a.distanceTo(c);
  }

  public double getDiagonalBD()
  {
    return b.distanceTo(d);
  }

  public double getArea()
  {
    double floorP = getPerimeter() / 2;
    return Math.sqrt((floorP - getLengthAB()) * (floorP - getLengthBC()) * (floorP - getLengthCD()) * (floorP - getLengthAD()));
  }

  public void infoFigure()
  {
    System.out.printf("Coordinates: a%s, b%s, c%s, d%s;%s", a, b, c, d, System.lineSeparator());
    System.out.printf("Length sides: AB = %.3f, BC = %.3f, CD = %.3f, AD = %.3f;%s",
        getLengthAB(), getLengthBC(), getLengthCD(), getLengthAD(), System.lineSeparator());
    System.out.printf("Diagonals: AC = %.3f, BD = %.3f;%s", getDiagonalAC(), getDiagonalBD(), System.lineSeparator());
    System.out.printf("Perimeter = %.3f;%s", getPerimeter(), System.lineSeparator());
    System.out.printf("Area = %.3f;%s", getArea(), System.lineSeparator());
  }
}

