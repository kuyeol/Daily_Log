package th.concurrency.immutable;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Immutable holder for caching a number and its corresponding fibonacci series.
 * 
 * Immutable holder class group related data items to make sure these data items
 * must be acted atomically.
 */
public class Cache
{
  private final BigInteger lastNum;
  private final BigInteger[] fibonacciSeries;

  public Cache(BigInteger n, BigInteger[] fibonacciSeries) {
    this.lastNum = n;

    // Cache would not be immutable without using defensive copying in this
    // constructor
    this.fibonacciSeries = Arrays.copyOf(fibonacciSeries, fibonacciSeries.length);
  }

  public BigInteger[] getSeries(BigInteger n)
  {
    if (lastNum == null || !lastNum.equals(n))
    {
      return null;
    }
    return Arrays.copyOf(fibonacciSeries, fibonacciSeries.length);
  }
}
