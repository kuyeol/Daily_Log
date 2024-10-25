package th.concurrency.producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainThread
{
  public static void main(String args[]) throws InterruptedException
  {
    BlockingQueue<Data> q = new ArrayBlockingQueue<Data>(20);
    Producer p1 = new Producer(q);
    Producer p2 = new Producer(q);
    Producer p3 = new Producer(q);

    Consumer c1 = new Consumer(q);
    Consumer c2 = new Consumer(q);

    Thread t1 = new Thread(p1);
    t1.setName("p1");
    t1.start();

    Thread t2 = new Thread(p2);
    t2.setName("p2");
    t2.start();

    Thread t3 = new Thread(p3);
    t3.setName("p3");
    t3.start();

    Thread t4 = new Thread(c1);
    t4.setName("c1");
    t4.start();

    Thread t5 = new Thread(c2);
    t5.setName("c2");
    t5.start();

    // run producers and consumers in 2 mins
    Thread.sleep(2 * 60 * 1000);

    // stop producers and consumers threads
    t1.interrupt();
    t2.interrupt();
    t3.interrupt();
    t4.interrupt();
    t5.interrupt();

    t1.join();
    t2.join();
    t3.join();
    t4.join();
    t5.join();
  }
}
