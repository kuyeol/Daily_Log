package th.concurrency.producer;

import java.util.concurrent.atomic.AtomicInteger;

public final class Counter
{
  public static AtomicInteger count = new AtomicInteger(0);

  public static long incrementCount()
  {
    return count.incrementAndGet();
  }

}
