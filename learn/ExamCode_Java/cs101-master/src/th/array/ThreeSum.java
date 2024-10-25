package th.array;

import java.util.Arrays;
import th.io.Console;
import th.probability.Rand;
import th.stats.Timer;

/**
 * count triples that sum to 0.
 */
public class ThreeSum
{

  /**
   * brute force algorithm
   */
  public static int bruteForce(int[] a)
  {
    int cnt = 0;
    int n = a.length;
    for (int i = 0; i < n; i++)
    {
      for (int j = i + 1; j < n; j++)
      {
        for (int k = j + 1; k < n; k++)
        {
          if (a[i] + a[j] + a[k] == 0)
          {
            ++cnt;
          }
        }
      }
    }
    return cnt;
  }

  // divide and conquer algorithm
  public static int count(int[] a)
  {
    int cnt = 0;
    int n = a.length;
    Arrays.sort(a);
    for (int i = 0; i < n; i++)
    {
      for (int j = i + 1; j < n; j++)
      {
        if (Arrays.binarySearch(a, -a[i] - a[j]) > j)
        {
          ++cnt;
        }
      }
    }
    return cnt;
  }

  public static double timeCount(int[] a)
  {
    Timer watch = new Timer();
    ThreeSum.count(a);
    return watch.elapsed();
  }

  public static double timeBruteForce(int[] a)
  {
    Timer watch = new Timer();
    ThreeSum.bruteForce(a);
    return watch.elapsed();
  }

  public static void main(String[] args)
  {
    int range = 1000000;

    // doubling the size of input in each iteration
    for (int n = 1; true; n += n)
    {
      int[] a = new int[n];
      for (int i = 0; i < n; i++)
      {
        a[i] = Rand.uniform(-range, range);
      }
      double t1 = timeBruteForce(a);
      double t2 = timeCount(a);
      Console.printf("input size =%6d, brute-force=%5.2f secs,  divide-conquer=%5.2f secs %n", n, t1, t2);
    }
  }
}
