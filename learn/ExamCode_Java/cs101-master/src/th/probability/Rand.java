package th.probability;

import java.util.Random;

public class Rand<E>
{

  private static Random rand = new Random();

  public static void setSeed(long seed)
  {
    rand = new Random(seed);
  }

  public static double random()
  {
    return rand.nextDouble();
  }

  public static int uniform(int x)
  {
    return rand.nextInt(x);
  }

  public static int uniform(int lo, int hi)
  {
    return lo + uniform(hi - lo);
  }

  public static double uniform()
  {
    return rand.nextDouble();
  }

  // randomly shuffle the elements in an array
  public void shuffle(E[] arr)
  {
    int size = arr.length;
    for (int i = 0; i < size; i++)
    {
      // exchange arr[i] with a random entry in arr[i..size-1]
      int x = i + Rand.uniform(size - i);
      E tmp = arr[i];
      arr[i] = arr[x];
      arr[x] = tmp;
    }
  }

  // Return a descrete number i with probability p[i].
  public static int discrete(double[] p)
  {
    double r = uniform();
    double sum = 0.0;
    for (int i = 0; i < p.length; i++)
    {
      sum = sum + p[i];
      if (sum >= r)
      {
        return i;
      }
    }
    return -1;
  }

  // Return a character i with probability p[i].
  public static char random_char(double[] p)
  {
    int i = discrete(p);
    if (i != -1)
    {
      return (char) (i + 97);
    }
    return '*';
  }
}
