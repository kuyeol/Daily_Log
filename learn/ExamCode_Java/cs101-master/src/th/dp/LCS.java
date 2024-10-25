package th.dp;

/**
 * Compute Longest Common Subsequence by adapting edit distance algorithm
 */
public class LCS
{

  public static int MATCH = 0;
  public static int REPLACE = 1;
  public static int INSERT = 2;
  public static int DELETE = 3;
  public static int OP_COST[] = { 0, 100, 1, 1 };

  public static void printLCS(String s, String t)
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

    System.out.printf("The LCS between \"%s\" and \"%s\" is: ", s, t);
    reconstructLCS(s, p, m, n);
    System.out.println("");
  }

  public static void reconstructLCS(String s, int[][] p, int i, int j)
  {
    if (p[i][j] == -1)
    {
      return;
    }

    if (p[i][j] == MATCH)
    {
      reconstructLCS(s, p, i - 1, j - 1);
      System.out.print(s.charAt(i - 1));
      return;
    }

    if (p[i][j] == REPLACE)
    {
      reconstructLCS(s, p, i - 1, j - 1);
      return;
    }

    if (p[i][j] == INSERT)
    {
      reconstructLCS(s, p, i, j - 1);
      return;
    }

    if (p[i][j] == DELETE)
    {
      reconstructLCS(s, p, i - 1, j);
      return;
    }
  }

  public static void main(String args[])
  {
    String s = "democrat";
    String t = "republican";
    printLCS(s, t);
  }
}
