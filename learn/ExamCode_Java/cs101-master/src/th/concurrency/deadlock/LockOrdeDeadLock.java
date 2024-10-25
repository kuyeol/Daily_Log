package th.concurrency.deadlock;

/**
 * Simple code to illustrate lock ordering deadlock
 */
public class LockOrdeDeadLock
{
  private static final Object lock1 = new Object();
  private static final Object lock2 = new Object();

  public void foo()
  {
    synchronized (lock1)
    {
      synchronized (lock2)
      {
        Dosomething.f1();
      }
    }
  }

  public void bar()
  {
    synchronized (lock2)
    {
      synchronized (lock1)
      {
        Dosomething.f2();
      }
    }
  }

  private static class Dosomething
  {
    public static void f1()
    {
    };

    public static void f2()
    {
    };
  }
}
