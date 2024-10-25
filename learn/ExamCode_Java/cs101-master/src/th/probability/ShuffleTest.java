package th.probability;

// test if Rand.shuffle() method randomly suffle the elements in array 
// test do m shuffles on an array of size n. 
// Init a[i] = i before each shuffle
// keep statistics of the number of times a[i] is shuffled to a[j]
// stat[i,j] keep number of times element i is shuffled to a[j]
// by law of large number... stat[i,j] should be proximately m/n 
public class ShuffleTest
{

  public static void test()
  {
    Rand<Integer> rand = new Rand<Integer>();
    int n = 20;
    int m = 200000;
    int[][] stat = new int[n][n];

    // perform m shuffles on an array of n elements
    for (int k = 0; k < m; k++)
    {

      Integer[] a = new Integer[n];
      for (int i = 0; i < n; i++)
      {
        a[i] = new Integer(i);
      }
      rand.shuffle(a);

      for (int j = 0; j < a.length; j++)
      {
        int i = a[j];
        stat[i][j]++;
      }
    }

    // check all entries stat[i][j] should be close to m/n;
    print2DArray(stat);

  }

  public static void print2DArray(int d[][])
  {
    for (int i = 0; i < d.length; i++)
    {
      for (int j = 0; j < d[i].length; j++)
      {
        System.out.printf(" %5d", d[i][j]);
      }
      System.out.println("");
    }
  }

  public static void main(String args[])
  {
    test();
  }
}
