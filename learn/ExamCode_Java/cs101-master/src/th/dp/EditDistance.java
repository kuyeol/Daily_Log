package th.dp;

/**
 * Compute Levenshtein edit distance
 * 
 */
public class EditDistance
{

  public static int MATCH = 0;
  public static int REPLACE = 1;
  public static int INSERT = 2;
  public static int DELETE = 3;
  public static int OP_COST[] = { 0, 1, 1, 1 };

  public static int compute(String s, String t)
  {

    int m = s.length();
    int n = t.length();

    // d[i][j] hold the distance between
    // the first i chars of s and the first j characters of t;
    int d[][] = new int[m + 1][n + 1];

    // p[i,j] hold the parent
    int p[][] = new int[m + 1][n + 1];

    int i, j;
    // base case 1;
    for (i = 0; i <= m; i++)
    {
      d[i][0] = i;
      if (i == 0)
      {
        p[i][0] = -1;
      } else
      {
        p[i][0] = DELETE;
      }
    }

    // base case 2;
    for (j = 0; j <= n; j++)
    {
      d[0][j] = j;
      if (j == 0)
      {
        p[0][j] = -1;
      } else
      {
        p[0][j] = INSERT;
      }
    }

    // building dynamic table from bottom up
    for (i = 1; i <= m; i++)
    {
      for (j = 1; j <= n; j++)
      {
        if (s.charAt(i - 1) == t.charAt(j - 1))
        {
          d[i][j] = d[i - 1][j - 1];
          p[i][j] = MATCH;
        } else
        {
          d[i][j] = d[i - 1][j - 1] + OP_COST[REPLACE];
          p[i][j] = REPLACE;

          if (d[i][j - 1] + OP_COST[INSERT] < d[i][j])
          {
            d[i][j] = d[i][j - 1] + OP_COST[INSERT];
            p[i][j] = INSERT;
          }

          if (d[i - 1][j] + OP_COST[DELETE] < d[i][j])
          {
            d[i][j] = d[i - 1][j] + OP_COST[DELETE];
            p[i][j] = DELETE;
          }
        }
      }
    }

    System.out.println("Distance table");
    print2DArray(d);

    System.out.println("Parent/Operation table");
    print2DArray(p);

    System.out.println("Reconstrucing path");
    reconstructPath(p, m, n);
    System.out.println("");

    return d[m][n];
  }

  public static void reconstructPath(int[][] p, int i, int j)
  {
    if (p[i][j] == -1)
    {
      return;
    }

    if (p[i][j] == MATCH)
    {
      reconstructPath(p, i - 1, j - 1);
      System.out.print("M");
      return;
    }

    if (p[i][j] == REPLACE)
    {
      reconstructPath(p, i - 1, j - 1);
      System.out.print("R");
      return;
    }

    if (p[i][j] == INSERT)
    {
      reconstructPath(p, i, j - 1);
      System.out.print("I");
      return;
    }

    if (p[i][j] == DELETE)
    {
      reconstructPath(p, i - 1, j);
      System.out.print("D");
      return;
    }

  }

  public static void print2DArray(int d[][])
  {

    for (int i = 0; i < d.length; i++)
    {
      for (int j = 0; j < d[i].length; j++)
      {
        System.out.printf(" %2d", d[i][j]);
      }
      System.out.println("");
    }
  }

  public static void main(String args[])
  {
    String s = "sitting";
    String t = "kitten";
    System.out.printf("The distance between \"%s\" and \"%s\" is %d \n", s, t, compute(s, t));

    s = "thou-shalt-not";
    t = "you-should-not";
    System.out.printf("The distance between \"%s\" and \"%s\" is %d \n", s, t, compute(s, t));
  }
}
