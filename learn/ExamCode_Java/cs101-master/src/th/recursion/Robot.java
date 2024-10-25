package th.recursion;

import java.util.ArrayList;

public class Robot
{
  private ArrayList<Point> cur_path = new ArrayList<Point>();

  // the grid has XxY layout
  static int X = 4;
  static int Y = 4;
  static boolean[][] grid = new boolean[X][Y];

  // square (1,2), (0,2), (3,1) are off limit. Robot can not walk into this
  static
  {
    grid[1][2] = true;
    grid[0][2] = true;
    grid[3][1] = true;
  }

  public boolean getPaths(int x, int y)
  {
    Point p = new Point(x, y);
    cur_path.add(p);
    if (x == 0 && y == 0)
    {
      return true;
    }

    boolean success = false;
    if (x >= 1 && !is_occupied(x - 1, y))
    {
      // walk right
      success = getPaths(x - 1, y);
    }

    if (!success && y >= 1 && !is_occupied(x, y - 1))
    {
      // walk down
      success = getPaths(x, y - 1);
    }

    if (!success)
    {
      cur_path.remove(p); // went wrong way
    }

    return success;

  }

  static boolean is_occupied(int x, int y)
  {
    if (grid[x][y])
    {
      return true;
    } else
    {
      return false;
    }
  }

  public void printPaths()
  {
    for (Point p : cur_path)
    {
      System.out.print(p);
    }
  }

  public static void main(String args[])
  {
    Robot robot = new Robot();
    robot.getPaths(3, 3);
    robot.printPaths();
  }

}
