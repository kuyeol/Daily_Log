package th.dp;

import java.util.ArrayList;

/**
 * Find the longest common substring from 2 strings
 * 
 * @author td
 */
public class LCSubstr
{

  /**
   * Use dynamic programming approach 1) run in O(mn). Use generalized suffix
   * tree for faster algorithm 2) The space complexity is O(mn). Can improve to
   * O(min(m,n)) if only keep last 2 rows/cols
   * 
   * @param s
   * @param t
   * @return
   */
  public static ArrayList<String> findLCSubstr(String s, String t)
  {
    int m = s.length();
    int n = t.length();

    int L[][] = new int[m + 1][n + 1];
    // z hold the len of the longest common substr sofar
    int z = 0;
    ArrayList<String> ret = new ArrayList<String>();

    for (int i = 1; i <= m; i++)
    {
      for (int j = 1; j <= n; j++)
      {
        if (s.charAt(i - 1) == t.charAt(j - 1))
        {
          if (i == 1 || j == 1)
          {
            L[i][j] = 1;
          } else
          {
            L[i][j] = L[i - 1][j - 1] + 1;
          }
          if (L[i][j] > z)
          {
            z = L[i][j];
            ret.clear();
          }

          if (L[i][j] == z)
          {
            ret.add(s.substring(i - z, i));
          }
        }
      }
    }

    return ret;
  }

  public static void main(String args[])
  {
    ArrayList<String> ret = findLCSubstr("ABAB", "BABA");
    for (String s : ret)
    {
      System.out.println(s);
    }
  }
}
