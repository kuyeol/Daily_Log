package th.dp;

import java.util.Arrays;

/**
 * Find a longest increasing subsequence of a given sequence. The subsequence is
 * not necessarily contiguous, nor unique
 */
public class LongestIncrSubSeq
{

  public static int[] findSubSeq(int[] x)
  {
    int p[] = new int[x.length];
    int m[] = new int[x.length + 1];
    m[1] = 0;
    int L = 1;
    for (int i = 1; i < x.length; i++)
    {

      // find largest j from 1..L such that x[m[j]] < x[i]
      int j = bsearch(x, m, x[i], 1, L);

      p[i] = m[j];

      if (j == L || x[i] < x[m[j + 1]])
      {
        m[j + 1] = i;
        L = Math.max(L, j + 1);
      }
    }
    return construct_SubSeq(x, m, p, L);
  }

  // find largest j from 1..L such that x[m[j]] < x[i]
  private static int bsearch(int[] x, int[] m, int v, int lwr, int upr)
  {
    while (true)
    {
      if (lwr >= upr - 1)
      {
        if (x[m[upr]] < v)
        {
          return upr;
        } else if (x[m[lwr]] < v)
        {
          return lwr;
        } else
        {
          return 0;
        }
      }

      int j = (lwr + upr) / 2;
      if (x[m[j]] > v)
      {
        upr = j;
      } else
      {
        lwr = j;
      }
    }

  }

  private static int[] construct_SubSeq(int[] x, int m[], int p[], int L)
  {
    int[] ret = new int[L];
    int i = m[L];
    for (int j = L - 1; j >= 0; j--)
    {
      ret[j] = x[i];
      i = p[i];
    }
    return ret;
  }

  public static void main(String[] args)
  {
    int[] testData = { 2, 4, 3, 5, 1, 7, 6, 9, 8 };
    System.out.printf("Input: %s \n", Arrays.toString(testData));
    System.out.printf("Longest Increasing Subsequence: %s \n", Arrays.toString(findSubSeq(testData)));
  }
}