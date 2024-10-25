package th.stats;

import th.io.Console;
import th.probability.Rand;
import th.search.TwoSum;

public class PerformanceTest
{

  // time both TwoSum.countSlowly & TwoSum.count for n randon imtegers between
  // 0 and 2000000
  public static double[] measureTime(int n)
  {
    int MIN = 0;
    int MAX = 2000000;
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
    {
      a[i] = Rand.uniform(MIN, MAX);
    }

    Timer timer = new Timer();
    long count0 = TwoSum.slowCount(a, 1000000);
    double measure0 = timer.elapsed();

    timer = new Timer();
    long count1 = TwoSum.count2(a, 1000000);
    double measure1 = timer.elapsed();

    timer = new Timer();
    long count2 = TwoSum.count(a, 1000000);
    double measure2 = timer.elapsed();

    double[] runningtime = new double[3];
    runningtime[0] = measure0;
    runningtime[1] = measure1;
    runningtime[2] = measure2;
    return runningtime;
  }

  // print running times for different n
  public static void main(String args[])
  {
    Console.printf("%10s %8s   %8s  %8s \n", "n", "countSlowly", "countFast", "count");
    for (int n = 256; n < Integer.MAX_VALUE; n += n)
    {
      double[] time = measureTime(n);
      Console.printf("%10d %8.2f %8.2f %8.2f \n", n, time[0], time[1], time[2]);
    }
  }
}
