package th.stats;

// Online algorithm to computte the min, max, mean, variance and standard deviation 
// of the data this Accumulator has seen sofar...
public class Accumulator
{

  // number of data items this Accumulator has seen
  protected int count;
  protected double mean;
  protected double ss; // current sum square
  protected double max = Double.NEGATIVE_INFINITY;
  protected double min = Double.POSITIVE_INFINITY;

  // data seen by this Accumulator
  public void seen(double data)
  {
    count++;
    if (data > max)
    {
      max = data;
    }

    if (data < min)
    {
      min = data;
    }
    mean = mean + (data - mean) / count;
    ss = ss + (count - 1) * 1.0 / (count) * (data - mean) * (data - mean);
  }

  public double min()
  {
    return min;
  }

  public double max()
  {
    return max;
  }

  public double mean()
  {
    return mean;
  }

  public double variance()
  {
    return ss / (count - 1);
  }

  public double stddev()
  {
    return Math.sqrt(variance());
  }

}
