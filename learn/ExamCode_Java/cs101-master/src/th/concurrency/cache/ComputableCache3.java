package th.concurrency.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ComputableCache3<Y, X> implements Computable<Y, X>
{

  private final ConcurrentMap<X, Future<Y>> cache = new ConcurrentHashMap<X, Future<Y>>();
  private final Computable<Y, X> c;

  public ComputableCache3(Computable<Y, X> c) {
    this.c = c;
  }

  public Y compute(final X x) throws InterruptedException
  {
    while (true)
    {
      Future<Y> f = cache.get(x);
      if (f == null)
      {
        Callable<Y> call = new Callable<Y>()
          {

            public Y call() throws InterruptedException
            {
              return c.compute(x);
            }
          };
        FutureTask<Y> ft = new FutureTask<Y>(call);
        f = cache.putIfAbsent(x, ft);
        if (f == null)
        {
          f = ft;
          ft.run();
        }
      }
      try
      {
        return f.get();
      } catch (CancellationException e)
      {
        cache.remove(x, f);
      } catch (ExecutionException e)
      {
        // omit handling code for brevity
      }
    }
  }
}