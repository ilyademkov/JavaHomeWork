public class Point {
  private double x;
  private double y;

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distanceTo(Point point) {
    double temp = Math.pow(point.getX() - x, 2);
    temp += Math.pow(point.getY() - y, 2);
    return Math.sqrt(temp);
  }

  @Override
  public String toString() {
    return String.format("[%.3f, %.3f]", this.x, this.y);
  }
}
