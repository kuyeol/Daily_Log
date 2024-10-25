package th.concurrency.cancellation;

import java.util.concurrent.BlockingQueue;

// A Cancellable producer using interruption mechanism  
public abstract class CancellableProducer<E> implements Runnable
{

  private final BlockingQueue<E> queue;

  CancellableProducer(BlockingQueue<E> q) {
    this.queue = q;
  }

  @Override
  public void run()
  {
    try
    {
      while (!Thread.currentThread().isInterrupted())
      {
        queue.put(getEntry());
      }
    } catch (InterruptedException e)
    {
      // just give the thread a chance to exit
    }
  }

  abstract E getEntry();

  public void cancel()
  {
    Thread.currentThread().interrupt();
  }

}
