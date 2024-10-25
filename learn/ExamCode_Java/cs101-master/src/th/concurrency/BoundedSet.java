package th.concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

// Use Semaphore to turn a HashSet into a bounded set
public class BoundedSet<E>
{

  private final Semaphore sem;
  private final Set<E> set;

  public BoundedSet(int permits) {
    this.set = Collections.synchronizedSet(new HashSet());
    this.sem = new Semaphore(permits);
  }

  public boolean add(E entry)
  {
    try
    {
      sem.acquire();
    } catch (InterruptedException ex)
    {
      return false;
    }
    boolean added = false;
    added = set.add(entry);
    if (!added)
    {
      sem.release();
    }
    return added;
  }

  public boolean remove(E entry)
  {
    boolean removed = set.remove(entry);
    if (removed)
    {
      sem.release();
    }
    return removed;
  }
}
