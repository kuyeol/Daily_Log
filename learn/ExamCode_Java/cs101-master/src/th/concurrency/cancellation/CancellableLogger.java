package th.concurrency.cancellation;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// producer-consumer type of logger with 
// Cancellation support
public final class CancellableLogger
{
  private final Object lock = new Object();
  private boolean isCancelled;
  private int pendingMessages;

  private final BlockingQueue<String> queue;
  private final Logger logger;
  private final PrintWriter writer;

  CancellableLogger(Writer writer) {
    this.writer = new PrintWriter(writer);
    this.queue = new LinkedBlockingQueue<String>();
    this.logger = new Logger();
  }

  public void start()
  {
    logger.start();
  }

  public void stop()
  {
    synchronized (this)
    {
      isCancelled = true;
    }
    logger.interrupt();
  }

  public void log(String msg) throws InterruptedException
  {
    synchronized (lock)
    {
      if (isCancelled) throw new IllegalStateException("logger is shutdown");
      ++pendingMessages;
    }
    queue.put(msg);
  }

  
  private class Logger extends Thread
  {
    public void run()
    {
      try
      {
        while (true)
        {
          try
          {
            synchronized (lock)
            {
              if (isCancelled && pendingMessages == 0) break;
            }
            String msg = queue.take();
            synchronized (lock)
            {
              --pendingMessages;
            }
            writer.println(msg);
          } catch (InterruptedException e)
          {
            // try to continue to log
          }
        }
      } finally
      {
        writer.close();
      }
    }
  }

}
