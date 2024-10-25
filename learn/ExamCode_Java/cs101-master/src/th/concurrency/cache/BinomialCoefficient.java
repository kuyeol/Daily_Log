package th.concurrency.cache;

// Compute the binomial coefficients
// simulate an expensive computing function 
public class BinomialCoefficient implements Computable<int[][], NK>
{

  // Count number of ways to choose k items from a set of n items
  public int[][] compute(final NK nk) throws InterruptedException
  {

    // for brevity, omit code to check if nk is null or k <= n
    int n = nk.n();
    int k = nk.k();

    int bc[][] = new int[n + 1][k + 1];

    for (int i = 0; i <= n; i++)
    {
      bc[i][0] = 1;
    }

    for (int j = 0; j <= k; j++)
    {
      bc[j][j] = 1;
    }

    for (int i = 1; i <= n; i++)
    {
      for (int j = 1; j <= k; j++)
      {
        bc[i][j] = bc[i - 1][j - 1] + bc[i - 1][j];
      }
    }
    return bc;
  }
}
