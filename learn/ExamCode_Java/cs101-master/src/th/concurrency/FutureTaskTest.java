package th.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import th.io.Console;
import th.stats.Timer;

public class FutureTaskTest
{

  public static void main(String[] args) throws InterruptedException, ExecutionException
  {
    int billion = 1000000000;
    FutureTask<Long> futureTask = new FutureTask(new ResultBearingTask(billion * 10));
    Thread t = new Thread(futureTask);
    t.start();

    Timer stopWatch = new Timer();
    // Depending on the state of the task...
    // if the task completed, futureTask.get() return the result imediately
    // otherwise, get() blocks until task is completed (or got cancelled,
    // exception, etc)
    long fiboNum = futureTask.get();
    double time = stopWatch.elapsed();
    Console.printf("Computation done. Run in %5.2f secs. The result is %(,d %n", time, fiboNum);
  }

  // a result bearing equivalent of Runnable
  static class ResultBearingTask implements Callable
  {

    private final long n;

    public ResultBearingTask(long n) {
      this.n = n;
    }

    // compute fino(n)
    public Long call() throws Exception
    {
      if (n == 0)
      {
        return 0L;
      }
      long back2 = 0;
      long back1 = 1;

      for (long i = 2; i < n; i++)
      {
        long cur = back1 + back2;
        back2 = back1;
        back1 = cur;
      }
      return back1 + back2;
    }
  }
}
