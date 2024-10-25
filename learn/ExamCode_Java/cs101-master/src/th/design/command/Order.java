package th.design.command;

import java.util.Date;

// This is the command - specify an interface for executing an operation
public interface Order extends Comparable<Order>
{

  public void execute();

  // when the order is placed
  public Date when();
}
