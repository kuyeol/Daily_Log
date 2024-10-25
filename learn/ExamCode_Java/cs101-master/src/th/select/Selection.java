package th.select;

import th.probability.Rand;
import th.sort.QuickSort;

public class Selection
{

  /**
   * Nonlinear general selection algorithm
   * 
   * @param arr
   * @param k
   * @return
   * 
   *         Same ideas as finding maximum algorithms. inefficient general
   *         algorithm for finding kth largest item in an array, Require O(kn)
   *         time, which is good IF k is small.
   * 
   *         works with linked list data structure too.
   * 
   */
  public static Comparable nonlinearKSelect(Comparable[] arr, int k)
  {
    for (int i = 0; i < k; i++)
    {
      int maxIndex = i;
      Comparable maxVal = arr[i];
      for (int j = i + 1; j < arr.length; j++)
      {
        if (arr[j].compareTo(maxVal) > 0)
        {
          maxIndex = j;
          maxVal = arr[j];
        }
      }
      swap(arr, i, maxIndex);
    }
    return arr[k - 1];
  }

  /**
   * select kth smallest element
   * 
   * @param arr
   * @param left
   * @param right
   * @param k
   * @return
   */
  public static Comparable quickSelect(Comparable[] arr, int left, int right, int k)
  {
    while (left <= right)
    {
      int pivotIndex = Rand.uniform(left, right);
      int newPivotIndex = partition(arr, left, right, pivotIndex);
      int pivotDistance = newPivotIndex - left + 1;

      if (pivotDistance == k)
      {
        return arr[newPivotIndex];
      } else if (k < pivotDistance)
      {
        right = newPivotIndex - 1;
      } else
      {
        k = k - pivotDistance;
        left = newPivotIndex + 1;
      }
    }

    return -1;
  }

  public static void quickFindFirstK(Comparable[] arr, int left, int right, int k)
  {
    if (right > left)
    {
      int pivotIndex = Rand.uniform(left, right);
      int new_pivot_index = partition(arr, left, right, pivotIndex);

      if (new_pivot_index > left + k)
      {
        quickFindFirstK(arr, left, new_pivot_index - 1, k);
      }

      if (new_pivot_index < left + k)
      {
        quickFindFirstK(arr, new_pivot_index + 1, right, k);
      }
    }
  }

  static int partition(Comparable[] arr, int left, int right, int pivot_index)
  {
    Comparable pivot = arr[pivot_index];
    swap(arr, pivot_index, right);
    int new_pivot_index = left;
    for (int i = left; i < right; i++)
    {
      if (arr[i].compareTo(pivot) < 0)
      {
        swap(arr, new_pivot_index, i);
        new_pivot_index++;
      }
    }

    swap(arr, new_pivot_index, right);
    return new_pivot_index;
  }

  public static void quickSortFirstK(Comparable[] arr, int left, int right, int k)
  {
    if (right > left)
    {
      int pivotIndex = Rand.uniform(left, right);
      int new_pivot_index = partition(arr, left, right, pivotIndex);
      quickSortFirstK(arr, left, new_pivot_index - 1, k);
      if (new_pivot_index < left + k)
      {
        quickSortFirstK(arr, new_pivot_index + 1, right, k);
      }
    }
  }

  /**
   * - From an array of n elements - Select k smallest elements - Return sorted
   * k smallest elements
   * 
   * @param arr
   * @param left
   * @param right
   * @param k
   * @return
   */

  public static Comparable[] selectKSmallest(Comparable[] arr, int left, int right, int k)
  {

    Comparable ret[] = new Comparable[k];

    // get kth smallest element
    Comparable kth = quickSelect(arr, left, right, k);
    ret[0] = kth;
    int j = 1;

    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i].compareTo(kth) < 0)
      {
        ret[j++] = arr[i];
      }
    }

    QuickSort.quickSort(ret, 0, ret.length - 1);
    return ret;

  }

  private static void swap(Comparable[] arr, int i, int j)
  {
    Comparable tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

}
