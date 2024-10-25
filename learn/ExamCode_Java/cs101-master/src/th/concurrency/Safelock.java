package th.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import th.collection.Queue;
import th.collection.Stack;

public class Safelock
{

  public enum MoveType
  {
    Queue2Stack, Stack2Queue;
  }

  private static class Mover extends Thread
  {

    private Queue<Integer> q;
    private Stack<Integer> s;
    private final Lock lock;
    private final MoveType type;

    Mover(Queue q, Stack s, Lock lock, MoveType type) {
      this.type = type;
      this.q = q;
      this.s = s;
      this.lock = lock;
    }

    @Override
    public void run()
    {
      if (type == MoveType.Queue2Stack)
      {
        moveQueueToStack();
      } else
      {
        moveStackToQueue();
      }
    }

    private void moveQueueToStack()
    {
      while (true)
      {
        if (lock.tryLock())
        {
          try
          {
            if (!q.empty())
            {
              int item = q.dequeue();
              System.out
                  .format("Thread: %s, moving %3d from queue to stack %n", Thread.currentThread().getName(), item);
              s.push(item);
            }
          } finally
          {
            lock.unlock();
          }
        }
      }
    }

    private void moveStackToQueue()
    {
      while (true)
      {
        if (lock.tryLock())
        {
          try
          {
            if (!s.empty())
            {
              int item = s.pop();
              System.out
                  .format("Thread: %s, moving %3d from stack to queue %n", Thread.currentThread().getName(), item);
              q.enqueue(item);
            }
          } finally
          {
            lock.unlock();
          }
        }
      }
    }
  }

  public static void main(String[] args)
  {
    Queue<Integer> q = new Queue();
    Stack<Integer> s = new Stack();
    Lock lock = new ReentrantLock();

    for (int i = 0; i < 100; i++)
    {
      q.enqueue(i);
      s.push(i * 2);
    }

    Thread t1 = new Mover(q, s, lock, MoveType.Queue2Stack);
    t1.start();

    Thread t2 = new Mover(q, s, lock, MoveType.Stack2Queue);
    t2.start();
  }
}