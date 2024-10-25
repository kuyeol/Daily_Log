package th.concurrency.deadlock;

// A deadlock example. an alien method 
// is being called while holding a lock!
// Solution: use open calls
import th.collection.Queue;
import th.collection.Stack;

public class InvokeAlienDeadlock
{

  private static class Mover extends Thread
  {
    private Queue<Integer> q;
    private Stack<Integer> s;

    Mover(Queue<Integer> q, Stack<Integer> s) {
      this.q = q;
      this.s = s;
    }

    @Override
    public void run()
    {
      String threadName = Thread.currentThread().getName();
      if ("QueueToStackMover".equalsIgnoreCase(threadName))
      {
        synchronized (q)
        {
          while (!q.empty())
          {
            moveQueueToStack();
          }
        }
      } else
      {
        synchronized (s)
        {
          while (!s.empty())
          {
            moveStackToQueue();
          }
        }
      }
    }

    private void moveQueueToStack()
    {
      int item = q.dequeue();
      System.out.format("Thread: %s, moving %d from queue to stack %n", Thread.currentThread().getName(), item);
      synchronized (s)
      {
        s.push(item);
      }
    }

    private void moveStackToQueue()
    {
      int item = s.pop();
      System.out.format("Thread: %s, moving %d from stack to queue %n", Thread.currentThread().getName(), item);
      synchronized (q)
      {
        q.enqueue(item);
      }
    }
  }

  public static void main(String[] args)
  {
    // Thread 1 hold a lock on a queue q and try to get a hold on a stack s
    // Thread 2 hold a lock on stack s and try to get a hold on queue q
    Queue<Integer> q = new Queue<Integer>();
    Stack<Integer> s = new Stack<Integer>();
    for (int i = 0; i < 100000; i++)
    {
      q.enqueue(i);
      s.push(i * 2);
    }

    Thread t1 = new Mover(q, s);
    t1.setName("QueueToStackMover");
    t1.start();

    Thread t2 = new Mover(q, s);
    t2.setName("StackToQueueMover");
    t2.start();
  }
}
