package th.concurrency.producer;

public class Data
{
  private String threadName;
  public long counter;

  /**
   * @return the producer threadName
   */
  public String getThreadName()
  {
    return threadName;
  }

  /**
   * @param threadName
   *          the threadName to set
   */
  public void setThreadName(String threadName)
  {
    this.threadName = threadName;
  }

  public Data(String threadName, long counter) {
    this.threadName = threadName;
    this.counter = counter;
  }
}
