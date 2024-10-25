package th.dp;

// use dynamic programming, not recursion 
public class Fibonacci
{

  // return a fibonacci number
  public static long number(int n)
  {
    if (n == 0)
    {
      return 0;
    }

    // starting from fibo(2)
    long back2 = 0;
    long back1 = 1;

    for (int i = 2; i < n; i++)
    {
      long cur = back1 + back2;
      back2 = back1;
      back1 = cur;
    }

    return back1 + back2;
  }

  // print fibonacci series
  public static void series(int n)
  {

    long back2 = 0;
    System.out.println(back2);
    if (n == 0)
    {
      return;
    }

    long back1 = 1;
    System.out.println(back1);
    if (n == 1)
    {
      return;
    }

    for (int i = 2; i <= n; i++)
    {
      long cur = back1 + back2;
      back2 = back1;
      back1 = cur;
      System.out.println(cur);
    }
  }

  public static void main(String args[])
  {
    for (int n = 0; n <= 10; n++)
    {
      System.out.printf("fibo(%d) = %4d \n", n, number(n));
    }

    series(10);

  }
}
