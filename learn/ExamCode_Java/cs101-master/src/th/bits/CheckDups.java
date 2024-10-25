package th.bits;

public class CheckDups
{

  public static void checkDups(int[] a)
  {
    BitSet bits = new BitSet(32000);

    for (int i = 0; i < a.length; i++)
    {
      int num = a[i];
      int pos = num - 1;
      if (bits.isVisited(pos))
      {
        System.out.println(num);
      } else
      {
        bits.set(pos);
      }
    }
  }
}
