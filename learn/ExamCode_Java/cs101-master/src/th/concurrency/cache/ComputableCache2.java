package th.concurrency.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ComputableCache2<Y, X> implements Computable<Y, X>
{

  private final Map<X, Y> cache = new ConcurrentHashMap<X, Y>();
  private final Computable<Y, X> function;

  public ComputableCache2(Computable<Y, X> c) {
    this.function = c;
  }

  public Y compute(X x) throws InterruptedException
  {
    Y result = cache.get(x);
    if (result == null)
    {
      result = function.compute(x);
      cache.put(x, result);
    }
    return result;
  }
}