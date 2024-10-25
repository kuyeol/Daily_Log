package th.concurrency.producer;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable
{

  private final BlockingQueue queue;
  private String threadName = "";

  Producer(BlockingQueue queue) {
    this.queue = queue;
  }

  public void run()
  {
    threadName = Thread.currentThread().getName();
    try
    {
      while (!Thread.currentThread().isInterrupted())
      {
        queue.put(produce());
      }
    } catch (InterruptedException ex)
    {
      System.out.println(threadName + ": got interrupted.");
    }
  }

  Data produce()
  {
    Data item = new Data(threadName, Counter.incrementCount());
    return item;
  }
}
