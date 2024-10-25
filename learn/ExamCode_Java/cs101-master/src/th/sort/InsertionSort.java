package th.sort;

public class InsertionSort
{

  public static void insertionSort(int a[])
  {

    for (int i = 1; i < a.length; i += 1)
    {
      int j;

      int x = a[i];

      for (j = i - 1; j >= 0; j -= 1)
      {
        if (a[j] <= x)
        {
          break;
        }

        a[j + 1] = a[j];
      }

      a[j + 1] = x;
    }

  }
}
