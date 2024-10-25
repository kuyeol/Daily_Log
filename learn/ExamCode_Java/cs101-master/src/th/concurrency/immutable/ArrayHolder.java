package th.concurrency.immutable;

import java.util.Arrays;

// use defensive copying to ensure 
// ArrayHolder is immutable
public class ArrayHolder
{

  private final double[] arr;

  // constructor use defensive copying.
  public ArrayHolder(double[] arr) {
    this.arr = Arrays.copyOf(arr, arr.length);
  }

  // no setter

  public double[] getter()
  {
    return Arrays.copyOf(arr, arr.length);
  }
}
