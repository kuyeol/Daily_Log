package th.array;

// Rotate an array with out using extra buffer 
public class Rotating
{

  public static void reverse(int[] a, int lwr, int upr)
  {
    for (int i = lwr, j = upr; i < j; i++, j--)
    {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }

  public static void rotate(int[] a, int k)
  {
    reverse(a, 0, k - 1);
    reverse(a, k, a.length - 1);
    reverse(a, 0, a.length - 1);
  }
}
