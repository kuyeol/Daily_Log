package th.sort;

import th.io.Console;
import java.util.Arrays;
import th.probability.Rand;

public class QuickSort
{

  public static void quickSort(Comparable[] a, int low, int high)
  {
    if (low < high)
    {
      int pivotIndex = Rand.uniform(low, high);
      int newPivotIndex = partition(a, low, high, pivotIndex);
      quickSort(a, low, newPivotIndex - 1); // Recursively sort left list
      quickSort(a, newPivotIndex + 1, high); // Recursively sort right
    }
    return;
  }

  private static int partition(Comparable[] a, int lo, int hi, int pivot_index)
  {
    Comparable pivot = a[pivot_index];
    swap(a, pivot_index, hi);
    int new_pivot_index = lo;
    for (int i = lo; i < hi; i++)
    {
      if (a[i].compareTo(pivot) < 0)
      {
        swap(a, new_pivot_index, i);
        new_pivot_index++;
      }
    }

    swap(a, new_pivot_index, hi);
    return new_pivot_index;
  }

  private static void swap(Comparable[] arr, int i, int j)
  {
    Comparable tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  // a quick test
  public static void main(String args[])
  {
    Integer[] a = new Integer[10];
    for (int i = 0; i < a.length; i++)
    {
      a[i] = Rand.uniform(100);
    }
    Console.printf("presort: %s \n", Arrays.toString(a));

    quickSort(a, 0, a.length - 1);

    Console.printf("postsort: %s \n", Arrays.toString(a));

  }
}
