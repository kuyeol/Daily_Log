package th.design.command;

import java.util.PriorityQueue;

// an example illustrating the command design pattern
// this class play the role of the invoker
class Agent
{

  private PriorityQueue<Order> queue = new PriorityQueue();
  private int THRESHOLD = 100;

  public Agent() {
  }

  public void placeOrder(Order order)
  {
    queue.add(order);

    // invoker might decide when to execute the command
    if (queue.size() > THRESHOLD)
    {
      while (queue.size() > 0)
      {
        Order executingOrder = queue.remove();
        executingOrder.execute();
      }
    }

  }
}