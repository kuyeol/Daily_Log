package th.search;

public class RotatedBinSearch
{

  public static final int NOT_FOUND = -1;

  public static int binSearch(int a[], int x, int l, int r)
  {
    while (l <= r)
    {
      int m = (l + r) / 2;
      if (x == a[m])
      {
        return m;
      }

      if (a[l] <= a[m])
      {
        if (x > a[m])
        {
          l = m + 1;
        } else if (x >= a[l])
        {
          r = m - 1;
        } else
        {
          l = m + 1;
        }
      } else
      {
        if (x < a[m])
        {
          r = m - 1;
        } else if (x <= a[r])
        {
          l = m + 1;
        } else
        {
          r = m - 1;
        }
      }
    }
    return NOT_FOUND;
  }
}
