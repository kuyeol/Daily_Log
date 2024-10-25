package th.concurrency.execution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import th.io.Console;
import th.probability.Rand;

// Code to illustrate the use of ExecutorService to run timed tasks
// Given a list of arrays... 
// count the number of pairs of each array that sum to 0  
// Use ExecutorService.invokeAll(List<Callable> tasks)) 
public class TimedTaskExecutor
{

  // count number of pairs (a[i], a[j]) that sum to zero
  static class TwoSumTask implements Callable<Integer>
  {

    private final int[] a;

    TwoSumTask(final int[] a) {      
      this.a = Arrays.copyOf(a, a.length);
    }

    public Integer call()
    {
      int count = 0;
      int n = a.length;
      Arrays.sort(a);
      for (int i = 0; i < n; i++)
      {
        if (Arrays.binarySearch(a, -a[i]) > i)
        {
          ++count;
        }
      }
      return count;
    }

    public int[] input()
    {
      return Arrays.copyOf(a, a.length);
    }
  }

  public static void execute(int nTasks, long time, TimeUnit unit, int arraySize) throws InterruptedException
  {
    ExecutorService exec = Executors.newFixedThreadPool(nTasks);

    List<TwoSumTask> tasks = new ArrayList<TwoSumTask>();

    for (int i = 0; i < nTasks; i++)
    {
      int[] input = new int[arraySize];
      for (int j = 0; j < input.length; j++)
      {
        input[j] = Rand.uniform(-arraySize, arraySize);
      }

      TwoSumTask task = new TwoSumTask(input);
      tasks.add(task);
    }

    List<Future<Integer>> futures = exec.invokeAll(tasks, time, unit);
    Iterator<TwoSumTask> itr = tasks.iterator();

    for (Future<Integer> f : futures)
    {
      TwoSumTask t = itr.next();
      try
      {
        Integer result = f.get();
        Console.printf("%s, count=%d %n", Arrays.toString(t.input()), result);
      } catch (ExecutionException e)
      {
        Console.println(e.getCause());
      } catch (CancellationException e)
      {
        Console.println(e.getCause());
      }
    }
  }

  public static void main(String[] args) throws InterruptedException
  {
    execute(10, 100, TimeUnit.MILLISECONDS, 10);
  }

}
