package th.collection.test;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import th.io.Console;

// Test if the ConcurrentHashMap can be locked exclusively 
public class ConcurrentHashMapTest
{

  private static final int nThreads = 10;
  private static final int data_size = 1000000; // data_size = one million
  // ints
  final static CountDownLatch startGate = new CountDownLatch(1);

  public static void main(String args[])
  {
    ConcurrentHashMap map = new ConcurrentHashMap();
    for (int i = 0; i < nThreads; i++)
    {
      byte[] data = new byte[data_size];
      Arrays.fill(data, (byte) i);
      Thread t = new WriterThread(map, i, data);
      t.start();
    }

    startGate.countDown();
  }

  static class WriterThread extends Thread
  {

    final private Map<Integer, Integer> map;
    final private int id;
    final byte[] data;

    public WriterThread(final Map map, int id, byte[] data) {
      this.id = id;
      this.map = map;
      this.data = data;
    }

    // when the thread executes, it read each byte from data[] and write to
    // the map
    @Override
    public void run()
    {
      try
      {
        Console.printf("Thread %2d is waitting to start %n", id);
        startGate.await();
      } catch (InterruptedException ex)
      {
        Thread.currentThread().interrupt();
        return;
      }

      // synchronized (map) {
      // From client point of view, we can lock ConcurrentHashMap for
      // exclusive access
      synchronized (map)
      {
        int i = id * data_size;
        for (int v : data)
        {
          int k = i++;
          map.put(k, v);
          Console.printf("Thread %2d: writting (%d,%d)to map %n", id, k, v);
        }
      }
    }
  }
}
