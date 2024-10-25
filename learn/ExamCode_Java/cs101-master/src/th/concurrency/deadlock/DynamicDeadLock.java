package th.concurrency.deadlock;

import java.util.concurrent.atomic.AtomicLong;

import th.io.Console;
import th.probability.Rand;

public class DynamicDeadLock
{
  private static final int NUM_ACCOUNTS = 10;
  private static final int NUM_THREADS = 10;
  private static final int NUM_ITERATIONS = 1000000;
  private static final Account[] accounts = new Account[NUM_ACCOUNTS];

  public static void main(String[] args)
  {
    for (int i = 0; i < NUM_ACCOUNTS; i++)
    {
      accounts[i] = new Account(Currency.USD, Rand.uniform(0, 100));
    }

    for (int i = 0; i < NUM_THREADS; i++)
    {
      Thread t = new TransferTask();
      t.setName("T" + i);
      t.start();
    }
  }

  static class TransferTask extends Thread
  {
    public void run()
    {
      for (int i = 0; i < NUM_ITERATIONS; i++)
      {
        int account1 = Rand.uniform(0, NUM_ACCOUNTS);
        int account2 = Rand.uniform(0, NUM_ACCOUNTS);
        Amount amt = new Amount(Currency.USD, Rand.uniform(0, 100));
        try
        {
          transfer(accounts[account1], accounts[account2], amt);
        } catch (InsufficientAmountException ex)
        {
          Console.tprintf("Not enough fund to transfer from %s to %s %n", account1, account2);
        }
      }
      Console.tprintf("DONE!");
    }

    // deadlock-prone
    public void transfer(Account account1, Account account2, Amount amt) throws InsufficientAmountException
    {
      Console.tprintf("about to transfer %5.2f from %s to %s %n", amt.amount, account1, account2);
      synchronized (account1)
      {
        synchronized (account2)
        {
          if (account1.balance.compareTo(amt) < 0) { throw new InsufficientAmountException(); }
          account1.debit(amt);
          account2.credit(amt);
          Console.tprintf("done transferring %5.2f from %s to %s %n", amt.amount, account1, account2);
        }
      }
    }
  }

  static class Account
  {

    private final long accountNum;
    private Amount balance;
    private static final AtomicLong sequence = new AtomicLong();

    public Account(Currency currency, double val) {
      balance = new Amount(currency, val);
      accountNum = sequence.incrementAndGet();
    }

    void debit(Amount amt)
    {
      balance.subtract(amt);
    }

    void credit(Amount amt)
    {
      balance.add(amt);
    }

    Amount getBalance()
    {
      return balance;
    }

    public long getAccountNum()
    {
      return accountNum;
    }

    public String toString()
    {
      return "account  " + accountNum + "(" + balance.amount + ")";
    }
  }

  // need more implementation
  static class Amount implements Comparable<Amount>
  {
    public Currency currency;
    public double amount;

    Amount(Currency cur, double amount) {
      this.currency = cur;
      this.amount = amount;
    }

    // need impl with currency exchange
    public int compareTo(Amount amt)
    {
      return (int) (amount - amt.amount);
    }

    // need impl with currency exchange
    public void add(Amount amt)
    {
      amount += amt.amount;
    }

    // need impl with currency exchange
    public void subtract(Amount amt)
    {
      amount -= amt.amount;
    }
  }

  static class Currency
  {
    public static Currency USD;
  }

  static class InsufficientAmountException extends Exception
  {
  }
}
