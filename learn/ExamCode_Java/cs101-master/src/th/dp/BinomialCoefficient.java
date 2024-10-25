package th.dp;

// Compute the binomial coefficients
// This version use dynamic programming algorithm
// a technique for efficiently doing computation 
// by storing partial results instead of computing 
// same sub problems over and over again
class BinomialCoefficient
{

  // Count number of ways to choose k things out of n possibilities
  public static int choose(int n, int k)
  {
    if (n < 0 || k < 0 || k > n)
    {
      throw new IllegalArgumentException();
    }

    // this extra buffer is a tradeoff of space for time
    // illustrating caching vs. computation decision
    int bc[][] = new int[n + 1][k + 1];

    // base case1:
    // there is exactly only 1 way to choose 0 thing
    // from a set of n things. That is, the empty set
    for (int i = 0; i <= n; i++)
    {
      bc[i][0] = 1;
    }

    // base case2: there is only 1 way to choose n out of n items
    for (int j = 0; j <= k; j++)
    {
      bc[j][j] = 1;
    }

    // using the recurence to compute from
    for (int i = 1; i <= n; i++)
    {
      for (int j = 1; j <= k; j++)
      {
        bc[i][j] = bc[i - 1][j - 1] + bc[i - 1][j];
      }
    }
    return bc[n][k];
  }
}