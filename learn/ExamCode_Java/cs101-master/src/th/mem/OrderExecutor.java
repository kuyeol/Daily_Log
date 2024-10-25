package th.mem;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class OrderExecutor
{

  private BlockingQueue<Order> orderQueue = new PriorityBlockingQueue<Order>();
  static Map<Runnable, TaskStatus> status = Collections.synchronizedMap(new HashMap<Runnable, TaskStatus>());
  static ExecutorService exec = Executors.newFixedThreadPool(10);

  public void newOrder(Order order) throws InterruptedException
  {
    orderQueue.put(order);
  }

  public void executeOrders() throws InterruptedException
  {
    Order order = orderQueue.take();
    Runnable task = new Task(order);
    status.put(task, TaskStatus.NOT_STARTED);
    exec.execute(task);
  }

  private enum TaskStatus
  {

    NOT_STARTED, RUNNING, COMPLETED
  };

  public class Task implements Runnable
  {

    private final Order order;

    Task(Order order) {
      this.order = order;
    }

    public void run()
    {
      status.put(this, TaskStatus.RUNNING);
      order.process();
      status.put(this, TaskStatus.COMPLETED);
    }
  }

  public interface Order
  {

    void process();
  }
}
