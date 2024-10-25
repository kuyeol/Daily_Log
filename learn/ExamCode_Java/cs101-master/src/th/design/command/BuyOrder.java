package th.design.command;

import java.util.Date;

// This class play the role of a ConcreteCommand 
// it implements the execute method 
// and invoking the corresponding operation on Receiver
class BuyOrder implements Order
{

  private TradeExecutionSystem receiver;;
  private Date time;
  private Stock stock;

  public BuyOrder(TradeExecutionSystem executor, Stock st, Date orderTime) {
    receiver = executor;
    stock = st;
    time = orderTime;
  }

  public void execute()
  {
    receiver.buy(stock);
  }

  public Date when()
  {
    return time;
  }

  // the order here is application specific....
  public int compareTo(Order other)
  {
    return this.time.compareTo(other.when());
  }

}