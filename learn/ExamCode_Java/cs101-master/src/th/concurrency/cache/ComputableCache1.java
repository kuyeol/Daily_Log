package th.concurrency.cache;

import java.util.HashMap;
import java.util.Map;

public class ComputableCache1<Y, X> implements Computable<Y, X>
{
  // @GuardedBy("this")
  private final Map<X, Y> cache = new HashMap<X, Y>();
  private final Computable<Y, X> function;

  public ComputableCache1(Computable<Y, X> c) {
    this.function = c;
  }

  public synchronized Y compute(X x) throws InterruptedException
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
