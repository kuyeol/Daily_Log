package th.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MergeSort
{

  public static void mergeSort(Comparable[] a)
  {
    if (a != null || a.length > 1)
    {
      Comparable[] tmp = new Comparable[a.length];
      mergeSort(a, tmp, 0, a.length - 1);
    }
  }

  private static void mergeSort(Comparable[] a, Comparable[] tmp, int lo, int hi)
  {
    if (lo < hi)
    {
      int mid = lo + (hi - lo) / 2;
      mergeSort(a, tmp, lo, mid);
      mergeSort(a, tmp, mid + 1, hi);
      merge(a, tmp, lo, mid, hi);
    }
  }

  public static void merge(Comparable[] a, Comparable[] tmp, int lo, int mid, int hi)
  {
    // copy from a to tmp array
    for (int i = lo; i <= hi; i++)
    {
      tmp[i] = a[i];
    }

    int p1 = lo;
    int p2 = mid + 1;
    // merge back to a;
    for (int i = lo; i <= hi; i++)
    {
      if (p1 > mid)
      {
        a[i] = tmp[p2++];
      } else if (p2 > hi)
      {
        a[i] = tmp[p1++];
      } else if (tmp[p1].compareTo(tmp[p2]) < 0)
      {
        a[i] = tmp[p1++];
      } else
      {
        a[i] = tmp[p2++];
      }
    }
  }

  public static void test()
  {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    Random rand = new Random();
    for (int i = 0; i < 10; i++)
    {
      arr.add(rand.nextInt(100));
    }

    Comparable[] a = new Comparable[arr.size()];
    arr.toArray(a);

    System.out.printf("presort: %s \n", toStr(a));
    mergeSort(a);
    System.out.printf("postsort: %s \n", toStr(a));
  }

  private static String toStr(Comparable[] arr)
  {
    String s = Arrays.toString(arr);
    return s;
  }

  public static void main(String args[])
  {
    test();
  }
}
