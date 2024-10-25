package th.dp;

import java.util.ArrayList;

public class LCSubSeq
{

  public static void printLCS(String s, String t)
  {
    if (s == null || s.length() == 0)
    {
      return;
    }
    if (t == null || t.length() == 0)
    {
      return;
    }

    int m = s.length();
    int n = t.length();

    int c[][] = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++)
    {
      for (int j = 1; j <= n; j++)
      {
        if (s.charAt(i - 1) == t.charAt(j - 1))
        {
          c[i][j] = c[i - 1][j - 1] + 1;
        } else
        {
          c[i][j] = Math.max(c[i][j - 1], c[i - 1][j]);
        }
      }
    }

    // System.out.println(find1LCS(c, s, t, m,n));
    ArrayList<StringBuffer> list = findAllLCS(c, s, t, m, n);
    for (StringBuffer buf : list)
    {
      System.out.println(buf.toString());
    }
  }

  public static ArrayList<StringBuffer> findAllLCS(int c[][], String s, String t, int i, int j)
  {
    if (i == 0 || j == 0)
    {
      ArrayList<StringBuffer> ret = new ArrayList<StringBuffer>();
      ret.add(new StringBuffer());
      return ret;
    }

    if (s.charAt(i - 1) == t.charAt(j - 1))
    {
      ArrayList<StringBuffer> list = findAllLCS(c, s, t, i - 1, j - 1);
      for (StringBuffer buf : list)
      {
        buf.append(s.charAt(i - 1));
      }
      return list;
    } else
    {
      ArrayList<StringBuffer> ret = new ArrayList<StringBuffer>();
      if (c[i][j - 1] >= c[i - 1][j])
      {
        ret = findAllLCS(c, s, t, i, j - 1);
      }

      if (c[i - 1][j] >= c[i][j - 1])
      {
        ret.addAll(findAllLCS(c, s, t, i - 1, j));
      }
      return ret;
    }
  }

  public static String find1LCS(int c[][], String s, String t, int i, int j)
  {
    if (i == 0 || j == 0)
    {
      return "";
    }

    if (s.charAt(i - 1) == t.charAt(j - 1))
    {
      return find1LCS(c, s, t, i - 1, j - 1) + s.charAt(i - 1);
    } else
    {
      if (c[i][j - 1] > c[i - 1][j])
      {
        return find1LCS(c, s, t, i, j - 1);
      } else
      {
        return find1LCS(c, s, t, i - 1, j);
      }
    }
  }

  public static void main(String args[])
  {
    String s = "ABC";
    String t = "ACB";

    System.out.printf("print the lcs between %s and %s: \n", s, t);
    printLCS(s, t);
  }
}
