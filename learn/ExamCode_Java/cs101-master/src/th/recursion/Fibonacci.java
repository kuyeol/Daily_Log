package th.recursion;

public class Fibonacci
{

  public static final int ERROR = -1;

  // iterative version
  public static int recursivefibo(int n)
  {
    if (n < 0)
    {
      return ERROR;
    }

    if (n == 0)
    {
      return 0;
    }

    if (n == 1 || n == 2)
    {
      return 1;
    } else
    {
      return recursivefibo(n - 1) + recursivefibo(n - 2);
    }
  }

  // iterative version
  public static long fibo(int n)
  {
    if (n < 0)
    {
      return -ERROR;
    }

    if (n == 0)
    {
      return 0;
    }

    long back2 = 0, back1 = 1;
    long cur = back1 + back2;

    for (int i = 3; i <= n; i++)
    {
      back2 = back1;
      back1 = cur;
      cur = back1 + back2;
    }

    return cur;
  }

  public static void main(String args[])
  {
    for (int n = 0; n <= 10; n++)
    {
      System.out.printf("fibo(%2d) = %4d \n", n, fibo(n));
    }
  }
}
