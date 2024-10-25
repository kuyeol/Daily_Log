package th.design.command;

import java.util.Date;

public class Client
{

  public static void main(String[] args)
  {

    // create a new receiver
    TradeExecutionSystem receiver = new TradeExecutionSystem();

    // create concrete commands
    BuyOrder order1 = new BuyOrder(receiver, new Stock("MSFT"), new Date());
    BuyOrder order2 = new BuyOrder(receiver, new Stock("MSFT"), new Date());

    // create a new invoker
    Agent agent = new Agent();

    // send the concrete commands to the invoker
    agent.placeOrder(order1);

    // send the concrete commands to the invoker
    agent.placeOrder(order2);
  }
}
