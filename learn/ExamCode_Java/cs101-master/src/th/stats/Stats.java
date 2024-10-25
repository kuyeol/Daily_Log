package th.stats;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import th.io.Console;
import th.io.OutStream;
import th.probability.Rand;

/**
 * This class implement methods for computing basic statistics such as min, max,
 * mean, variance, standard deviation and frequency table of the data that it
 * has seen
 * 
 * The difference between this class and Accumulator is that Accumulator is a
 * more light-weight and suitable for computing on an infinite data stream,
 * while this class store all data it has seen.
 */
public class Stats extends Accumulator
{

  private double[] list;
  private final TreeMap<Double, Integer> freqTable;

  public Stats(int capacity) {
    list = new double[capacity];
    freqTable = new TreeMap();
  }

  // data seen by this object
  @Override
  public void seen(double data)
  {
    if (count == list.length)
    {
      resize();
    }
    super.seen(data);
    if (freqTable.containsKey(data))
    {
      freqTable.put(data, freqTable.get(data) + 1);
    } else
    {
      freqTable.put(data, 1);
    }
    list[count - 1] = data;
  }

  private void resize()
  {
    double[] tmp = new double[count * 2];
    System.arraycopy(list, 0, tmp, 0, count);
    this.list = tmp;
  }

  public void save(OutStream out)
  {
    out.println(this.toString());
    out.println("Data:");
    for (double d : list)
    {
      out.println(d);
    }
    out.close();
  }

  @Override
  public String toString()
  {
    StringBuilder buf = new StringBuilder();
    buf.append(String.format("%n%s: %n", "Basic stats"));
    buf.append(String.format("Min: %5.2f %n", min()));
    buf.append(String.format("Max: %5.2f %n", max()));
    buf.append(String.format("Mean: %5.2f %n", mean()));
    buf.append(String.format("Variance: %5.2f %n", variance()));
    buf.append(String.format("Std Deviation: %5.2f %n", stddev()));
    buf.append(String.format("%n", ""));
    buf.append(String.format("%s: %n", "Frequency table"));
    for (Map.Entry<Double, Integer> entry : freqTable.entrySet())
    {
      buf.append(String.format("(%5.1f, %d) %n", entry.getKey(), entry.getValue()));
    }
    return buf.toString();
  }

  public static void main(String args[])
  {
    Stats stat = new Stats(10);
    for (int i = 1; i <= 10; i++)
    {
      stat.seen(i);
    }
    Console.printf("stat.list: %s %n", Arrays.toString(stat.list));
    Console.printf("%s %n", stat.toString());

    for (int i = 11; i <= 30; i++)
    {
      int r = Rand.uniform(1, 30);
      stat.seen(r);
    }
    Console.printf("stat.list: %s %n", Arrays.toString(stat.list));
    Console.printf("%s %n", stat.toString());
    stat.save(new OutStream("stats.txt"));
  }
}
