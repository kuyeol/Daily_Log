package th.search;

// Given an array a of integers, count the number of pair that sum to s
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import th.io.Console;

public class TwoSum
{

  // Naive algorithm use 2 nested loop and check all possible pairs (n choose
  // 2 pairs)
  // n*(n-1)/2 operations
  public static int slowCount(int[] a, int s)
  {
    int n = a.length;
    int count = 0;
    for (int i = 0; i < n; i++)
    {
      for (int j = i + 1; j < n; j++)
      {
        if ((a[i] + a[j]) == s)
        {
          count++;
        }
      }
    }
    return count;
  }

  // Sort a first, then for each a[i], use binary search to find(s-a[i]).
  // if found a[j] = s - a[i] and j > i, then count++
  // n*log(n) algorithm
  public static int count(int[] a, int s)
  {
    Arrays.sort(a);
    int n = a.length;
    int count = 0;
    for (int i = 0; i < n; i++)
    {
      if (Arrays.binarySearch(a, s - a[i]) > i)
      {
        count++;
      }
    }
    return count;
  }

  // assuming elements in array a are distinct
  public static int count2(int[] a, int s)
  {
    HashMap<Integer, Integer> hash = new HashMap(1048576);
    for (int i = 0; i < a.length; i++)
    {
      hash.put(a[i], i);
    }
    int cnt = 0;
    for (Map.Entry<Integer, Integer> entry : hash.entrySet())
    {
      int v = entry.getKey();
      if (hash.containsKey(s - v))
      {
        cnt++;
      }
    }
    return cnt / 2;
  }

  public static void test_count_fast()
  {
    int[] a = { 1, 2, 3, 4, 6, 5, 7, 8, 9, 10 };
    System.out.printf("Array: %s.  \n", Arrays.toString(a));
    Console.printf("number of pairs sum to %d is %d.  \n", 10, count2(a, 10));
  }

  public static void main(String args[])
  {
    test_count_fast();
  }
}
