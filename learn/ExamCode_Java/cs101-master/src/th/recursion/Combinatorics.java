package th.recursion;

public class Combinatorics
{

  // How many ways you can choose k items from n items?
  // For any random item i
  // C(n,k) = number of subsets that include i
  // + number of subsets that don't include i
  // Thus, recursively C(n,k) = C(n-1,k-1) + C(n-1,k)

  static long choose(int n, int k)
  {
    if (k == 0 || n == k)
    {
      return 1;
    } else
    {
      return choose(n - 1, k - 1) + choose(n - 1, k);
    }
  }

  // iterative version of C(n,k)
  // using bottom-up dynamic programming strategy
  static long choose_dp(int n, int k)
  {
    if (n < 0 || k < 0 || n < k)
    {
      throw new IllegalArgumentException();
    }

    long bc[][] = new long[n + 1][k + 1];

    // base case 1 C(i,0) = 1;
    for (int i = 0; i <= n; i++)
    {
      bc[i][0] = 1;
    }

    // base case 2 C(j,j) = 1;
    for (int j = 0; j <= k; j++)
    {
      bc[j][j] = 1;
    }

    // currurence C(n,k) = C(n-1,k-1) + C(n-1,k)
    for (int i = 1; i <= n; i++)
    {
      for (int j = 1; j <= k; j++)
      {
        bc[i][j] = bc[i - 1][j - 1] + bc[i - 1][j];
      }
    }
    return bc[n][k];
  }

  public static void main(String args[])
  {
    int n = Integer.parseInt(args[0]);
    int k = Integer.parseInt(args[1]);
    System.out.printf("%d choose %d = %d \n", n, k, choose_dp(n, k));
  }

}
