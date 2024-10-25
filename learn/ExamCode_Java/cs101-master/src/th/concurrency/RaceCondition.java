package th.concurrency;

import java.util.Arrays;
import th.io.Console;

/**
 * Race condition arise when two or more threads are reading and writing on some
 * shared variable simultaneously and the final state of the shared data depend
 * on the timing of how these threads are scheduled.
 * 
 * This code illustrate an example where Race condition arise.
 * 
 */
public class RaceCondition
{

  private static double sharedSum = 0;
  private final static Object lock = new Object();

  public static void main(String args[]) throws InterruptedException
  {

    // a sequence of a billion number. each entry has a value of 1
    byte[] seq = new byte[1000000000];
    Arrays.fill(seq, (byte) 1);

    while (true)
    {
      sharedSum = 0;
      // this thread wil add 1 billion to the shared sum
      Thread t1 = new Thread(new AddingThread(seq, 1));

      // this thread wil add 1*2 billion to the shared sum
      Thread t2 = new Thread(new AddingThread(seq, 2));
      t1.start();
      t2.start();
      t1.join();
      t2.join();

      // the expected sum is 3 billions. But the final sum here is
      // unpreditable...
      // due to the race condition situation
      Console.printf("Expected sum is 3 billion. The actual value is %(,.0f %n", sharedSum);
    }

  }

  private static class AddingThread implements Runnable
  {
    // The AddingThread will add seach data from this sequence of ints to
    // the shared sum

    final private byte[] seq;
    final private int multiplier;

    public AddingThread(byte[] data, int multiplier) {
      this.multiplier = multiplier;
      this.seq = data;
    }

    public void run()
    {
      for (int x : seq)
      {
        /* Without synchronization, race condition will occur here. */
        // synchronized(lock) {
        sharedSum = sharedSum + x * multiplier;
        // }
      }
    }
  }
}
