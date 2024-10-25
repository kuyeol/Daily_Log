package th.recursion;

class Point
{
  public int x;
  public int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString()
  {
    StringBuilder buf = new StringBuilder();
    buf.append("[").append(x).append(",").append(x).append("]");
    return buf.toString();
  }
}
