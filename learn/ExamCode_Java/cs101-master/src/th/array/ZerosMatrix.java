package th.array;

import th.io.Console;
import th.probability.Rand;

/**
 * Implement an algorithm to zero out an mxn matrix using the rule: if an
 * element is 0, set its row and its column to 0
 */
public class ZerosMatrix
{

  public static void setZeros(int[][] a)
  {
    int m = a.length;
    int n = a[0].length;
    boolean[] zero_row = new boolean[m];
    boolean[] zero_col = new boolean[n];
    for (int i = 0; i < m; i++)
    {
      for (int j = 0; j < n; j++)
      {
        if (a[i][j] == 0)
        {
          zero_row[i] = true;
          zero_col[j] = true;
        }
      }
    }

    for (int i = 0; i < m; i++)
    {
      for (int j = 0; j < n; j++)
      {
        if (zero_row[i] || zero_col[j])
        {
          a[i][j] = 0;
        }
      }
    }
  }

  // a quick test
  public static void main(String args[])
  {
    int[][] mat = new int[10][12];
    int m = mat.length;
    int n = mat[0].length;
    for (int i = 0; i < m; i++)
    {
      for (int j = 0; j < n; j++)
      {
        mat[i][j] = Rand.uniform(1, 10);
      }
    }
    mat[3][7] = 0;
    mat[4][8] = 0;
    print2DArray(mat);
    setZeros(mat);
    Console.printf("%s", "--------------------------------\n");
    print2DArray(mat);
  }

  private static void print2DArray(int d[][])
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
}
