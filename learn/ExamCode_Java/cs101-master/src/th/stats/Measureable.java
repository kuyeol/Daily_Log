package th.stats;

public interface Measureable
{

  // measure time for the input of size n
  public double timeTrial(int n);

  // measure time for the input object o
  public double timeTrial(Object o);

  // measure time for the input object o, but use only size n
  public double timeTrial(Object o, int n);

}
