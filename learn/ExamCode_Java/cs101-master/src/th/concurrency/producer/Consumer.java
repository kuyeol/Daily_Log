package th.concurrency.producer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable
{

  private final BlockingQueue queue;
  private String threadName;

  Consumer(BlockingQueue queue) {
    this.queue = queue;
  }

  public void run()
  {
    threadName = Thread.currentThread().getName();
    Data item = null;
    try
    {
      while (!Thread.currentThread().isInterrupted())
      {
        item = (Data) queue.take();
        // consume(item);
      }
    } catch (InterruptedException ex)
    {
      System.out.println(threadName + ": got interrupted.");
    }

    if (item != null)
    {
      System.out.println(item.getThreadName() + ": " + item.counter);
    }
  }

  void consume(Data x)
  {
    System.out.println(threadName + ": consuming " + x.counter + " from " + x.getThreadName());
  }
}
