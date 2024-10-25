package th.string.matching;

public class RabinKarp
{

  public static int search(String t, String p)
  {
    int M = p.length();
    int N = t.length();
    int h1 = 0, h2 = 0;

    int q = 3355439; // table size
    int d = 256; // radix

    int j = 0;
    for (j = 0; j < M; j++)
    {
      h1 = (h1 * d + p.charAt(j)) % q; // hash the pattern
      h2 = (h2 * d + t.charAt(j)) % q; // hash the text
    }

    if (h1 == h2)
    { // matchted!
      return j - M;
    }

    for (j = M; j < N; j++)
    {
      h2 = (h2 - t.charAt(j)) % q; // remove high-order char
      h2 = (h2 * d + t.charAt(j)) % q; // insert low-order char

      if (h1 == h2)
      { // matchted!
        return j - M;
      }
    }
    return -1;
  }
}
