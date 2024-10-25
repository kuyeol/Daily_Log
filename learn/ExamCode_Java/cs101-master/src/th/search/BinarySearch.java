package th.search;

import java.util.Arrays;

// O(log n) algorithm to find an element
// in a sorted array
public class BinarySearch
{
  public static final int NOT_FOUND = -1;

  // array a must be sorted before finding
  public static int find(int a[], int key)
  {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi)
    {
      int mid = lo + (hi - lo) / 2;
      if (key == a[mid])
      {
        return mid;
      } else if (key < a[mid])
      {
        hi = mid - 1;
      } else
      {
        lo = mid + 1;
      }
    }
    return NOT_FOUND;
  }

  // array a must be sorted before finding
  public static int find(Comparable a[], Comparable key)
  {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi)
    {
      int mid = lo + (hi - lo) / 2;
      if (key.compareTo(a[mid]) == 0)
      {
        return mid;
      } else if (key.compareTo(a[mid]) < 0)
      {
        hi = mid - 1;
      } else
      {
        lo = mid + 1;
      }
    }
    return NOT_FOUND;
  }

  public static void main(String args[])
  {
    int[] A = { -1, -1, 0, 0, 1, 5, 5 };
    int rank = find(A, 1);
    System.out.printf("Searched 1 in %s.  Found at %d \n", Arrays.toString(A), rank);
  }
}
