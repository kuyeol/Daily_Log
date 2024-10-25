package th.concurrency.execution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import th.io.Console;
import th.probability.Rand;

// Code to illustrate the use of CompletionService
// Given a list of arrays... 
// count the number of pairs of each array that sum to 0  
// Use CompletionService to submit each task working on each array 
public class TwoSumExecutor
{
  private final ExecutorService exec;

  TwoSumExecutor(ExecutorService exec) {
    this.exec = exec;
  }

  public void execute(List<int[]> inputs)
  {
    CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(exec);

    for (final int[] input : inputs)
    {
      Callable<Integer> task = new TwoSum(input);
      cs.submit(task);
    }

    try
    {
      for (int i = 0; i < inputs.size(); i++)
      {
        Future<Integer> task = cs.take();
        Integer result = task.get();
        Console.printf("result: %d %n", result);
      }
    } catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
    } catch (ExecutionException e)
    {
      // TODO Auto-generated catch block
    }

  }

  // count number of pairs (a[i], a[j]) that sum to zero
  static class TwoSum implements Callable<Integer>
  {

    private final int[] a;

    TwoSum(final int[] a) {
      this.a = Arrays.copyOf(a, a.length);
    }

    public Integer call()
    {
      int cnt = 0;
      int n = a.length;
      Arrays.sort(a);
      for (int i = 0; i < n; i++)
      {
        if (Arrays.binarySearch(a, -a[i]) > i)
        {
          ++cnt;
        }
      }
      return cnt;
    }
  }

  public static void main(String[] args)
  {
    ExecutorService exec = Executors.newFixedThreadPool(10);
    TwoSumExecutor ecs = new TwoSumExecutor(exec);

    List<int[]> inputs = new ArrayList<int[]>();
    for (int i = 0; i < 10; i++)
    {
      int[] input = new int[10];
      for (int j = 0; j < input.length; j++)
      {
        input[j] = Rand.uniform(-10, 10);
      }
      inputs.add(input);
    }
    ecs.execute(inputs);
  }
}
