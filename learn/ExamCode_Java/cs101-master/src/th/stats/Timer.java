package th.stats;

public class Timer
{

  private final long begin;

  public Timer() {
    begin = System.currentTimeMillis();
  }

  // elapsed time in second
  public double elapsed()
  {
    long elapsed = System.currentTimeMillis() - begin;
    return elapsed / 1000.0;
  }

}
