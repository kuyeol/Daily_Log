package th.design.command;

import th.io.Console;

// This class play the rol eof the Receiver 
public class TradeExecutionSystem
{

  public void buy(Stock s)
  {
    // simulating the method code
    Console.printf("Execute stock %s", s);
  }

  public void sell(Stock s)
  {
    // simulating the method code
    Console.printf("Sold stock %s", s);
  }

}
